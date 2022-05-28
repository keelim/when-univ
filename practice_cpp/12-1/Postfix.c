#pragma once

#include "Postfix.h"

struct _Postfix { //struct 정의
	int _maxNumberOfTokens;
	char* _expression;
	int _evaluatedValue;
	Stack* _operandStack;
};


Postfix* Postfix_new (int givenMaxNumberOfTokens) { //생성
	Postfix* _this=NewObject (Postfix);
	_this->_maxNumberOfTokens=givenMaxNumberOfTokens;
	_this->_expression=NewVector (char, givenMaxNumberOfTokens);
	_this->_operandStack=Stack_new ();
	return _this;
}

void Postfix_delete (Postfix* _this) {//소멸
	Stack_delete (_this->_operandStack);
	free (_this->_expression);
	free (_this);

}

void Postfix_setExpression (Postfix* _this, char* anExpression) { //setter
	strcpy (_this->_expression, anExpression);
}

void Postfix_showTokenAndStack (Postfix* _this, char currentToken) { //스택에 있는 것들을 확인한다.
	int i;
	AppView_out_Token (currentToken);
	AppView_out_Message ("<Bottom> ");
	for (i=0; i < Stack_size (_this->_operandStack); i++) {
		AppView_out_Elemenet (Stack_elementAt (_this->_operandStack, i));
	}
	AppView_out_Message (" <Top>\n");
}


Boolean Postfix_evaluate (Postfix* _this) { //값을 계산한다.
	int operand, operand1, operand2, calculated;
	char currentToken;
	int i=0;
	Stack_reset (_this->_operandStack); //Stack reset
	while (_this->_expression[i] != '\0') { //종료 조건?
		currentToken=_this->_expression[i];
		if (currentToken >= '0' && currentToken <= '9') { //Toekn 0~ 9 확인
			// token is an operand. Push it into stack
			operand=(currentToken - '0');
			if (Stack_isFull (_this->_operandStack)) {
				return PostfixError_ExpressionTooLong; //[오류] 수식이 너무 길어 처리가 불가능 합니다.
			}
			else {
				Stack_push (_this->_operandStack, operand);
			}
		}
		else { // The token is an operator +, -, * / % 값 핸들링
			if (currentToken == '+') {
				if (Stack_size (_this->_operandStack) >= 2) {
					operand2=Stack_pop (_this->_operandStack);
					operand1=Stack_pop (_this->_operandStack);
					calculated=operand1 + operand2;
					Stack_push (_this->_operandStack, calculated);
				}
				else {
					return PostfixError_OperandsTooFew;//[오류] 연산자에 비해 연산값의 수가 적습니다.
				}
			}
			else if (currentToken == '-') {
				if (Stack_size (_this->_operandStack) >= 2) {
					operand2=Stack_pop (_this->_operandStack);
					operand1=Stack_pop (_this->_operandStack);
					calculated=operand1 - operand2;
					Stack_push (_this->_operandStack, calculated);

				}
				else {
					return PostfixError_OperandsTooFew;//[오류] 연산자에 비해 연산값의 수가 적습니다.
				}
			}
			else if (currentToken == '*') {
				if (Stack_size (_this->_operandStack) >= 2) {
					operand2=Stack_pop (_this->_operandStack);
					operand1=Stack_pop (_this->_operandStack);
					calculated=operand1 * operand2;
					Stack_push (_this->_operandStack, calculated);
				}
				else {
					return PostfixError_OperandsTooFew;//[오류] 연산자에 비해 연산값의 수가 적습니다.
				}

			}
			else if (currentToken == '/') {
				if (Stack_size (_this->_operandStack) >= 2) {
					operand2=Stack_pop (_this->_operandStack);
					operand1=Stack_pop (_this->_operandStack);
					if (operand2 == 0) {
						return PostfixError_DivideByZero;
					}
					calculated=operand1 / operand2;
					Stack_push (_this->_operandStack, calculated);

				}
				else {
					return PostfixError_OperandsTooFew;//[오류] 연산자에 비해 연산값의 수가 적습니다.
				}
			}
			else if (currentToken == '%') {
				if (Stack_size (_this->_operandStack) >= 2) {
					operand2=Stack_pop (_this->_operandStack);
					operand1=Stack_pop (_this->_operandStack);
					if (operand2 == 0) {
						return PostfixError_DivideByZero;
					}
					calculated=operand1 % operand2;
					Stack_push (_this->_operandStack, calculated);

				}
				else {
					return PostfixError_OperandsTooFew;//[오류] 연산자에 비해 연산값의 수가 적습니다.
				}
			}
			else {
				return PostfixError_UnknownOperator;//[오류] 수식에 알 수 없는 연산자가 있습니다.
			}
		}
		Postfix_showTokenAndStack (_this, currentToken); // 출력을 한다.
		i++;
	} // end of while

	if (Stack_size (_this->_operandStack) == 1) { //Size
		_this->_evaluatedValue=Stack_pop (_this->_operandStack);
	}
	else if (Stack_size (_this->_operandStack) > 1) {
		return PostfixError_OperandsTooMany;//[오류] 연산자에 비해 연산값의 수가 많습니다.
	}
	return PostfixError_None; //아무 오류 없을 시 반환값
}

int Postfix_evaluatedValue (Postfix* _this) { //getter
	return (_this->_evaluatedValue);
}
