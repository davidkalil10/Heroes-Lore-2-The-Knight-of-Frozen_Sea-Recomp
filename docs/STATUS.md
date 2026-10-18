# STATUS — Heroes Lore 2: The Knight of Frozen Sea

_Última atualização: 2026-10-18 (Versão v0.2.16 lançada oficialmente)_

## Ambiente
- Java 17/21, Python 3.13, Git: OK.
- Toolchain C++ (MSYS2 UCRT64: g++, CMake, Ninja, SDL2, SDL2_mixer): OK.
- Guia Mestre Arquitetural disponível em `docs/PORTING_GUIDE_BLUEPRINT.md`.

## Estado Atual
- [x] JAR original copiado: `reference/heroes2.jar` (917.273 bytes).
- [x] Extraído: `reference/extracted/` (109 classes).
- [x] Decompilado: `reference/decompiled_cfr/` (CFR com `--renamedupmembers`).
- [x] Bytecode desmontado: `reference/javap/` (109 arquivos `.javap`).
- [x] Identificação do MIDlet principal: `rpg.RPGHero2`.
- [x] Motor base C++17 copiado de Heroes Lore 1 (`src/vm/`, `src/midp/`, `src/platform/`).
- [x] Assets de sistema integrados: fontes TrueType Inter (`assets/fonts/`), soundfont GM (`assets/soundfont/TimGM6mb.sf2`), botões translúcidos (`assets/ui/`).
- [x] `main.cpp` instancia e inicializa `rpg.RPGHero2` (2026-10-12).
- [x] Classes da plataforma coreana (`com.skt.m.*`, `com.xce.*`) rodam como bytecode do JAR; faltavam apenas APIs padrão (feito).
- [x] Resolução Widescreen (16:9 / 568x320), True Widescreen dinâmico para classes do HL2 (com.xce.lcdui.XDisplay, bw, bd, u, ck) e Modo Auto funcionais.
- [x] DLLs de runtime (`SDL2`, `SDL2_mixer`, etc.) e pasta `assets/` copiadas automaticamente para `build/` (execução standalone via duplo clique funcionando).
- [x] Marco 0 (Milestone 1): tela de título + música MIDI + fluxo New Game → slot → classe → cutscene inicial (validado).
- [x] Controles completos ajustados:
  - Gamepad: START = Menu Principal (-7), SELECT/BACK = Minimapa (42 / '*'), A = Ação ('5'), B = Voltar/Cancelar (-7), X/Y/L1/R1 = Habilidades (1, 3, 7, 9), D-Pad/Analógico = Movimento, LT/RT/R3 = Poções (0, #).
  - Teclado: Escape/Tab/E/I/Backspace = Menu (-7), M = Minimapa (42), Enter/Espaço/J/Z = Ação ('5'), U/O/K/L e 1/3/7/9 = Habilidades, Q/R/0 = Poção, T/#/] = Ciclar Poção, WASD/Setas = Movimento.
- [x] Moldura Bezel personalizada para *Heroes Lore II: The Knight of Frozen Sea* gerada em 1080p com medalhão gélido e arquivo de preservação oficial.
- [x] Suporte multi-plataforma e isolamento completo de IDs/pacotes (sem conflito com Heroes Lore 1):
  - Android: `com.davidbraga.heroeslore2`, provider `com.davidbraga.heroeslore2.provider`, APK universal & arm64.
  - Nintendo Switch: TitleID `0100484C32000000`, NRO `heroes_lore_2.nro`, RomFS embutido.
  - Linux: AppImage portátil `heroes_lore_2_linux_x86_64.AppImage` + Desktop Entry + Ícone oficial.
  - Windows: `heroes_lore_2.exe` + ZIP standalone com runtime UCRT64 e assets.
- [x] Auto-Updater OTA (GitHub Releases API) validado e testado com sucesso no Android (atualização automática sem reinstalação manual).
- [x] Exibição da versão nativa da recompilação no Menu de Título (`bw.a:(Ljavax/microedition/lcdui/Graphics;)V`):
  - Logo abaixo do texto original `"V.1.0.2"`, renderiza `"v0.2.2"` com a fonte bitmap original do jogo estilizada em tom azul celeste (`0x80C0FF`), facilitando a conferência da versão ativa.
- [x] Integração completa de configurações personalizadas nos Menus do Jogo (`l.class` expandido para 9 itens):
  - Menu de Título -> *Settings* e Menu In-Game -> *System -> Options*.
  - Opções 0..4: Volume de Som, BGM, Vibração, Iluminação e Guia de Teclas (comportamento e persistência originais).
  - Opção 5: Taxa de Quadros (FPS) (15 FPS padrão / 30 FPS turbo).
  - Opção 6: Proporção de Tela (Auto / 3:4 / 16:9).
  - Opção 7: Nuvem (Google Drive Cloud Save RFC 8628).
  - Opção 8: Atualizações (`Update: Check`), permitindo verificar novas releases manualmente com um clique a partir do jogo.
- [x] Correção do recarregamento em tempo real do Save Restaurado da Nuvem (v0.2.3):
  - Limpa `XFile.store:Ljava/util/Hashtable;` e rescaneia os slots via `u.k:()V`.
  - Se a restauração ocorre durante uma sessão in-game: fecha os menus abertos (`ck.a:(Z)V`), garante `bd.q:Z = false` e chama diretamente `u.a:(I)V` (arg 1) para recarregar o save imediatamente na jogabilidade ativa.
  - Elimina completamente as 3 telas intermediárias indesejadas (tela de pausa "pressione qualquer tecla", tela de transição de fundo e menu de seleção com cursores), permitindo retorno limpo e transparente ao jogo.
  - Se restaurado no Menu de Título: recria `bg` em brilho total (`l = 3`) com "Continuar" ativo e pronto para clique direto.
- [x] Correção dos botões Joy-Con do Nintendo Switch no modal de Nuvem (v0.2.3):
  - Invertido o mapeamento SDL2 para Switch no modal: Joy-Con X físico (`SDL_CONTROLLER_BUTTON_Y`) agora aciona Restaurar (tecla 50), e Joy-Con Y físico (`SDL_CONTROLLER_BUTTON_X`) aciona Desconectar (tecla 51), harmonizando perfeitamente botões físicos, touch e legendas visuais.
- [x] Correção integral da localização e multi-idioma (v0.2.5):
  - Localização dinâmica dos novos itens do menu de configurações (`Idioma`, `Tela`, `Nuvem`, `Atualizar`, `Checar`).
  - Resolução de caminhos no interceptor de assets (`Platform::readAsset`), normalizando prefixos como `reference/extracted/` para garantir o roteamento correto de arquivos localizados (`/t/`, `/itm/`, `/m/m/`).
  - Tradução integral de todas as 255 missões em `/t/q.tdf` para Português do Brasil.
  - Tradução integral de todos os 1.430 diálogos de história e NPCs distribuídos pelos 111 mapas (`/m/m/*.m`) com preservação estrita de marcações de cor (`@`, `|`, `$`, `{`, `}`) e caracteres ASCII sem acentos.
  - Suporte direto a `romfs:/` no Nintendo Switch para carregamento de assets traduzidos embutidos no NRO.
- [x] Validação de persistência e carregamento RMS no disco e na nuvem.
- [x] Correção do crash no combate (`Math.max:(II)I` adicionado em `natives.cpp`), viabilizando a renderização do banner do alvo em `bd.a(ag, boolean)`.
- [x] Sistema Completo de Trapaças & Modo Desenvolvedor (`src/platform/cheats.h` e `cheats.cpp`):
  - Integrado diretamente ao menu de opções (`l.class` expandido para 11 itens).
  - Modo Deus (HP Infinito), SP Infinito, Zero Cooldown instantâneo para habilidades ativas.
  - Adição de ouro (+100.000 G) e Seletor de Patentes Militares / Honor Rank (15 patentes originais com auto-aplicação).
  - Interface responsiva com botões dedicados de toque para smartphones e proporções otimizadas para Nintendo Switch e PC.
- [x] Validação de zeramento contínuo (Campanha completa finalizada pelo usuário no Nintendo Switch, créditos validados e transição para o New Game+ / Hardcore Mode confirmada).
- [x] Detecção Automática do Modo Dock no Nintendo Switch (v0.2.16): Ao conectar o Switch à TV no dock, todos os botões virtuais da tela (D-Pad, ações, menu, mapa, olho e rotação) são 100% ocultados em tempo real via libnx Horizon OS, e a tela passa para Paisagem 16:9 em 1080p. Ao retirar do dock para o modo portátil, todos os controles virtuais e orientações retornam instantaneamente.

## Roadmap de Etapas (Seguindo o Blueprint)
- [x] **Passo 0:** Boot nativo no PC da classe `rpg.RPGHero2` e renderização do primeiro frame.
- [x] **Passo 1:** Movimentação contínua e game loop estável a 15/30 FPS.
- [x] **Passo 2:** Suporte completo a gamepads com mapeamento ergonômico.
- [x] **Passo 3:** Persistência de save games RMS em disco com integridade confirmada.
- [x] **Passo 4:** Port Android nativo (Estrutura Gradle 8 + NDK + SDLActivity + Provider isolado + CI).
- [x] **Passo 5:** Port Nintendo Switch Homebrew (Makefile.switch + TitleID HL2 + RomFS + CI).
- [x] **Passo 6:** True Widescreen (16:9), Molduras temáticas (Bezels) e Modo Auto.
- [x] **Passo 7:** Auto-Updater OTA via GitHub Releases (integrado com assets de HL2).
- [x] **Passo 8:** Cloud Save Multiplataforma (Google Drive RFC 8628 isolado para HL2).
- [x] **Passo 9:** Sistema de Localização Multi-idiomas (I18N), Tradução PT-BR integral e Troca a Quente em Tempo Real.
- [x] **Passo 10:** Validação de zeramento contínuo (Campanha concluída no Nintendo Switch com sucesso e New Game+ / Hardcore Mode desbloqueado).


