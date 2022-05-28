#include "AppView.h"

void AppView_out_startProgram() {
    printf("<<< 큐 처리 프로그램을 시작합니다 >> >\n ");
    AppView_out_newLine();
}

void AppView_out_endProgram() {
    AppView_out_newLine();
    printf("<<< 큐 처리 프로그램을 종료합니다 >> >\n ");
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
    printf("[EnQueue] 삽입된 원소는 %c 입니다.\n", aChar);
}

void AppView_out_noElementInQueue() {
    printf("[deQueue1:Empty] 큐에 삭제할 원소가 없습니다.\n");
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
    printf("<Riear>\n");
}

void AppView_out_queueSize(int numberOfSize){
    printf("[Size] 큐에는 현재 %d 개의 원소가 있습니다.  ", numberOfSize);
}

void AppView_out_ignoredChar(){
    printf("[Ignored] 의미 없는 문자가 입력되었습니다. \n");
}

void AppView_out_frontElement(char anElement){
    printf("[Front] Front 원소는 %c 입니다. \n", anElement);
}

void AppView_out_endInput () {
    printf ("[End Input] 입력을 종료하며, 스택의 모든 원소를 삭제합니다:\n");
}

void AppView_out_removedElementByEndInput(char anElement) {
    printf ("-End Input: 삭제된 원소는 %c 입니다.\n", anElement);
}

void AppView_out_numberOfInputChars (int numberOfChars) {
    printf ("……입력된 문자는 모두 %d 개 입니다.\n ", numberOfChars);
}

void AppView_out_numberOfNormallyProcessedChars (int numberOfChars) {
    printf ("……정상으로 처리된 문자는 %d개 입니다.\n ", numberOfChars);
}

void AppView_out_numberOfIgnoredChars (int numberOfChars) {
    printf ("……무시된 문자는 %d 개 입니다.\n ", numberOfChars);
}

void AppView_out_numberOfAddedChars(int numberOfChars) {
    printf ("……큐에 넣은 문자는 %d개 입니다.\n ", numberOfChars);
}


