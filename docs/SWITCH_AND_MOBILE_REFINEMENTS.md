# Guia de Refinamentos: Nintendo Switch (Dock & Modo Retrato) e Layout Ergonômico Mobile

Este documento técnico serve como especificação e manual de replicação para os demais jogos da franquia *Heroes Lore* (ex: *Heroes Lore: Wind of Soltia*, *Heroes Lore III*, etc.) portados em C++17 com SDL2 e devkitPro (`libnx`).

Ele detalha as três soluções arquiteturais e ergonômicas desenvolvidas e consolidadas nas versões `v0.2.15`, `v0.2.16` e `v0.2.17`.

---

## 1. Detecção Automática do Modo Dock no Nintendo Switch

### O Problema
No Nintendo Switch em modo portátil, o jogo pode exibir controles virtuais touchscreen (D-Pad, botões de ação e botões utilitários de ocultação e rotação). No entanto, ao acoplar o console no **Dock conectado à TV**, o jogador passa a utilizar Joy-Cons ou Pro Controller. Manter os botões virtuais na tela da TV gerava poluição visual e quebrava a experiência cinematográfica em 1080p.

### A Solução Nativa via `libnx`
A biblioteca nativa do Switch (`libnx`) no devkitPro disponibiliza a API de applet do Horizon OS para consulta do estado do hardware em tempo real:
```c
#include <switch.h>
// Em switch/services/applet.h:
AppletOperationMode appletGetOperationMode(void);
```

Os valores do enum `AppletOperationMode` são:
- `AppletOperationMode_Handheld` (0): Console em modo portátil ou tabletop (tela integrada).
- `AppletOperationMode_Console` (1): Console acoplado no Dock (saída HDMI na TV).

> [!IMPORTANT]
> **Atenção à Assinatura:** Em versões modernas do `libnx`, `appletGetOperationMode` não recebe parâmetros (`void`) e retorna o enum diretamente. Não passe ponteiro por parâmetro.

### Implementação em C++

#### 1. Helper de Consulta
```cpp
static bool isSwitchDocked() {
#ifdef __SWITCH__
  return (appletGetOperationMode() == AppletOperationMode_Console);
#else
  return false;
#endif
}
```

#### 2. Limpeza Total no Cálculo do Layout (`calculateLayout`)
Ao detectar dock, a área de jogo é centralizada na tela da TV (com as molduras temáticas *bezels* em 1080p) e a lista de botões virtuais é completamente esvaziada, zerando o raio do D-Pad:
```cpp
static GamepadLayout calculateLayout(int winW, int winH) {
  GamepadLayout layout;
  layout.isPortrait = (winH > winW);
  layout.dpadR = 0;

  // No Nintendo Switch em modo Dock (TV), não há controles de toque na TV:
  // Ocultamos todos os botões virtuais sem exceção (D-Pad, ações, MENU, MAPA, olho, rotação, etc.)
  if (isSwitchDocked()) {
    float scaleX = (float)winW / (float)g_screenWidth;
    float scaleY = (float)winH / (float)g_screenHeight;
    float scale = std::min(scaleX, scaleY);
    int gameW = (int)((float)g_screenWidth * scale);
    int gameH = (int)((float)g_screenHeight * scale);
    int gameX = (winW - gameW) / 2;
    int gameY = (winH - gameH) / 2;
    layout.gameRect = { gameX, gameY, gameW, gameH };
    layout.controllerBgRect = { 0, 0, 0, 0 };
    layout.buttons.clear();
    return layout;
  }
  // ... fluxo normal em modo portátil ...
}
```

#### 3. Salvaguarda no Renderizador do Gamepad
```cpp
static void drawGamepad(const GamepadLayout& layout) {
  if (!s_renderer || isSwitchDocked()) return;
  // ... renderização do dpad e botões ...
}
```

#### 4. Salvaguarda de Rotação e Notificação de Transição OSD
Se o jogador estiver jogando em modo retrato (TATE) no portátil e conectar o Switch no Dock, a imagem na TV **não pode ficar virada a 90°**. Forçamos a exibição em Paisagem 16:9 tradicional na TV e notificamos a transição:
```cpp
#ifdef __SWITCH__
  static bool s_wasSwitchDocked = false;
  static bool s_dockStateInit = false;
  bool currentDocked = isSwitchDocked();
  if (!s_dockStateInit) {
    s_wasSwitchDocked = currentDocked;
    s_dockStateInit = true;
  } else if (currentDocked != s_wasSwitchDocked) {
    s_wasSwitchDocked = currentDocked;
    if (currentDocked) {
      Platform::showOsdMessage("Modo TV (Dock): Controles virtuais desativados");
    } else {
      Platform::showOsdMessage("Modo Portatil: Controles virtuais restaurados");
    }
  }

  // Se estiver no Dock, não aplica rotação de 90/270 graus na TV
  if (s_screenRotation != 0 && !currentDocked) {
    // Composição intermediária em s_rotateTarget
  }
#endif
```

---

## 2. Correção de Diálogos Modais no Modo Retrato do Switch (TATE)

### O Problema
No Nintendo Switch, ao jogar em modo vertical (TATE 90° ou Flip Grip 270°), abrir qualquer diálogo modal (como o Menu de Trapaças/Cheats, o Cloud Save ou o Atualizador OTA) fazia a tela parecer congelada. 
- O menu não aparecia na tela;
- O jogo deixava de responder aos direcionais do mapa;
- Ao apertar `B`, o jogo destravava;
- Ao girar o console para o modo paisagem, o menu subitamente aparecia desenhado.

### Diagnóstico
No modo vertical do Switch, o SDL renderiza a cena em uma textura intermediária `s_rotateTarget` de dimensões `720x1280` e, em seguida, a projeta rotacionada na tela física do Switch com um retorno antecipado:
```cpp
#ifdef __SWITCH__
  if (s_screenRotation != 0 && !currentDocked) {
    // ...
    SDL_RenderCopyEx(s_renderer, s_rotateTarget, nullptr, &dstRect, angle, nullptr, SDL_FLIP_NONE);
    SDL_RenderPresent(s_renderer);
    return; // <-- Retorno antecipado!
  }
#endif
```
As rotinas que desenhavam as janelas modais (`Cheats::drawModal`, `CloudSave::drawModal` e `Updater::drawModal`) estavam localizadas **depois** desse bloco `#ifdef __SWITCH__`. 
Consequentemente, o modal se tornava ativo no backend (bloqueando a entrada do jogo normal), mas **nunca era gravado em `s_rotateTarget`**. O jogador via apenas o último frame estático do jogo.

### A Solução
Basta desenhar os modais ativos diretamente dentro de `s_rotateTarget` (passando o viewport `720, 1280`) antes de desvincular o render target:

```cpp
#ifdef __SWITCH__
  if (s_screenRotation != 0 && !currentDocked) {
    if (!s_rotateTarget) {
      s_rotateTarget = SDL_CreateTexture(
          s_renderer,
          SDL_PIXELFORMAT_RGBA8888,
          SDL_TEXTUREACCESS_TARGET,
          720, 1280);
    }
    if (s_rotateTarget) {
      SDL_SetRenderTarget(s_renderer, s_rotateTarget);
      SDL_SetRenderDrawColor(s_renderer, 10, 12, 16, 255);
      SDL_RenderClear(s_renderer);

      GamepadLayout layout = calculateLayout(720, 1280);
      SDL_RenderCopy(s_renderer, s_screenTexture, nullptr, &layout.gameRect);
      drawGamepad(layout);
      drawOsd(720, 1280);

      // Renderiza os modais diretamente na textura portrait do Switch
      if (Updater::isPromptActive()) {
        Updater::drawModal(s_renderer, 720, 1280);
      }
      if (CloudSave::isModalActive()) {
        CloudSave::drawModal(s_renderer, 720, 1280);
      }
      if (Cheats::isModalActive()) {
        Cheats::drawModal(s_renderer, 720, 1280);
      }

      SDL_SetRenderTarget(s_renderer, nullptr);
      SDL_SetRenderDrawColor(s_renderer, 0, 0, 0, 255);
      SDL_RenderClear(s_renderer);

      double angle = (s_screenRotation == 1) ? 90.0 : 270.0;
      SDL_Rect dstRect = { 280, -280, 720, 1280 };
      SDL_RenderCopyEx(s_renderer, s_rotateTarget, nullptr, &dstRect, angle, nullptr, SDL_FLIP_NONE);
      SDL_RenderPresent(s_renderer);
      return;
    }
  }
#endif
```

Como os modais já possuem lógica responsiva para `isPortrait = (winH > winW)` (detectando `1280 > 720`), eles adaptam sua largura automaticamente para 93% da tela, ficando perfeitamente legíveis e navegáveis no modo vertical.

---

## 3. Ergonomia do Layout Retrato (Vertical / TATE) em Mobile e Switch

### O Problema do Layout Antigo
Em telas compridas de smartphones modernos (proporções 19.5:9 ou 20:9, ex: 1080x2400):
1. **Oclusão do HUD:** Se a tela do jogo começava muito abaixo do topo, a base da tela descia até a área dos botões virtuais, fazendo com que botões como `( 3 SKILL )` e `( 9 SKILL )` ficassem por cima das barras de HP/SP e dos atalhos de habilidades do jogo.
2. **Alcance Inconfortável:** Os botões de sistema `[ MENU ]` e `[ MAPA ]` ficavam no topo da tela, exigindo que o jogador soltasse o aparelho com uma das mãos para tocar no topo.

### O Novo Layout Otimizado

```
+------------------------------------------+
|  [Notch / Barra de Status segura]        |
|  +------------------------------------+  |
|  |                                    |  |
|  |          ÁREA DE JOGO 3:4          |  |
|  |     (100% Desobstruída no topo)    |  |
|  |                                    |  |
|  |   [HP/SP Bar]  [Skills 1 3 7 9 0]  |  |
|  +------------------------------------+  |
|                                          |
|   [ MENU ]   [ MAPA ]      ( 3 )   ( 9 ) |  <-- Linha de Ação Superior
|                                          |
|        ^                   ( 1 )         |
|     < D-PAD >                     ( 5 )  |  <-- Arco de Combate
|        v                   ( 7 )         |      (Inalterado)
|                                    ( 0 ) |
|    (Olho) (Girar)          ( < )   ( > ) |
+------------------------------------------+
```

### Regras Matemáticas do Cálculo (`calculateLayout`)

1. **Elevação do Viewport:**
   O jogo é iniciado no topo absoluto com margem mínima segura de 1.5%:
   ```cpp
   int gameY = std::max(0, (int)(winH * 0.015f));
   layout.gameRect = { gameX, gameY, gameW, gameH };
   ```
   Em telas 1080x2400, o jogo 3:4 ocupa 1080x1440px (terminando em Y = ~1476px), liberando mais de 920px na parte inferior exclusivamente para os controles virtuais.

2. **Posicionamento de `[ MENU ]` e `[ MAPA ]` Acima do D-Pad:**
   São colocados lado a lado no quadrante inferior esquerdo, imediatamente acima da borda superior do D-Pad:
   ```cpp
   int pillW = (int)(winW * 0.21f);
   int pillH = (int)(pillW * (100.0f / 240.0f));
   int sysY = (layout.dpadY - layout.dpadR) - pillH / 2 - (int)(winW * 0.035f);
   int menuX = (int)(winW * 0.14f);
   int mapX = (int)(winW * 0.38f);

   // MENU (-7) e MAPA (42 / '*')
   layout.buttons.push_back({ -7, menuX, sysY, 0, pillW, pillH, s_texBtnMenu });
   layout.buttons.push_back({ 42, mapX, sysY, 0, pillW, pillH, s_texBtnMap });
   ```

3. **Preservação Rígida do Arco de Ação:**
   O cluster de botões da mão direita (`5 ATK`, `1`, `3`, `7`, `9`, `0 ITEM`) permanece intocado em sua geometria e proporções aprovadas:
   ```cpp
   int actX = (int)(winW * 0.74f);
   int actY = winH - (int)(winW * 0.31f);
   int r5 = (int)(winW * 0.11f);
   int rSub = (int)(r5 * 0.74f);

   // 5 - Atacar / Confirmar
   layout.buttons.push_back({ 53, actX, actY, r5, r5 * 2, r5 * 2, s_texBtn5 });
   // 1 - Skill 1
   layout.buttons.push_back({ 49, actX - (int)(r5 * 1.50f), actY - (int)(r5 * 0.70f), rSub, rSub * 2, rSub * 2, s_texBtn1 });
   // 3 - Skill 2
   layout.buttons.push_back({ 51, actX - (int)(r5 * 0.75f), actY - (int)(r5 * 1.45f), rSub, rSub * 2, rSub * 2, s_texBtn3 });
   // 7 - Skill 3
   layout.buttons.push_back({ 55, actX - (int)(r5 * 1.45f), actY + (int)(r5 * 0.85f), rSub, rSub * 2, rSub * 2, s_texBtn7 });
   // 9 - Skill 4
   layout.buttons.push_back({ 57, actX + (int)(r5 * 0.90f), actY - (int)(r5 * 1.40f), rSub, rSub * 2, rSub * 2, s_texBtn9 });
   // 0 - Item / Poção
   layout.buttons.push_back({ 48, actX + (int)(r5 * 1.35f), actY + (int)(r5 * 1.15f), rSub, rSub * 2, rSub * 2, s_texBtnRskRound ? s_texBtnRskRound : s_texBtnRsk });
   ```

---

## 4. Checklist para Aplicação nos Demais Jogos da Franquia

Para replicar com facilidade em outro port (*Heroes Lore 1*, *Heroes Lore 3*, etc.):

- [ ] Incluir `<switch.h>` sob `#ifdef __SWITCH__`.
- [ ] Adicionar `isSwitchDocked()` usando `appletGetOperationMode() == AppletOperationMode_Console`.
- [ ] Inserir a verificação `if (isSwitchDocked())` no topo de `calculateLayout()` para limpar botões virtuais quando acoplado na TV.
- [ ] No `Platform::present()`, envolver o bloco de rotação de tela do Switch com `if (s_screenRotation != 0 && !isSwitchDocked())`.
- [ ] Dentro do bloco `s_rotateTarget` do Switch, chamar `drawModal` de todos os diálogos de sistema (`Cheats`, `CloudSave`, `Updater`).
- [ ] No modo portrait de `calculateLayout()`, elevar `gameY = std::max(0, (int)(winH * 0.015f))` e posicionar `MENU` e `MAPA` acima do D-Pad (`sysY = dpadTop - pillH/2 - 0.035*winW`).
