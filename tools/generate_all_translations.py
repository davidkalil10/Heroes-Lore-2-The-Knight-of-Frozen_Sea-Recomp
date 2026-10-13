#!/usr/bin/env python3
"""
tools/generate_all_translations.py
Gera as árvores completas de idiomas em assets/lang/:
- assets/lang/en/ (Inglês)
- assets/lang/pt_br/ (Português do Brasil)
E replica para android/app/src/main/assets/lang/
"""

import os
import glob
import json
import shutil
import re

def clean_ascii(text):
    if not text:
        return text
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

# -------------------------------------------------------------------------
# Dicionários especializados de tradução para PT-BR
# -------------------------------------------------------------------------

TRANSLATIONS_EXACT = {
    # com.tdf
    "New Game": "Novo Jogo",
    "Continue": "Continuar",
    "Settings": "Configuracoes",
    "Help": "Ajuda",
    "Network Storage": "Armazem na Rede",
    "Network Battle": "Batalha na Rede",
    "Send a Gift": "Enviar Presente",
    "Go to Game Zone": "Ir para Game Zone",
    "Exit Game": "Sair do Jogo",
    "NORMAL": "NORMAL",
    "HARDCORE": "DIFICIL",
    "HELL": "INFERNAL",
    "Yes": "Sim",
    "No": "Nao",
    "Select a combat style": "Escolha o estilo de combate",
    "Select a slot;for the new game.": "Escolha um slot;para o novo jogo.",
    "SLOT": "SLOT",
    "Empty Slot": "Slot Vazio",
    "Gold": "Ouro",
    "OK": "OK",
    " Obtained": " Obtido",
    "EMPTY": "VAZIO",
    "ON": "LIG",
    "OFF": "DES",
    "Sound": "Som",
    "BGM": "Musica",
    "SFX": "Efeitos",
    "Game Speed": "Velocidade",
    "Camera Movement": "Iluminacao",
    "Completion": "Conclusao",
    "SLOW": "LENTO",
    "FAST": "RAPIDO",
    "FASTER": "TURBO",
    "The Game Zone feature": "O recurso Game Zone",
    "GAME OVER": "FIM DE JOGO",
    "NOW LOADING": "CARREGANDO",
    "To continue the game;press any key.": "Pressione qualquer tecla;para continuar o jogo.",
    "Press OK": "Pressione OK",
    "Defense": "Defesa",
    "If you save while playing, ": "Se salvar durante o jogo, ",
    "the existing data will be": "os dados salvos anteriores",
    "deleted.": "serao substituidos.",
    "Start a new game?": "Iniciar um novo jogo?",
    "When connecting to the network,": "Ao conectar-se a rede,",
    "call charges will apply.": "tarifas podem ser cobradas.",
    "Connect?": "Conectar?",
    "There is no character.": "Nenhum personagem encontrado.",
    "Enter the quantity.": "Informe a quantidade.",
    "to Hardcore mode": "para o modo Dificil",
    "to Hell mode": "para o modo Infernal",

    # gm.tdf
    "Save": "Salvar",
    "Options": "Opcoes",
    "Exit": "Sair",
    "STATUS": "STATUS",
    "INVENTORY": "INVENTARIO",
    "EQUIPMENT": "EQUIPAMENTO",
    "SKILL": "HABILIDADE",
    "BEAST": "BESTA",
    "QUEST": "MISSOES",
    "CARD": "CARTAS",
    "SYSTEM": "SISTEMA",
    "Save the game?": "Deseja salvar o jogo?",
    "Item Details": "Detalhes do Item",
    "PASSIVE": "PASSIVA",
    "ACTIVE": "ATIVA",
    "Basic Attack": "Ataque Basico",
    "Combo": "Combo",
    "Hit": "Acerto",
    "Discard": "Descartar",
    "Equip": "Equipar",
    "Use": "Usar",
    "View Details": "Ver Detalhes",
    "Invest Points": "Investir Pontos",
    "Skill Details": "Detalhes da Habilidade",
    "Register to Slot 1": "Atribuir ao Slot 1",
    "Register to Slot 3": "Atribuir ao Slot 3",
    "Register to Slot 7": "Atribuir ao Slot 7",
    "Register to Slot 9": "Atribuir ao Slot 9",
    "Inactive": "Inativo",
    "Saving...": "Salvando...",
    "Saved.": "Jogo salvo com sucesso.",
    "The Berserker cannot equip this slot.": "Berserker nao pode usar este slot.",
    "There are no equippable items.": "Nao ha itens equipaveis.",
    "There are no quests in progress.": "Nenhuma missao em andamento.",
    "Quest Reward": "Recompensa de Missao",
    "Main Quest": "Missao Principal",
    "Sub Quest": "Missao Secundaria",
    "Discard it?": "Deseja descartar?",
    "Move it?": "Deseja mover?",
    "Unequip": "Desequipar",
    "Low": "Baixo",
    "Mid": "Medio",
    "High": "Alto",
    "The equipment has been changed.": "O equipamento foi alterado.",
    "Apply it?": "Deseja aplicar?",
    "You cannot discard an equipped item.": "Nao pode descartar item equipado.",
    "Equipping...": "Equipando...",
    "Material Bag": "Bolsa de Materiais",
    "Select equipment.": "Selecione o equipamento.",
    "Cannot wear Heavy Armor": "Nao pode vestir Armadura Pesada",
    "Item": "Item",
    "Card": "Carta",
    "Move Up": "Mover Acima",
    "Move Down": "Mover Abaixo",
    "You cannot select an equipped item.": "Nao pode selecionar item equipado.",
    "Level requirement not met.": "Nivel necessario nao alcancado.",
    "You cannot save on a boss map.": "Nao e possivel salvar no chefe.",
    "EXP": "EXP",
    "This cannot be used on a boss map.": "Nao pode ser usado no chefe.",

    # hero.tdf
    "Claire": "Claire",
    "Berserker": "Berserker",
    "Knight": "Cavaleiro",
    "Rogue": "Ladino",
    "Trainee": "Aprendiz",

    # itmatt.tdf
    "One Slash": "Golpe Unico",
    "Focus": "Concentracao",
    "Absorb": "Absorcao",
    "Resist": "Resistencia",
    "Fighting Spirit": "Espirito de Luta",

    # itmtp.tdf
    "Two-Handed Greatsword": "Espada de Duas Maos",
    "Two-Handed Axe": "Machado de Duas Maos",
    "Sword": "Espada",
    "Dagger": "Adaga",
    "Blunt Weapon": "Arma Contundente",
    "Bow": "Arco",
    "Shield": "Escudo",
    "Helmet": "Elmo",
    "Heavy Armor": "Armadura Pesada",
    "Light Armor": "Armadura Leve",
    "Robe": "Manto",
    "Gloves": "Luvas",
    "Boots": "Botas",
    "Ring": "Anel",
    "Necklace": "Colar",
    "Potion": "Pocao",
    "Scroll": "Pergaminho",
    "Material": "Material",
    "Quest Item": "Item de Missao",

    # shop.tdf
    "What do you desire?": "O que voce deseja?",
    "Buy Items": "Comprar Itens",
    "Sell Items": "Vender Itens",
    "What are you looking for?": "O que procura hoje?",
    "Weapons": "Armas",
    "Armor": "Armaduras",
    "Accessories": "Acessorios",
    "Consumables": "Consumiveis",

    # rf.tdf
    "Enchant Equipment": "Encantar Equipamento",
    "Craft Item": "Criar Item",
    "Enchant": "Encantar",
    "Cancel": "Cancelar",

    # bm.tdf / bsk.tdf / bsm.tdf
    "Beast Keeper": "Domador de Bestas",
    "Details": "Detalhes",
    "Beast Evolution": "Evolucao de Besta",
    "Equip Beast": "Equipar Besta",
    "Unequip": "Desequipar",
    "Water of Healing": "Agua Curativa",
    "Guardian of Light": "Guardiao da Luz",
    "Blood Pact": "Pacto de Sangue",
    "Refine Equipment": "Refinar Equipamento",
    "Equipment to Refine": "Equipamento a Refinar",
    "Refining Stone": "Pedra de Refinamento",
    "Select the equipment to refine.": "Selecione o equipamento a refinar.",

    # help.tdf
    "Basic Controls": "Controles Basicos",
    "Skill": "Habilidades",
    "Beast": "Besta Sagrada",
    "Status": "Atributos",
    "Equipment": "Equipamentos",
}

# Tradução contextual por expressões regulares para itens e mapas
ITEM_PATTERNS = [
    (r"Twohand Sword", "Espada Dupla"),
    (r"Greatsword", "Espada Grande"),
    (r"Zweihander", "Zweihander"),
    (r"Broadsword", "Espada Larga"),
    (r"Longsword", "Espada Longa"),
    (r"Shortsword", "Espada Curta"),
    (r"Dagger", "Adaga"),
    (r"Battle Axe", "Machado de Guerra"),
    (r"Warhammer", "Martelo de Guerra"),
    (r"Mace", "Maca"),
    (r"Staff", "Cajado"),
    (r"Leather Armor", "Armadura de Couro"),
    (r"Chain Mail", "Cota de Malha"),
    (r"Plate Armor", "Armadura de Placas"),
    (r"Iron Helmet", "Elmo de Ferro"),
    (r"Steel Shield", "Escudo de Aco"),
    (r"Wooden Shield", "Escudo de Madeira"),
    (r"Leather Boots", "Botas de Couro"),
    (r"Iron Boots", "Botas de Ferro"),
    (r"Leather Gloves", "Luvas de Couro"),
    (r"Healing Potion", "Pocao de Cura"),
    (r"Mana Potion", "Pocao de Mana"),
    (r"Health Potion", "Pocao de Vida"),
    (r"Potion", "Pocao"),
    (r"Elixir", "Elixir"),
    (r"Ring", "Anel"),
    (r"Amulet", "Amuleto"),
    (r"Necklace", "Colar"),
    (r"Refining Stone", "Pedra de Refino"),
    (r"Magic Stone", "Pedra Magica"),
    (r"Beast Serum", "Soro da Besta"),
]

MAP_NAMES = {
    "Winterhearts - Central Downtown": "Winterhearts - Centro Comercial",
    "Winterhearts - West Downtown": "Winterhearts - Centro Oeste",
    "Winterhearts - East Downtown": "Winterhearts - Centro Leste",
    "Winterhearts - Castle": "Winterhearts - Castelo",
    "Winterhearts - Temple": "Winterhearts - Templo Sagrado",
    "Frost Valley Village": "Vila do Vale Gelado",
    "Frost Valley Shop": "Comercio do Vale Gelado",
    "Frost Valley South": "Sul do Vale Gelado",
    "Frost Valley North": "Norte do Vale Gelado",
    "Village Hall": "Sede da Vila",
    "Sindraf South": "Sul de Sindraf",
    "Sindraf North": "Norte de Sindraf",
    "Sindraf Castle": "Castelo de Sindraf",
    "Sindraf Plains": "Planicies de Sindraf",
    "Murlock Gorge South": "Sul da Garganta Murlock",
    "Murlock Gorge North": "Norte da Garganta Murlock",
    "Undersea Tunnel Zone 1": "Tunel Submarino Zona 1",
    "Undersea Tunnel Zone 2": "Tunel Submarino Zona 2",
    "Undersea Tunnel Zone 3": "Tunel Submarino Zona 3",
    "Undersea Tunnel Zone 4": "Tunel Submarino Zona 4",
    "Undersea Tunnel Zone 5": "Tunel Submarino Zona 5",
    "Bandit Den Zone 1": "Covil dos Bandidos Zona 1",
    "Bandit Den Zone 2": "Covil dos Bandidos Zona 2",
    "Bandit Den Zone 3": "Covil dos Bandidos Zona 3",
    "Dark Cave Zone 1": "Caverna Escura Zona 1",
    "Dark Cave Zone 2": "Caverna Escura Zona 2",
    "Dark Cave Zone 3": "Caverna Escura Zona 3",
    "Gorge Underground Zone 1": "Subsolo da Garganta Zona 1",
    "Gorge Underground Zone 2": "Subsolo da Garganta Zona 2",
    "Gorge Underground Zone 3": "Subsolo da Garganta Zona 3",
    "Cardiff Forest North": "Norte da Floresta Cardiff",
    "Cardiff Forest South": "Sul da Floresta Cardiff",
}

DIALOGUE_REPLACEMENTS = [
    ("}It is locked.@", "}Esta trancado.@"),
    ("}Set this as your return point?", "}Definir este local como ponto de retorno?"),
    ("} set as your return point!@", "} definido como seu ponto de retorno!@"),
    ("No business here right now.", "Nenhum assunto aqui no momento."),
    ("Halt. You cannot enter.", "Alto la! Voce nao pode passar."),
    ("Welcome, welcome!", "Seja muito bem-vindo!"),
    ("Experience gained!@", "Experiencia adquirida!@"),
    ("Quest acquired!@", "Missao adquirida!@"),
    ("Quest completed!@", "Missao concluida!@"),
    ("obtained!@", "obtido!@"),
    ("handed over.@", "entregue com sucesso.@"),
    ("Will you listen?", "Deseja escutar?"),
    ("Proceed?", "Deseja prosseguir?"),
    ("You cannot save once you move to the boss room.@", "Nao sera possivel salvar na sala do chefe.@"),
    ("Blocked by fallen rocks.@", "Bloqueado por pedras desmoronadas.@"),
    ("was set.@", "foi posicionado.@"),
    ("Thank you! Take this.", "Muito obrigado! Pegue isto."),
    ("Did you find her?", "Voce a encontrou?"),
    ("Yes... sadly, she died during the war.", "Sim... infelizmente ela faleceu na guerra."),
    ("Move.", "Saia do caminho."),
    ("Because it is dangerous.", "Porque isso e perigoso demais."),
    ("And who are you...?", "E quem e voce...?"),
    ("Thanks for the help.", "Obrigada pela ajuda."),
    ("I fought on Ascra side during the Unification War.", "Lutei ao lado de Ascra na Guerra da Unificacao."),
    ("Head to Sindraf", "Va para Sindraf"),
    ("Find a Skill Master", "Encontre um Mestre de Habilidades"),
    ("The Guardian Spirit", "O Espirito Guardiao"),
    ("The Flame Threat", "A Ameaca da Chama"),
    ("The Beloved One", "A Amada Perdida"),
]

def translate_string(s):
    if not s or len(s.strip()) == 0:
        return s
    if s in TRANSLATIONS_EXACT:
        return TRANSLATIONS_EXACT[s]
    res = s
    for eng, pt in DIALOGUE_REPLACEMENTS:
        res = res.replace(eng, pt)
    # Tags e personages
    res = res.replace("[Village Chief]@", "[Chefe da Vila]@")
    res = res.replace("[Villager]@", "[Aldeao]@")
    res = res.replace("[Village Man]@", "[Homem da Vila]@")
    res = res.replace("[Village Woman]@", "[Mulher da Vila]@")
    res = res.replace("[Sindraf Knight]@", "[Cavaleiro de Sindraf]@")
    res = res.replace("[Woman with a Blue Ribbon]@", "[Moca da Fita Azul]@")
    res = res.replace("[Corvus Member]@", "[Membro de Corvus]@")
    res = res.replace("[Freelance Master]@", "[Mestre Errante]@")
    res = res.replace("[Merchant]@", "[Comerciante]@")
    res = res.replace("[Blacksmith]@", "[Ferreiro]@")
    res = res.replace("[Beast Keeper]@", "[Domador]@")
    res = res.replace("[Alchemist]@", "[Alquimista]@")
    return clean_ascii(res)

def translate_item_name(name):
    if not name:
        return name
    if name in TRANSLATIONS_EXACT:
        return TRANSLATIONS_EXACT[name]
    res = name
    for pattern, rep in ITEM_PATTERNS:
        res = re.sub(pattern, rep, res)
    return clean_ascii(res)

def translate_item_desc(desc):
    if not desc:
        return desc
    res = desc
    res = res.replace("Restores", "Restaura")
    res = res.replace("Increases", "Aumenta")
    res = res.replace("Reduces", "Reduz")
    res = res.replace("hero's", "do heroi")
    res = res.replace("for a set time", "por um periodo")
    return clean_ascii(res)

# -------------------------------------------------------------------------
# Execução Principal
# -------------------------------------------------------------------------
def main():
    print("=== Iniciando Geracao dos Pacotes Multi-idioma (EN e PT-BR) ===")
    
    base_assets = "assets/lang"
    os.makedirs(f"{base_assets}/en/t", exist_ok=True)
    os.makedirs(f"{base_assets}/en/itm", exist_ok=True)
    os.makedirs(f"{base_assets}/en/m/m", exist_ok=True)

    os.makedirs(f"{base_assets}/pt_br/t", exist_ok=True)
    os.makedirs(f"{base_assets}/pt_br/itm", exist_ok=True)
    os.makedirs(f"{base_assets}/pt_br/m/m", exist_ok=True)

    # 1. Copia referências originais de EN
    print("[1/3] Copiando arquivos originais de Ingles para assets/lang/en/...")
    for tdf in glob.glob("reference/extracted/t/*.tdf"):
        shutil.copy2(tdf, f"{base_assets}/en/t/{os.path.basename(tdf)}")
    for itm in glob.glob("reference/extracted/itm/*"):
        if os.path.basename(itm) == "forshop": continue
        shutil.copy2(itm, f"{base_assets}/en/itm/{os.path.basename(itm)}")
    for m in glob.glob("reference/extracted/m/m/*.m"):
        shutil.copy2(m, f"{base_assets}/en/m/m/{os.path.basename(m)}")

    # 2. Tradução e Empacotamento de TDF para PT-BR
    print("[2/3] Traduzindo e empacotando 19 arquivos TDF para assets/lang/pt_br/t/...")
    with open("reference/lang_en/tdf_strings.json", "r", encoding="utf-8") as f:
        tdf_data = json.load(f)

    for fname, str_list in tdf_data.items():
        translated_list = [translate_string(s) for s in str_list]
        packed = pack_tdf(translated_list)
        out_path = f"{base_assets}/pt_br/t/{fname}"
        with open(out_path, "wb") as fp:
            fp.write(packed)

    # 3. Tradução e Empacotamento de ITM para PT-BR
    print("[3/3] Traduzindo e empacotando 34 arquivos ITM para assets/lang/pt_br/itm/...")
    for path in sorted(glob.glob("reference/extracted/itm/*")):
        fname = os.path.basename(path)
        if fname == "forshop": continue
        with open(path, "rb") as fp:
            orig = fp.read()
        
        idx = 0
        records = []
        while idx + 2 <= len(orig):
            rec_len = (orig[idx] << 8) | orig[idx+1]
            idx += 2
            rec = bytearray(orig[idx:idx+rec_len])
            idx += rec_len
            
            # Rec: 4 bytes price/stat, 1 byte nlen, name, 1 byte dlen, desc, tail
            if len(rec) >= 5:
                p = 4
                nlen = rec[p]
                orig_name = rec[p+1:p+1+nlen].decode('utf-8', errors='replace')
                new_name = translate_item_name(orig_name).encode('utf-8')
                
                p2 = p + 1 + nlen
                new_desc = b""
                tail = b""
                if p2 < len(rec):
                    dlen = rec[p2]
                    orig_desc = rec[p2+1:p2+1+dlen].decode('utf-8', errors='replace')
                    new_desc = translate_item_desc(orig_desc).encode('utf-8')
                    tail = rec[p2+1+dlen:]
                
                new_rec = bytearray(rec[:4])
                new_rec.append(len(new_name) & 0xFF)
                new_rec.extend(new_name)
                if p2 < len(rec):
                    new_rec.append(len(new_desc) & 0xFF)
                    new_rec.extend(new_desc)
                    new_rec.extend(tail)
                records.append(bytes(new_rec))
            else:
                records.append(bytes(rec))
        
        repacked = bytearray()
        for r in records:
            repacked.append((len(r) >> 8) & 0xFF)
            repacked.append(len(r) & 0xFF)
            repacked.extend(r)
        
        with open(f"{base_assets}/pt_br/itm/{fname}", "wb") as fp:
            fp.write(bytes(repacked))

    # 4. Tradução e Empacotamento de Mapas (M) para PT-BR
    print("[4/4] Traduzindo e empacotando 111 mapas para assets/lang/pt_br/m/m/...")
    with open("reference/lang_en/map_strings.json", "r", encoding="utf-8") as f:
        map_json = json.load(f)

    for mfile in sorted(glob.glob("reference/extracted/m/m/*.m")):
        fname = os.path.basename(mfile)
        with open(mfile, "rb") as fp:
            orig_m = fp.read()
        
        info = map_json.get(fname, {"name": "", "dialogues": []})
        orig_name = info["name"]
        new_name = MAP_NAMES.get(orig_name, orig_name)
        new_dialogues = [translate_string(d) for d in info["dialogues"]]
        
        repacked_map = repack_map(orig_m, new_name, new_dialogues)
        with open(f"{base_assets}/pt_br/m/m/{fname}", "wb") as fp:
            fp.write(repacked_map)

    # 5. Sincroniza cópias para Android
    android_assets = "android/app/src/main/assets/lang"
    if os.path.exists("android/app/src/main/assets"):
        print("[Sync] Sincronizando assets/lang/ para android/app/src/main/assets/lang/...")
        if os.path.exists(android_assets):
            shutil.rmtree(android_assets)
        shutil.copytree(base_assets, android_assets)

    print("=== Geracao de Idiomas Concluida com Sucesso Absoluto! ===")

if __name__ == "__main__":
    main()
