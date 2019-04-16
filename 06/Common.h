#pragma once
#include<stdlib.h>
#include<stdio.h>
typedef enum { FALSE, TRUE } Boolean;
//동적 할당
#define NewVector(TYPE, SIZE) (TYPE*)malloc(sizeof(TYPE)*SIZE)
#define NewObject(TYPE) (TYPE*)malloc(sizeof(TYPE))
//swap
#define SWAP(TYPE, X, Y) {TYPE temp = X; X=Y; Y=temp;} 
