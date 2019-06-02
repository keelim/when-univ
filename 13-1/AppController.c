#include "AppController.h"


struct _AppController {
    Queue *_queue;
    int _inputChars;    // 입력된 문자의 개수
    int _ignoredChars; // 무시된 문자의 개수
    int _addedChars;  // 삽입된 문자의 개수
};

AppController *AppController_new() {
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

void AppController_run(AppController *_this) { //실행을 한다.
    AppView_out_startProgram();
    AppController_initCharCounts(_this);
    char inputChar = AppView_in_nextInputChar();
    AppController_countInput(_this);
    while (inputChar != Esc) { //ESC 입력을 받으면 종료
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
    int numberOfChars = aChar - '0';
    for (int i = 0; (i < numberOfChars); i++) { //입력 수 만큼 반복
        if (Queue_isEmpty(_this->_queue)) { //비어 있는지 확인
            AppView_out_noElementInQueue();
            return;
        }
        char removedChar = Queue_remove(_this->_queue); //pop
        AppView_out_removedElementFromQueue(removedChar);
    }
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
    AppView_out_label_Front(); // printf ("<Front> ") ;
    for (int i = 0; i < Queue_size(_this->_queue); i++) {
        AppView_out_elementInQueue(Queue_elementAt(_this->_queue, i));
    }
    AppView_out_label_Rear(); // printf ("<Rear>\n") ;
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

void AppController_showSize(AppController *_this) {
    AppView_out_queueSize(Queue_size(_this->_queue));
    AppView_out_newLine();
}

void AppController_showFront(AppController *_this) {
    char element = Queue_elementAt(_this->_queue, 0);
    AppView_out_frontElement(element);
}

void AppController_ignore(AppController *_this) {
    AppController_countIgnored(_this);
    AppView_out_ignoredChar();
}

void AppController_endInput(AppController* _this){
    AppView_out_endInput ();
    int bound=Queue_size (_this->_queue);
    for (int i=0; i < bound; i++) {
        Element poppedElement=Queue_remove (_this->_queue);
        AppView_out_removedElementByEndInput(poppedElement);
    }
}

int AppController_numberOfInputChars (AppController* _this) {
    return (_this->_inputChars);

}

int AppController_numberOfIgnoredChars (AppController* _this) {
    return _this->_ignoredChars;

}

int AppController_numberOfNormallyProcessedChars (AppController* _this) {
    return (_this->_inputChars - _this->_ignoredChars);
}

int AppController_numberOfAddedChars(AppController *_this) {
    return _this->_addedChars;
}

void AppController_showStatistics (AppController * _this) {
    AppView_out_newLine ();
    AppView_out_numberOfInputChars
            (AppController_numberOfInputChars (_this));
    AppView_out_numberOfNormallyProcessedChars
            (AppController_numberOfNormallyProcessedChars (_this));
    AppView_out_numberOfIgnoredChars
            (AppController_numberOfIgnoredChars (_this));
    AppView_out_numberOfAddedChars
            (AppController_numberOfAddedChars(_this));

}

void AppController_esc(AppController *_this) {
    AppController_endInput (_this); //종료 메시지 출력
    AppController_showStatistics (_this); //통계 함수 출력
}
