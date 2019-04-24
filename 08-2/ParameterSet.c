#include "ParameterSet.h"

struct _ParameterSet {
    int _minTestSize;
    int _intervalSize;
    int _numberOfTests;
};

ParameterSet *ParameterSet_new(void) { // 생성자 ……
    // 여기를 채우시오
}

ParameterSet *ParameterSet_newWith(givenMinTestSize, givenIntervalSize, givenNumberOfTests) {// 초기화 값이 주어지는 생성자
    // 여기를 채우시오
}

void ParameterSet_delete(ParameterSet *_this) {
    // 소멸자 …… // 여기를 채우시오
}

void ParameterSet_setMinTestSize(ParameterSet *_this, int newMinTestSize) {

}

int ParameterSet_minTestSize(ParameterSet *_this) {
    return 0;
}

void ParameterSet_setIntervalSize(ParameterSet *_this, int newIntervalSize) {

}

int ParameterSet_intervalSize(ParameterSet *_this) {
    return 0;
}

void ParameterSet_setNumberOfTests(ParameterSet *_this, int newNumberOfTests) {

}

int ParameterSet_numberOfTests(ParameterSet *_this) {
    return 0;
}

int ParameterSet_maxTestSize(ParameterSet *_this) {
    return (_this->_minTestSize + (_this->_intervalSize * (_this->_numberOfTests - 1)));

}

