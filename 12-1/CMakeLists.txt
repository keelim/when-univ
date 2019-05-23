cmake_minimum_required(VERSION 3.14)
project(12_1 C)

set(CMAKE_C_STANDARD 11)

include_directories(.)

add_executable(12_1
        AppController.c
        AppController.h
        AppView.c
        AppView.h
        Common.h
        main.c
        Node.c
        Node.h
        Postfix.c
        Postfix.h
        Stack.c
        Stack.h)
