# 🏷️ VERSIONING — Políticas de Versionamento e Lançamento de Releases

Este documento define as regras de versionamento semântico, fluxo de CI/CD automatizado e lançamento de versões para a recompilação nativa de **Heroes Lore 2: The Knight of Frozen Sea**.

---

## 1. Versionamento Semântico (SemVer)

O projeto adota o padrão `vMAJOR.MINOR.PATCH`:

- **MAJOR (v1.0.0):** Jogo 100% jogável do início ao fim em todas as 4 plataformas com persistência RMS validada, áudio completo e todos os mapas transitáveis sem falhas.
- **MINOR (v0.x.0):** Conclusão de grandes marcos arquiteturais do Blueprint:
  - `v0.1.0` — **Marco 0:** Boot nativo no PC, renderização da tela de título, New Game e fluxo inicial.
  - `v0.2.0` — **Marco 1:** Game loop a 15/30 FPS, True Widescreen 16:9, Gamepad completo e menu de opções personalizado.
  - `v0.3.0` — **Marco 2:** Jogabilidade e persistência de save games RMS em disco confirmada.
  - `v0.4.0` — **Marco 3:** Suporte consolidado multiplataforma (Android, Switch, Linux, Windows).
- **PATCH (v0.x.y):** Correções de bugs pontuais, ajustes visuais, patches de áudio ou melhorias de compatibilidade.
  - `v0.2.1` — **Patch 1:** Correção da restauração de saves na nuvem (limpeza de `XFile.store`, encerramento de sessão in-game com transição imediata para o Title Screen), identificação de classes dos heróis nos slots (`Berserker`, `Cavaleiro`, `Ladino`) e validação do sistema OTA.
  - `v0.2.2` — **Patch 2:** Recarregamento em tempo real do save restaurado da nuvem (resolução de símbolos de bytecode `u.k:()V`, `bg.a:()V`, `bd.a:()V`), badge visual da versão nativa (`v0.2.2`) centralizado no Menu de Título e botão dedicado para verificação de atualizações no menu de configurações (`Update: Check`).
  - `v0.2.3` — **Patch 3:** Correção do mapeamento dos botões Joy-Con no Nintendo Switch no modal de nuvem (Joy-Con X=Restaurar, Joy-Con Y=Desconectar) e recarregamento in-game direto e transparente de saves restaurados via `u.a:(I)V` (arg 1) sem telas de pausa (`bd.q = 0`) ou cliques intermediários.

---

## 2. Fluxo de CI/CD Automatizado (GitHub Actions)

A esteira de integração contínua está implementada em [`.github/workflows/build.yml`](../.github/workflows/build.yml):

1. **Build Contínuo na Branch `main` (Sem Release Prematura):**
   - A cada `push` na branch `main`, 4 jobs são executados em paralelo nos runners do GitHub:
     - `build-switch`: Compilação Homebrew via devkitPro/devkitA64 gerando `heroes_lore_2.nro`.
     - `build-windows`: Compilação nativa via MSYS2 UCRT64 gerando o ZIP standalone com executável e runtime.
     - `build-linux`: Compilação Ubuntu 22.04 + empacotamento AppImage portátil `heroes_lore_2_linux_x86_64.AppImage`.
     - `build-android`: Compilação Java 17 + Gradle 8 + NDK 26 gerando APK universal e arm64.
   - **Upload de Artefatos:** Os executáveis são empacotados e anexados como artefatos de teste via `actions/upload-artifact@v4`.
   - **Regra:** Nenhuma tag ou release pública é criada automaticamente no push da `main`, garantindo que apenas versões testadas e aprovadas pelo usuário sejam publicadas.

2. **Geração de Release Oficial (Via Tag Git):**
   - Quando um marco for homologado e o usuário solicitar a release:
     - Criação de tag anotada (ex: `git tag -a v0.2.0 -m "Release v0.2.0 - Menu de Opções & True Widescreen"`).
     - Envio da tag para o repositório remoto (`git push origin v0.2.0`).
     - O workflow do GitHub Actions detecta a tag e publica a release oficial com notas de atualização automáticas e todos os 4 binários anexados.

---

## 3. Isolamento de Identificadores e Pacotes

Para evitar qualquer sobreposição ou conflito com instalações de *Heroes Lore: Wind of Soltia*:

| Plataforma | Identificador / Pacote | Observações |
| :--- | :--- | :--- |
| **Android** | `com.davidbraga.heroeslore2` | FileProvider: `com.davidbraga.heroeslore2.provider` |
| **Nintendo Switch** | `0100484C32000000` | Hex ASCII de 'HL2' + prefixo de Homebrew |
| **Linux** | `heroes_lore_2` | Dados em `~/.local/share/heroes_lore_2` |
| **Windows** | `heroes_lore_2.exe` | Dados em `./` e `%APPDATA%/heroes_lore_2` |
| **Google Drive** | `heroes_lore_2_save.json` | Pasta: `Heroes Lore II - The Knight of Frozen Sea` |
| **Auto-Updater** | `davidkalil10/Heroes-Lore-2-The-Knight-of-Frozen_Sea-Recomp` | Repositório exclusivo de updates OTA |
