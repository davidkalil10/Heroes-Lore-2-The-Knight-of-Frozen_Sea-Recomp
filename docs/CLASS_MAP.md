# CLASS_MAP ‚Äî Heroes Lore 2: The Knight of Frozen Sea

Este documento mapeia todas as 109 classes decompiladas do jogo para seus pap√©is no motor.

## Classes de Entrada & Sistema
- `rpg.RPGHero2`: MIDlet principal (`extends javax.microedition.midlet.MIDlet`). Ponto de entrada do jogo.
- `com.skt.m.AudioClip`, `com.skt.m.AudioSystem`: APIs de √°udio da operadora coreana SK Telecom.
- `com.skt.m.Device`, `com.skt.m.BackLight`: Controle de luz de fundo e vibra√ß√£o do aparelho.
- `com.xce.io.XFile`, `com.xce.lcdui.XDisplay`: Extens√µes da plataforma XCE.

## Classes Ofuscadas da Raiz (`a` .. `cr`)
_Em auditoria conforme o avan√ßo das sess√µes._

## Descobertas (Sess„o 2)
- `cd`: Canvas principal (current Canvas no loop). `cj`: engine/loader (thread prÛpria, `cj.a(Display)` no construtor do MIDlet; `cj.var_cj_a.b()` = start).
- `bz`: thread de ·udio (usa `wait/notify`, `AudioClip`/`AudioSystem`).
- `as`: leitura de recursos via `XFile`; `u`, `cj`: gravaÁ„o/leitura de saves via `XFile` (RMS).
- `af`: rede (`Connector`, `XBrowser`, `Socket`) ó stub: `Connector.open` lanÁa IOException.
