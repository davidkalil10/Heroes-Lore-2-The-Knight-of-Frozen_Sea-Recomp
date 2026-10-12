# LEARNINGS — Heroes Lore 2: The Knight of Frozen Sea

## Sessão 1 (Análise do JAR e Scaffolding Inicial)
- **Estrutura do Pacote Original:**
  - Arquivo: `Heroes_Lore_2_The_Knight_of_Frozen_Sea_J2ME_Port_v1_0_2_EN_240x320.jar` (917.273 bytes).
  - Vendedor: *Hands-On Mobile Korea Ltd.*
  - Perfil: MIDP-2.0, CLDC-1.1.
  - MIDlet Principal: `rpg.RPGHero2` (localizado em `rpg/RPGHero2.class`).
  - Total de classes: 109 classes (96 classes ofuscadas na raiz de `a.class` até `cr.class`, classes da SKT Telecom `com.skt.m.*`, classes XCE `com.xce.*`, e `rpg.RPGHero2`).
- **Particularidades Técnicas Preliminares:**
  - Presença de classes de extensões móveis coreanas (`com.skt.m.AudioClip`, `com.skt.m.AudioSystem`, `com.skt.m.Device`, `com.xce.io.XFile`). O emulador/camada MIDP precisará fornecer stubs ou implementações dessas APIs caso o jogo as invoque para som ou vibração.
  - A resolução base de tela é 240x320 (proporção 3:4 clássica).

## Sess�o 2 (Marco 0 � boot, t�tulo e fluxo inicial)
- **Toolchain:** MSYS2 UCRT64 n�o est� no PATH. Usar `$env:PATH="C:\msys64\ucrt64\bin;$env:PATH"` (build E execu��o � as DLLs SDL2 v�m dali). Cuidado: com esse PATH, `python` aponta para o Python do MSYS (sem Pillow) � rodar convers�es de imagem num comando separado.
- **CMake:** `find_package(SDL2_mixer)` precisa linkar via alvo `SDL2_mixer::SDL2_mixer` / PkgConfig; usar s� `${SDL2_MIXER_LIBRARIES}` deixa `Mix_*` sem link.
- **As classes `com.skt.m.*` e `com.xce.*` s�o Java real dentro do JAR** (AudioClipImpl sobre `Manager/Player`, XFile sobre RMS). N�o precisam de stubs nativos; s� das APIs padr�o (`Hashtable`, `Player.setMediaTime`, etc.).
- **Armadilha cr�tica:** o class loader (`vm.cpp` ~L289) SUBSTITUI m�todos do JAR por natives registrados com a mesma chave `Classe.metodo:desc`. Os hooks de Wind of Soltia (`aj.a`, `bl.a`, `bf.a`, `bx.a`, `be.a`) colidem com nomes ofuscados do HL2 ? foram desativados. Widescreen/OTA/idiomas s� voltam ap�s re-an�lise por classe.
- **Auditoria de APIs:** `tools/audit_natives.py` lista chamadas `java/*`/`javax/*` do bytecode sem native registrado (falsos positivos: chamadas de interface resolvidas por classe concreta, e classes `com/*` que s�o do JAR).
- **Natives adicionados:** `Throwable.<init>/getMessage`, `Object.wait/notify`, `String.concat/getBytes/hashCode/lastIndexOf/<init>([B)`, `Hashtable` (novo `K_HASH`), `Vector.firstElement/removeElement`, `Thread.<init>()/run`, `ByteArrayInputStream.available`, `Canvas.repaint(IIII)`, `Connector.open` (lan�a IOException), `MIDIControl`.
- **Threads:** o runner agora invoca `Thread.run()` virtual (subclasses de Thread funcionam; o native delega ao `Runnable`).
- **Teste automatizado:** build com `-DHL_DEV_SCREENSHOTS` (dir `build_shot`) salva BMPs e injeta FIRE(53) nos frames 330/420/510/600/690; `tools/input_test.ps1`. `SendKeys` n�o funciona (foco do SDL).
- **Fluxo validado (frames):** logo Hands-On ? t�tulo "Heroes Lore 2 v1.0.2" ? New Game ? slot ? estilo de combate (Berserker/Claire) ? cutscene inicial com mapa de Sindraf.

## Sessao 3 (Calibracao de Controles, True Widescreen 16:9 Dinamico e Bezel Frozen Sea)
- **Mapeamento de Teclas do HL2 (bd.java e cd.java):**
  - No Canvas do HL2, keyPressed intercepta a tecla -7 (RSK) e converte em 8. A tecla 8 aciona u.void_a((byte)6), que abre o Menu Principal/Inventario.
  - A tecla 42 ('*') aciona u.a((byte)3, (byte)11, (byte)3), que abre o Minimapa da Regiao. No HL1 o minimapa era '0', mas no HL2 '0' (48) consome a pocao rapida selecionada e '#' (35) cicla entre os slots de pocoes.
  - O botao START no gamepad estava mapeado para -8 (CLR no HL1, ignorado no HL2). Corrigido para -7 (Menu Principal).
  - O botao SELECT / BACK no gamepad e a tecla M no teclado enviavam 48. Corrigidos para 42 ('*'), abrindo o Minimapa imediatamente.
  - No teclado, adicionadas as teclas Escape, Tab, E, I e Backspace mapeadas para -7 (Menu Principal).
- **True Widescreen (16:9 / 568x320) e Alinhamento:**
  - O desalinhamento (graficos colados a esquerda e barra preta a direita) ocorria porque a janela SDL ja criava o framebuffer em 568x320, mas o motor Java permanecia com as variaveis estaticas em 240x320.
  - No HL2, as classes de controle de viewport sao:
    - com.xce.lcdui.XDisplay: width (568) e height2 (320).
    - bw: g (568), h (320), i (284) e j (160).
    - bd: a / var_int_a (568), b / var_int_b (294), c / var_int_c (276), d / var_int_d (147), com flags de redesenho a, b, c, q.
    - u: posicoes da camera b e d deslocadas por deltaC.
    - ah.java: o renderizador de tiles calcula colunas por (bd.var_int_a - n3 - 1) / 16. Com bd.var_int_a = 568, renderiza o mapa de ponta a ponta sem cortes.
    - O HUD em bd.java calcula n4 = (bw.g - 120) >> 1 e preenche fillRect(0, n3, bw.g, 26), centralizando as barras e decorando com gargulas em 16:9 real.
  - VM::findField foi aprimorado para suportar fallback por nome simples quando a busca no mapa de descritores nao encontra correspondencia exata.
  - Chamada explicita de Platform::updateViewport(vm) adicionada logo apos o startApp() no main.cpp.
- **Bezel (Moldura) Tematico de Frozen Sea:**
  - Criado script procedural tools/generate_bezel_textures.py adaptado para Heroes Lore II: The Knight of Frozen Sea.
  - Coluna esquerda: Medalhao sagrado envolto em nevoa gelada, espada runica, runas em ciano brilhante e inscricao '• FROZEN SEA •'.
  - Coluna direita: Placa superior em ouro 'HEROES LORE II / KNIGHT OF FROZEN SEA', cartucho heraldico oficial de preservacao com creditos a David Kalil Braga (C++17) e EA Mobile • Hands-On Mobile Korea (2007).
  - Texturas geradas em 1080p e salvas em assets/ui/ e build/assets/ui/.

## Sessao 4 (Multiplataforma, Isolamento de Pacotes e CI/CD GitHub Actions)
- **Isolamento Completo contra Conflitos com Heroes Lore 1:**
  - Android: `applicationId` e `namespace` definidos como `com.davidbraga.heroeslore2`. O `provider` authority foi isolado como `com.davidbraga.heroeslore2.provider` em `AndroidManifest.xml` e no método `installApk` em `SDLActivity.java` (evitando erro de `INSTALL_FAILED_CONFLICTING_PROVIDER`).
  - Nintendo Switch: TitleID definido como `0100484C32000000` (representando 'HL2' em ASCII hex). Nome do binário/NRO: `heroes_lore_2.nro`.
  - Linux: Binário `heroes_lore_2`, Desktop Entry `heroes_lore_2.desktop`, e AppImage `heroes_lore_2_linux_x86_64.AppImage`.
  - Windows: Binário `heroes_lore_2.exe` e arquivo ZIP portátil `heroes_lore_2_windows_x64.zip`.
  - Pastas de Dados e RMS: `Platform::getStorageDir()` no Linux agora usa `.local/share/heroes_lore_2` e no Switch `sdmc:/switch/heroes_lore_2`.
  - Cloud Save: Pasta no Google Drive isolada como `'Heroes Lore II - The Knight of Frozen Sea'` e arquivo `heroes_lore_2_save.json`, com rotina de scan dinâmica para qualquer arquivo `.rms`.
  - Auto-Updater: Endpoint atualizado para o repositório `davidkalil10/Heroes-Lore-2-The-Knight-of-Frozen_Sea-Recomp`.
- **Pipeline CI/CD no GitHub Actions (`.github/workflows/build.yml`):**
  - Configurado com 4 jobs concorrentes de build nativo: `build-switch` (devkitpro/devkita64), `build-windows` (MSYS2 UCRT64), `build-linux` (Ubuntu 22.04 + appimagetool), e `build-android` (Java 17 + Gradle 8 + NDK 26).
  - Artefatos enviados via `actions/upload-artifact@v4` no push para a branch `main` sem criação de release ou tag, viabilizando testes antecipados antes da publicação oficial.

