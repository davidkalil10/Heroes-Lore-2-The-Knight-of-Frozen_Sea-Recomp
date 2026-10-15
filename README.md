# ❄️ Heroes Lore 2: The Knight of Frozen Sea — Recompilação Nativa (C++17 + SDL2)

[![CI/CD Multiplatform Build](https://github.com/davidkalil10/Heroes-Lore-2-The-Knight-of-Frozen_Sea-Recomp/actions/workflows/build.yml/badge.svg)](https://github.com/davidkalil10/Heroes-Lore-2-The-Knight-of-Frozen_Sea-Recomp/actions/workflows/build.yml)
[![Plataformas Suportadas](https://img.shields.io/badge/Plataformas-Windows%20%7C%20Linux%20%7C%20Android%20%7C%20Switch-blue.svg)](#plataformas-suportadas)
[![C++17](https://img.shields.io/badge/Standard-C%2B%2B17-blue.svg)](https://en.wikipedia.org/wiki/C%2B%2B17)
[![SDL2](https://img.shields.io/badge/Frontend-SDL2%20%2B%20SDL2__mixer-green.svg)](https://www.libsdl.org/)

Port nativo e literal em **C++17** do clássico RPG J2ME **Heroes Lore 2: The Knight of Frozen Sea** (*Hands-On Mobile Korea*), MIDlet principal `rpg.RPGHero2`.

O projeto executa o **bytecode original diretamente no motor C++**, sem emulação pesada e sem reescrever a lógica de jogo no olhômetro. Todas as fórmulas de combate, progressão de atributos, inteligência artificial de monstros e diálogos operam com fidelidade absoluta de 100% ao jogo original.

---

## 🌟 Recursos da Recompilação

- 🎮 **Controles Modernos & Gamepad Completo:**
  - Suporte nativo plug-and-play a controles Xbox, PlayStation, Nintendo Switch Pro Controller e genéricos (D-Pad, analógicos com zona morta, vibração rumble e botões de ombro).
  - Teclado com atalhos de sistema mapeados ergonomicamentes (`WASD`/Setas, `Enter`/`Espaço` para Ação, `Esc`/`Backspace` para Menu, `M` para Minimapa, `Q`/`R` e `[`/`]` para Poções).
  - Gamepad virtual translúcido responsivo na tela para celulares Android e Switch (modo portátil).
- 🖥️ **True Widescreen (16:9) & Aspect Ratio Dinâmico:**
  - Alternância entre **Auto** (padrão responsivo à orientação do dispositivo), **3:4 Original** (240x320) e **16:9 True Widescreen** (568x320 com expansão real de viewport do mapa e HUD proporcional).
  - Molduras temáticas (Bezels) com medalhão gélido oficial de *The Knight of Frozen Sea* para preenchimento de telas panorâmicas no modo 3:4.
- ⚡ **Limitador de Quadros (15 FPS / 30 FPS):**
  - **15 FPS:** Taxa de quadros autêntica do hardware móvel J2ME de 2007 (padrão nostalgia).
  - **30 FPS:** Modo fluido turbo de alta performance.
- ☁️ **Cloud Save Multiplataforma (Google Drive):**
  - Sincronização e backup de saves na nuvem via RFC 8628 (Device Flow).
  - Permite continuar o mesmo progresso em qualquer dispositivo (PC, Android, Linux ou Switch).
- ⚙️ **Menu de Opções Integrado (`l.class`):**
  - Configurações de Idioma, FPS, Proporção de Tela, Cloud Save e Atualizações integradas diretamente nos menus originais do jogo (**Menu de Título → Settings** e **Menu In-Game → System → Options**).
- 🌐 **Sistema Multi-idiomas & Tradução PT-BR (Padrão):**
  - Tradução integral para Português do Brasil (PT-BR) de todos os menus, itens, missões, habilidades e diálogos de mapa.
  - Alternância de idioma a quente (em tempo real) pelo menu de configurações sem necessidade de reiniciar ou trocar de mapa.
  - Arquitetura modular extensível em `assets/lang/<codigo>/` pronta para receber novos idiomas comunitários.
- 🔄 **Atualizações OTA (Over-The-Air):**
  - Verificação e notificação automática de novas versões lançadas diretamente pelo GitHub Releases.

---

## 📱 Plataformas Suportadas

| Plataforma | Pacote / Binário | Formato | Status |
| :--- | :--- | :--- | :--- |
| 🪟 **Windows** | `heroes_lore_2.exe` | Standalone ZIP (com DLLs e Assets) | ✅ Suportado |
| 🐧 **Linux** | `heroes_lore_2_linux_x86_64.AppImage` | AppImage portátil universal | ✅ Suportado |
| 🤖 **Android** | `heroes_lore_2-universal.apk` | APK nativo (arm64-v8a + armeabi-v7a) | ✅ Suportado |
| 🕹️ **Nintendo Switch** | `heroes_lore_2.nro` | Homebrew NRO com RomFS embutido | ✅ Suportado |

> **Nota de Isolamento:** Os identificadores de pacote (`com.davidbraga.heroeslore2`), Title IDs (`0100484C32000000`), pastas de armazenamento e arquivos de save na nuvem são 100% isolados de *Heroes Lore: Wind of Soltia*, permitindo que ambos os jogos coexistam no mesmo dispositivo sem qualquer conflito.

---

## 🕹️ Mapeamento de Controles

| Ação | Teclado | Gamepad (Xbox / Geral) | Nintendo Switch | Toque (Mobile) |
| :--- | :--- | :--- | :--- | :--- |
| **Movimento** | WASD / Setas | D-Pad / Analógico Esquerdo | D-Pad / Stick Esquerdo | D-Pad Virtual |
| **Atacar / Interagir ('5')** | Enter / Espaço / J / Z | Botão A | Botão A (leste) | Botão 5 |
| **Voltar / Menu (-7)** | Esc / Backspace / Tab / E / I | Botão B / START | Botão B (sul) / + | Botão MENU |
| **Minimapa da Região ('*')** | M / Asterisco (*) | Botão SELECT / L3 | Botão - / L3 | Botão MAPA |
| **Habilidade 1 ('1')** | 1 / U | Botão X | Botão Y | Botão 1 |
| **Habilidade 2 ('3')** | 3 / O | Botão Y | Botão X | Botão 3 |
| **Habilidade 3 ('7')** | 7 / K / X | Botão LB / L1 | Botão L | Botão 7 |
| **Habilidade 4 ('9')** | 9 / L / C | Botão RB / R1 | Botão R | Botão 9 |
| **Usar Poção ('0')** | 0 / Q / R | LT / L2 | ZL | Botão R |
| **Ciclar Poção ('#')** | ] / T / Ponto (.) | RT / R2 / R3 | ZR / R3 | Botões < e > |

---

## 🛠️ Como Compilar

### Pré-requisitos
- Compilador C++17 (GCC 10+, Clang 12+ ou MSVC 2019+)
- CMake 3.16+
- Ninja Build
- SDL2 e SDL2_mixer (desenvolvimento)
- libcurl (para Linux/UNIX)

### Windows (MSYS2 UCRT64)
```bash
cmake -B build -G Ninja -DCMAKE_BUILD_TYPE=Release
cmake --build build
.\build\heroes_lore_2.exe
```

### Linux (Ubuntu / Debian / Arch)
```bash
sudo apt-get install -y libsdl2-dev libsdl2-mixer-dev libcurl4-openssl-dev ninja-build cmake
cmake -B build -G Ninja -DCMAKE_BUILD_TYPE=Release
cmake --build build
./build/heroes_lore_2
```

### Android (Gradle + NDK)
```bash
cd android
./gradlew assembleRelease
```

### Nintendo Switch (devkitPro / devkitA64)
```bash
make -f Makefile.switch -j$(nproc)
```

---

## 📚 Documentação do Projeto

- 📘 [`AGENTS.md`](AGENTS.md) — Diretrizes de arquitetura, padrões literais de port e layout.
- 🗺️ [`docs/CLASS_MAP.md`](docs/CLASS_MAP.md) — Auditoria e mapa de papéis das 109 classes J2ME decompiladas.
- 🧭 [`docs/PORTING_GUIDE_BLUEPRINT.md`](docs/PORTING_GUIDE_BLUEPRINT.md) — Guia mestre arquitetural passo a passo.
- 📋 [`docs/STATUS.md`](docs/STATUS.md) — Estado atual de progresso, marcos alcançados e tarefas ativas.
- 🧠 [`docs/LEARNINGS.md`](docs/LEARNINGS.md) — Registro de aprendizados, descobertas do bytecode, armadilhas superadas e decisões técnicas.
- 🏷️ [`docs/VERSIONING.md`](docs/VERSIONING.md) — Políticas de versionamento semântico, CI/CD e lançamentos de releases.

---

## ⚖️ Licença e Créditos
Recompilação desenvolvida com propósitos estritos de **preservação histórica de jogos clássicos** e engenharia reversa para compatibilidade com plataformas modernas. Todo o conteúdo original do jogo (código J2ME, assets, roteiro e áudio) pertence aos detentores originais dos direitos autorais (*Hands-On Mobile Korea*).
