// cheats.cpp — Implementação do Menu Secreto de Trapaças (God Mode, SP Infinito, +100k Gold e Rank de Honra)
#include "platform/cheats.h"
#include "platform/platform.h"
#include "vm/vm.h"

#include <algorithm>
#include <cstdio>
#include <chrono>

namespace hl {

// Estado global dos Cheats
static bool s_modalActive = false;
static int s_selectedItem = 0;       // 0: GodMode, 1: InfSP, 2: AddGold, 3: Rank, 4: Fechar
static int s_selectedRank = 14;      // Padrão: 14 (Comandante Supremo)
static bool s_godMode = false;
static bool s_infiniteSp = false;
static bool s_zeroCooldown = false;

static VM* s_vm = nullptr;
static std::string s_feedbackMsg = "";
static uint32_t s_feedbackTimer = 0;

// Cache de índices de campos
static int s_idxPlayer = -1;
static int s_idxGold = -1;
static int s_idxHonor = -1;
static int s_idxCurrentHp = -1;
static int s_idxMaxHp = -1;
static int s_idxCurrentSp = -1;
static int s_idxMaxSp = -1;
static int s_idxRank = -1;
static int s_idxCooldowns = -1;

// Lista de nomes de patentes originais (15 patentes, baseadas em hero.tdf)
static const char* s_rankNamesPt[15] = {
  "Recruta",
  "Mercenario",
  "Infantaria Leve",
  "Cavalaria Leve",
  "Cabo",
  "Centuriao",
  "Escudeiro",
  "Cavaleiro Junior",
  "Cavaleiro Pleno",
  "Membro da Ordem",
  "Capitao da Ordem",
  "Guarda Real",
  "Capitao da Guarda",
  "Comandante",
  "Comandante Supremo"
};

static const char* s_rankNamesEn[15] = {
  "Trainee",
  "Mercenary",
  "Light Infantry",
  "Light Cavalry",
  "Corporal",
  "Centurion",
  "Squire",
  "Junior Knight",
  "Full Knight",
  "Knight Order Member",
  "Knight Captain",
  "Royal Guard Member",
  "Royal Guard Captain",
  "Commander",
  "Supreme Commander"
};

// Hitboxes interativas para Touch e Mouse
struct CheatHitbox {
  SDL_Rect rect;
  int action; // 0..4: Linha, 10: Rank Left, 11: Rank Right, 20: Fechar (X)
};
static std::vector<CheatHitbox> s_hitboxes;

const char* Cheats::getRankName(int rankIndex, bool isPt) {
  rankIndex = std::clamp(rankIndex, 0, 14);
  return isPt ? s_rankNamesPt[rankIndex] : s_rankNamesEn[rankIndex];
}

int Cheats::getSelectedRank() {
  return s_selectedRank;
}

bool Cheats::isGodMode() {
  return s_godMode;
}

void Cheats::setGodMode(bool enable) {
  s_godMode = enable;
}

void Cheats::toggleGodMode() {
  s_godMode = !s_godMode;
  bool isPt = (Platform::getCurrentLanguage() == "pt" || Platform::getCurrentLanguage() == "pt_br");
  if (s_godMode) {
    s_feedbackMsg = isPt ? "Modo Deus: ATIVADO!" : "God Mode: ENABLED!";
  } else {
    s_feedbackMsg = isPt ? "Modo Deus: DESATIVADO!" : "God Mode: DISABLED!";
  }
  s_feedbackTimer = SDL_GetTicks() + 2500;
  if (s_godMode && s_vm) {
    update(s_vm);
  }
}

bool Cheats::isInfiniteSp() {
  return s_infiniteSp;
}

void Cheats::setInfiniteSp(bool enable) {
  s_infiniteSp = enable;
}

void Cheats::toggleInfiniteSp() {
  s_infiniteSp = !s_infiniteSp;
  bool isPt = (Platform::getCurrentLanguage() == "pt" || Platform::getCurrentLanguage() == "pt_br");
  if (s_infiniteSp) {
    s_feedbackMsg = isPt ? "SP Infinito: ATIVADO!" : "Infinite SP: ENABLED!";
  } else {
    s_feedbackMsg = isPt ? "SP Infinito: DESATIVADO!" : "Infinite SP: DISABLED!";
  }
  s_feedbackTimer = SDL_GetTicks() + 2500;
  if (s_infiniteSp && s_vm) {
    update(s_vm);
  }
}

bool Cheats::isZeroCooldown() {
  return s_zeroCooldown;
}

void Cheats::setZeroCooldown(bool enable) {
  s_zeroCooldown = enable;
}

void Cheats::toggleZeroCooldown() {
  s_zeroCooldown = !s_zeroCooldown;
  bool isPt = (Platform::getCurrentLanguage() == "pt" || Platform::getCurrentLanguage() == "pt_br");
  if (s_zeroCooldown) {
    s_feedbackMsg = isPt ? "Zero Cooldown: ATIVADO!" : "Zero Cooldown: ENABLED!";
  } else {
    s_feedbackMsg = isPt ? "Zero Cooldown: DESATIVADO!" : "Zero Cooldown: DISABLED!";
  }
  s_feedbackTimer = SDL_GetTicks() + 2500;
  if (s_zeroCooldown && s_vm) {
    update(s_vm);
  }
}

void Cheats::init() {
  s_modalActive = false;
  s_selectedItem = 0;
  s_selectedRank = 14;
  s_godMode = false;
  s_infiniteSp = false;
  s_zeroCooldown = false;
  s_feedbackMsg.clear();
  s_feedbackTimer = 0;
}

bool Cheats::isModalActive() {
  return s_modalActive;
}

void Cheats::openModal(VM* vm) {
  s_modalActive = true;
  s_selectedItem = 0;
  s_feedbackMsg.clear();
  s_feedbackTimer = 0;
  if (vm) s_vm = vm;

  // Se o jogador estiver carregado na memória, sincroniza a patente atual
  if (s_vm) {
    ClassInfo* uClass = s_vm->findClass("u");
    if (uClass) {
      if (s_idxPlayer == -1) {
        FieldInfo* f = s_vm->findField(uClass, "a:Lb;");
        if (f) s_idxPlayer = f->index;
      }
      if (s_idxPlayer >= 0 && s_idxPlayer < (int)uClass->statics.size()) {
        Object* pObj = uClass->statics[s_idxPlayer].o;
        if (pObj && pObj->kind == K_INST) {
          Instance* player = static_cast<Instance*>(pObj);
          if (s_idxRank == -1) {
            ClassInfo* bClass = s_vm->findClass("b");
            if (bClass) {
              FieldInfo* f = s_vm->findField(bClass, "b:B");
              if (f) s_idxRank = f->index;
            }
          }
          if (s_idxRank >= 0 && s_idxRank < (int)player->f.size()) {
            int curRank = (int)(int8_t)player->f[s_idxRank].i;
            s_selectedRank = std::clamp(curRank, 0, 14);
          }
        }
      }
    }
  }
}

void Cheats::closeModal() {
  s_modalActive = false;
  s_feedbackMsg.clear();
  s_feedbackTimer = 0;
}

void Cheats::addMoney(VM* vm, int amount) {
  if (!vm) vm = s_vm;
  bool isPt = (Platform::getCurrentLanguage() == "pt" || Platform::getCurrentLanguage() == "pt_br");
  if (!vm) {
    s_feedbackMsg = isPt ? "Erro: VM indisponivel" : "Error: VM unavailable";
    s_feedbackTimer = SDL_GetTicks() + 2500;
    return;
  }

  ClassInfo* uClass = vm->findClass("u");
  if (!uClass) {
    s_feedbackMsg = isPt ? "Erro: Classe u nao encontrada" : "Error: Class u not found";
    s_feedbackTimer = SDL_GetTicks() + 2500;
    return;
  }

  if (s_idxGold == -1) {
    FieldInfo* f = vm->findField(uClass, "f:I");
    if (f) s_idxGold = f->index;
  }

  if (s_idxGold >= 0 && s_idxGold < (int)uClass->statics.size()) {
    int curGold = uClass->statics[s_idxGold].i;
    curGold += amount;
    if (curGold > 99999999) curGold = 99999999;
    if (curGold < 0) curGold = 0;
    uClass->statics[s_idxGold].i = curGold;

    char buf[64];
    snprintf(buf, sizeof(buf), isPt ? "+%d Gold adicionado! (Total: %d)" : "+%d Gold added! (Total: %d)", amount, curGold);
    s_feedbackMsg = buf;
    s_feedbackTimer = SDL_GetTicks() + 3000;
  } else {
    s_feedbackMsg = isPt ? "Carregue um jogo primeiro!" : "Load a game first!";
    s_feedbackTimer = SDL_GetTicks() + 2500;
  }
}

void Cheats::setRank(VM* vm, int rankIndex) {
  if (!vm) vm = s_vm;
  bool isPt = (Platform::getCurrentLanguage() == "pt" || Platform::getCurrentLanguage() == "pt_br");
  if (!vm) {
    s_feedbackMsg = isPt ? "Erro: VM indisponivel" : "Error: VM unavailable";
    s_feedbackTimer = SDL_GetTicks() + 2500;
    return;
  }

  ClassInfo* uClass = vm->findClass("u");
  if (!uClass) {
    s_feedbackMsg = isPt ? "Erro: Classe u nao encontrada" : "Error: Class u not found";
    s_feedbackTimer = SDL_GetTicks() + 2500;
    return;
  }

  if (s_idxPlayer == -1) {
    FieldInfo* f = vm->findField(uClass, "a:Lb;");
    if (f) s_idxPlayer = f->index;
  }

  rankIndex = std::clamp(rankIndex, 0, 14);

  if (s_idxPlayer >= 0 && s_idxPlayer < (int)uClass->statics.size()) {
    Object* pObj = uClass->statics[s_idxPlayer].o;
    if (pObj && pObj->kind == K_INST) {
      Instance* player = static_cast<Instance*>(pObj);
      ClassInfo* bClass = vm->findClass("b");
      if (bClass && s_idxRank == -1) {
        FieldInfo* f = vm->findField(bClass, "b:B");
        if (f) s_idxRank = f->index;
      }
      if (s_idxRank >= 0 && s_idxRank < (int)player->f.size()) {
        player->f[s_idxRank].i = (int8_t)rankIndex;

        // Atualiza pontos de honra em u.g para condizer com o ranking
        if (s_idxHonor == -1) {
          FieldInfo* fH = vm->findField(uClass, "g:I");
          if (fH) s_idxHonor = fH->index;
        }
        if (s_idxHonor >= 0 && s_idxHonor < (int)uClass->statics.size()) {
          uClass->statics[s_idxHonor].i = (rankIndex + 1) * 200;
        }

        std::string name = getRankName(rankIndex, isPt);
        s_feedbackMsg = isPt ? ("Patente aplicada: " + name + "!") : ("Rank applied: " + name + "!");
        s_feedbackTimer = SDL_GetTicks() + 3000;
        return;
      }
    }
  }

  s_feedbackMsg = isPt ? "Carregue um jogo primeiro!" : "Load a game first!";
  s_feedbackTimer = SDL_GetTicks() + 2500;
}

// Atualização contínua a cada frame (mantém HP e SP travados no máximo se ativados)
void Cheats::update(VM* vm) {
  if (!vm) return;
  s_vm = vm;

  if (!s_godMode && !s_infiniteSp && !s_zeroCooldown) return;

  ClassInfo* uClass = vm->findClass("u");
  if (!uClass) return;

  if (s_idxPlayer == -1) {
    FieldInfo* f = vm->findField(uClass, "a:Lb;");
    if (f) s_idxPlayer = f->index;
  }
  if (s_idxPlayer < 0 || s_idxPlayer >= (int)uClass->statics.size()) return;

  Object* pObj = uClass->statics[s_idxPlayer].o;
  if (!pObj || pObj->kind != K_INST) return;
  Instance* player = static_cast<Instance*>(pObj);

  ClassInfo* bClass = vm->findClass("b");
  if (!bClass) return;

  if (s_idxCurrentHp == -1) {
    FieldInfo* f = vm->findField(bClass, "a:I");
    if (f) s_idxCurrentHp = f->index;
    f = vm->findField(bClass, "d:I");
    if (f) s_idxMaxHp = f->index;
    f = vm->findField(bClass, "b:I");
    if (f) s_idxCurrentSp = f->index;
    f = vm->findField(bClass, "e:I");
    if (f) s_idxMaxSp = f->index;
  }

  // Notifica o HUD bd para redesenhar as barras se houver alteração
  Instance* bdObj = nullptr;
  int idxBdD = -1;
  int idxBdE = -1;
  ClassInfo* bdClass = vm->findClass("bd");
  if (bdClass) {
    FieldInfo* fBdInst = vm->findField(bdClass, "a:Lbd;");
    if (fBdInst && fBdInst->isStatic && fBdInst->index >= 0 && fBdInst->index < (int)bdClass->statics.size()) {
      Object* o = bdClass->statics[fBdInst->index].o;
      if (o && o->kind == K_INST) {
        bdObj = static_cast<Instance*>(o);
        FieldInfo* fD = vm->findField(bdClass, "d:Z");
        if (fD) idxBdD = fD->index;
        FieldInfo* fE = vm->findField(bdClass, "e:Z");
        if (fE) idxBdE = fE->index;
      }
    }
  }

  // God Mode: HP atual = HP máximo
  if (s_godMode && s_idxCurrentHp >= 0 && s_idxMaxHp >= 0 &&
      s_idxCurrentHp < (int)player->f.size() && s_idxMaxHp < (int)player->f.size()) {
    int maxHp = player->f[s_idxMaxHp].i;
    if (maxHp > 0) {
      if (player->f[s_idxCurrentHp].i != maxHp) {
        player->f[s_idxCurrentHp].i = maxHp;
      }
      if (bdObj && idxBdD >= 0 && idxBdD < (int)bdObj->f.size()) {
        bdObj->f[idxBdD].i = 1; // Força redesenho da barra de vida cheia
      }
    }
  }

  // Infinite SP: SP atual = SP máximo
  if (s_infiniteSp && s_idxCurrentSp >= 0 && s_idxMaxSp >= 0 &&
      s_idxCurrentSp < (int)player->f.size() && s_idxMaxSp < (int)player->f.size()) {
    int maxSp = player->f[s_idxMaxSp].i;
    if (maxSp > 0) {
      if (player->f[s_idxCurrentSp].i != maxSp) {
        player->f[s_idxCurrentSp].i = maxSp;
      }
      if (bdObj && idxBdE >= 0 && idxBdE < (int)bdObj->f.size()) {
        bdObj->f[idxBdE].i = 1; // Força redesenho da barra de SP cheia
      }
    }
  }

  // Zero Cooldown: zera todos os timers de recarga em u.a:[I] (var_int_arr_a)
  if (s_zeroCooldown) {
    if (s_idxCooldowns == -1) {
      FieldInfo* fCd = vm->findField(uClass, "a:[I");
      if (fCd && fCd->isStatic) s_idxCooldowns = fCd->index;
    }
    if (s_idxCooldowns >= 0 && s_idxCooldowns < (int)uClass->statics.size()) {
      Object* cdObj = uClass->statics[s_idxCooldowns].o;
      if (cdObj && cdObj->kind == K_ARRAY) {
        Array* arr = static_cast<Array*>(cdObj);
        int* cdData = reinterpret_cast<int*>(arr->data.data());
        for (int c = 0; c < arr->len; c++) {
          cdData[c] = -1; // -1 = pronto / sem recarga no jogo original
        }
      }
    }
  }
}

// Navegação e Ações por Teclado e Gamepad
bool Cheats::handleInput(int key, VM* vm) {
  if (!s_modalActive) return false;
  if (vm) s_vm = vm;

  // 1. Navegação Vertical (6 itens: 0..5)
  if (key == 50 || key == -1) { // Cima (Tecla 2, D-Pad Up, Seta Cima)
    s_selectedItem = (s_selectedItem + 5) % 6;
    return true;
  } else if (key == 56 || key == -2) { // Baixo (Tecla 8, D-Pad Down, Seta Baixo)
    s_selectedItem = (s_selectedItem + 1) % 6;
    return true;
  }

  // 2. Navegação Horizontal
  if (key == 52 || key == -3) { // Esquerda (Tecla 4, D-Pad Left, Seta Esquerda)
    if (s_selectedItem == 0) {
      toggleGodMode();
    } else if (s_selectedItem == 1) {
      toggleInfiniteSp();
    } else if (s_selectedItem == 2) {
      toggleZeroCooldown();
    } else if (s_selectedItem == 4) {
      s_selectedRank = (s_selectedRank + 14) % 15;
      setRank(s_vm, s_selectedRank);
    }
    return true;
  } else if (key == 54 || key == -4) { // Direita (Tecla 6, D-Pad Right, Seta Direita)
    if (s_selectedItem == 0) {
      toggleGodMode();
    } else if (s_selectedItem == 1) {
      toggleInfiniteSp();
    } else if (s_selectedItem == 2) {
      toggleZeroCooldown();
    } else if (s_selectedItem == 4) {
      s_selectedRank = (s_selectedRank + 1) % 15;
      setRank(s_vm, s_selectedRank);
    }
    return true;
  }

  // 3. Ação / Confirmação (Enter, Espaço, Tecla 5, Botão A)
  if (key == 53 || key == 13 || key == 32 || key == -5) {
    switch (s_selectedItem) {
      case 0:
        toggleGodMode();
        break;
      case 1:
        toggleInfiniteSp();
        break;
      case 2:
        toggleZeroCooldown();
        break;
      case 3:
        addMoney(s_vm, 100000);
        break;
      case 4:
        s_selectedRank = (s_selectedRank + 1) % 15;
        setRank(s_vm, s_selectedRank);
        break;
      case 5:
        closeModal();
        break;
    }
    return true;
  }

  // 4. Cancelar / Voltar (Esc, Backspace, Tecla 7, Botão B, RSK)
  if (key == -7 || key == 8 || key == 27 || key == 55) {
    closeModal();
    return true;
  }

  return true;
}

// Suporte a Toque / Clique do Mouse
void Cheats::handleClick(int x, int y, VM* vm) {
  if (!s_modalActive) return;
  if (vm) s_vm = vm;

  // 1. Prioridade máxima: botões dedicados (Fechar X e Botões de Patente [ < ] e [ > ])
  for (const auto& hb : s_hitboxes) {
    if (x >= hb.rect.x && x <= hb.rect.x + hb.rect.w &&
        y >= hb.rect.y && y <= hb.rect.y + hb.rect.h) {
      if (hb.action == 20) { // Botão Fechar (X)
        closeModal();
        return;
      } else if (hb.action == 10) { // Rank Botão Esquerdo [ < ]
        s_selectedItem = 4;
        s_selectedRank = (s_selectedRank + 14) % 15;
        setRank(s_vm, s_selectedRank);
        return;
      } else if (hb.action == 11) { // Rank Botão Direito [ > ]
        s_selectedItem = 4;
        s_selectedRank = (s_selectedRank + 1) % 15;
        setRank(s_vm, s_selectedRank);
        return;
      }
    }
  }

  // 2. Linhas gerais de opções (0 a 5)
  for (const auto& hb : s_hitboxes) {
    if (x >= hb.rect.x && x <= hb.rect.x + hb.rect.w &&
        y >= hb.rect.y && y <= hb.rect.y + hb.rect.h) {
      switch (hb.action) {
        case 0:
          s_selectedItem = 0;
          toggleGodMode();
          return;
        case 1:
          s_selectedItem = 1;
          toggleInfiniteSp();
          return;
        case 2:
          s_selectedItem = 2;
          toggleZeroCooldown();
          return;
        case 3:
          s_selectedItem = 3;
          addMoney(s_vm, 100000);
          return;
        case 4:
          // Toque em qualquer ponto da linha de patente: avança para a próxima patente
          s_selectedItem = 4;
          s_selectedRank = (s_selectedRank + 1) % 15;
          setRank(s_vm, s_selectedRank);
          return;
        case 5:
          s_selectedItem = 5;
          closeModal();
          return;
      }
    }
  }
}

// Renderização gráfica nobre da Janela Modal de Cheats (Tema Soltia / Frozen Sea)
void Cheats::drawModal(SDL_Renderer* renderer, int winW, int winH) {
  if (!s_modalActive || !renderer) return;

  SDL_SetRenderDrawBlendMode(renderer, SDL_BLENDMODE_BLEND);

  // 1. Escurecimento translúcido do fundo (Backdrop)
  SDL_Rect fullScreen = { 0, 0, winW, winH };
  SDL_SetRenderDrawColor(renderer, 0, 0, 0, 215);
  SDL_RenderFillRect(renderer, &fullScreen);

  // 2. Parâmetros de Dispositivo e Escala Proporcional Harmônica
  float refDim = (float)std::min(winW, winH);
  float scaleFactor = std::clamp(refDim / 720.0f, 0.85f, 1.25f);

  int modalW = std::clamp((int)(590.0f * scaleFactor), 470, (int)(winW * 0.94f));
  int modalH = std::min((int)(460.0f * scaleFactor), (int)(winH * 0.92f));
  int modalX = (winW - modalW) / 2;
  int modalY = (winH - modalH) / 2;

  s_hitboxes.clear();

  // 3. Fundo Principal da Janela Modal
  SDL_Rect boxRect = { modalX, modalY, modalW, modalH };
  SDL_SetRenderDrawColor(renderer, 15, 22, 34, 252); // Azul ardósia profundo
  SDL_RenderFillRect(renderer, &boxRect);

  // Borda Externa Ciano Metálico
  SDL_SetRenderDrawColor(renderer, 58, 120, 185, 255);
  SDL_RenderDrawRect(renderer, &boxRect);
  SDL_Rect borderInner = { modalX + 1, modalY + 1, modalW - 2, modalH - 2 };
  SDL_SetRenderDrawColor(renderer, 28, 55, 90, 255);
  SDL_RenderDrawRect(renderer, &borderInner);

  // 4. Cabeçalho Nobre
  int headerH = (int)(48.0f * scaleFactor);
  SDL_Rect headerRect = { modalX + 2, modalY + 2, modalW - 4, headerH };
  SDL_SetRenderDrawColor(renderer, 22, 36, 56, 255);
  SDL_RenderFillRect(renderer, &headerRect);

  SDL_SetRenderDrawColor(renderer, 65, 140, 210, 200);
  SDL_RenderDrawLine(renderer, modalX + 2, modalY + headerH + 2, modalX + modalW - 3, modalY + headerH + 2);

  bool isPt = (Platform::getCurrentLanguage() == "pt" || Platform::getCurrentLanguage() == "pt_br");
  std::string titleStr = isPt ? "MENU DE CHEATS" : "CHEAT MENU";
  int titleFontSize = (int)(20.0f * scaleFactor);
  int titleW = Platform::getTextWidth(titleStr, titleFontSize, 0);
  Platform::drawTextColored(renderer, titleStr, modalX + (modalW - titleW) / 2, modalY + (int)(8.0f * scaleFactor), titleFontSize, 255, 230, 130, 255);

  std::string subTitleStr = isPt ? "MODO DESENVOLVEDOR / TRAPACAS" : "DEVELOPER / CHEAT MODE";
  int subFontSize = (int)(11.0f * scaleFactor);
  int subW = Platform::getTextWidth(subTitleStr, subFontSize, 0);
  Platform::drawTextColored(renderer, subTitleStr, modalX + (modalW - subW) / 2, modalY + (int)(30.0f * scaleFactor), subFontSize, 120, 190, 255, 220);

  // Botão Fechar [ X ] no cabeçalho (Hitbox ampliada para toque)
  int closeSize = (int)(28.0f * scaleFactor);
  SDL_Rect closeRect = { modalX + modalW - closeSize - (int)(12.0f * scaleFactor), modalY + (headerH - closeSize) / 2 + 1, closeSize, closeSize };
  SDL_SetRenderDrawColor(renderer, 35, 50, 75, 220);
  SDL_RenderFillRect(renderer, &closeRect);
  SDL_SetRenderDrawColor(renderer, 90, 140, 190, 255);
  SDL_RenderDrawRect(renderer, &closeRect);
  Platform::drawTextColored(renderer, "X", closeRect.x + (int)(9.0f * scaleFactor), closeRect.y + (int)(5.0f * scaleFactor), (int)(16.0f * scaleFactor), 255, 255, 255, 240);
  
  SDL_Rect closeTouchRect = { closeRect.x - (int)(10.0f * scaleFactor), modalY, closeRect.w + (int)(20.0f * scaleFactor), headerH + 4 };
  s_hitboxes.push_back({ closeTouchRect, 20 });

  // 5. Linhas de Opções (6 itens: 0..5)
  int startY = modalY + headerH + (int)(8.0f * scaleFactor);
  int availH = modalH - headerH - (int)(56.0f * scaleFactor);
  int rowH = std::clamp(availH / 6 - (int)(5.0f * scaleFactor), 34, (int)(44.0f * scaleFactor));
  int rowGap = (int)(5.0f * scaleFactor);
  int padX = (int)(16.0f * scaleFactor);
  int rowW = modalW - padX * 2;
  int itemFontSize = (int)(15.0f * scaleFactor);
  int valueFontSize = (int)(14.0f * scaleFactor);

  // Âncora direita alinhada com precisão absoluta para todas as opções
  int rightAnchor = modalX + padX + rowW - (int)(14.0f * scaleFactor);

  for (int i = 0; i < 6; ++i) {
    int curY = startY + i * (rowH + rowGap);
    bool isSel = (s_selectedItem == i);

    SDL_Rect rRect = { modalX + padX, curY, rowW, rowH };
    s_hitboxes.push_back({ rRect, i });

    // Fundo da Linha
    if (isSel) {
      SDL_SetRenderDrawColor(renderer, 30, 60, 95, 240); // Destaque azul brilhante
      SDL_RenderFillRect(renderer, &rRect);
      SDL_SetRenderDrawColor(renderer, 100, 190, 255, 255); // Borda acesa
      SDL_RenderDrawRect(renderer, &rRect);
    } else {
      SDL_SetRenderDrawColor(renderer, 18, 28, 42, 200); // Cartão escuro elegante
      SDL_RenderFillRect(renderer, &rRect);
      SDL_SetRenderDrawColor(renderer, 38, 55, 80, 200);
      SDL_RenderDrawRect(renderer, &rRect);
    }

    // Cursor Indicador [ > ]
    int textX = modalX + padX + (int)(12.0f * scaleFactor);
    int textY = curY + (rowH - itemFontSize) / 2;

    if (isSel) {
      Platform::drawTextColored(renderer, ">", textX, textY, itemFontSize, 255, 220, 80, 255);
      textX += (int)(16.0f * scaleFactor);
    }

    // Título do Item
    std::string itemTitle = "";
    switch (i) {
      case 0: itemTitle = isPt ? "Modo Deus (HP Infinito)" : "God Mode (Infinite HP)"; break;
      case 1: itemTitle = isPt ? "SP Infinito (Mana Ilimitada)" : "Infinite SP (Unlimited Mana)"; break;
      case 2: itemTitle = isPt ? "Zero Cooldown (Sem Recarga)" : "Zero Cooldown (Instant Skills)"; break;
      case 3: itemTitle = isPt ? "Adicionar Ouro (+100.000 G)" : "Add Gold (+100,000 G)"; break;
      case 4: itemTitle = isPt ? "Patente / Rank de Honra" : "Honor Rank / Title"; break;
      case 5: itemTitle = isPt ? "Fechar / Retornar ao Jogo" : "Close / Return to Game"; break;
    }

    uint8_t tr = isSel ? 255 : 210;
    uint8_t tg = isSel ? 255 : 220;
    uint8_t tb = isSel ? 255 : 230;
    Platform::drawTextColored(renderer, itemTitle, textX, textY, itemFontSize, tr, tg, tb, 255);

    // Valor / Tag à Direita (Perfeitamente alinhada na margem direita)
    int valY = curY + (rowH - valueFontSize) / 2;

    if (i == 0) { // God Mode Tag
      std::string valStr = s_godMode ? (isPt ? "[ ATIVADO ]" : "[ ENABLED ]") : (isPt ? "[ DESATIVADO ]" : "[ DISABLED ]");
      int valW = Platform::getTextWidth(valStr, valueFontSize, 0);
      int valX = rightAnchor - valW;
      if (s_godMode) {
        Platform::drawTextColored(renderer, valStr, valX, valY, valueFontSize, 80, 240, 130, 255);
      } else {
        Platform::drawTextColored(renderer, valStr, valX, valY, valueFontSize, 140, 150, 165, 230);
      }
    } else if (i == 1) { // Infinite SP Tag
      std::string valStr = s_infiniteSp ? (isPt ? "[ ATIVADO ]" : "[ ENABLED ]") : (isPt ? "[ DESATIVADO ]" : "[ DISABLED ]");
      int valW = Platform::getTextWidth(valStr, valueFontSize, 0);
      int valX = rightAnchor - valW;
      if (s_infiniteSp) {
        Platform::drawTextColored(renderer, valStr, valX, valY, valueFontSize, 80, 240, 130, 255);
      } else {
        Platform::drawTextColored(renderer, valStr, valX, valY, valueFontSize, 140, 150, 165, 230);
      }
    } else if (i == 2) { // Zero Cooldown Tag
      std::string valStr = s_zeroCooldown ? (isPt ? "[ ATIVADO ]" : "[ ENABLED ]") : (isPt ? "[ DESATIVADO ]" : "[ DISABLED ]");
      int valW = Platform::getTextWidth(valStr, valueFontSize, 0);
      int valX = rightAnchor - valW;
      if (s_zeroCooldown) {
        Platform::drawTextColored(renderer, valStr, valX, valY, valueFontSize, 80, 240, 130, 255);
      } else {
        Platform::drawTextColored(renderer, valStr, valX, valY, valueFontSize, 140, 150, 165, 230);
      }
    } else if (i == 3) { // Add Gold Tag
      std::string valStr = isPt ? "[ EXECUTAR ]" : "[ EXECUTE ]";
      int valW = Platform::getTextWidth(valStr, valueFontSize, 0);
      int valX = rightAnchor - valW;
      Platform::drawTextColored(renderer, valStr, valX, valY, valueFontSize, 255, 215, 60, 255);
    } else if (i == 4) { // Rank Selector com Botões Touch Dedicados e Caixa Central
      std::string rName = getRankName(s_selectedRank, isPt);
      
      int btnW = (int)(30.0f * scaleFactor);
      int btnH = (int)(26.0f * scaleFactor);
      int btnY = curY + (rowH - btnH) / 2;
      
      int gap = (int)(6.0f * scaleFactor);
      int rankBoxW = (int)(180.0f * scaleFactor);
      int rankBoxH = btnH;
      int rankBoxY = btnY;

      // Alinhamento exato terminando em rightAnchor
      int btnRightX = rightAnchor - btnW;
      int rankBoxX = btnRightX - gap - rankBoxW;
      int btnLeftX = rankBoxX - gap - btnW;

      // 1. Botão Esquerdo [ < ] (Touch Action 10)
      SDL_Rect btnLeftRect = { btnLeftX, btnY, btnW, btnH };
      SDL_SetRenderDrawColor(renderer, 28, 48, 76, 230);
      SDL_RenderFillRect(renderer, &btnLeftRect);
      SDL_SetRenderDrawColor(renderer, 70, 140, 210, 255);
      SDL_RenderDrawRect(renderer, &btnLeftRect);
      int arrowLeftW = Platform::getTextWidth("<", valueFontSize, 0);
      Platform::drawTextColored(renderer, "<", btnLeftX + (btnW - arrowLeftW) / 2, valY, valueFontSize, 255, 255, 255, 255);

      // Hitbox touch generosa para o botão esquerdo (ideal para celular)
      SDL_Rect touchLeftRect = { btnLeftX - (int)(8.0f * scaleFactor), curY, btnW + (int)(12.0f * scaleFactor), rowH };
      s_hitboxes.push_back({ touchLeftRect, 10 });

      // 2. Caixa Central com o Nome da Patente
      SDL_Rect rankBoxRect = { rankBoxX, rankBoxY, rankBoxW, rankBoxH };
      SDL_SetRenderDrawColor(renderer, 14, 24, 38, 220);
      SDL_RenderFillRect(renderer, &rankBoxRect);
      SDL_SetRenderDrawColor(renderer, 48, 76, 110, 200);
      SDL_RenderDrawRect(renderer, &rankBoxRect);
      
      int nameW = Platform::getTextWidth(rName, valueFontSize, 0);
      int nameX = rankBoxX + (rankBoxW - nameW) / 2;
      Platform::drawTextColored(renderer, rName, nameX, valY, valueFontSize, 120, 215, 255, 255);

      // Hitbox da caixinha da patente (Action 4)
      SDL_Rect touchBoxRect = { rankBoxX, curY, rankBoxW, rowH };
      s_hitboxes.push_back({ touchBoxRect, 4 });

      // 3. Botão Direito [ > ] (Touch Action 11)
      SDL_Rect btnRightRect = { btnRightX, btnY, btnW, btnH };
      SDL_SetRenderDrawColor(renderer, 28, 48, 76, 230);
      SDL_RenderFillRect(renderer, &btnRightRect);
      SDL_SetRenderDrawColor(renderer, 70, 140, 210, 255);
      SDL_RenderDrawRect(renderer, &btnRightRect);
      int arrowRightW = Platform::getTextWidth(">", valueFontSize, 0);
      Platform::drawTextColored(renderer, ">", btnRightX + (btnW - arrowRightW) / 2, valY, valueFontSize, 255, 255, 255, 255);

      // Hitbox touch generosa para o botão direito (ideal para celular)
      SDL_Rect touchRightRect = { btnRightX - (int)(4.0f * scaleFactor), curY, btnW + (int)(14.0f * scaleFactor), rowH };
      s_hitboxes.push_back({ touchRightRect, 11 });

    } else if (i == 5) { // Fechar Tag
      std::string valStr = isPt ? "[ SAIR ]" : "[ EXIT ]";
      int valW = Platform::getTextWidth(valStr, valueFontSize, 0);
      int valX = rightAnchor - valW;
      Platform::drawTextColored(renderer, valStr, valX, valY, valueFontSize, 220, 220, 220, 220);
    }
  }

  // 6. Mensagem de Feedback Temporária
  if (!s_feedbackMsg.empty() && SDL_GetTicks() < s_feedbackTimer) {
    int fbFontSize = (int)(13.0f * scaleFactor);
    int fbW = Platform::getTextWidth(s_feedbackMsg, fbFontSize, 0);
    int fbY = modalY + modalH - (int)(50.0f * scaleFactor);

    SDL_Rect fbRect = { modalX + padX, fbY - (int)(3.0f * scaleFactor), rowW, (int)(24.0f * scaleFactor) };
    SDL_SetRenderDrawColor(renderer, 24, 42, 64, 230);
    SDL_RenderFillRect(renderer, &fbRect);
    SDL_SetRenderDrawColor(renderer, 80, 160, 230, 255);
    SDL_RenderDrawRect(renderer, &fbRect);

    Platform::drawTextColored(renderer, s_feedbackMsg, modalX + (modalW - fbW) / 2, fbY, fbFontSize, 255, 230, 100, 255);
  }

  // 7. Rodapé com Instruções de Controle
  int footerFontSize = (int)(12.0f * scaleFactor);
  std::string footerStr = isPt ? "[ Toque / 5 / A ] Selecionar/Alterar    [ 7 / B ] Voltar" : "[ Touch / 5 / A ] Select/Toggle    [ 7 / B ] Back";
  int footerW = Platform::getTextWidth(footerStr, footerFontSize, 0);
  int footerY = modalY + modalH - (int)(20.0f * scaleFactor);
  Platform::drawTextColored(renderer, footerStr, modalX + (modalW - footerW) / 2, footerY, footerFontSize, 150, 175, 205, 220);
}

} // namespace hl
