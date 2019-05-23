cmake_minimum_required(VERSION 3.14)
project(cp12 C)

set(CMAKE_C_STANDARD 99)

add_executable(cp12 Node.c Node.h Common.h Stack.c Stack.h Postfix.c Postfix.h AppView.h AppView.c AppController.h AppController.c OStack.c OStack.h VStack.c VStack.h infix.c infix.h main.c)