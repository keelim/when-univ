#pragma once
#include <stdlib.h>

typedef enum {
    FALSE, TRUE
} Boolean;

typedef int Element;

#define NewObject(TYPE) (TYPE*)malloc(sizeof(TYPE))
#define NewVector(TYPE, SIZE) (TYPE*)malloc(sizeof(TYPE)*SIZE)