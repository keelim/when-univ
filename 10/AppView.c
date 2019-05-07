#include "AppView.h"

void AppView_out_startingMessage() {
    printf("<<< Postfix 수식 계산을 시작합니다. ");
}

void AppView_out_errorInExpression() {
    printf(">수식에 오류가 있습니다.\n");
}

void AppView_out_evaluatedValue(int value) {
    printf("계산값 : %d\n", value);
}

void AppView_out_endingMessage() {
    printf("<<< Postfix 수식 계산을 종료합니다. ");
}

void AppView_out_Message(char *s) {
    printf(s);
}
