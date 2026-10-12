#!/usr/bin/env python3
"""
tools/generate_app_icons.py
Gera ícones nativos de alta fidelidade para todas as 4 plataformas a partir de reference/extracted/icon.png:
  - Nintendo Switch: switch/icon.jpg (256x256 JPEG)
  - Linux: dist_linux/heroes_lore_2.png (256x256 PNG)
  - Android: android/app/src/main/res/mipmap-*/ic_launcher.png e ic_launcher_round.png
"""

import os
from PIL import Image, ImageDraw

def generate_all_icons():
    src_icon = "reference/extracted/icon.png"
    if not os.path.exists(src_icon):
        print(f"[ERRO] Ícone original não encontrado em: {src_icon}")
        return

    orig = Image.open(src_icon).convert("RGBA")
    print(f"[Ícones] Ícone base carregado de {src_icon} ({orig.size[0]}x{orig.size[1]})")

    # 1. Gera Nintendo Switch: switch/icon.jpg (256x256 JPEG)
    os.makedirs("switch", exist_ok=True)
    switch_img = orig.resize((256, 256), Image.Resampling.LANCZOS)
    switch_bg = Image.new("RGB", (256, 256), (15, 18, 24))
    switch_bg.paste(switch_img, (0, 0), switch_img)
    switch_path = "switch/icon.jpg"
    switch_bg.save(switch_path, "JPEG", quality=95, optimize=True)
    print(f"  + Switch: {switch_path} (256x256 JPEG)")

    # 2. Gera Linux: dist_linux/heroes_lore_2.png (256x256 PNG)
    os.makedirs("dist_linux", exist_ok=True)
    linux_path = "dist_linux/heroes_lore_2.png"
    switch_img.save(linux_path, "PNG")
    print(f"  + Linux: {linux_path} (256x256 PNG)")

    # 3. Gera Android: mipmap-*/ic_launcher.png e ic_launcher_round.png
    densities = {
        'mipmap-mdpi': 48,
        'mipmap-hdpi': 72,
        'mipmap-xhdpi': 96,
        'mipmap-xxhdpi': 144,
        'mipmap-xxxhdpi': 192,
    }
    res_base = os.path.join("android", "app", "src", "main", "res")

    for folder, size in densities.items():
        out_dir = os.path.join(res_base, folder)
        os.makedirs(out_dir, exist_ok=True)

        # Ícone quadrado padrão
        resized = orig.resize((size, size), Image.Resampling.LANCZOS)
        resized.save(os.path.join(out_dir, "ic_launcher.png"), "PNG")

        # Ícone circular (ic_launcher_round.png)
        mask = Image.new('L', (size * 4, size * 4), 0)
        draw = ImageDraw.Draw(mask)
        draw.ellipse((0, 0, size * 4, size * 4), fill=255)
        mask = mask.resize((size, size), Image.Resampling.LANCZOS)

        round_img = Image.new('RGBA', (size, size), (0, 0, 0, 0))
        round_img.paste(resized, (0, 0))
        round_img.putalpha(mask)
        round_img.save(os.path.join(out_dir, "ic_launcher_round.png"), "PNG")
        print(f"  + Android {folder}: {size}x{size}")

    print("[OK] Todos os ícones das plataformas foram gerados com sucesso!")

if __name__ == "__main__":
    generate_all_icons()
