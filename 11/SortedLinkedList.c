#pragma once

#include "SortedLinkedList.h"
#include "Node.h"
//todo 소스 채울 것

struct _SortedLinkedList {
    int _size;
    int _capacity;
    Node *_head;
};

SortedLinkedList *SortedLinkedList_new(int givenCapacity) {
    SortedLinkedList *_this = NewObject(SortedLinkedList);
    _this->_size = 0;
    _this->_head = Node_new();
    Node_setElement(_this->_head, 0);
    Node_setNext(_this->_head, NULL);
    _this->_capacity = givenCapacity;
    return _this;
}

void SortedLinkedList_delete(SortedLinkedList *_this) {
    Node_delete(_this->_head);
    free(_this);
}

Boolean SortedLinkedList_isEmpty(SortedLinkedList *_this) {
    Boolean flag = FALSE;
    if (_this->_size == 0) {
        flag = TRUE;
    }
    return flag;

}

Boolean SortedLinkedList_isFull(SortedLinkedList *_this) {
    return FALSE; //얘는 맞음
}

Boolean SortedLinkedList_add(SortedLinkedList *_this, Element anElement) {
    return FALSE; //todo
}

Element SortedLinkedList_min(SortedLinkedList *_this) {
    //todo
    return 0;
}

Element SortedLinkedList_removeMax(SortedLinkedList *_this) {
    return 0; //todo
}
