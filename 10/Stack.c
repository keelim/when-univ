#pragma once
#include "Stack.h"

struct _Stack {
	int _capacity;
	int _top;
	Element* _elements; // 배열을 동적으로 할당한다.
};

Stack* Stack_new () { //Stack 생성
	Stack* _this;
	_this=NewObject (Stack);
	_this->_elements=NewVector (Element, DEFAULT_STACK_CAPACITY);
	_this->_capacity=DEFAULT_STACK_CAPACITY;
	_this->_top=-1;
	return _this;

}

void Stack_delete (Stack* _this) { //Stack delete
	free (_this->_elements);
	free (_this);
}

Boolean Stack_isEmpty (Stack* _this) { //Stack 비어 있는지 확인
	return ((_this->_top) < 0);
}

Boolean Stack_isFull (Stack* _this) { //Stack 꽉차 있는지 확인
	return ((_this->_top) == (_this->_capacity - 1));
}

void Stack_push (Stack * _this, Element anElement) { //Stack push
	if (!Stack_isFull (_this)) {
		_this->_top++;
		_this->_elements[_this->_top]=anElement;
	} // Stack이 empty이면 push를 무시한다.
}

Element Stack_pop (Stack * _this) {  //Stack pop

// Stack 은 empty 가 아니라고 가정한다. (위험한 코드. 이유는?)
	Element poppedElement;
	poppedElement=_this->_elements[_this->_top];
	_this->_top--;
	return poppedElement;
}

int Stack_size (Stack * _this) {
	return (_this->_top+1 );
}

Element Stack_topElement (Stack * _this) { //Stack peek
	return (_this->_elements[_this->_top]);
}

Element Stack_elementAt (Stack * _this, int anOrder) { // elementAt 구현
	return _this->_elements[anOrder];
}

void Stack_reset (Stack * _this) {
	_this->_top=-1;
}
