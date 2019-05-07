#pragma once
#include "Postfix.h"

struct _Postfix {
    int _maxNumberOfTokens;
    char *_expression;
    int _evaluatedValue;
    Stack *_operandStack;
};

Postfix *Postfix_new(int givenMaxNumberOfTokens) {
    Postfix *_this = NewObject(Postfix);
    _this->_maxNumberOfTokens = givenMaxNumberOfTokens;
    _this->_expression = NewVector(char, givenMaxNumberOfTokens);
    _this->_operandStack = Stack_new(givenMaxNumberOfTokens);
    return _this;
}

void Postfix_delete(Postfix *_this) {
    Stack_delete(_this->_operandStack);
    free(_this->_expression);
    free(_this);

}

void Postfix_setExpression(Postfix *_this, char *anExpression) {
    strcpy(_this->_expression, anExpression);
}

void Postfix_showTokenAndStack(Postfix *_this, char currentToken) { //todo 채워야 하는 곳이다.
//AppView.outputDebugMessage(" : " + operator + "OperatorStack <Bottom> ");
//for (int i = 0; i < this.operatorStack().size(); i++) { //반복을 통하여 연산자 스택 확인
//AppView.outputDebugMessage(
//((ArrayList<Character>) this.operatorStack()).elementAt(i) + " ");
//}
//AppView.outputLineDebugMessage("<Top>");
}

Boolean Postfix_evaluate(Postfix *_this) {
    int operand, operand1, operand2, calculated;
    char currentToken;
    int i = 0;
    Stack_reset(_this->_operandStack);
    while (_this->_expression[i] != '\0') {
        currentToken = _this->_expression[i];
        if (currentToken >= '0' && currentToken <= '9') {
// token is an operand. Push it into stack
            operand = (currentToken - '0');
            if (Stack_isFull(_this->_operandStack)) {
                return PostfixError_ExpressionTooLong; //[오류] 수식이 너무 길어 처리가 불가능 합니다.
            } else {
                Stack_push(_this->_operandStack, operand);
            }
        } else { // The token is an operator
            if (currentToken == '+') {
                if (Stack_size(_this->_operandStack) >= 2) {
                    operand2 = Stack_pop(_this->_operandStack);
                    operand1 = Stack_pop(_this->_operandStack);
                    calculated = operand1 + operand2;
                    Stack_push(_this->_operandStack, calculated);
                } else {
                    PostfixError_OperandsTooFew;//[오류] 연산자에 비해 연산값의 수가 적습니다.
                }
            } else if (currentToken == '-') {
                if (Stack_size(_this->_operandStack) >= 2) {
                    operand2 = Stack_pop(_this->_operandStack);
                    operand1 = Stack_pop(_this->_operandStack);
                    calculated = operand1 - operand2;
                    Stack_push(_this->_operandStack, calculated);

                } else {
                    PostfixError_OperandsTooFew;//[오류] 연산자에 비해 연산값의 수가 적습니다.
                }
            } else if (currentToken == '*') {
                if (Stack_size(_this->_operandStack) >= 2) {
                    operand2 = Stack_pop(_this->_operandStack);
                    operand1 = Stack_pop(_this->_operandStack);
                    calculated = operand1 * operand2;
                    Stack_push(_this->_operandStack, calculated);
                } else {
                    PostfixError_OperandsTooFew;//[오류] 연산자에 비해 연산값의 수가 적습니다.
                }

            } else if (currentToken == '/') {
                if (Stack_size(_this->_operandStack) >= 2) {
                    operand2 = Stack_pop(_this->_operandStack);
                    operand1 = Stack_pop(_this->_operandStack);
                    if (operand2 == 0) {
                        return PostfixError_DivideByZero;
                    }
                    calculated = operand1 / operand2;
                    Stack_push(_this->_operandStack, calculated);

                } else {
                    PostfixError_OperandsTooFew;//[오류] 연산자에 비해 연산값의 수가 적습니다.
                }
            } else if (currentToken == '%') {
                if (Stack_size(_this->_operandStack) >= 2) {
                    operand2 = Stack_pop(_this->_operandStack);
                    operand1 = Stack_pop(_this->_operandStack);
                    if (operand2 == 0) {
                        return PostfixError_DivideByZero;
                    }
                    calculated = operand1 % operand2;
                    Stack_push(_this->_operandStack, calculated);

                } else {
                    PostfixError_OperandsTooFew;//[오류] 연산자에 비해 연산값의 수가 적습니다.
                }
            } else {
                return PostfixError_UnknownOperator;//[오류] 수식에 알 수 없는 연산자가 있습니다.
            }
        }
        Postfix_showTokenAndStack(_this, currentToken); // 여기에 출력이 있는 이유는? //그러게여
        i++;
    } // end of while
// At this point, the result is on top of stack

    if (Stack_size(_this->_operandStack) == 1) {
        _this->_evaluatedValue = Stack_pop(_this->_operandStack);
    } else if (Stack_size(_this->_operandStack) > 1) {
        return PostfixError_OperandsTooMany;//[오류] 연산자에 비해 연산값의 수가 많습니다.
    }
    return TRUE;
}

int Postfix_evaluatedValue(Postfix *_this) {
    return (_this->_evaluatedValue);
}
