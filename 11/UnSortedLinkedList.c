#pragma once

#include "UnSortedLinkedList.h"
#include "Node.h"

//todo 소스 채울 것
struct _UnsortedLinkedList {
    int size;
    Node *_head;
};


UnsortedLinkedList *UnsortedLinkedList_new() {
    UnsortedLinkedList *_this = NewObject(UnsortedLinkedList);
    _this->_head = Node_new();
    Node_setElement(_this->_head, NULL);
    _this->size = 0;
}

void UnsortedLinkedList_delete(UnsortedLinkedList *_this) {
    Node_delete(_this->_head);
    free(_this);
}

Boolean UnsortedLinkedList_isEmpty(UnsortedLinkedList *_this) {
    Boolean flag = FALSE;
    if (_this->size == 0) {
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
    
    _this->size++;
    return TRUE;
}

Element UnsortedLinkedList_min(UnsortedLinkedList *_this) {
    return 0;
}

Element UnsortedLinkedList_removeMax(UnsortedLinkedList *_this) {
    return 0;
}
