#pragma once
#include <stdlib.h>
typedef enum {FALSE, TRUE} Boolean;
#define NewObject(TYPE) (TYPE*)malloc(sizeof(TYPE))
#define NewVector(TYPE, SIZE) (TYPE*)MALLOC(SIZEOF(TYPE)*SIZE)
