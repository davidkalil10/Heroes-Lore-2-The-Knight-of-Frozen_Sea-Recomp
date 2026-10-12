cmake_minimum_required(VERSION 3.16)
project(heroes_lore_2 LANGUAGES C CXX)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

if(MSVC)
    add_compile_options(/W3 /O2)
else()
    add_compile_options(-Wall -Wextra -Wno-unused-parameter -O3)
endif()

find_package(SDL2 REQUIRED)
find_package(SDL2_mixer QUIET)
if (NOT SDL2_mixer_FOUND)
    find_package(PkgConfig REQUIRED)
    pkg_check_modules(SDL2_MIXER REQUIRED IMPORTED_TARGET SDL2_mixer)
endif()

file(GLOB_RECURSE SRC_FILES
    src/*.cpp
    src/*.h
)

add_executable(heroes_lore_2 ${SRC_FILES})

target_include_directories(heroes_lore_2 PRIVATE
    ${CMAKE_CURRENT_SOURCE_DIR}/src
    ${CMAKE_CURRENT_SOURCE_DIR}/third_party
    ${SDL2_INCLUDE_DIRS}
    ${SDL2_MIXER_INCLUDE_DIRS}
)

if (TARGET SDL2::SDL2main)
    target_link_libraries(heroes_lore_2 PRIVATE SDL2::SDL2main)
endif()

if (TARGET SDL2::SDL2)
    target_link_libraries(heroes_lore_2 PRIVATE SDL2::SDL2)
else()
    target_link_libraries(heroes_lore_2 PRIVATE ${SDL2_LIBRARIES})
endif()

if (TARGET SDL2_mixer::SDL2_mixer)
    target_link_libraries(heroes_lore_2 PRIVATE SDL2_mixer::SDL2_mixer)
elseif (TARGET PkgConfig::SDL2_MIXER)
    target_link_libraries(heroes_lore_2 PRIVATE PkgConfig::SDL2_MIXER)
else()
    target_link_libraries(heroes_lore_2 PRIVATE ${SDL2_MIXER_LIBRARIES})
endif()

if(WIN32)
    target_link_libraries(heroes_lore_2 PRIVATE winhttp)
elseif(UNIX AND NOT ANDROID AND NOT APPLE)
    find_package(CURL REQUIRED)
    target_link_libraries(heroes_lore_2 PRIVATE CURL::libcurl)
endif()

# Cópia automática das DLLs necessárias para execução nativa no Windows
if (WIN32)
    set(RUNTIME_DLLS
        SDL2.dll
        SDL2_mixer.dll
        libgcc_s_seh-1.dll
        libstdc++-6.dll
        libwinpthread-1.dll
        libFLAC.dll
        libmpg123-0.dll
        libopusfile-0.dll
        libvorbisfile-3.dll
        libwavpack-1.dll
        libxmp.dll
        libogg-0.dll
        libopus-0.dll
        libvorbis-0.dll
    )
    foreach(dll ${RUNTIME_DLLS})
        find_file(DLL_PATH_${dll} NAMES ${dll}
            PATHS
                "$ENV{MINGW_PREFIX}/bin"
                "$ENV{MSYSTEM_PREFIX}/bin"
                "C:/msys64/ucrt64/bin"
                "C:/msys64/mingw64/bin"
        )
        if (DLL_PATH_${dll})
            add_custom_command(TARGET heroes_lore_2 POST_BUILD
                COMMAND ${CMAKE_COMMAND} -E copy_if_different "${DLL_PATH_${dll}}" "$<TARGET_FILE_DIR:heroes_lore_2>"
            )
        endif()
    endforeach()
endif()

# Cópia automática de assets para permitir execução standalone por duplo clique
add_custom_command(TARGET heroes_lore_2 POST_BUILD
    COMMAND ${CMAKE_COMMAND} -E copy_directory
        "${CMAKE_CURRENT_SOURCE_DIR}/reference/extracted"
        "$<TARGET_FILE_DIR:heroes_lore_2>/assets"
    COMMAND ${CMAKE_COMMAND} -E copy_directory
        "${CMAKE_CURRENT_SOURCE_DIR}/assets"
        "$<TARGET_FILE_DIR:heroes_lore_2>/assets"
)
