cmake_minimum_required(VERSION 3.13)
project(Listperformance1)

set(CMAKE_CXX_STANDARD 14)

add_executable(Listperformance1 main.c AppController.c AppController.h Common.h Timer.c Timer.h Messages.c Messages.h UnSortedArrayList.c UnSortedArrayList.h)