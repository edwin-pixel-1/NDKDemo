cmake_minimum_required(VERSION 3.4.1)

add_library(
        native-lib-gl
        SHARED
        src/main/cpp/native-lib-gl.cpp)

find_library(
        log-lib
        log)

target_link_libraries(
        native-lib-gl
        ${log-lib})