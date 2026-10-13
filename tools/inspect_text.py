import os
import glob
import re

print("=== Analyzing text files in reference/extracted ===")

# Check all .tdf files
tdf_files = sorted(glob.glob("reference/extracted/t/*.tdf"))
total_strings = 0
for p in tdf_files:
    with open(p, "rb") as f:
        data = f.read()
    count = data[0]
    total_strings += count
    fn = os.path.basename(p)
    strings = []
    pos = 1
    for i in range(count):
        if pos + 2 > len(data): break
        slen = (data[pos] << 8) | data[pos+1]
        pos += 2
        raw = data[pos:pos+slen]
        pos += slen
        try:
            strings.append(raw.decode("utf-8"))
        except:
            strings.append(repr(raw))
    print(f"{fn} ({count} texts): sample: {strings[:2]}")

print(f"Total TDF texts: {total_strings}")

# Check where 'new e(' is called across java files
print("\n=== Finding 'new e(' callers ===")
for p in sorted(glob.glob("reference/decompiled_cfr/*.java")):
    with open(p, "r", encoding="utf-8", errors="ignore") as f:
        content = f.read()
    matches = re.findall(r'new e\([^)]+\)', content)
    if matches:
        print(f"{os.path.basename(p)}: {matches}")
