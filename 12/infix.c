#include "infix.h"
#include "Common.h"
#include "OStack.h"

struct _Infix {
    char *_infixExpression; // AppController 에서 보내준다
    char _postfixExpression[DEFAULT_MAX_NUMBER_OF_TOKENS];
// postfix로 변환된 결과는 이곳에 저장된다.
    OStack *_operatorStack;
};

void Infix_showTokenAndOStack(Infix *pInfix, char token);

int Infix_inStackPrecedence(Element element);

int Infix_inComingPrecedence(char aToken) {
// 각 연산자의 입력 토큰 상태의 우선 순위를 돌려준다
    if (aToken == '(') {
        return 20;
    } else if (aToken == ')') {
        return 19;
    } else if (aToken == '^') {
        return 17;
    } else if (aToken == '*') {
        return 13;
    } else if (aToken == '/') {
        return 13;
    } else if (aToken == '%') {
        return 13;
    } else if (aToken == '+') {
        return 12;
    } else if (aToken == '-') {
        return 12;
    } else if (aToken == '$') {
        return 0;
    } else {
        return -1;
    }
}

Boolean Infix_toPostfix(Infix *_this) {
    int i = 0;
    int p = 0;
    char currentToken = 0, poppedToken = 0;
    int infixSize = strlen(_this->_infixExpression);
    _this->_operatorStack = OStack_new(infixSize);
    while (i < infixSize) {
        currentToken = _this->_infixExpression[i++];
        if (isDigit(currentToken)) { // operand
            _this->_postfixExpression[p++] = currentToken;
        } else { // operator
            if (currentToken == ')') {
                if (OStack_isEmpty(_this->_operatorStack)) {
                    return FALSE; // 수식 오류
                } else {
                    poppedToken = OStack_pop(_this->_operatorStack);
                    while (poppedToken != '(') {
                        _this->_postfixExpression[p++] = poppedToken;
                        if (OStack_isEmpty(_this->_operatorStack)) {
                            return FALSE; // 수식 오류
                        } else {
                            poppedToken = OStack_pop(_this->_operatorStack);
                        }
                    }
                    Infix_showTokenAndOStack(_this, currentToken);
                }
            } else {
                int inComingPrecedence = Infix_inComingPrecedence(currentToken);
                while (!OStack_isEmpty(_this->_operatorStack) &&
                       Infix_inStackPrecedence(OStack_topElement(_this->_operatorStack)) >= inComingPrecedence) {
                    poppedToken = OStack_pop(_this->_operatorStack);
                    _this->_postfixExpression[p++] = poppedToken;
                }
                OStack_push(_this->_operatorStack, currentToken);
                Infix_showTokenAndOStack(_this, currentToken);
            }
        }

        while (!OStack_isEmpty(_this->_operatorStack)) {
            poppedToken = OStack_pop(_this->_operatorStack);
            _this->_postfixExpression[p++] = poppedToken;
        }
        return TRUE;

    }
}

Infix *Infix_new() {
    //todo return NULL;
}

void Infix_delete(Infix *_this) {
//todo
}

void Infix_setExpression(Infix *_this, char *newExpression) {
//todo
}

char *Infix_postfix(Infix *_this) {
    return NULL; //todo
}

int Infix_inStackPrecedence(Element element) {
    return 0; //todo
}

void Infix_showTokenAndOStack(Infix *pInfix, char token) {
//todo
}

