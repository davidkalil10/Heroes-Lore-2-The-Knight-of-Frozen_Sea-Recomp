# ❄️ Heroes Lore 2: The Knight of Frozen Sea — Native Recompilation (C++17 + SDL2)

Recompilação nativa do RPG clássico **Heroes Lore 2: The Knight of Frozen Sea** (*Hands-On Mobile Korea*), baseado na versão 240x320 em inglês.

Executa o **bytecode original decompilado em C++17** com uma camada fina sobre SDL2, preservando 100% das fórmulas, atributos, IA e diálogos originais.

---

## 🛠️ Status do Projeto
- **Fase:** Marco 0 (Scaffolding, auditoria de classes e inicialização do MIDlet `rpg.RPGHero2`).
- **Blueprint Arquitetural:** Documentado em [`docs/PORTING_GUIDE_BLUEPRINT.md`](docs/PORTING_GUIDE_BLUEPRINT.md).

## ⚙️ Como Compilar no PC (Windows / Linux)
```bash
cmake -B build -G Ninja -DCMAKE_BUILD_TYPE=Release
cmake --build build
.\build\heroes_lore_2.exe
```
