﻿#pragma once
#include<stdlib.h>
typedef enum {
	FALSE, TRUE
} Boolean; //enum no double import
#define END_OF_RUN -1
#define MAX_ORDER 99
#define NewObject(TYPE) (TYPE*)malloc(sizeof(TYPE)) //중요


