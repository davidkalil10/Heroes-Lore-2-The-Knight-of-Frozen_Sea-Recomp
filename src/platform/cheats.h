// cheats.h — Sistema de Menu Secreto de Trapaças (God Mode, SP Infinito, Ouro e Ranking de Honra)
#pragma once
#include <string>
#include <vector>
#include <cstdint>

#if defined(__has_include)
  #if __has_include(<SDL2/SDL.h>)
    #include <SDL2/SDL.h>
  #else
    #include <SDL.h>
  #endif
#else
  #include <SDL.h>
#endif

namespace hl {

struct VM;

class Cheats {
public:
  static void init();
  static void update(VM* vm);

  // Controle de exibição do Modal
  static bool isModalActive();
  static void openModal(VM* vm = nullptr);
  static void closeModal();

  // Tratamento de Entradas (Teclado, Gamepad, Touch)
  static bool handleInput(int key, VM* vm = nullptr);
  static void handleClick(int x, int y, VM* vm = nullptr);

  // Renderização sobre o Renderer SDL2
  static void drawModal(SDL_Renderer* renderer, int winW, int winH);

  // Getters e Toggles dos Cheats
  static bool isGodMode();
  static void setGodMode(bool enable);
  static void toggleGodMode();

  static bool isInfiniteSp();
  static void setInfiniteSp(bool enable);
  static void toggleInfiniteSp();

  static void addMoney(VM* vm, int amount = 100000);
  static void setRank(VM* vm, int rankIndex);
  static int getSelectedRank();
  static const char* getRankName(int rankIndex, bool isPt = true);
};

} // namespace hl
