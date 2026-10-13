import glob
import re

print("=== Callers of bk.a( (Font renderer) ===")
for p in sorted(glob.glob("reference/decompiled_cfr/*.java")):
    with open(p, "r", encoding="utf-8", errors="ignore") as f:
        content = f.read()
    matches = re.findall(r'bk\.a\([^;]+\);', content)
    if matches:
        print(f"\n{p}: {len(matches)} calls")
        for m in matches[:5]:
            print("  ", m.strip())
