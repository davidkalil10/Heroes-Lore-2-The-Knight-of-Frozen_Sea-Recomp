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
- **Menu de Opções Unificado no Heroes Lore 2 (`l.class`):**
  - Diferente do Heroes Lore 1 onde o menu de opções era `be.class`, no Heroes Lore 2 tanto o menu de título (*Settings*, instanciado por `bg.java:64`) quanto o in-game (*System -> Options*, instanciado por `ad.java:54`) compartilham a classe `l.class` (`l` extends `g`).
  - O campo `this.a` booleano indica o contexto: `false` para o Menu de Título e `true` para o Menu In-Game.
  - O construtor original inicializa `this.i = 5` (quantidade de opções). Através dos hooks nativos `l_init_native`, `l_a_native` e `l_draw_native`, o total de itens foi expandido para 8 (`this.i = 8`).
  - O loop de navegação herdado de `g.class` (`boolean_c(n2, n3)`) gerencia automaticamente o ciclo de seleção de 0 a 7, e o método `l_cursor_native` (`l.b:(II)V`) renderiza as setas animadas `<` e `>` perfeitamente alinhadas a cada linha.
  - A renderização gráfica (`l_draw_native`) utiliza o motor original de fontes do jogo (`bk.a`) e a biblioteca de strings do JAR (`as.var_e_a`), desenhando:
    - Linha 5: **FPS** (15 FPS como padrão nostalgia J2ME, alternável para 30 FPS turbo fluido via `Platform::toggleFps()`).
    - Linha 6: **Tela** (Modo Auto como padrão, adaptando dinamicamente para 16:9 widescreen se a tela for horizontal ou 3:4 se for vertical, alternável para 3:4 e 16:9 via `Platform::nextAspect()` / `prevAspect()`).
    - Linha 7: **Nuvem** (Google Drive Cloud Save RFC 8628 via `Platform::openCloudSave()`).
  - Tanto no Menu de Título quanto In-Game, o botão RSK / Voltar / Cancelar (`-7`, Backspace, Esc, Gamepad B) salva as configurações no RecordStore `/o` e retorna suavemente para a tela anterior.

## Sessão 5 (Correções Críticas nos Menus, Botão Back e Arquitetura de Saves XFile)
- **Causa Raiz do Crash no Menu de Título (`l_draw_native`):**
  - O método `g.a(Graphics)` é um método de instância herdado de `g.class` e espera 2 argumentos na VM: slot 0 é a referência do próprio objeto (`this` / `selfObj`) e slot 1 é o `Graphics` (`gObj`).
  - No código anterior, estava sendo passado apenas `aArgs[1]` com `aArgs[0].o = gObj;`, o que fazia a VM usar o ponteiro do Graphics como se fosse a instância de `g`, lendo memória inválida na pilha e gerando crash imediato ao abrir Settings no título.
  - Corrigido passando `aArgs[2]` com `aArgs[0].o = selfObj; aArgs[1].o = gObj;`.
- **Causa Raiz do Botão Back/RSK Mudando Opções em vez de Voltar:**
  - No código original do Canvas (`cd.java:61` e `bd.java:75`), a tecla `-7` (RSK / Back) é interceptada e convertida para `8` antes de ser despachada para os menus (`if (n2 == -7) { n2 = 8; }`).
  - Em `l.java` original, a condição `if (n3 == 53 || n2 == 8 || n3 == 8)` é a forma de fechar o menu e salvar as opções.
  - Como o hook nativo tratava `8` no mesmo ramo de confirmação de ação ('5' / Enter), quando o cursor estava sobre as novas opções (FPS no item 5, Tela no item 6 ou Nuvem no item 7) e o jogador apertava Back, o código interpretava como confirmação e ficava ciclando as opções em vez de fechar.
  - Além disso, o método de fechamento invocava `parent.b(2)` com descritor de byte `"b:(B)V"`, mas em `g.class` a assinatura do método é `"b:(I)V"` (inteiro). Com isso, `findMethod` retornava nulo e o submenu `parent.b` nunca era desativado.
  - Corrigido separando o tratamento da tecla `8` / `-7` / Esc como Voltar prioritário em qualquer posição, limpando explicitamente o submenu com `parent.b = nullptr` e invocando `parent.b(2)` com a assinatura correta `b:(I)V`.
- **Arquitetura de Saves do Heroes Lore 2 (`com.xce.io.XFile`):**
  - Ao contrário do Heroes Lore 1 (que gravava arquivos `_k.rms`, `_s.rms`, `_w.rms`), o Heroes Lore 2 grava seus arquivos através da classe `com.xce.io.XFile`.
  - O método `XFile.rmsName(String path)` calcula `n = (path.hashCode() & Integer.MAX_VALUE)` e gera nomes de RecordStore no formato `"XF" + n`.
  - Arquivos gerados no disco:
    - `/g1` -> `XF48409.rms` (Slot 1 de jogo)
    - `/g2` -> `XF48410.rms` (Slot 2 de jogo)
    - `/g3` -> `XF48411.rms` (Slot 3 de jogo)
    - `/n1` -> `XF48626.rms` (Metadados do Slot 1)
    - `/n2` -> `XF48627.rms` (Metadados do Slot 2)
    - `/n3` -> `XF48628.rms` (Metadados do Slot 3)
    - `/cf` -> `XF48338.rms` (Configurações do sistema)
  - Criptografia e Decodificação do Nível: os dados dos slots usam criptografia XOR com verificação de paridade via `cb.java` e chaves fixas em `u.java` (`m = {5, 71, 24, 59, 43, 16}`, `n = {14, 26, 72, 10, 28, 98}`, `o = {67, 12, 35, 68, 91, 43}`). O nível autêntico do herói é obtido decodificando o bloco 2 com a chave `n[1] = 26` (`rec[off2 + 2] ^ 26`).
  - O `Platform::getRmsDir` e o `CloudSave` foram atualizados para reconhecer e empacotar todos esses arquivos, exibindo corretamente o status dos slots (ex: "Slot 1 (Nv. 1)") e sincronizando com o Google Drive.





## Sessao 6 (Touch, 16:9 retrato e teclas do menu de opcoes)
- **Retrato 16:9 esticado:** `calculateLayout` fixava o gameRect em 240x320 (3:4) mesmo com `g_screenWidth` = 568. Agora usa `g_screenWidth x g_screenHeight` (area de jogo mais larga e baixa, sem distorcer).
- **Botoes MENU/MAPA touch:** o HL2 nao usa -8 (CLR) nem 48 ('0' = pocao). Menu = -7 (Canvas converte em keyCode 8) e Mapa = 42 ('*').
- **gameAction x keyCode em `l.a(II)`:** parametros = (gameAction, keyCode). O keyCode 53 produz gameAction FIRE(8) e D-Pad cima produz gameAction 1 (UP). Testar `n2 == 8` como Back ou `n2 == 1` como confirmar quebrava navegacao e '5'. Back = keyCode 8/-7/-8/27; confirmar = keyCode 53/-5/13/32.
- **Modais no Android:** `SDL_GetWindowSize` pode diferir de `SDL_GetRendererOutputSize` (espaco em que o modal e desenhado) e o toque tambem gera `SDL_MOUSEBUTTONDOWN` com `which == SDL_TOUCH_MOUSEID` (duplicado). Modais devem usar o renderer output size e ignorar mouse sintetico.

## Sessao 7 (Restauracao de Save, Cache XFile.store e Identificacao de Classes HL2)
- **Cache Estatico em `com.xce.io.XFile.store`:**
  - A classe `XFile` possui o campo estatico `private static final Hashtable store = new Hashtable();`.
  - Ao abrir qualquer arquivo para leitura (`mode = 1`), se a chave do arquivo ja existe em `store`, ele retorna os bytes da memoria sem ler do disco (`loadRms`).
  - Durante o processo de restauracao do save da nuvem, os arquivos `.rms` eram reescritos em disco com sucesso, mas o jogo mantinha os bytes em cache.
  - Corrigido implementando `Hashtable.clear:()V` nas natives da VM e limpando `XFile.store` explicitamente durante o reload apos a restauracao.
- **Transição de Sessão In-Game para o Title Screen:**
  - O código herdado do jogo 1 tentava invocar metodos inexistentes de `n.class` e `bu.class` (`ao.class`, `bu.d()`, etc.).
  - No Heroes Lore 2, a transicao e encerramento de sessao ativo sao feitos por:
    1. Parar audios da sessao ativa via `ak.c()`.
    2. Descartar instancia do titulo anterior via `bg.void_a()`.
    3. Definir `u.var_int_a = 2` (modo Title Screen) e limpar `u.var_byte_d = 0`.
    4. Invocar `bg.bg_a()`, que executa `u.var_u_a.k()` (re-escaneando os slots de save em disco e atualizando `u.var_byte_b > 0` para habilitar o botao "Continue").
    5. Reinicializar o canvas `bd` com `bd.g = true` e tocar tema do titulo com `ak.b(1)` / `ak.a()`.
    6. Fechar o modal do Cloud Save via `closeModal()`, levando o jogador diretamente para o Menu de Titulo pronto.
- **Decodificacao de Classes do Heroi em `XF48409..11.rms` (`/g1..3`):**
  - O Bloco 1 (decriptado com a chave `m = {5, 71, 24, 59, 43, 16}`) armazena o ID da classe no indice 4: `rec[2 + 4] ^ 16`.
  - Os IDs mapeiam diretamente para os estilos de combate de `hero.tdf`:
    - `0`: Berserker
    - `1`: Cavaleiro (Knight / Cavaliere / Caballero)
    - `2`: Ladino (Rogue / Ladro / Pícaro)
  - O resumo local e da nuvem agora exibe a classe e o nivel em formato rico: `"Slot 1: Cavaleiro (Nv. 15)"`.
- **Estrutura de Instâncias na VM (`hl::Instance` vs `hl::ClassInfo`):**
  - Na VM (`src/vm/vm.h`), `ClassInfo` define os metadados dos campos em `std::vector<FieldInfo> fields`.
  - Já uma instância de objeto em execução (`struct Instance : Object`) armazena os valores de seus campos no vetor `std::vector<Value> f`.
  - Ao manipular campos de instâncias diretamente no código C++, o acesso deve ser `inst->f[field->index]`, e não `inst->fields`.
- **Nomes Reais de Bytecode vs Descompilação CFR para Reflexão (`VM::findMethod`, `VM::findField`):**
  - O descompilador CFR desambigua métodos sobrecarregados e campos gerando nomes sintéticos (ex.: `void_a()`, `bg_a()`, `var_int_a`, `var_bd_a`).
  - No interpretador da VM C++17, os nomes registrados no Constant Pool são os identificadores reais de bytecode (ex.: `a:()V`, `a:()Lbg;`, `a:I`, `a:Lbd;`).
  - Ao invocar métodos de classes do jogo via C++ nativo, deve-se sempre consultar a saída do `javap` para utilizar o nome e descritor canônicos, evitando falhas silenciosas de busca.
- **Reload de Saves Restaurados em Tempo Real sem Reiniciar o Jogo:**
  - Além de limpar o cache estático `XFile.store:Ljava/util/Hashtable;`, é mandatório chamar o método de instância `u.k:()V` na instância estática `u.a:Lu;`.
  - Esse método re-escaneia todos os slots do disco (`XF48409..11.rms`), decodifica os novos bytes e atualiza `u.b:B` (contagem de saves existentes).
  - Em seguida, chamando `bg.a:()V` e `bg.a:()Lbg;`, a tela de título é recriada com o botão "Continuar" ativo e apontando para os dados recém-restaurados.
- **Intercepção de `bw.a:(Ljavax/microedition/lcdui/Graphics;)V` para Badge de Versão:**
  - A classe `bw.class` renderiza o fundo do título e o texto original `"V.1.0.2"`.
  - Registrando um hook nativo em `VM::registerNatives` para `bw.a:(Ljavax/microedition/lcdui/Graphics;)V`, é possível reutilizar a própria rotina de renderização e invocar `bk.a:(Ljavax/microedition/lcdui/Graphics;II[BII)V` para desenhar `"v0.2.2"` centralizado abaixo de `"V.1.0.2"` em tom azul celeste (`0x80C0FF`), mantendo 100% da fidelidade estética dos bitmaps J2ME.


