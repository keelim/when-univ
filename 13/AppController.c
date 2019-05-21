#include "AppController.h"


struct _AppController {
    Queue *_queue;
    int _inputChars; // 입력된 문자의 개수
    int _ignoredChars; // 무시된 문자의 개수
    int _addedChars; // 삽입된 문자의 개수
};

AppController *AppController_new(void) {
    AppController *_this;
    _this = NewObject(AppController);
    _this->_queue = Queue_new();
    _this->_inputChars = 0;
    _this->_ignoredChars = 0;
    _this->_addedChars = 0;
    return (_this);
}

void AppController_delete(AppController *_this) {
    Queue_delete(_this->_queue);
    free(_this);
}

void AppController_run(AppController *_this) {
    AppView_out_startProgram();
    AppController_initCharCounts(_this);
    char inputChar = AppView_in_nextInputChar();
    AppController_countInput(_this);
    while (inputChar != Esc) {
        if (isAlpha(inputChar)) {
            AppController_add(_this, inputChar);
        } else if (isDigit(inputChar)) {
            AppController_removeN(_this, inputChar);
        } else if (inputChar == '-') {
            AppController_remove1(_this);
        } else if (inputChar == '#') {
            AppController_showSize(_this);
        } else if (inputChar == '/') {
            AppController_showAllFromFront(_this);
        } else if (inputChar == '^') {
            AppController_showFront(_this);
        } else {
            AppController_countIgnored(_this);
            AppController_ignore(_this);
        }
        inputChar = AppView_in_nextInputChar();
        AppController_countInput(_this);
    }
    AppController_esc(_this);
    AppView_out_endProgram();
}

void AppController_add(AppController *_this, char aChar) {
    if (Queue_isFull(_this->_queue)) {
        AppView_out_queueIsFull(aChar);
// printf("[Full] 큐가 꽉 차서 원소 \'%c\' 는 삽입이 불가능합니다. \n", aChar) ;
    } else {
        Queue_add(_this->_queue, aChar);
        AppController_countAdded(_this);
        AppView_out_addedElementInQueue(aChar);
    }

}

void AppController_removeN(AppController *_this, char aChar) {
    //todo
}

void AppController_remove1(AppController *_this) {
    char removedChar;
    if (Queue_isEmpty(_this->_queue)) {
        AppView_out_noElementInQueue();
// printf("[Empty] 큐에 삭제할 원소가 없습니다. \n") ;
    } else {
        removedChar = Queue_remove(_this->_queue);
        AppView_out_removedElementFromQueue(removedChar);
// printf("[Remove1] 삭제된 원소는 \'%c\' 입니다. \n", removedChar ) ;
    }
}

void AppController_showAllFromFront(AppController *_this) {
    AppView_out_label(); // printf ("<Front> ") ;
    for (int i = 0; i < Queue_size(_this->_queue); i++) {
        AppView_out_elementInQueue(Queue_elementAt(_this->_queue, i));
    }
    AppView_out_label(); // printf ("<Rear>\n") ;
}

void AppController_initCharCounts(AppController *_this) {
    _this->_inputChars = 0;
    _this->_ignoredChars = 0;
    _this->_addedChars = 0;
}

void AppController_countInput(AppController *_this) {
    _this->_inputChars++;
}

void AppController_countIgnored(AppController *_this) {
    _this->_ignoredChars++;
}

void AppController_countAdded(AppController *_this) {
    _this->_addedChars++;
}
