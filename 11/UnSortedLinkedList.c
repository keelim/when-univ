#pragma once

#include "UnSortedLinkedList.h"
#include "Node.h"

//todo 소스 채울 것
struct _UnsortedLinkedList {
    int _size;
    int _capacity;
    Node *_head;
};


UnsortedLinkedList *UnsortedLinkedList_new(int givenCapacity) {
    UnsortedLinkedList *_this = NewObject(UnsortedLinkedList);
    _this->_size = 0;
    _this->_head = Node_new();
    Node_setElement(_this->_head, 0);
    Node_setNext(_this->_head, NULL);
    _this->_capacity = givenCapacity;
    return _this;
}

void UnsortedLinkedList_delete(UnsortedLinkedList *_this) {
    Node_delete(_this->_head);
    free(_this);
}

Boolean UnsortedLinkedList_isEmpty(UnsortedLinkedList *_this) {
    Boolean flag = FALSE;
    if (_this->_size == 0) {
        flag = TRUE;
    }
    return flag;
}

Boolean UnsortedLinkedList_isFull(UnsortedLinkedList *_this) {
    return FALSE;
}

Boolean UnsortedLinkedList_add(UnsortedLinkedList *_this, Element anElement) {
    Node *addNode = Node_new();
    Node_setElement(addNode, anElement);
    Node_setNext(addNode, _this->_head);
    
    _this->_size++;
    return TRUE;
}

Element UnsortedLinkedList_min(UnsortedLinkedList *_this) {
    return 0;
}

Element UnsortedLinkedList_removeMax(UnsortedLinkedList *_this) {
    if(UnsortedLinkedList_isEmpty(_this)){
        return -1;
    } else {
        Element  maxElement = Node_element(_this->_head);

    }
}
