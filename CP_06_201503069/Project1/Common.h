#pragma once
#include<stdlib.h>
typedef enum { FALSE, TRUE } Boolean;
#define NewVector(TYPE, SIZE) (TYPE*)malloc(sizeof(TYPE)*SIZE)
#define NewObject(TYPE) (TYPE*)malloc(sizeof(TYPE))
#define SWAP(TYPE, X, Y) {TYPE temp = X; X=Y; Y=temp;}
