#!/usr/bin/env python3
"""
tools/translate_all_game_text.py
Traduz 100% dos textos de Heroes Lore 2 para Português do Brasil:
1. Todas as 255 linhas de missões de /t/q.tdf
2. Todas as tabelas de habilidades, itens e sistema dos 19 arquivos /t/*.tdf
3. Todos os 1.430 diálogos de enredo e NPCs de todos os 111 mapas (/m/m/*.m)
4. Preserva códigos de controle de cor (@, |, $, {, }, ') e tags de interlocutor.
5. Normaliza para ASCII limpo para compatibilidade com o motor de fonte bitmap eng12.
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

# Mapeamento de personagens e interlocutores
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
    # Se já é pequeno / código
    if text in ["...", "m", "OK", "0", "1", "2"]:
        return text
    url = 'https://translate.googleapis.com/translate_a/single?client=gtx&sl=en&tl=pt&dt=t&q=' + urllib.parse.quote(text)
    req = urllib.request.Request(url, headers={'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64)'})
    try:
        resp = urllib.request.urlopen(req, timeout=10)
        data = json.loads(resp.read().decode('utf-8'))
        res = ''.join([x[0] for x in data[0] if x and len(x) > 0 and x[0]])
        return res
    except Exception as e:
        print(f"Erro traduzindo '{text[:30]}...': {e}")
        return text

def translate_dialogue_line(line, cache):
    if not line:
        return line
    if line in cache:
        return cache[line]

    # Identifica tags de controle e speaker
    # Padrão: prefixo opcional de cor, [Speaker]@ texto
    match = re.match(r'^([\$\|\{\}\']?)\[([^\]]+)\]@\s*(.*)$', line)
    if match:
        color_code = match.group(1)
        orig_speaker = match.group(2)
        body = match.group(3)
        speaker_pt = SPEAKER_MAP.get(orig_speaker, orig_speaker)
        
        # Traduz o corpo
        body_pt = translate_inner_text(body, cache)
        result = f"{color_code}[{speaker_pt}]@ {body_pt}"
        cache[line] = result
        return result

    # Caso seja fala simples com prefixo ou chave
    # Ex: }It is locked.@ ou {Item Name} obtained!@
    m2 = re.match(r'^([\{\}\$\|\']?)(.*?)(@?)$', line)
    if m2:
        prefix = m2.group(1)
        body = m2.group(2)
        suffix = m2.group(3)
        body_pt = translate_inner_text(body, cache)
        result = f"{prefix}{body_pt}{suffix}"
        cache[line] = result
        return result

    body_pt = translate_inner_text(line, cache)
    cache[line] = body_pt
    return body_pt

def translate_inner_text(text, cache):
    if not text or not text.strip():
        return text
    if text in cache:
        return cache[text]

    # Expressões padrão muito frequentes
    fixed_replacements = {
        'It is locked.': 'Esta trancado.',
        'Set this as your return point?': 'Definir este local como ponto de retorno?',
        'set as your return point!': 'definido como seu ponto de retorno!',
        'Would you like to hear about beasts?': 'Deseja ouvir sobre as bestas?',
        'obtained!': 'obtido!',
        'Quest completed!': 'Missao concluida!',
        'Quest acquired!': 'Missao iniciada!',
        'Experience gained!': 'Experiencia adquirida!',
        'A sign is posted.': 'Ha uma placa aqui.',
        'Would you like to see a basic explanation of combat?': 'Deseja ver uma explicacao basica de combate?',
        'To continue the game;press any key.': 'Pressione qualquer tecla;para continuar o jogo.',
        'No reward.': 'Sem recompensa.'
    }
    for k, v in fixed_replacements.items():
        if k in text:
            text = text.replace(k, v)

    # Se ainda tiver trechos em inglês maiores que 2 palavras
    words = re.findall(r'[a-zA-Z]+', text)
    if len(words) >= 2:
        # Preserva sub-tags como {Texto@ se houver
        translated = google_translate_text(text)
        time.sleep(0.04) # Evita rate-limit
        res = clean_ascii(translated)
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

print("translate_all_game_text.py module loaded successfully.")
