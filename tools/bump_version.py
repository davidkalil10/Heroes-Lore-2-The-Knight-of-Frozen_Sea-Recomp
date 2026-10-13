#!/usr/bin/env python3
"""
tools/bump_version.py — Heroes Lore 2: The Knight of Frozen Sea
Utilitário para atualizar a versão do jogo de forma sincronizada e automática
em todas as plataformas e documentações:

1. src/platform/updater.h (HL_VERSION_TAG e HL_VERSION_NUM)
2. android/app/build.gradle (versionCode incremental e versionName)
3. Makefile.switch (APP_VERSION para metadados .nacp e .nro do Switch)
4. docs/STATUS.md (cabeçalho de status e data atual)

Uso:
    python tools/bump_version.py 0.2.7
    python tools/bump_version.py patch      # incrementa patch (ex: 0.2.6 -> 0.2.7)
    python tools/bump_version.py minor      # incrementa minor (ex: 0.2.6 -> 0.3.0)
    python tools/bump_version.py major      # incrementa major (ex: 0.2.6 -> 1.0.0)
    python tools/bump_version.py --current  # exibe a versão atual
    python tools/bump_version.py 0.2.7 --git # atualiza, comita e cria a tag automaticamente
"""

import sys
import os
import re
import datetime
import subprocess

def get_current_version():
    tag = "Desconhecida"
    updater_path = "src/platform/updater.h"
    if os.path.exists(updater_path):
        with open(updater_path, "r", encoding="utf-8") as f:
            for line in f:
                if "#define HL_VERSION_TAG" in line:
                    tag = line.split('"')[1]
                    break
    return tag

def compute_next_version(current_tag, bump_type):
    ver_clean = current_tag.lstrip("v")
    parts = ver_clean.split(".")
    if len(parts) != 3:
        raise ValueError(f"Versão atual '{current_tag}' não segue SemVer X.Y.Z")
    major, minor, patch = int(parts[0]), int(parts[1]), int(parts[2])
    
    if bump_type == "patch":
        patch += 1
    elif bump_type == "minor":
        minor += 1
        patch = 0
    elif bump_type == "major":
        major += 1
        minor = 0
        patch = 0
    else:
        raise ValueError(f"Tipo de incremento inválido: {bump_type}")
        
    return f"{major}.{minor}.{patch}"

def bump_version(new_ver_clean, auto_git=False):
    if new_ver_clean.startswith("v"):
        new_ver_clean = new_ver_clean[1:]

    # Valida formato semver (ex: 0.2.7)
    if not re.match(r"^\d+\.\d+\.\d+$", new_ver_clean):
        print(f"[ERRO] Formato de versão inválido: '{new_ver_clean}'. Use X.Y.Z (ex: 0.2.7).")
        sys.exit(1)

    tag = f"v{new_ver_clean}"
    today_str = datetime.date.today().strftime("%Y-%m-%d")
    print(f"\n==================================================")
    print(f" Sincronizando Versão para {tag} ({new_ver_clean})")
    print(f" Data: {today_str}")
    print(f"==================================================\n")

    modified_files = []

    # 1. src/platform/updater.h
    updater_path = "src/platform/updater.h"
    if os.path.exists(updater_path):
        with open(updater_path, "r", encoding="utf-8") as f:
            content = f.read()
        content = re.sub(r'#define HL_VERSION_TAG "[^"]+"', f'#define HL_VERSION_TAG "{tag}"', content)
        content = re.sub(r'#define HL_VERSION_NUM "[^"]+"', f'#define HL_VERSION_NUM "{new_ver_clean}"', content)
        with open(updater_path, "w", encoding="utf-8") as f:
            f.write(content)
        modified_files.append(updater_path)
        print(f"[OK] Atualizado {updater_path} (HL_VERSION_TAG={tag}, HL_VERSION_NUM={new_ver_clean})")
    else:
        print(f"[AVISO] Arquivo não encontrado: {updater_path}")

    # 2. android/app/build.gradle
    gradle_path = "android/app/build.gradle"
    if os.path.exists(gradle_path):
        with open(gradle_path, "r", encoding="utf-8") as f:
            lines = f.readlines()
        new_lines = []
        old_code = None
        new_code = None
        for line in lines:
            if "versionCode" in line and not line.strip().startswith("//"):
                m = re.search(r'versionCode\s+(\d+)', line)
                if m:
                    old_code = int(m.group(1))
                    new_code = old_code + 1
                    line = re.sub(r'versionCode\s+\d+', f'versionCode {new_code}', line)
            elif "versionName" in line and not line.strip().startswith("//"):
                line = re.sub(r'versionName\s+"[^"]+"', f'versionName "{new_ver_clean}"', line)
            new_lines.append(line)
        with open(gradle_path, "w", encoding="utf-8") as f:
            f.writelines(new_lines)
        modified_files.append(gradle_path)
        print(f"[OK] Atualizado {gradle_path} (versionCode: {old_code} -> {new_code}, versionName: \"{new_ver_clean}\")")
    else:
        print(f"[AVISO] Arquivo não encontrado: {gradle_path}")

    # 3. Makefile.switch
    switch_path = "Makefile.switch"
    if os.path.exists(switch_path):
        with open(switch_path, "r", encoding="utf-8") as f:
            content = f.read()
        content = re.sub(r'APP_VERSION\s*:=\s*[^\r\n]+', f'APP_VERSION :=  {new_ver_clean}', content)
        with open(switch_path, "w", encoding="utf-8") as f:
            f.write(content)
        modified_files.append(switch_path)
        print(f"[OK] Atualizado {switch_path} (APP_VERSION := {new_ver_clean})")
    else:
        print(f"[AVISO] Arquivo não encontrado: {switch_path}")

    # 4. docs/STATUS.md
    status_path = "docs/STATUS.md"
    if os.path.exists(status_path):
        with open(status_path, "r", encoding="utf-8") as f:
            content = f.read()
        content = re.sub(
            r'_Última atualização: [^\n\r]+',
            f'_Última atualização: {today_str} (Versão {tag} lançada oficialmente)_',
            content
        )
        with open(status_path, "w", encoding="utf-8") as f:
            f.write(content)
        modified_files.append(status_path)
        print(f"[OK] Atualizado {status_path} (Status header com {tag})")
    else:
        print(f"[AVISO] Arquivo não encontrado: {status_path}")

    print("\n=== Concluído! Todos os pontos de versão sincronizados com sucesso. ===")

    if auto_git:
        print("\n=== Executando comandos Git automaticamente... ===")
        subprocess.run(["git", "add"] + modified_files, check=True)
        commit_msg = f"chore(release): bump version to {tag}"
        subprocess.run(["git", "commit", "-m", commit_msg], check=True)
        subprocess.run(["git", "tag", "-a", tag, "-m", f"Release {tag}"], check=True)
        print(f"[OK] Commit e Tag {tag} criados!")
        print(f"Para enviar ao GitHub Actions e publicar o release:")
        print(f"  git push origin main")
        print(f"  git push origin {tag}\n")
    else:
        files_str = " ".join(modified_files)
        print("\nComandos Git recomendados:")
        print(f"  git add {files_str}")
        print(f"  git commit -m \"chore(release): bump version to {tag}\"")
        print(f"  git tag -a {tag} -m \"Release {tag}\"")
        print(f"  git push origin main")
        print(f"  git push origin {tag}\n")

def main():
    if len(sys.argv) < 2 or sys.argv[1] in ["-h", "--help"]:
        print(__doc__)
        sys.exit(0)

    arg = sys.argv[1].lower()
    if arg == "--current":
        print(f"Versão atual do projeto: {get_current_version()}")
        sys.exit(0)

    auto_git = "--git" in sys.argv

    if arg in ["patch", "minor", "major"]:
        current = get_current_version()
        target_version = compute_next_version(current, arg)
    else:
        target_version = sys.argv[1]

    bump_version(target_version, auto_git=auto_git)

if __name__ == "__main__":
    main()
