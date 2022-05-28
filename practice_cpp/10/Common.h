#pragma once
#include <stdlib.h>

typedef enum {
	FALSE, TRUE
} Boolean;

#define NewObject(TYPE) (TYPE*)malloc(sizeof(TYPE))
#define NewVector(TYPE, SIZE) (TYPE*)malloc(sizeof(TYPE) * SIZE)

typedef enum {
	PostfixError_None,
	PostfixError_ExpressionTooLong,
	PostfixError_OperandsTooMany,
	PostfixError_OperandsTooFew,
	PostfixError_UnknownOperator,
	PostfixError_DivideByZero
} PostfixError;
