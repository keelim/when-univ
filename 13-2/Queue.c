#pragma once
#include "Queue.h"

struct _Queue {
    int _capacity; // 배열로 리스트를 구현할 때 반드시 필요한 속성
    int _front;
    int _rear;
    Element *_elements; // 객체 생성시에 동적 할당도 가능
};

Queue *Queue_new(int givenCapacity) {
    Queue *_this;
    _this = NewObject(Queue);
    _this->_capacity = givenCapacity;
    _this->_elements = NewVector(Element, givenCapacity);
    _this->_front = 0;
    _this->_rear = 0; // 큐 초기화
    return _this;
}

void Queue_delete(Queue *_this) {
    free(_this->_elements);
    free(_this);
}

Boolean Queue_isEmpty(Queue *_this) {
    return _this->_front == _this->_rear;
}

Boolean Queue_isFull(Queue *_this) {
    int nextRear = (_this->_rear + 1) % _this->_capacity;
    return nextRear == _this->_front;
}

int Queue_size(Queue *_this) {
    if (_this->_rear >= _this->_front) {
        return (_this->_rear - _this->_front);
    } else {
        return _this->_rear + (_this->_capacity + 1) - _this->_front;
    }
}

Boolean Queue_add(Queue *_this, Element anElement) {
    if (Queue_isFull(_this)) {
        return FALSE; // Queue Full 처리
    } else {
        _this->_rear = (_this->_rear + 1) % _this->_capacity;
        _this->_elements[_this->_rear] = anElement;
        return TRUE;
    }
}

Element Queue_remove(Queue *_this) {
    Element removedElement;
    if (Queue_isEmpty(_this)) { /* Queue Empty 처리 */ }
    else {
        _this->_front = (_this->_front + 1) % _this->_capacity;
        removedElement = _this->_elements[_this->_front];
        return (removedElement);
    }
}

Element Queue_elementAt(Queue *_this, int anOrder) {
    return _this->_elements[((_this->_front+1+anOrder)%(_this->_capacity+1))];
}



