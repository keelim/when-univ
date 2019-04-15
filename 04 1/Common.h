#pragma once
typedef enum{FALSE, TRUE} Boolean;
#define EPSILON 0.000001
#define FloatValueIsZero(NUMBER) (fabsf(NUMBER)<EPSILON)