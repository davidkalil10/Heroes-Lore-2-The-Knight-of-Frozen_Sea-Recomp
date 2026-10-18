# CLASS_MAP — Heroes Lore 2: The Knight of Frozen Sea

Este documento mapeia todas as 109 classes decompiladas do jogo (`reference/extracted/` e `reference/decompiled_cfr/`) para seus respectivos papéis no motor em C++17.

---

## 🏛️ Classes de Entrada & Sistema Principal

- `rpg.RPGHero2`: MIDlet principal (`extends javax.microedition.midlet.MIDlet`). Ponto de entrada que inicializa a máquina de estados e o ciclo de vida da aplicação.
- `cd`: Canvas principal do jogo (`extends javax.microedition.lcdui.Canvas`). Recebe os eventos de teclado e controle (`keyPressed`, `keyReleased`) e direciona o ciclo de renderização (`paint`).
- `cj`: Engine central / Thread principal de lógica do jogo (`implements Runnable`). Inicializa a fila de eventos, áudio, iluminação, e gerencia a persistência de configurações no record store `/o`.
- `bw`: Gerenciador de contexto gráfico e viewport (`bw.g`: largura da tela, `bw.h`: altura da tela, `bw.i`: centro X, `bw.j`: centro Y). Suporta expansão True Widescreen 16:9 dinâmica.
- `u`: Estado global de jogo, herói ativo, coordenadas mundiais, inventário e dados de sessão ativa.

---

## 🖼️ Interface de Usuário & Menus

- `g`: Classe base abstrata de todas as telas modais e submenus com paginação de itens (`this.i`), cursor de seleção (`this.h`), indicador de setas (`b:(Graphics, int, int, int, int, boolean)`) e navegação direcional (`boolean_c`).
- `bg`: Menu de Título do jogo (New Game, Continue, Settings, Sound, About, Exit; herda de `g`).
- `ad`: Menu de Sistema In-Game (System → Save, Load, Options, Exit; herda de `g`).
- `l`: Tela unificada de Opções / Configurações (herda de `g`). Compartilhada entre o Título (`bg.java:64`) e In-Game (`ad.java:54`). Campo `this.a` booleano determina o contexto (false = Título, true = In-Game). Expandida na recompilação para 11 opções nativas (FPS, Aspect Ratio, Cloud Save, Atualizações e Menu Secreto de Cheats).
- `ca`: Menu de seleção de slots de save game e criação de novo personagem (herda de `g`).
- `bx`: Janela de exibição de mensagens de história, diálogos estendidos e ajuda (herda de `g`).
- `ai`: Tela de Créditos / Sobre do jogo (herda de `g`).
- `bk`: Renderizador tipográfico e de fontes pixel art autêntico do jogo (`bk.a`). Suporta caracteres ASCII e hangul coreano.

---

## 🛠️ Camada Nativa de Plataforma (`src/platform/`)

- `CloudSave` (`cloud_save.h` / `cloud_save.cpp`): Sincronização e restauração de saves na nuvem com o Google Drive via RFC 8628 (Device Flow).
- `Updater` (`updater.h` / `updater.cpp`): Verificação, notificação e atualização Over-The-Air (OTA) diretamente pelo GitHub Releases API.
- `Cheats` (`cheats.h` / `cheats.cpp`): Sistema nativo de trapaças e modo desenvolvedor (God Mode, SP Infinito, Zero Cooldown, +100k Ouro e Seletor de Patentes de Honra).

---

## 📦 Assets, Dados & Áudio

- `as`: Carregador central de recursos visuais e imagens estáticas via `XFile` (`as.var_e_a` armazena as strings localizadas do jogo; `as.t` armazena os rebites metálicos das molduras).
- `ak`: Gerenciador de efeitos sonoros, canais MIDI, volume e vibração do dispositivo.
- `bz`: Thread de processamento e sincronização de áudio em background (`wait/notify`).
- `e`: Tabela de strings de dados localizados do JAR (`e.a(int id)` retorna `byte[]`).
- `ck`: Gerenciador de elementos visuais do HUD e barra de status do jogador.

---

## 🌐 Plataforma Coreana (SK Telecom & XCE)

- `com.skt.m.AudioClip`, `com.skt.m.AudioSystem`: APIs de áudio da operadora coreana SK Telecom.
- `com.skt.m.Device`, `com.skt.m.BackLight`: Controle de luz de fundo e vibração tátil do aparelho.
- `com.xce.io.XFile`: Subsistema de leitura e gravação de arquivos de dados binários e saves RMS (`/k`, `/c`, `/s`, `/w`, `/o`).
- `com.xce.lcdui.XDisplay`: Extensões da plataforma XCE para controle de tela e buffer gráfico.
- `af`: Módulo de rede (`Connector`, `XBrowser`, `Socket`). Implementado como stub seguro.

---

## 🗺️ Mapa de Classes Ofuscadas de Combate e Entidades (`a` .. `cr`)

| Classe | Papel / Função Identificada |
| :--- | :--- |
| `p`, `am`, `cf` | Entidades de equipamentos, armas, armaduras e itens de inventário. |
| `q` | Status do herói, atributos básicos (Attack, Defense, HP, SP). |
| `ah` | Definição de monstros, chefes de fase e atributos de combate inimigo. |
| `ce` | Banco de dados de missões (quests) e tabelas de mapeamento de NPCs. |
| `n` | Definição de mundos, mapas de região e instâncias de NPCs em tela. |
| `bd` | Renderizador do mapa de ladrilhos (tilemap) e detecção de colisões. |
