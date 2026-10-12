import re, glob, os
root = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
used = {}
pat = re.compile(r'//\s*(?:Method|InterfaceMethod|Field)\s+((?:java|javax|com)/[\w/$]+)\."?([\w<>$]+)"?:(\S+)')
for f in glob.glob(os.path.join(root, 'reference/javap/*.javap')):
    for line in open(f, encoding='utf-8', errors='replace'):
        if 'invoke' in line or 'getstatic' in line or 'putstatic' in line or 'getfield' in line:
            m = pat.search(line)
            if m:
                kind = 'F' if ('field' in line or 'static' in line.split()[1]) else 'M'
                used.setdefault((m.group(1), m.group(2), m.group(3), kind), set()).add(os.path.basename(f)[:-6])
src = ''
for f in glob.glob(os.path.join(root, 'src/**/*.cpp'), recursive=True):
    src += open(f, encoding='utf-8', errors='replace').read()
missing = []
for (c, n, d, k), users in sorted(used.items()):
    if k == 'M':
        key = f'{c}.{n}:{d}'
        if key not in src:
            missing.append((key, sorted(users)[:3]))
    else:
        if f'{c}.{n}' not in src and n not in src:
            missing.append((f'FIELD {c}.{n}:{d}', sorted(users)[:3]))
for k, u in missing:
    print(k, u)
print(len(missing), 'missing of', len(used))
vmsrc = open(os.path.join(root, 'src/vm/vm.cpp'), encoding='utf-8', errors='replace').read()
print('--- classes usadas e nao builtin / nao no JAR ---')
for c in sorted({k[0] for k in used}):
    if f'"{c}"' not in vmsrc and not os.path.exists(os.path.join(root, 'reference/extracted', c + '.class')):
        print(c)
