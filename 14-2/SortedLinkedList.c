#pragma once

#include "SortedLinkedList.h"


struct _SortedLinkedList {
    int _size;
    Node *_head;
};

SortedLinkedList *SortedLinkedList_new() {
    SortedLinkedList *_this = NewObject (SortedLinkedList);
    _this->_head = NULL;
    _this->_size = 0;
    return _this;
}

void SortedLinkedList_delete(SortedLinkedList *_this) {
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
    return FALSE;
}

Boolean SortedLinkedList_add(SortedLinkedList *_this, Element anElement) {
    Node *currentNode; //현재 노드 설정
    Node *addedNode = Node_new();
    Node_setElement(addedNode, anElement); //다음 엘리먼트 설정
    Node_setNext(addedNode, NULL); //다음 설정
    if (SortedLinkedList_isEmpty(_this)) {
        _this->_head = addedNode; //헤드를 설정
        _this->_size++; //사이즈를 늘린다.
        return TRUE;
    } else if (Node_element(_this->_head) >= anElement) {//  _this->_head
        Node_setNext(addedNode, _this->_head); //다음을 설정
        _this->_head = addedNode; //head 설정
        _this->_size++; //사이즈를 늘린다.
        return TRUE;
    } else {
        Node *previous = _this->_head;
        currentNode = Node_next(_this->_head); //SortedLinkedList 노드를 추가
        while (currentNode != NULL) {
            if (anElement > Node_element(currentNode)) {
                previous = currentNode;
                currentNode = Node_next(currentNode);
            } else {
                Node_setNext(previous, addedNode);
                Node_setNext(addedNode, currentNode);
                _this->_size++;
                return TRUE;
            }
        }
        Node_setNext(previous, addedNode);
        _this->_size++;
        return TRUE;
    }
}

Element SortedLinkedList_min(SortedLinkedList *_this) { //사이즈 1일 떄를 고려를 하는 것
    if (SortedLinkedList_isEmpty(_this)) {
        return 0;
    } else {
        return Node_element(_this->_head);
    }
}

Element SortedLinkedList_removeMax(SortedLinkedList *_this) {
    if (SortedLinkedList_isEmpty(_this)) {
        return 0;
    } else if (_this->_size == 1) {
        Node *removedNode = NULL;
        Element removedElement;

        if (_this->_head != NULL) {
            removedNode = _this->_head;
            _this->_head = Node_next(_this->_head);
            removedElement = Node_element(removedNode);
            Node_delete(removedNode);
            return removedElement;
        }

    } else {
        Node *removedNode = _this->_head;
        for (int i = 0; i < _this->_size - 1; i++) {
            removedNode = Node_next(removedNode);
        }
        return Node_element(removedNode);

    }
    _this->_size--;

}

Boolean SortedLinkedList_search(SortedLinkedList *_this, Element anElement) {
    Node* pointer = _this->_head;
    while(Node_element(pointer) != NULL){
        if(Node_element(pointer) == anElement){
            return TRUE;
        } else {
            pointer = Node_next(pointer);
        }
    }
    return FALSE;
}

Boolean SortedLinkedList_remove(SortedLinkedList *_this, Element anElement) {
    Node* pointer = _this->_head;
    _this->_head = Node_next(pointer);
    Node_delete(pointer);
    _this->_size--;
    return TRUE;

}
