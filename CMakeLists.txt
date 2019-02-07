cmake_minimum_required(VERSION 3.13)
project(EndFamily)

set(CMAKE_CXX_STANDARD 14)

include_directories(.)
include_directories(app)

add_executable(EndFamily
        app/src/main/cpp/native-lib.cpp)
