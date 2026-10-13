#!/usr/bin/env python3
"""
tools/build_translations.py
Gera os pacotes de localização para Heroes Lore 2: The Knight of Frozen Sea.
Produz:
- assets/lang/en/ (Inglês original para fallback / troca)
- assets/lang/pt_br/ (Português do Brasil - padrão)
"""

import os
import glob
import json
import shutil
import re

def clean_ascii(text):
    """
    Substitui caracteres acentuados comuns por equivalentes sem acento
    para garantir 100% de compatibilidade com a fonte bitmap eng12 (ASCII 32..126).
    """
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

def pack_itm(items_data):
    repacked = bytearray()
    for rec in items_data:
        repacked.append((len(rec) >> 8) & 0xFF)
        repacked.append(len(rec) & 0xFF)
        repacked.extend(rec)
    return bytes(repacked)

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

print("Translation builder library initialized.")
