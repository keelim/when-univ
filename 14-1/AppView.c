#include "AppView.h"
#include "Key.h"

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

char AppView_int_removeKey () {
	printf ("> 삭제할 키값을 입력하여 주세요!: ");
	char charFromKeyboard;
	charFromKeyboard=_getch ();
	AppView_out_newLine ();
	return charFromKeyboard;
}

void AppView_out_dictionaryIsFull(char aChar) {
    printf("[Dictionary: Full] 사전이 꽉 차서 원소 %c 는 삽입이 불가능합니다.\n", aChar);
}

void AppView_out_addedElementInDictionary(char aChar, int aInt) {
    printf("[Add] 삽입된 키-객체 쌍은 <‘%c‘, %d> 입니다.\n", aChar, aInt);
}

void AppView_out_noElementInDictionary() {
    printf("[deQueue1:Empty] 사전에 삭제할 원소가 없습니다.\n");
}

void AppView_out_removedElementFromDictionary(char removedChar, int removeInt) {
    printf("[삭제] < %c,%d> 이 성공적으로 삭제되었습니다\n", removedChar,removeInt);
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

void AppView_out_doesExist(Boolean flag, Key *aKey) {
    char keyValue = Key_value(aKey);
    if(flag == FALSE){
        printf("[검색] 주어진 키가 사전에 존재하지 않습니다.\n");
    } else {
        printf("[검색] < '%c', %d> 쌍이 사전에 존재합니다.\n", keyValue, (int)keyValue);
    }
}

char AppView_in_searchKey() {
    printf("검색할 객체의 Key 값을 입력하시오: ");
    char charFromKeyboard;
    charFromKeyboard=_getch ();
    AppView_out_newLine ();
    return charFromKeyboard;
}

void AppView_out_noKeyInDictionary() {
    printf("[삭제] 주어진 키가 사전에 존재하지 않습니다 \n");
}

void AppView_out_replace(char keyValue, int objectValue) {
    printf("[Replace] key <'%c'> 의 object 를 <%d>로 대체합니다.\n", keyValue, objectValue);
}

void AppView_out_traverseDisplay(Key *aKey, int aDepth) {
    for(int i=0; i<aDepth; i++){
        printf("   ");
    }
    printf("%c\n", Key_value(aKey));
}

void AppView_out_treeSign() {
    printf ("[Tree]\n");
}




