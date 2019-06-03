#include "AppController.h"
#include "AppView.h"

struct _AppController {
    Dictionary *_dictionary;
};

void AppView_out_doesExist(Boolean flag);

AppController *AppController_new() {
    AppController *_this = NewObject(AppController);
    _this->_dictionary = Dictionary_new();
    return _this;
}

void AppController_delete(AppController *_this) {
    Dictionary_delete(_this->_dictionary);
    free(_this);
}

void AppController_showInternalShapeOfBinaryTree(AppController *_this, Traverse *aTraverse) {
    Dictionary_scanInSortedOrder(_this->_dictionary, aTraverse);
}

void AppController_add(AppController *_this, char keyValue) { //todo
    int objectValue = (int) keyValue;
    if (Dictionary_isFull(_this->_dictionary)) {
        AppView_out_dictionaryIsFull(keyValue);
// printf("[Full] 큐가 꽉 차서 원소 \'%c\' 는 삽입이 불가능합니다. \n", aChar) ;
    } else {
        Dictionary_addKeyAndObject(_this->_dictionary, keyValue, objectValue);
        AppView_out_addedElementInDictionary(keyValue);
    }

}

void AppController_remove(AppController *_this, char inputChar) { //todo
    char removedChar;
    if (Dictionary_isEmpty(_this->_dictionary)) {
        AppView_out_noElementInDictionary();
        // printf("[Empty] 큐에 삭제할 원소가 없습니다. \n") ;
    } else {
        removedChar = Dictionary_removeObjectForKey(_this->_dictionary, inputChar);
        AppView_out_removedElementFromQueue(removedChar);
        // printf("[Remove1] 삭제된 원소는 \'%c\' 입니다. \n", removedChar ) ;
    }
}

void AppController_exist(AppController *_this, char inputChar) { //todo
    Boolean flag = Dictionary_keyDoesExist(_this->_dictionary, inputChar);
    AppView_out_doesExist(flag);
}


void AppController_showSize(AppController *_this) {
    AppView_out_dictionarySize(Dictionary_size(_this->_dictionary));
    AppView_out_newLine();
}

void AppController_ignore(AppController *_this) {
    AppView_out_ignoredChar();
}

void AppController_esc(AppController *_this) {
    AppView_out_endInput();//종료 메시지 출력
}

void AppController_run(AppController *_this) {
    AppView_out_startProgram();
    char inputChar = AppView_in_nextInputChar();
    while (inputChar != Esc) { //ESC 입력을 받으면 종료
        Traverse *traverse = Traverse_new();
        if (isAlpha(inputChar)) {
            AppController_add(_this, inputChar);
        } else if (inputChar == '-') {
            AppController_remove(_this, inputChar);
        } else if (inputChar == '#') {
            AppController_showSize(_this);
        } else if (inputChar == '/') {
            AppController_showInternalShapeOfBinaryTree(_this, traverse);
        } else if (inputChar == '?') {
            AppController_exist(_this, inputChar);
        } else {
            AppController_ignore(_this);
        }
        inputChar = AppView_in_nextInputChar();
    }
    AppController_esc(_this);
    AppView_out_endProgram();
}
