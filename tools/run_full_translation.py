#!/usr/bin/env python3
"""
tools/run_full_translation.py
Executa a tradução integral de:
1. Todas as 255 linhas de missões de q.tdf
2. Todas as habilidades e textos de sistema dos 19 arquivos TDF
3. Todos os 1.430 diálogos de enredo de todos os 111 mapas
4. Empacota tudo em binários para assets/lang/pt_br/ e sincroniza com Android
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
        print(f"[Cache] Carregados {len(cache)} itens do cache.")
    except Exception as e:
        print("[Cache] Erro lendo cache:", e)

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

def google_translate_text(text):
    if not text or not text.strip():
        return text
    if text in ["...", "m", "OK", "0", "1", "2"]:
        return text
    url = 'https://translate.googleapis.com/translate_a/single?client=gtx&sl=en&tl=pt&dt=t&q=' + urllib.parse.quote(text)
    req = urllib.request.Request(url, headers={'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64)'})
    for attempt in range(3):
        try:
            resp = urllib.request.urlopen(req, timeout=8)
            data = json.loads(resp.read().decode('utf-8'))
            res = ''.join([x[0] for x in data[0] if x and len(x) > 0 and x[0]])
            return clean_ascii(res)
        except Exception as e:
            time.sleep(0.5)
    return clean_ascii(text)

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

def translate_dialogue_line(line):
    if not line or not line.strip():
        return line
    if line in cache:
        return cache[line]

    # Expressões padrão exatas de sistema
    fixed_sys = {
        '}It is locked.@': '}Esta trancado.@',
        '}Set this as your return point?@': '}Definir este local como ponto de retorno?@',
        '}Would you like to hear about beasts?@': '}Deseja ouvir sobre as bestas?@',
        '}Experience gained!@': '}Experiencia adquirida!@',
        '}A sign is posted. {-House For Sale-@': '}Ha uma placa aqui. {-Casa a Venda-@',
        '}Would you like to see a basic explanation of combat?@': '}Deseja ver uma explicacao basica de combate?@'
    }
    if line in fixed_sys:
        cache[line] = fixed_sys[line]
        return fixed_sys[line]

    # Speaker pattern: [$|{]?[Speaker]@ text
    m = re.match(r'^([\$\|\{\}\']?)\[([^\]]+)\]@\s*(.*)$', line)
    if m:
        c_code = m.group(1)
        orig_spk = m.group(2)
        body = m.group(3)
        spk_pt = SPEAKER_MAP.get(orig_spk, orig_spk)
        body_pt = translate_sentence(body)
        res = f"{c_code}[{spk_pt}]@ {body_pt}"
        cache[line] = res
        return res

    # Single-wrapped tag: {Text} obtained!@ / {Text} set as your return point!@
    m2 = re.match(r'^\{([^}]+)\}\s*(.*)$', line)
    if m2:
        inner = m2.group(1)
        tail = m2.group(2)
        inner_pt = translate_sentence(inner)
        tail_pt = translate_sentence(tail)
        res = f"{{{inner_pt}}} {tail_pt}".strip()
        cache[line] = res
        return res

    # Fallback normal sentence
    res = translate_sentence(line)
    cache[line] = res
    return res

def translate_sentence(text):
    if not text or not text.strip():
        return text
    if text in cache:
        return cache[text]
    
    # Substituições diretas frequentes
    repl = {
        'obtained!@': 'obtido!@',
        'obtained!': 'obtido!',
        'Quest completed!@': 'Missao concluida!@',
        'Quest acquired!@': 'Missao iniciada!@',
        'set as your return point!@': 'definido como ponto de retorno!@',
        'Beast Keeper': 'Guardiao das Bestas',
        'Beast Evolution Serum': 'Soro de Evolucao de Besta',
        'Find Wolfgang': 'Encontre Wolfgang',
        'Return Gate': 'Portal de Retorno',
        'Return Scroll': 'Pergaminho de Retorno'
    }
    for k, v in repl.items():
        if k in text:
            text = text.replace(k, v)

    # Verifica se tem palavras em inglês
    words = re.findall(r'[a-zA-Z]+', text)
    if len(words) >= 2:
        t = google_translate_text(text)
        time.sleep(0.04)
        res = clean_ascii(t)
        cache[text] = res
        return res

    res = clean_ascii(text)
    cache[text] = res
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
    print("=== [1/3] Traduzindo todos os 19 arquivos TDF (incluindo todas as missoes de q.tdf) ===")
    with open("reference/lang_en/tdf_strings.json", "r", encoding="utf-8") as f:
        tdf_dict = json.load(f)

    for fname, str_list in tdf_dict.items():
        print(f"Traduzindo TDF {fname} ({len(str_list)} strings)...")
        translated_list = []
        for s in str_list:
            if not s or not s.strip():
                translated_list.append(s)
            elif s in cache:
                translated_list.append(cache[s])
            else:
                t = translate_sentence(s)
                cache[s] = t
                translated_list.append(t)
        
        packed = pack_tdf(translated_list)
        out_p = f"assets/lang/pt_br/t/{fname}"
        with open(out_p, "wb") as fp:
            fp.write(packed)

    print("=== [2/3] Traduzindo todos os 1430 dialogos de mapas (/m/m/*.m) ===")
    with open("reference/lang_en/map_strings.json", "r", encoding="utf-8") as f:
        map_json = json.load(f)

    save_counter = 0
    for mfile in sorted(glob.glob("reference/extracted/m/m/*.m")):
        fname = os.path.basename(mfile)
        with open(mfile, "rb") as fp:
            orig_m = fp.read()

        info = map_json.get(fname, {"name": "", "dialogues": []})
        orig_name = info["name"]
        orig_dlgs = info["dialogues"]

        # Traduz nome do mapa
        new_name = translate_sentence(orig_name)
        new_dlgs = []
        for d in orig_dlgs:
            new_dlgs.append(translate_dialogue_line(d))
            save_counter += 1
            if save_counter % 50 == 0:
                with open(CACHE_FILE, "w", encoding="utf-8") as f:
                    json.dump(cache, f, ensure_ascii=False, indent=2)
                print(f"Progresso: {save_counter} dialogos processados...")

        repacked = repack_map(orig_m, new_name, new_dlgs)
        with open(f"assets/lang/pt_br/m/m/{fname}", "wb") as fp:
            fp.write(repacked)

    # Salva cache final
    with open(CACHE_FILE, "w", encoding="utf-8") as f:
        json.dump(cache, f, ensure_ascii=False, indent=2)

    print("=== [3/3] Sincronizando com android/app/src/main/assets/lang/pt_br ===")
    if os.path.exists("android/app/src/main/assets/lang"):
        shutil.rmtree("android/app/src/main/assets/lang/pt_br")
        shutil.copytree("assets/lang/pt_br", "android/app/src/main/assets/lang/pt_br")

    print("=== CONCLUIDO COM SUCESSO TOTAL! ===")

if __name__ == "__main__":
    main()
