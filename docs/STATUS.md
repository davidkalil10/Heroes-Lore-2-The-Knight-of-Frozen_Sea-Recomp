# STATUS — Heroes Lore 2: The Knight of Frozen Sea

_Última atualização: 2026-10-12 (Marco 0 parcial)_

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
- [x] Auto-Updater OTA e Cloud Save Google Drive direcionados exclusivamente para o repositório e pasta do Heroes Lore 2 (`heroes_lore_2_save.json`).
- [x] GitHub Actions CI/CD automatizado (`.github/workflows/build.yml`) para compilar e gerar artefatos para download das 4 plataformas na branch `main`.
- [ ] Validação de jogabilidade contínua (combate em mapa aberto e diálogos com NPCs).
- [ ] Validação de salvamento e carregamento RMS.

## Roadmap de Etapas (Seguindo o Blueprint)
- [x] **Passo 0:** Boot nativo no PC da classe `rpg.RPGHero2` e renderização do primeiro frame.
- [x] **Passo 1:** Movimentação contínua e game loop estável a 15/30 FPS.
- [x] **Passo 2:** Suporte completo a gamepads com mapeamento ergonômico.
- [ ] **Passo 3:** Persistência de save games RMS em disco com integridade confirmada.
- [x] **Passo 4:** Port Android nativo (Estrutura Gradle 8 + NDK + SDLActivity + Provider isolado + CI).
- [x] **Passo 5:** Port Nintendo Switch Homebrew (Makefile.switch + TitleID HL2 + RomFS + CI).
- [x] **Passo 6:** True Widescreen (16:9), Molduras temáticas (Bezels) e Modo Auto.
- [x] **Passo 7:** Auto-Updater OTA via GitHub Releases (integrado com assets de HL2).
- [x] **Passo 8:** Cloud Save Multiplataforma (Google Drive RFC 8628 isolado para HL2).

