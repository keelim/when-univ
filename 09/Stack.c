#include "Stack.h"

struct _Stack {
    int _capacity;
    int _top;
    Element *_elements; // 배열을 동적으로 할당한다.
};

Stack *Stack_new() {
    Stack *_this;
    _this = NewObject (Stack);
    _this->_elements = NewVector(Element, DEFAULT_STACK_CAPACITY);
    _this->_capacity = DEFAULT_STACK_CAPACITY;
    _this->_top = -1;
    return _this;

}

void Stack_delete(Stack *_this) {
    free(_this->_elements);
    free(_this);

}
