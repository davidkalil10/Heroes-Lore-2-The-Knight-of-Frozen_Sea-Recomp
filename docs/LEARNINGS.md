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
- **Acesso a Elementos de `hl::Array` na VM C++:**
  - Na estrutura `hl::Array : Object` (`src/vm/vm.h`), os dados brutos são mantidos em `std::vector<uint8_t> data`.
  - Para arrays de referências (`type == 'L'`), o acesso aos ponteiros de objetos deve ser feito exclusivamente através do método `arr->refs()`, que retorna `Object**` (`reinterpret_cast<Object**>(data.data())`), por exemplo: `arr->refs()[index]`.
- **Mapeamento de Botões Físicos no Nintendo Switch (SDL2/libnx):**
  - No hardware do Nintendo Switch, os botões Joy-Con frontais seguem a disposição da Nintendo (Norte=X, Sul=B, Leste=A, Oeste=Y).
  - O backend SDL2 do libnx segue os nomes lógicos do layout Xbox para suas constantes:
    - O botão físico **X** (topo) emite `SDL_CONTROLLER_BUTTON_Y`.
    - O botão físico **Y** (esquerda) emite `SDL_CONTROLLER_BUTTON_X`.
  - Ao tratar eventos diretos `SDL_CONTROLLERBUTTONDOWN` para interfaces e modais, é essencial condicionar `#ifdef __SWITCH__` para que a ação do botão X (Restaurar) responda a `SDL_CONTROLLER_BUTTON_Y` e o botão Y (Desconectar) responda a `SDL_CONTROLLER_BUTTON_X`.
- **Fluxo Limpo de Recarregamento In-Game de Saves sem Telas de Pausa:**
  - O método `bd.a:()V` não é um reinicializador, mas sim a rotina de interrupção/pausa do MIDlet (`resumeApp`), que define `bd.q = true`. Quando `q == true`, `bd.paint` bloqueia o jogo com a mensagem `"Pressione qualquer tecla para continuar"` (`as.var_e_a.a(39)`).
  - Ao restaurar dados na nuvem durante o jogo:
    1. Nunca chamar `bd.a:()V` e garantir `bd.q = 0`.
    2. Fechar menus in-game com `ck.a:(Z)V`.
    3. Rescanear com `u.k:()V` e chamar `u.a:(I)V` com argumento `1`. O motor executa o caso 9 (`u.r()`), descompactando o RMS diretamente na sessão ativa e executando o fade-in nativo `bd.var_bd_a.a((byte)2, false)`.
    4. O jogador volta direto para o gameplay no ponto do save, sem passar por telas de título ou cliques estranhos.

## Sessão 8 (Arquitetura de Textos do HL2, Multi-idiomas e Troca a Quente)
- **Comparação Arquitetural de Textos (HL1 vs HL2):**
  - No *Heroes Lore 1 (Wind of Soltia)*, todos os textos do jogo residiam em um único arquivo binário monolítico (`lang.en-GB`), compactado em formato de bit-stream variável (BabbleText com árvore/ponteiros de bits de 0 a 4500).
  - No *Heroes Lore 2 (The Knight of Frozen Sea)*, a Hands-On Mobile redesenhou totalmente o subsistema de localização, dividindo os textos em três estruturas modulares de tamanho pré-fixado:
    1. **Textos de Sistema, UI, Quests e Habilidades (`reference/extracted/t/*.tdf`):** 19 arquivos binários com 834 strings no total (`com.tdf`, `gm.tdf`, `q.tdf`, `sk0..2.tdf`, `help.tdf`, `hero.tdf`, `itmtp.tdf`, `shop.tdf`, `rf.tdf`, `bm.tdf`, `bsk.tdf`, `bsm.tdf`, `ed.tdf`, etc.). Formato: byte 0 = contagem de strings $N$; a seguir, para cada string, 2 bytes de comprimento em big-endian seguidos de bytes de texto UTF-8.
    2. **Itens e Equipamentos (`reference/extracted/itm/*`):** 34 arquivos com 578 itens no total. Registros com 4 bytes de atributos seguidos por byte de tamanho de nome, bytes do nome, byte de tamanho de descrição e bytes da descrição.
    3. **Nomes de Região e Diálogos de NPCs (`reference/extracted/m/m/*.m`):** 111 mapas com 1.430 diálogos de NPC no total. O cabeçalho armazena o nome da região (byte de tamanho + texto) e a seção de eventos armazena a matriz sequencial de falas (byte de contagem + bytes de tamanho e texto por fala).
- **Renderizador de Fontes (`bk.java`):**
  - Utiliza fonte bitmap de 12px com tabela de larguras para ASCII 32..126 (`/ftd/eng12w`).
  - Caracteres com o bit mais significativo ligado (`& 0x80 != 0`) eram reservados para sílabas Hangul coreanas (EUC-KR de 2 bytes). Por essa razão, textos ocidentais (inglês e português) operam com máxima fidelidade e clareza visual utilizando a faixa padrão ASCII / transliteração limpa sem caracteres corrompidos.
  - Caracteres especiais atuam como códigos de formatação de cores e quebras de linha:
    - `@` (0xFFFFFF branco)
    - `|` (0xFFFF00 amarelo)
    - `$` (1630207 azul)
    - `{` / `}` (0xFF9F3F laranja / 14597755)
    - `'` (65280 verde)
    - `;` (quebra de linha)
- **Troca a Quente de Idioma em Tempo Real sem Recarregar Mapa:**
  - A troca de idioma intercepta `Platform::readAsset` redirecionando para `assets/lang/<idioma>/`.
  - Ao alterar o idioma nas opções, `Platform::reloadLanguage(vm)` atualiza:
    1. Os vetores de strings de todas as instâncias ativas de `class e` (`as.var_e_*`, `ck.var_e_*`, etc.).
    2. O array estático `ah.var_java_lang_Object_arr_d` com os diálogos traduzidos do mapa ativo (`u.h`).
    3. O banner de nome de mapa em `u.var_ah_a.i`.
    4. Os nomes e descrições dos itens ativos no inventário (`cp.class`).
    5. O menu de configurações é redesenhado de imediato com os novos textos traduzidos.

## Sessão 9 (Correção da Interceptação de Assets, Tradução Completa de Quests e Diálogos, Localização dos Menus)
- **Causa Raiz da Não-Localização de Diálogos e Missões:**
  - No motor Java do HL2, `Class.getResourceAsStream(path)` em `natives.cpp` prefixa o caminho com `vm.dataDir` (ex: `"reference/extracted/m/m/00.m"` ou `"reference/extracted/t/q.tdf"`).
  - Em `Platform::readAsset`, a verificação de localização checava `clean.rfind("t/", 0) == 0`, o que falhava porque `clean` começava com `"reference/extracted/"`. Com isso, o jogo caía diretamente nos arquivos em inglês originais no disco.
  - **Solução:** Normalização completa de `relTarget` removendo os prefixos `reference/extracted/`, `extracted/` e `assets/` antes de verificar as rotas localizáveis (`t/`, `itm/`, `m/m/`).
- **Tradução em Lote de Alto Desempenho para Textos do Jogo:**
  - O HL2 possui 1.969 textos únicos entre diálogos de mapa, missões de `q.tdf` e textos de sistema.
  - Criado o script `tools/run_fast_translation.py`, que agrupa até 20 textos por requisição com o separador `\n@@@\n`, reduzindo as requisições HTTP de ~2.000 para apenas 99 lotes.
  - Todas as 255 linhas de missões de `q.tdf` e todos os 1.430 diálogos de NPC nos 111 mapas foram traduzidos mantendo intactos os caracteres especiais de cores (`@`, `|`, `$`, `{`, `}`) e padronizados em ASCII limpo compatível com a fonte bitmap original.
- **Localização Dinâmica dos Menus Personalizados:**
  - As opções adicionais de recompilação (5..9) em `l_draw_native` agora consultam dinamicamente `Platform::getCurrentLanguage()`, alternando automaticamente entre:
    - `Idioma: PT-BR / English` (com valores `PT-BR` ou `English`)
    - `Tela: Auto / 3:4 / 16:9` (ou `Aspect`)
    - `Nuvem: Google` (ou `Cloud`)
    - `Atualizar: Checar` (ou `Update: Check`)
- **Compatibilidade com Nintendo Switch:**
  - Adicionado fallback explícito para `romfs:/lang/...` e `romfs:/assets/lang/...` em `Platform::readAsset` sob a diretiva `#ifdef __SWITCH__`, garantindo que o executável NRO carregue os textos localizados embutidos diretamente no RomFS.

## Sessão 10 (Build Windows Nativo, Sistema de Log Contínuo, Rastreamento de Pilha Java e Crash Handlers)
- **Diagnóstico da Investigação de Crash no Combate (Mapa 04.m):**
  - O jogador relatou fechamento instantâneo do jogo ao atacar no mapa `04.m` (porão do Wolfgang, após seguir o NPC que prepara uma emboscada).
  - No código decompilado, no mapa da cidade (`00.m`), `ah.var_boolean_a` permanece `false`, fazendo `u.c((byte)0)` retornar imediatamente (ataque nunca é acionado). No mapa `04.m`, `by12 > 0` (existem inimigos), o que define `ah.var_boolean_a = true`. Portanto, ao pressionar tecla 5 / botão de ação, é a primeira vez em toda a sessão de jogo que `u.c((byte)0)` é efetivamente executado.
  - A cadeia de execução de combate envolve: `u.c((byte)0)` -> `var_b_a.boolean_c(by2)` -> `u.d((byte)3, ...)` -> `u.d()` -> `b.h()` -> `b.boolean_a()` -> `ce.boolean_a()` -> `ce.boolean_h()` -> `b.c(BBI)Z` -> `b.a(ag, ...)` -> `ag.a(...)` -> `bd.var_bd_a.a(this, false)` -> `Image.createImage(...)` / `getGraphics()` / `bd.hlzTextWidth(...)` / `ak.a((byte)4)`.
- **Implementação do Sistema de Logging Contínuo (`heroes_lore_2.log`):**
  - Anteriormente, o arquivo de log só era aberto sob `#ifdef __SWITCH__`. No Windows e Linux, saídas para stdout/stderr eram perdidas caso o aplicativo fosse executado desanexado do console.
  - Adicionada abertura de `heroes_lore_2.log` no `main.cpp` com modo `_IONBF` (flush imediato a cada `boot_log` / `printf`), garantindo persistência mesmo se o processo for finalizado abruptamente pelo sistema operacional.
- **Rastreamento Dinâmico de Pilha de Chamadas Java (`CallFrame` na VM):**
  - Adicionado `struct CallFrame { Method* m; int pc; };` e `std::vector<CallFrame> callStack;` em `ThreadCtx`.
  - No `VM::invoke()`, um RAII `FrameGuard` empilha `{m, 0}` na entrada e desempilha na saída.
  - No interpretador de bytecode (`interp.cpp`), a cada instrução executada em `exec()`, `tctx->callStack.back().pc = curpc;` mantém o bytecode PC perfeitamente atualizado em tempo real.
  - Implementada a função `VM::dumpStackTrace()`, que formata e registra no log e no terminal a sequência completa de métodos chamados (ex: `at rpg/u.c:(B)V (pc=42)`), identificando com precisão onde qualquer exceção ou erro fatal ocorre.
- **Handlers Nativos de Exceção de Hardware (Windows SEH + POSIX Signals):**
  - No Windows: `SetUnhandledExceptionFilter(windowsCrashHandler)` intercepta Access Violations (0xC0000005) e falhas nativas, despejando código de exceção, endereço de memória faltoso, thread ativa e a pilha Java correspondente diretamente em `heroes_lore_2.log`, seguido de um diálogo nativo `MessageBoxA`.
  - No Linux/Android: `sigaction` para `SIGSEGV`, `SIGABRT`, `SIGFPE`, `SIGILL` despeja a pilha ativa e aciona `abort()`.
- **Intercepção de Exceções de Input no SDL:**
  - Funções `sendKeyPressed` e `sendKeyReleased` em `platform_sdl.cpp` interceptam qualquer `JavaThrow` ou `std::exception` disparada durante `keyPressed` / `keyReleased` (em vez de engoli-la silenciosamente), gravando o tipo de erro, mensagem e o stack trace Java completo.
- **Build Windows:**
  - Executável `build/heroes_lore_2.exe` compilado com sucesso com todas as DLLs e assets. Criado o script `run_windows.bat` na raiz para execução rápida com duplo clique.
- **Causa Raiz do Crash no Combate e Resolução Definitiva:**
  - O log capturou com 100% de precisão: `[FATAL ERROR] método não encontrado: java/lang/Math.max:(II)I` disparado em `bd.a(Lag;Z)V (pc=52)`.
  - A classe `bd` gerencia a interface do jogo (HUD) e, ao entrar em combate ou mirar em um inimigo pela primeira vez, o método `bd.a(ag, boolean)` calcula a largura do banner do alvo: `Math.min(Math.max(bd.hlzTextWidth(...) + 16, 66), bw.g - 20)`.
  - `Math.abs:(I)I` e `Math.min:(II)I` já estavam registrados em `natives.cpp`, mas `Math.max:(II)I` nunca havia sido registrado na VM, causando erro fatal no primeiro golpe desferido no jogo inteiro.
  - Implementado `Math_max` e registrado `java/lang/Math.max:(II)I` em `src/vm/natives.cpp`. Recompilação validada com sucesso.

## Sessão 11 (Sistema de Menu Secreto de Trapaças, God Mode, SP Infinito, Ouro e Ranking de Honra)
- **Engenharia Reversa dos Atributos de Combate do Jogador:**
  - O jogador em `u.a` (instância de `b.class`) armazena:
    - `b.a` (int): HP atual.
    - `b.d` (int): HP máximo.
    - `b.b` (int): SP atual.
    - `b.e` (int): SP máximo.
    - `b.c` (int): EXP atual.
    - `b.f` (int): EXP necessária para o próximo nível.
    - `b.b` (byte): Patente militar / Honor Rank (0 a 14).
    - `u.f` (int, estático): Ouro do jogador.
    - `u.g` (int, estático): Pontos de Honra (criptografados com XOR 0xA1F084DE no save RMS).
- **Mapeamento das Patentes de Honra (`hero.tdf`):**
  - O jogo original requeria conexão online aos servidores da SK Telecom coreana (`211.239.150.70:30000`) para subir de patente via Batalhas em Rede ("Network Battles"). Como os servidores não existem mais, o rank permanecia travado em Recruta (Trainee, 0).
  - Todas as 15 patentes originais foram extraídas e mapeadas: 0: Recruta (Trainee), 1: Mercenário, 2: Infantaria Leve, 3: Cavalaria Leve, 4: Cabo, 5: Centurião, 6: Escudeiro, 7: Cavaleiro Júnior, 8: Cavaleiro Pleno, 9: Membro da Ordem, 10: Capitão da Ordem, 11: Guarda Real, 12: Capitão da Guarda Real, 13: Comandante, 14: Comandante Supremo (Supreme Commander).
  - Ao alterar a patente, o método `b.n:()V` é acionado para recalcular os bônus de combate e permitir o uso sem penalidades de qualquer arma rara que exija alto Honor Rank.
- **Implementação do Modal de Cheats (`src/platform/cheats.h` e `cheats.cpp`):**
  - Criado o componente nativo `Cheats` no mesmo padrão arquitetural de `CloudSave` e `Updater`:
    - `God Mode`: Trava o HP no máximo a cada frame durante o loop do jogo.
    - `SP Infinito`: Trava o SP no máximo a cada frame.
    - `Adicionar Ouro (+100.000 G)`: Incrementa `u.f` diretamente.
    - `Patente / Rank de Honra`: Seletor interativo `< [Patente] >` permitindo escolher qualquer uma das 15 patentes.
    - Suporte completo a gamepad, teclado e toques na tela (touch).
- **Integração no Menu de Configurações (`l.class` em `natives.cpp`):**
  - O menu de opções foi expandido para 11 itens (0..10), posicionando a opção `Cheats: Abrir` exatamente abaixo de `Atualizar: Checar`.
  - Calibradas as coordenadas e altura da janela modal in-game (`boxH = 224`, `startY = bw_j - 88`) para acomodar com precisão e elegância visual os 11 itens na tela.
- **Diagnóstico e Correção da Sessão 11 (b.n e Barras de HP/SP):**
  - **Fatal Error `invoke chamado sem ThreadCtx ativo no método: b.n`:**
    - Acontecia porque `Cheats::setRank` tentava invocar `vm->invoke(mBn, ...)` diretamente a partir do processador de eventos/toques SDL, onde `tctx` estava nulo fora do ciclo de thread Java ativo.
    - Análise do bytecode de `b.java:686-745` demonstrou que `b.n:()V` apenas recalcula bônus de equipamentos (armas/armaduras), não sendo necessário para a patente. A alteração direta de `player.b:B` (0..14) e de `u.g:I` (pontos de honra) aplica o rank de forma imediata e 100% segura sem invocar bytecode fora de contexto.
  - **Correção Definitiva de God Mode e SP Infinito:**
    - O HUD do jogo (`bd.java:506-519`) condiciona a renderização gráfica das barras aos sinalizadores booleanos `bd.d:Z` (vida) e `bd.e:Z` (mana). Sem ativá-los, a interface visual permanecia desenhando a barra com o valor reduzido.
    - Foram criados métodos nativos em `src/vm/natives.cpp` interceptando `b.b:(I)V` (dano/cura do herói) e `b.a:(I)V` (consumo/recuperação de SP). Quando ativados, qualquer dano ou custo recebido é neutralizado instantaneamente, mantendo os valores no máximo e disparando `bd.d = true` e `bd.e = true`.
    - No loop principal (`src/main.cpp`), `Cheats::update(&vm)` agora é sincronizado antes e depois do ciclo de renderização gráfica `paint`, garantindo consistência total e barras 100% cheias ininterruptamente.

## Sessão 12 (Cheat de Zero Cooldown e Seleção de Patente para Telas Touch / Celular na v0.2.12)
- **Engenharia Reversa dos Timers de Cooldown (`u.var_int_arr_a` / `u.a:[I]`):**
  - O jogo original gerencia a recarga de todas as habilidades e itens através do array estático `u.a:[I]` de 4 inteiros na classe `u`.
  - No bytecode:
    - `-1` significa "habilidade pronta para conjuração".
    - Valores `> 0` indicam a quantidade de ticks restantes de recarga.
    - `bd.java:204`: `if (u.var_int_arr_a[n2] > 0) return;` bloqueia o acionamento caso o slot esteja em cooldown.
    - `bd.java:614`: O HUD desenha uma sobreposição sombreada circular se `u.var_int_arr_a[slot] > 0`.
    - `u.java:441`: `u.a(int slot, boolean isSkill)` atribui a contagem de recarga logo após a conjuração.
  - Com o cheat `Zero Cooldown` ativado:
    - `Cheats::update(&vm)` força todos os 4 slots do array para `-1` em tempo real a cada frame.
    - O jogador pode disparar qualquer habilidade repetidamente sem nenhum atraso e sem nenhuma sombra de recarga no HUD.
- **Interface Touch Otimizada para Celular na Seleção de Patente:**
  - Em dispositivos móveis (Android) e consoles portáteis em modo touch, o jogador não dispõe de setas direcionais físicas no modal de cheats.
  - Para resolver a usabilidade touch:
    - Criados botões gráficos dedicados e estilizados `[ < ]` e `[ > ]` com bordas e fundo destacados na linha de patente.
    - Hitboxes de toque generosas (Action 10 e Action 11) garantem acionamento imediato e preciso mesmo com o polegar em qualquer tamanho de tela.
    - Tocar em qualquer outro ponto da linha da patente (Action 4) avança ciclicamente para a próxima patente e aplica na hora.
    - Cada alteração é gravada imediatamente no personagem (`player.b:B` e `u.g:I`) e exibe banner de feedback com o nome nobre da patente em português ou inglês.

## Sessão 13 (Correção Cirúrgica de Alinhamento e Proporções do Menu de Cheats na v0.2.13)
- **Causa Raiz do Desalinhamento e Sobreposição de Texto:**
  - O método `Platform::getTextWidth(str, charW, stepX)` trata `charW` como o tamanho de fonte `fontSize` quando o renderizador TTF está ativo.
  - No código de renderização do modal, a largura de todos os textos estava sendo consultada passando `(int)(fontSize * 0.58f)` (resquício de fontes bitmap legadas).
  - Como resultado, a largura computada de strings como "Comandante Supremo" dava apenas ~58% do tamanho real desenhado na tela, fazendo o botão `[ > ]` ser desenhado no meio da palavra ("Comandante Su > mo") e desalinhando todas as tags `[ DESATIVADO ]`, `[ EXECUTAR ]` e `[ SAIR ]` pela margem direita.
- **Novo Layout e Alinhamento Preciso:**
  - Todas as chamadas a `getTextWidth` passaram a enviar diretamente o `fontSize` real de renderização.
  - Implementada uma âncora de margem direita fixa (`rightAnchor = modalX + padX + rowW - 14 * scaleFactor`) para todas as opções, garantindo que o caractere de fechamento `]` termine rigorosamente na mesma coluna de pixels.
  - O seletor de patentes foi redesenhado em um componente elegante de 3 seções:
    - Botão `[ < ]` estilizado com borda metálica e fundo escuro.
    - Caixinha central fixa (180px) com o nome da patente perfeitamente centralizado, impedindo qualquer colisão de texto.
    - Botão `[ > ]` alinhado à direita no mesmo pixel limite das demais opções.
  - Proporções harmônicas de escala (`scaleFactor = std::clamp(refDim / 720.0f, 0.85f, 1.25f)`) evitando que a janela fique excessivamente grande em telas verticais de smartphones e mantendo o padrão refinado no Nintendo Switch e PC.

## Sessão 14 (Adoção do Padrão Responsivo de CloudSave no Menu de Cheats na v0.2.14)
- **Diagnóstico da Escala Reduzida em Smartphones:**
  - Em telas móveis verticais de alta resolução (ex: 1080x2400 portrait), um fator de escala travado em 1.25x fazia a janela modal ocupar apenas ~30% da largura útil da tela e ter fontes muito pequenas (~18px), tornando a leitura desconfortável e as áreas de toque minúsculas para o polegar.
- **Implementação do Padrão CloudSave:**
  - Foi adotada a mesma fórmula dinâmica consolidada em `CloudSave::drawModal`:
    - `isPortrait = (winH > winW)` e detecção de mobile (`#if defined(__ANDROID__)`).
    - Em portrait móvel: largura adaptativa preenchendo **93% da largura útil da tela** (`winW * 0.93f`), deixando margem lateral simétrica e limpa de 3.5%.
    - `scaleFactor` dinâmico: `(refDim / 720.0f) * 1.15f` em mobile (gerando ~1.725f em telas 1080p), elevando a tipografia para títulos em ~38px, itens em ~28px e tags em ~26px.
    - Altura de linha generosa no mobile (`rowH = 52 * scaleFactor` = ~90px) e botões de toque com `42 * scaleFactor` de largura, oferecendo áreas de clique confortáveis para o dedo.
    - Posicionamento vertical inteligente (`modalY = winH * 0.16f`) sobrepondo a janela perfeitamente sobre a tela de jogo sem cobrir o Gamepad virtual posicionado na metade inferior.
  - No Nintendo Switch e PC (Landscape 16:9), todas as proporções aprovadas foram preservadas rigorosamente intactas (`scaleFactor = 1.0f`, `modalW = 590px`, `rowH = 44px`).
  - Acabamento visual aprimorado com Sombra Projetada e Moldura Interna em Ouro Nobre (Soltia Theme), mantendo identidade visual uniforme entre o Cloud Save e o Menu de Cheats.

## Sessão 15 (Otimização Ergonômica do Layout Vertical Mobile/Switch na v0.2.15)
- **Problema de Oclusão do HUD e Alcance das Mãos no Modo Retrato:**
  - Anteriormente, os botões `MENU` e `MAPA` ficavam no topo extremo da tela, forçando a área do jogo a começar mais abaixo (`gameY = ~250px`).
  - Como consequência, a base da tela do jogo descia a ponto do HUD de combate original (vida, mana e ícones de habilidades ativas) ser invadido e coberto pelos botões virtuais `3 (SKILL)` e `9 (SKILL)`.
  - Além disso, no smartphone em pé, o jogador precisava retirar a mão da posição de empunhadura para tocar no topo da tela para abrir o menu ou mapa.
- **Novo Posicionamento Estratégico (Simulação do Usuário Validada):**
  - A tela do jogo foi elevada para o topo da janela (`gameY = winH * 0.015f`), desobstruindo integralmente o HUD de combate. Nenhum botão virtual fica mais sobreposto à área de jogo.
  - Os botões `[ MENU ]` e `[ MAPA ]` foram transferidos para a zona inferior esquerda, posicionados lado a lado imediatamente acima do D-Pad direcional (`sysY = dpadTop - pillH/2 - 0.035*winW`).
  - Na linha horizontal logo abaixo do jogo, formou-se um alinhamento harmonioso: `[ MENU ]` e `[ MAPA ]` à esquerda, e `( 3 SKILL )` e `( 9 SKILL )` à direita.
  - Acesso instantâneo e ergonômico a todas as funções com o polegar esquerdo sem alterar nomes, cores ou o arco de ação favorito dos botões de combate.

## Sessão 16 (Detecção Automática do Modo Dock no Nintendo Switch na v0.2.16)
- **Desafio do Modo Dock (TV) no Nintendo Switch:**
  - Quando o console era conectado ao dock na TV, o jogo mantinha na tela da televisão os botões virtuais touchscreen (D-Pad, botões de ação e os botões utilitários de ocultar/olho e rotação de tela), poluindo a imagem 1080p da TV sem nenhuma necessidade, já que na TV o jogador utiliza Joy-Cons ou Pro Controller.
- **Detecção em Tempo Real via Horizon OS / libnx:**
  - Implementada a função `isSwitchDocked()` consultando `appletGetOperationMode() == AppletOperationMode_Console` da biblioteca `libnx`.
  - Se `mode == AppletOperationMode_Console`:
    - `calculateLayout()` zera e limpa completamente `layout.buttons` e `layout.dpadR = 0`.
    - `drawGamepad()` retorna imediatamente sem desenhar nenhum elemento virtual de toque.
    - Se o jogador estava com rotação de tela ativa (TATE vertical/Flip Grip no modo portátil), a saída na TV muda dinamicamente para Paisagem 16:9 tradicional em 1080p, evitando imagem de lado na televisão.
    - A transição é detectada automaticamente com notificação discreta OSD: `"Modo TV (Dock): Controles virtuais desativados"`.
  - Ao remover o console do dock (`AppletOperationMode_Handheld`):
    - Todos os controles virtuais e a orientação prévia de tela do modo portátil são restaurados instantânea e perfeitamente: `"Modo Portatil: Controles virtuais restaurados"`.

## Sessão 17 (Correção da Renderização de Modais no Modo Vertical do Switch na v0.2.17)
- **Diagnóstico da Janela Invisível no Modo Retrato (TATE):**
  - No Nintendo Switch em modo vertical (`s_screenRotation != 0`), a cena é composta inicialmente em uma textura intermediária `s_rotateTarget` de 720x1280 e depois projetada e rotacionada em 90° ou 270° na tela física.
  - No entanto, a rotina de renderização dos diálogos modais (`Cheats::drawModal`, `CloudSave::drawModal` e `Updater::drawModal`) estava posicionada exclusivamente no final da função `Platform::present()`, após o retorno antecipado (`return`) do bloco de rotação.
  - Consequentemente, ao abrir o Menu de Cheats ou o Cloud Save no modo vertical, o modal tornava-se ativo e capturava os eventos de entrada, mas nunca era desenhado em `s_rotateTarget`. O jogador enxergava a imagem estática de jogo e parecia "travado", destravando apenas ao apertar 'B' (que fechava o modal invisível) ou mudando para modo paisagem (onde a rotina normal desenhava o modal).
- **Resolução:**
  - Adicionadas as chamadas de renderização de `Updater::drawModal`, `CloudSave::drawModal` e `Cheats::drawModal` diretamente dentro do bloco de composição de `s_rotateTarget` (passando o viewport 720x1280).
  - Dessa forma, os modais adaptam-se com perfeição ao modo portrait, recebem todos os toques e navegação via botões físicos (D-Pad, A, B) e são rotacionados na orientação correta da tela física do Switch.




