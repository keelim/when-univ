#pragma once
#include "AppController.h"

struct _AppController {
	char _expression[MAX_NUMBER_OF_TOKENS];
	Postfix* _postfix;
};

AppController* AppController_new () { //AppController 생성
	AppController* _this;
	_this=NewObject (AppController); //dynamic allocation
	_this->_postfix=Postfix_new (MAX_NUMBER_OF_TOKENS);
	return _this;
}

void AppController_delete (AppController* _this) {
	free (_this);
}

void AppController_run (AppController* _this) {
	Boolean expressionIsAvailable;
	PostfixError evaluationError;
	AppView_out_startingMessage (); //프로그램 시작 메시지 출력
	_this->_postfix=Postfix_new (MAX_NUMBER_OF_TOKENS); //후위식 생성
	expressionIsAvailable=AppView_in_postfixExpression (_this->_expression); //후위식 셋팅
	while (expressionIsAvailable) {
		Postfix_setExpression (_this->_postfix, _this->_expression);
		evaluationError=Postfix_evaluate (_this->_postfix); //값을 계산을 한다.
		if (evaluationError == PostfixError_None) { //오류가 없을 시
			AppView_out_evaluatedValue (Postfix_evaluatedValue (_this->_postfix)); //계산 값을 출력
		}
		else {
			AppView_out_postfixEvaluationErrorMessage (evaluationError); //오류가 있을 시 오류 메시지 출력
		}
		expressionIsAvailable=AppView_in_postfixExpression (_this->_expression);
	}
	Postfix_delete (_this->_postfix); //후위식 소멸
	AppView_out_endingMessage (); //종료 메시지 출력
}

