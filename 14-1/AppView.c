#include "AppView.h"

void AppView_out_startProgram() {
    printf("<<< 사전 처리 프로그램을 시작합니다 >> >\n ");
    AppView_out_newLine();
}

void AppView_out_endProgram() {
    AppView_out_newLine();
    printf("<<< 사전 처리 프로그램을 종료합니다 >> >\n ");
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

void AppView_out_dictionaryIsFull(char aChar) {
    printf("[Dictionary: Full] 사전이 꽉 차서 원소 %c 는 삽입이 불가능합니다.\n", aChar);
}

void AppView_out_addedElementInDictionary(char aChar) {
    printf("[Dictionary] 삽입된 원소는 %c 입니다.\n", aChar);
}

void AppView_out_noElementInDictionary() {
    printf("[deQueue1:Empty] 사전에 삭제할 원소가 없습니다.\n");
}

void AppView_out_removedElementFromQueue(char removedChar) {
    printf("[DeQueue1] 삭제된 원소는 %c 입니다.\n", removedChar);
}

void AppView_out_elementInDictionary(Element element) {
    printf("%c", element);
}

void AppView_out_dictionarySize(int numberOfSize){
    printf("[Size] 사전에는 현재 %d 개의 원소가 있습니다.  ", numberOfSize);
}

void AppView_out_ignoredChar(){
    printf("[Ignored] 의미 없는 문자가 입력되었습니다. \n");
}

void AppView_out_endInput () {
    printf ("[End Input] 입력을 종료합니다. \n");
}

void AppView_out_doesExist(Boolean flag) {
    if(flag == FALSE){
        printf("키 값이 존재하지 않습니다. ");
    } else {
        printf("키 값이 존재 합니다. ");
    }
}




