cmake_minimum_required(VERSION 3.13)
project(lListperformance)

set(CMAKE_CXX_STANDARD 14)

add_executable(lListperformance main.c AppController.c AppController.h Common.h Timer.c Timer.h Messages.c Messages.h UnSortedArrayList.c UnSortedArrayList.h ParameterSet.c ParameterSet.h SortedArrayList.c SortedArrayList.h)