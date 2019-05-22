#include "AppView.h"

void AppView_out_startProgram() {
    printf("<<< 스택 처리 프로그램을 시작합니다 >> >\n ");
    AppView_out_newLine();
}

void AppView_out_endProgram() {
    AppView_out_newLine();
    printf("<<< 스택 처리 프로그램을 종료합니다 >> >\n ");
}


void AppView_out_newLine() {
    printf("\n");
}

char AppView_in_nextInputChar() {
    printf(">문자를 입력하시오: ");
    char charFromKeyboard;
    charFromKeyboard = _getch();
    AppView_out_newLine();
    return charFromKeyboard;
}

void AppView_out_queueIsFull(char aChar) {
    printf("[Queue: Full] 큐가 꽉 차서 원소 %c 는 삽입이 불가능합니다.\n", aChar);
}

void AppView_out_addedElementInQueue(char aChar) {
    printf("[InQueue] 삽입된 원소는 %c 입니다.\n", aChar);
}

void AppView_out_noElementInQueue() {
    printf("[deQueue1:Empty] 스택에 삭제할 원소가 없습니다.\n");
}

void AppView_out_removedElementFromQueue(char removedChar) {
    printf("[DeQueue1] 삭제된 원소는 %c 입니다.\n", removedChar);
}

void AppView_out_elementInQueue(Element element) {
    printf("%c", element);
}

void AppView_out_label_Front() {
    printf("<Front> ");
}

void AppView_out_label_Rear() {
    printf("<Rear>\n");
}


