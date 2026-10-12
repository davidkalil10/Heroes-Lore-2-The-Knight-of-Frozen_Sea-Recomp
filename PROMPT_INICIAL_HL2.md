# 🚀 Prompt para Abrir a Nova Sessão de Heroes Lore 2

Copie e cole o texto abaixo na primeira mensagem da nova janela do Antigravity ao abrir a pasta `heroes_lore_2_recomp`:

```markdown
Olá! Vamos iniciar o projeto de recompilação nativa de Heroes Lore 2: The Knight of Frozen Sea (C++17 + SDL2).

Por favor:
1. Leia atentamente o arquivo `AGENTS.md` e `docs/STATUS.md`.
2. Consulte o guia de arquitetura comprovado em `docs/PORTING_GUIDE_BLUEPRINT.md`.
3. O JAR original já está extraído em `reference/extracted/`, decompilado com CFR em `reference/decompiled_cfr/` e com bytecode desmontado em `reference/javap/`.
4. O MIDlet principal identificado é `rpg.RPGHero2`.
5. Nosso objetivo imediato é o **Marco 0 (Milestone 1)**: adaptar o ponto de entrada em `src/main.cpp` e o motor C++ para carregar a classe `rpg.RPGHero2`, renderizar a tela de título no PC via SDL2 em 240x320, tocar a música e permitir iniciar o jogo jogando com teclado e gamepad!
```
