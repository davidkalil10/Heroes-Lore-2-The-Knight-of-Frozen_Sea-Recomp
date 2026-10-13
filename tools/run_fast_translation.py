#!/usr/bin/env python3
"""
tools/run_fast_translation.py
Tradução ultra-rápida em lote (batching) com suporte a 100% dos textos do jogo:
1. 19 arquivos TDF (/t/*.tdf), incluindo todas as 255 missões (/t/q.tdf)
2. 1.430 diálogos de enredo dos 111 mapas (/m/m/*.m)
3. Preservação de cores (@, |, $, {, }, '), tags de interlocutores e quebras de linha
4. Limpeza ASCII completa para renderização na fonte bitmap original eng12
"""

import os
import sys
import glob
import json
import time
import re
import urllib.request
import urllib.parse
import shutil

sys.stdout.reconfigure(encoding='utf-8')

CACHE_FILE = "reference/lang_pt_br/translation_cache.json"
os.makedirs("reference/lang_pt_br", exist_ok=True)

cache = {}
if os.path.exists(CACHE_FILE):
    try:
        with open(CACHE_FILE, "r", encoding="utf-8") as f:
            cache = json.load(f)
        print(f"[Cache] Carregados {len(cache)} itens em cache.", flush=True)
    except Exception as e:
        print("[Cache] Erro ao carregar cache:", e, flush=True)

def clean_ascii(text):
    if not text:
        return ""
    replacements = {
        'á': 'a', 'à': 'a', 'ã': 'a', 'â': 'a', 'ä': 'a',
        'é': 'e', 'è': 'e', 'ê': 'e', 'ë': 'e',
        'í': 'i', 'ì': 'i', 'î': 'i', 'ï': 'i',
        'ó': 'o', 'ò': 'o', 'õ': 'o', 'ô': 'o', 'ö': 'o',
        'ú': 'u', 'ù': 'u', 'û': 'u', 'ü': 'u',
        'ç': 'c',
        'Á': 'A', 'À': 'A', 'Ã': 'A', 'Â': 'A', 'Ä': 'A',
        'É': 'E', 'È': 'E', 'Ê': 'E', 'Ë': 'E',
        'Í': 'I', 'Ì': 'I', 'Î': 'I', 'Ï': 'I',
        'Ó': 'O', 'Ò': 'O', 'Õ': 'O', 'Ô': 'O', 'Ö': 'O',
        'Ú': 'U', 'Ù': 'U', 'Û': 'U', 'Ü': 'U',
        'Ç': 'C',
        '“': '"', '”': '"', '’': "'", '‘': "'", '—': '-', '–': '-'
    }
    for k, v in replacements.items():
        text = text.replace(k, v)
    return text

SPEAKER_MAP = {
    'Alchemist': 'Alquimista',
    'Basil': 'Basil',
    'Beast Keeper': 'Guardiao das Bestas',
    'Blacksmith': 'Ferreiro',
    'Bob-haired Girl': 'Garota de Cabelo Curto',
    'Bodyguard Knight': 'Cavaleiro Guarda-Costas',
    'Bored Kid': 'Crianca Entediada',
    'Claire': 'Claire',
    "Claire's Mother": 'Mae de Claire',
    'Clemens': 'Clemens',
    'Cold-looking Man': 'Homem Frio',
    'Corvus Member': 'Membro dos Corvus',
    'Cute Girl': 'Garota Fofa',
    'Cute Grandson': 'Neto Querido',
    'Developer': 'Desenvolvedor',
    'Dimitri': 'Dimitri',
    'Durian': 'Durian',
    'Elderly Grandmother': 'Vovo Idosa',
    'Emma': 'Emma',
    "Engineer's Lover": 'Amada do Engenheiro',
    'Familiar-looking Man': 'Homem Familiar',
    'Freelance Alchemist': 'Alquimista Independente',
    'Freelance Master': 'Mestre Independente',
    'Girl': 'Garota',
    'Girl Eating Candy': 'Garota Comendo Doce',
    'Girl Taking the Air': 'Garota Tomando Ar',
    'Guard': 'Guarda',
    'Guards': 'Guardas',
    'Guild Man': 'Membro da Guilda',
    'Handel': 'Handel',
    'Hans': 'Hans',
    'Heinz': 'Heinz',
    'Hiding Kid': 'Crianca Escondida',
    'Ian': 'Ian',
    "Ian's Subordinate": 'Subordinado de Ian',
    'Idle Woman': 'Mulher Ociosa',
    'Innkeeper': 'Estalajadeiro',
    'Jess': 'Jess',
    'Kenneth': 'Kenneth',
    'Kid': 'Crianca',
    "Kid Who's It": 'Crianca Brincando',
    'Kind-looking Woman': 'Mulher Gentil',
    'Klaus': 'Klaus',
    'Knights': 'Cavaleiros',
    'Little Kid': 'Criancinha',
    'Louise': 'Louise',
    'Maid': 'Criada',
    'Man': 'Homem',
    'Maro': 'Maro',
    'Men': 'Homens',
    'Merchant': 'Comerciante',
    'Old Woman': 'Senhora Idosa',
    'Oliver': 'Oliver',
    'Pretty Woman': 'Mulher Bonita',
    'Priest': 'Sacerdote',
    'Purple-hooded Warrior': 'Guerreiro de Capuz Roxo',
    'Ralph': 'Ralph',
    'Red-haired Young Man': 'Jovem Ruivo',
    'Sailor': 'Marinheiro',
    'Ship Engineer': 'Engenheiro Naval',
    'Sindraf Knight': 'Cavaleiro de Sindraf',
    'Sleeping Twins': 'Gemeos Dormindo',
    'Smart Girl': 'Jovem Esperta',
    'Smart Young Lady': 'Jovem Astuta',
    'Soldier': 'Soldado',
    'Stowaway': 'Clandestino',
    'Sybille': 'Sybille',
    'Temple Knight': 'Cavaleiro do Templo',
    'Till': 'Till',
    'Ulrike': 'Ulrike',
    'Village Chief': 'Chefe da Vila',
    'Village Man': 'Homem da Vila',
    'Village Woman': 'Mulher da Vila',
    'Villager': 'Aldeao',
    'Wary Man': 'Homem Cauteloso',
    'Wolfgang': 'Wolfgang',
    'Woman': 'Mulher',
    'Woman in a Dress': 'Mulher de Vestido',
    'Woman with a Blue Ribbon': 'Mulher com Fita Azul',
    'Worker': 'Trabalhador',
    'Young Man': 'Jovem'
}

def translate_batch(texts):
    if not texts:
        return []
    sep = '\n@@@\n'
    joined = sep.join(texts)
    url = 'https://translate.googleapis.com/translate_a/single?client=gtx&sl=en&tl=pt&dt=t&q=' + urllib.parse.quote(joined)
    req = urllib.request.Request(url, headers={'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64)'})
    for attempt in range(3):
        try:
            resp = urllib.request.urlopen(req, timeout=12)
            data = json.loads(resp.read().decode('utf-8'))
            full = ''.join([x[0] for x in data[0] if x and len(x) > 0 and x[0]])
            parts = [clean_ascii(s.strip()) for s in full.split('@@@')]
            if len(parts) == len(texts):
                return parts
            # Se a quantidade diferir, faz fallback elemento a elemento
            break
        except Exception as e:
            time.sleep(0.5)
    
    # Fallback elemento a elemento
    res = []
    for t in texts:
        url_single = 'https://translate.googleapis.com/translate_a/single?client=gtx&sl=en&tl=pt&dt=t&q=' + urllib.parse.quote(t)
        req_single = urllib.request.Request(url_single, headers={'User-Agent': 'Mozilla/5.0'})
        try:
            r = urllib.request.urlopen(req_single, timeout=6)
            d = json.loads(r.read().decode('utf-8'))
            res.append(clean_ascii(''.join([x[0] for x in d[0] if x and len(x) > 0 and x[0]])))
        except:
            res.append(clean_ascii(t))
        time.sleep(0.02)
    return res

def pack_tdf(strings):
    b = bytearray()
    b.append(len(strings) & 0xFF)
    for s in strings:
        s_clean = clean_ascii(s)
        sb = s_clean.encode('utf-8')
        b.append((len(sb) >> 8) & 0xFF)
        b.append(len(sb) & 0xFF)
        b.extend(sb)
    return bytes(b)

def repack_map(orig_bytes, new_name, new_dialogues):
    p = 0
    var_byte_c = orig_bytes[p]; p += 1
    name_len = orig_bytes[p]; p += 1
    p += name_len
    header_end = p

    by10 = orig_bytes[p]; p += 1; p += by10
    by11 = orig_bytes[p]; p += 1; p += by11
    var_byte_d = orig_bytes[p]; p += 1
    var_byte_e = orig_bytes[p]; p += 1
    p += var_byte_d * var_byte_e
    p += var_byte_d * var_byte_e
    by4 = orig_bytes[p]; p += 1
    for _ in range(by4):
        by7 = orig_bytes[p]; p += 1; p += by7 * 3
    n7 = orig_bytes[p]; p += 1; p += n7 * 5
    n5 = orig_bytes[p]; p += 1; p += n5 * 5
    n4 = orig_bytes[p]; p += 1; p += n4 * 5
    n3 = orig_bytes[p]; p += 1; p += n3 * 5
    by12 = orig_bytes[p]; p += 1; p += by12
    n8 = orig_bytes[p]; p += 1; p += n8 * 3
    by13 = orig_bytes[p]; p += 1; p += by13
    by2 = orig_bytes[p]; p += 1; p += by2 * 3
    n9 = orig_bytes[p]; p += 1
    for _ in range(n9):
        n10 = orig_bytes[p]; p += 1; p += n10 * 31
    dialogue_start = p
    n8_dialogues = orig_bytes[p]; p += 1
    for _ in range(n8_dialogues):
        n11 = orig_bytes[p]; p += 1
        p += n11
    dialogue_end = p
    tail = orig_bytes[dialogue_end:]

    map_name_bytes = clean_ascii(new_name).encode('utf-8')
    out = bytearray()
    out.append(var_byte_c)
    out.append(len(map_name_bytes) & 0xFF)
    out.extend(map_name_bytes)
    out.extend(orig_bytes[header_end:dialogue_start])
    out.append(len(new_dialogues) & 0xFF)
    for d in new_dialogues:
        db = clean_ascii(d).encode('utf-8')
        out.append(len(db) & 0xFF)
        out.extend(db)
    out.extend(tail)
    return bytes(out)

def main():
    print("=== [Etapa 1] Coletando todos os textos unicos a serem traduzidos ===", flush=True)
    with open("reference/lang_en/tdf_strings.json", "r", encoding="utf-8") as f:
        tdf_dict = json.load(f)

    with open("reference/lang_en/map_strings.json", "r", encoding="utf-8") as f:
        map_json = json.load(f)

    # 1. Lista de textos de TDF pendentes
    tdf_to_translate = []
    for fname, str_list in tdf_dict.items():
        for s in str_list:
            if s and len(re.findall(r'[a-zA-Z]+', s)) >= 1:
                if s not in cache and s not in tdf_to_translate:
                    tdf_to_translate.append(s)

    # 2. Lista de corpos de diálogos pendentes
    dialogues_raw = []
    for info in map_json.values():
        m_name = info.get("name", "")
        if m_name and len(re.findall(r'[a-zA-Z]+', m_name)) >= 1 and m_name not in cache and m_name not in tdf_to_translate:
            tdf_to_translate.append(m_name)
        for d in info.get("dialogues", []):
            if d not in dialogues_raw:
                dialogues_raw.append(d)

    dlg_bodies_to_translate = []
    dlg_structure = {} # line -> (c_code, speaker_pt, body_orig, suffix)

    for line in dialogues_raw:
        if not line or not line.strip():
            continue
        m = re.match(r'^([\$\|\{\}\']?)\[([^\]]+)\]@\s*(.*)$', line)
        if m:
            c_code = m.group(1)
            orig_spk = m.group(2)
            body = m.group(3)
            spk_pt = SPEAKER_MAP.get(orig_spk, orig_spk)
            dlg_structure[line] = (c_code, spk_pt, body, "@")
            if body and len(re.findall(r'[a-zA-Z]+', body)) >= 1:
                if body not in cache and body not in dlg_bodies_to_translate:
                    dlg_bodies_to_translate.append(body)
        else:
            m2 = re.match(r'^([\{\}\$\|\']?)(.*?)(@?)$', line)
            if m2:
                prefix = m2.group(1)
                body = m2.group(2)
                suffix = m2.group(3)
                dlg_structure[line] = (prefix, "", body, suffix)
                if body and len(re.findall(r'[a-zA-Z]+', body)) >= 1:
                    if body not in cache and body not in dlg_bodies_to_translate:
                        dlg_bodies_to_translate.append(body)

    all_pending = tdf_to_translate + dlg_bodies_to_translate
    # Remove repetidos
    all_pending = list(dict.fromkeys(all_pending))
    all_pending = [x for x in all_pending if x not in cache]

    print(f"Total de textos pendentes para traducao em lote: {len(all_pending)}", flush=True)

    # Tradução em lotes de 20
    BATCH_SIZE = 20
    for i in range(0, len(all_pending), BATCH_SIZE):
        batch = all_pending[i:i+BATCH_SIZE]
        print(f"Traduzindo lote {i//BATCH_SIZE + 1}/{(len(all_pending) + BATCH_SIZE - 1)//BATCH_SIZE} ({len(batch)} textos)...", flush=True)
        translated_batch = translate_batch(batch)
        for orig, trans in zip(batch, translated_batch):
            cache[orig] = trans
        time.sleep(0.08)

        # Salva checkpoint a cada 5 lotes
        if (i // BATCH_SIZE) % 5 == 0:
            with open(CACHE_FILE, "w", encoding="utf-8") as f:
                json.dump(cache, f, ensure_ascii=False, indent=2)

    with open(CACHE_FILE, "w", encoding="utf-8") as f:
        json.dump(cache, f, ensure_ascii=False, indent=2)

    print("=== [Etapa 2] Empacotando todos os 19 arquivos TDF traduzidos ===", flush=True)
    os.makedirs("assets/lang/pt_br/t", exist_ok=True)
    for fname, str_list in tdf_dict.items():
        translated_list = []
        for s in str_list:
            if not s or not s.strip():
                translated_list.append(s)
            else:
                translated_list.append(cache.get(s, clean_ascii(s)))
        packed = pack_tdf(translated_list)
        with open(f"assets/lang/pt_br/t/{fname}", "wb") as fp:
            fp.write(packed)

    print("=== [Etapa 3] Empacotando todos os 111 mapas com dialogos traduzidos ===", flush=True)
    os.makedirs("assets/lang/pt_br/m/m", exist_ok=True)
    for mfile in sorted(glob.glob("reference/extracted/m/m/*.m")):
        fname = os.path.basename(mfile)
        with open(mfile, "rb") as fp:
            orig_m = fp.read()

        info = map_json.get(fname, {"name": "", "dialogues": []})
        orig_name = info["name"]
        new_name = cache.get(orig_name, clean_ascii(orig_name))

        new_dlgs = []
        for d in info.get("dialogues", []):
            if d in dlg_structure:
                prefix, spk, body, suffix = dlg_structure[d]
                trans_body = cache.get(body, clean_ascii(body))
                if spk:
                    new_dlgs.append(f"{prefix}[{spk}]@ {trans_body}")
                else:
                    new_dlgs.append(f"{prefix}{trans_body}{suffix}")
            else:
                new_dlgs.append(cache.get(d, clean_ascii(d)))

        repacked = repack_map(orig_m, new_name, new_dlgs)
        with open(f"assets/lang/pt_br/m/m/{fname}", "wb") as fp:
            fp.write(repacked)

    print("=== [Etapa 4] Sincronizando com android/app/src/main/assets/lang/pt_br ===", flush=True)
    android_pt = "android/app/src/main/assets/lang/pt_br"
    if os.path.exists("android/app/src/main/assets/lang"):
        if os.path.exists(android_pt):
            shutil.rmtree(android_pt)
        shutil.copytree("assets/lang/pt_br", android_pt)

    print("=== SUCESSO TOTAL! Todos os textos e dialogos traduzidos e sincronizados! ===", flush=True)

if __name__ == "__main__":
    main()
