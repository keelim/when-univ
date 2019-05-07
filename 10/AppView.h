#pragma once
#include "Common.h"
#include <stdio.h>

#define ErrorMsg_ExpressionTooLong "[오류] 수식이 너무 길어 처리가 불가능합니다."
#define ErrorMsg_OperandsTooMany "[오류] 연산자에 비해 연산값의 수가 많습니다."
#define ErrorMsg_OperandsTooFew "[오류] 연산자에 비해 연산값의 수가 적습니다."
#define ErrorMsg_UndefinedOperator "[오류] 수식에 알 수 없는 연산자가 있습니다."
#define ErrorMsg_DivideByZero "[오류] 나눗셈의 분모가 0 입니다."

void AppView_out_postfixEvaluationErrorMessage(PostfixError aPostfixError);

void AppView_out_startingMessage();

Boolean AppView_in_postfixExpression();

void AppView_out_errorInExpression();

void AppView_out_evaluatedValue(int value);

void AppView_out_endingMessage();

void AppView_out_message(char *s);