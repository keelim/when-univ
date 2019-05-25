#pragma once

#include "AppView.h"

void AppView_out_startingMessage () {
	printf ("<<< Infix 수식 계산을 시작합니다.>>>\n\n ");
}

void AppView_out_errorInExpression () {
	printf (">수식에 오류가 있습니다.\n");
}

void AppView_out_evaluatedValue (int value) {
	printf ("계산값 : %d\n\n", value);
}

void AppView_out_endingMessage () {
	printf ("\n <<< Infix 수식 계산을 종료합니다. >>>");
}

void AppView_out_postfixEvaluationErrorMessage (PostfixError aPostfixError) {
	if (aPostfixError == PostfixError_ExpressionTooLong) {
		printf (ErrorMsg_ExpressionTooLong);
	}
	else if (aPostfixError == PostfixError_OperandsTooMany) {
		printf (ErrorMsg_OperandsTooMany);
	}
	else if (aPostfixError == PostfixError_OperandsTooFew) {
		printf (ErrorMsg_OperandsTooFew);
	}
	else if (aPostfixError == PostfixError_UnknownOperator) {
		printf (ErrorMsg_UndefinedOperator);
	}
	else if (aPostfixError == PostfixError_DivideByZero) {
		printf (ErrorMsg_DivideByZero);
	}
}

void AppView_out_Message (char* s) {
	printf (s);
}

void AppView_out_Token (char token) {
	printf ("%c : ", token);
}

void AppView_out_Elemenet (int element) {
	printf ("%d ", element);
}

void AppView_out_Infix_Elemenet (int element) {
	printf ("%c ", element);
}
void AppView_out_change(){
    printf("> Infix를 Postfix로 변환\n");
}

Boolean AppView_in_postfixExpression (char* s) {
	printf ("? Infix 수식을 입력하여 주세요: \n");

	scanf ("%s", s);

	char temp=s[0];

	if (temp == '!') {
		return FALSE;
	}
	else {
		return TRUE;
	}

}
