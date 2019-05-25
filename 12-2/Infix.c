#pragma once

#include "Infix.h"

struct _Infix {
    char *_infixExpression; // AppController 에서 보내준다
    char _postfixExpression[DEFAULT_MAX_NUMBER_OF_TOKENS];
// postfix로 변환된 결과는 이곳에 저장된다.
    OStack *_operatorStack;

};

int Infix_inComingPrecedence(char aToken);

int Infix_inStackPrecedence(char aToken);

void Infix_showTokenAndOStack(Infix *_this, char currentToken);

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
                        if (OStack_isEmpty(_this->_operatorStack))
                            return FALSE; // 수식 오류
                        else {
                            poppedToken = OStack_pop(_this->_operatorStack);
                        }
                    }
                }
                Infix_showTokenAndOStack(_this, currentToken);
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
    }

    while (!OStack_isEmpty(_this->_operatorStack)) {
        poppedToken = OStack_pop(_this->_operatorStack);
        _this->_postfixExpression[p++] = poppedToken;
    }
    return TRUE;
}


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

int Infix_inStackPrecedence(char aToken) {
// 각 연산자의 스택 안에서의 우선 순위를 돌려준다.
    if (aToken == '^') {
        return 16;
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

void Infix_showTokenAndOStack(Infix *_this, char currentToken) { //스택에 있는 것들을 확인한다.
    int i;
    AppView_out_Token(currentToken);
    AppView_out_Message("<Bottom> ");
    for (i = 0; i < OStack_size(_this->_operatorStack); i++) {
        AppView_out_Elemenet(OStack_elementAt(_this->_operatorStack, i));
    }
    AppView_out_Message(" <Top>\n");
}





