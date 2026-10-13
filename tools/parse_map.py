import glob
import os

def parse_m_file(p):
    with open(p, "rb") as f:
        data = f.read()
    n2 = 0
    var_byte_c = data[n2]; n2 += 1
    by9 = data[n2]; n2 += 1
    map_name = data[n2:n2+by9].decode("utf-8", errors="ignore")
    n2 += by9
    by10 = data[n2]; n2 += 1 # face count
    by11 = data[n2]; n2 += 1 # obj count
    n2 += by11 # obj array
    var_byte_d = data[n2]; n2 += 1
    var_byte_e = data[n2]; n2 += 1
    n2 += var_byte_e * var_byte_d # layer 1
    n2 += var_byte_e * var_byte_d # layer 2
    by4 = data[n2]; n2 += 1 # ao count
    for _ in range(by4):
        by7 = data[n2]; n2 += 1
        n2 += by7 * 3
    # n7 cc_arr_a
    n7 = data[n2]; n2 += 1
    n2 += n7 * 5
    # n5 cc_arr_b
    n5 = data[n2]; n2 += 1
    n2 += n5 * 5
    # n4 cc_arr_c
    n4 = data[n2]; n2 += 1
    n2 += n4 * 5
    # n3 bc_arr_a
    n3 = data[n2]; n2 += 1
    n2 += n3 * 5
    # by12 enemies
    by12 = data[n2]; n2 += 1
    n2 += by12
    # n8 enemy spawns
    n8 = data[n2]; n2 += 1
    n2 += n8 * 3
    # by13 npc types
    by13 = data[n2]; n2 += 1
    n2 += by13
    # by2 npc placements
    by2 = data[n2]; n2 += 1
    n2 += by2 * 3
    
    # now this.a(byArray, n32)
    # triggers
    n9 = data[n2]; n2 += 1
    for _ in range(n9):
        n10 = data[n2]; n2 += 1
        if n10 > 0:
            n2 += n10 * 31
    # dialogues!
    num_dlg = data[n2]; n2 += 1
    dialogues = []
    for _ in range(num_dlg):
        n11 = data[n2]; n2 += 1
        raw = data[n2:n2+n11]
        n2 += n11
        try:
            txt = raw.decode("utf-8")
        except:
            txt = repr(raw)
        dialogues.append(txt)
    return map_name, dialogues

print("Testing parser on all maps:")
total_dlgs = 0
for p in sorted(glob.glob("reference/extracted/m/m/*.m")):
    fn = os.path.basename(p)
    try:
        mname, dlg = parse_m_file(p)
        total_dlgs += len(dlg)
        if len(dlg) > 0:
            print(f"{fn} ({mname}): {len(dlg)} dialogues. First: {dlg[0][:40]}")
    except Exception as e:
        print(f"{fn}: error {e}")

print(f"\nTotal map dialogues: {total_dlgs}")
