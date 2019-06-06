#include "AppController.h"
#include "AppView.h"

struct _AppController {
    Dictionary *_dictionary;
};

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

void AppController_add(AppController *_this, char keyValue) {
    int objectValue = (int) keyValue;
    Key *addKey = Key_newWith(keyValue);
    Object *addObject = Object_newWith(objectValue);
    if (Dictionary_isFull(_this->_dictionary)) {
        AppView_out_dictionaryIsFull(keyValue);
    } else if(Dictionary_keyDoesExist(_this->_dictionary, addKey)){
        //키가 존재를 할 때
        Dictionary_replaceObjectForKey(_this->_dictionary, addKey, addObject);
        AppView_out_replace(keyValue, objectValue);
    }else {
        //키가 존재 하지 않을 때
        Dictionary_addKeyAndObject(_this->_dictionary, addKey, addObject);
        AppView_out_addedElementInDictionary(keyValue, objectValue);
    }

}

void AppController_remove(AppController *_this) { //todo 여기서 부터 새로 수정을 할 것
    Key *removeKey = Key_newWith(AppView_int_removeKey());
    char removedChar = (char) Key_value(removeKey);
    if (Dictionary_isEmpty(_this->_dictionary)) {
        AppView_out_noElementInDictionary();
    } else if (Dictionary_keyDoesExist(_this->_dictionary, removeKey)) {
        //존재 할 때
        Dictionary_removeObjectForKey(_this->_dictionary, removeKey);
        AppView_out_removedElementFromDictionary(removedChar, (int) removedChar);
    } else {
        //존재 하지 않을 떄.
        AppView_out_noKeyInDictionary();
    }
}



void AppController_exist(AppController *_this, char inputChar) {
    char searchKey = AppView_in_searchKey();
    Key *search = Key_newWith(searchKey);
    Boolean flag = Dictionary_keyDoesExist(_this->_dictionary, search);
    AppView_out_doesExist(flag, search);
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
            AppController_remove(_this);
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
