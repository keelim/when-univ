#pragma once
typedef enum {FALSE, TRUE} Boolean; //Boolean 정의

#include <math.h> 
#define MAXFLOAT 1.0E+100 //MACRO 정의
#define EPSILON 1.0E-6
#define FloatValueIsZero(NUMBER) (fabsf(NUMBER) <EPSILON)

typedef struct { //Solution struct 정의
	float _root1;
	float _root2;

} Solution;

typedef struct { //QuadEquaiton struct 정의
	float _c0;
	float _c1;
	float _c2;

} QuadEquation;