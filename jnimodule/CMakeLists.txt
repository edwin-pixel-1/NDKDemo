cmake_minimum_required(VERSION 3.4.1)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11 -Wall")

add_library(
        opengl-triangle
        SHARED
        src/main/cpp/opengl-triangle.cpp)

add_library(
        native-lib-gl
        SHARED
        src/main/cpp/native-lib-gl.cpp)

find_library(
        log-lib
        log)

target_link_libraries(
        opengl-triangle
        android
        EGL
        GLESv2
        ${log-lib})

target_link_libraries(
        native-lib-gl
        ${log-lib})