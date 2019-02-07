cmake_minimum_required(VERSION 3.13)
project(peoject C)

set(CMAKE_C_STANDARD 99)
set(CMAKE_C_FLAGS "-fexec-charset=CP949")

add_executable(peoject main.c)