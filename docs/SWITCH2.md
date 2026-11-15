# Heroes Lore 2: The Knight of Frozen Sea — Switch 2 experimental

## Integração à main e releases — 15/11/2026

O suporte Switch 2 passa a integrar o fluxo multiplataforma. `build.yml` chama `build-switch2.yml` como workflow reutilizável, evitando uma segunda compilação independente no mesmo push. Pushes na main e pull requests geram o artefato; tags `v*` publicam o NRO e seu SHA-256 junto dos demais arquivos, após as builds terminarem com sucesso. O workflow de Switch 2 também pode ser iniciado manualmente.

As releases atuais recebem o NRO exato aprovado no console, sem substituir os arquivos das outras plataformas. Para atualizações futuras, use o versionamento normal do projeto: Switch 2 herda `APP_VERSION` de `Makefile.switch`. A publicação manual usa a tag informada, em vez de usar o nome da branch como tag. Não há mudança do formato RMS nem da identidade Google Drive nesta integração.

As seções seguintes registram a preparação e os testes iniciais da branch experimental. As referências a main inalterada e ausência de publicação se referem àquela etapa anterior.


Build separada da base 0.2.18 para kaiHEN/ounce-hbmenu. Preserva lógica do jogo, recursos, localização, persistência e Google Drive. Makefile e workflow originais das demais plataformas permanecem intactos.

## Compilação no GitHub

O workflow **Experimental Nintendo Switch 2 NRO** usa `devkitpro/devkita64:20260219`, ounce-devkit `20261115` e instalador fixado na revisão `0f38ba80d7ee768c5749278f127749d14ece2036`. O instalador verifica o SHA-256 do SDK. Esse ambiente já compilou os ports de Heroes Lore Zero e Wind of Soltia aprovados no console; o resultado não certifica automaticamente o jogo 2.

Mudanças relevantes na branch `codex/switch2-action` disparam a build experimental. O workflow também define execução manual quando disponível no GitHub. Não publica releases, cria tags ou altera a main.

O artefato `heroes_lore_2_switch2_nro` contém o NRO, SHA-256, relatório e este guia. Logs são publicados separadamente, inclusive em falhas. O relatório verifica código NRO0, limites das seções ASET, ícone, NACP e RomFS.

## Alterações delimitadas

`Makefile.switch2` seleciona `libounce/switch2_rules`, `SWITCH2_CPU`, saída `heroes_lore_2_switch2.nro` e objetos em `build_switch2`. As regras do SDK priorizam as bibliotecas gráficas OunceVK, mantendo as portlibs compatíveis de SDL2, áudio e rede.

O atualizador diferencia `__SWITCH2__` antes de `__SWITCH__` e procura apenas `heroes_lore_2_switch2.nro`, preservando o comportamento das outras plataformas. A inicialização de rede e as rotinas Google Drive não são desativadas.

## Saves e isolamento entre jogos

O diretório `sdmc:/switch/heroes_lore_2` e o formato RMS existente são preservados. O jogo 2 reconhece arquivos `XF*.rms` e nomes legados conforme seu código atual, e o backup reúne dinamicamente os arquivos RMS. Não substituir esse comportamento por listas de arquivos de Zero ou Wind of Soltia.

O backup Google Drive continua `heroes_lore_2_save.json`, na pasta **Heroes Lore II - The Knight of Frozen Sea**, sem reutilizar identidades dos outros jogos. Antes do teste, preserve cópias do progresso local e da nuvem. Validar salvar, fechar/reabrir, enviar backup, restaurar e carregar progresso no console. Preservar o código não equivale a comprovar os serviços do SDK novo.

## Teste pelo Netloader

Com hbmenu ativo, abra Netloader e envie o NRO por nxlink para o IP exibido. Os recursos acompanham o RomFS embutido. Não é necessário reabrir SmileBASIC ou repetir a conexão do toolkit para cada envio. Use um nome distinto dos outros ports e da build de Switch 1.

Verifique abertura, imagem, controles, áudio, localização, menus, saves, backup/restauração e retorno ao hbmenu. A aprovação dos outros ports serve de referência do ambiente; este NRO tem seu próprio checkpoint de validação.

Créditos: [ounce-devkit](https://github.com/ouncebrew/ounce-devkit), [libounce](https://github.com/ouncebrew/libounce), [OunceVK](https://github.com/ouncebrew/ouncevk), [kaiHEN](https://github.com/ouncebrew/kaihen), devkitPro e contribuidores.

## Compilação aprovada — 15/11/2026

A execução [43689191483](https://github.com/davidkalil10/Heroes-Lore-2-The-Knight-of-Frozen_Sea-Recomp/actions/runs/43689191483) concluiu com sucesso na revisão `8fdacddf573a36a7798db9b2e135056c75d7e9b2`. NRO, ícone, NACP e RomFS passaram pela inspeção estrutural do workflow. A validação de execução e Google Drive no jogo 2 ainda depende de teste no console.

## NRO verificado e enviado pelo Netloader

Arquivo da revisão `8fdacddf573a36a7798db9b2e135056c75d7e9b2`: 80.118.112 bytes, SHA-256 `8e47db5f335f04ceed3dc8f680f632ec18afa9c98a3503774613ba08457c8b56`. O nome específico do atualizador Switch 2 também foi confirmado no binário.

Em 15/11/2026, o Netloader confirmou o recebimento de `heroes_lore_2_switch2_8fdacdd.nro`, com 24.913.373 bytes comprimidos. A transferência não acessou saves. A confirmação do protocolo não comprova execução; abertura, jogabilidade e backup/restauração Google Drive ainda aguardam confirmação no console. A pasta original e a main permanecem intactas.
