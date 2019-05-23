#pragma once

#include "VStack.h"
#include "Node.h"


struct _VStack {
    int _size;
    Node *_top;
};

void VStack_deleteLinkedNodes(VStack *_this);

void VStack_deleteLinkedNodesRecursively(VStack *_this, Node *node);

VStack *VStack_new() { //Stack 생성
    VStack *_this;
    _this = NewObject (VStack);
    _this->_top = NULL;
    _this->_size = 0;
    return _this;
}

void Stack_delete(VStack *_this) { //Stack delete
    VStack_deleteLinkedNodes(_this);
    free(_this);
}

void VStack_deleteLinkedNodes(VStack *_this) {
    VStack_deleteLinkedNodesRecursively(_this, _this->_top);

}

Boolean VStack_isEmpty(VStack *_this) { //Stack 비어 있는지 확인
    return ((_this->_top) < 0);
}

Boolean Stack_isFull(VStack *_this) { //Stack 꽉차 있는지 확인
    return FALSE;
}

Boolean Stack_push(VStack *_this, Element anElement) { //Stack push
    Node *addedNode = Node_new();
    Node_setElement(addedNode, anElement);
    Node_setNext(addedNode, _this->_top);
    _this->_top = addedNode;
    _this->_size++;
    return TRUE;
}

Element VStack_pop(VStack *_this) {  //Stack pop
    Element poppedElement;
    Node *poppedNode = _this->_top;
    poppedElement = Node_element(poppedNode);
    _this->_top = Node_next(poppedNode);
    Node_delete(poppedNode);
    _this->_size--;
    return poppedElement;
}

int VStack_size(VStack *_this) {
    return _this->_size;
}

Element VStack_topElement(VStack *_this) { //Stack peek
    return Node_element(_this->_top);
}

Element VStack_elementAt(VStack *_this, int anOrder) { // elementAt 구현
    Node *ElementAt = _this->_top;
    for (int i = 0; i < anOrder; i++) {
        ElementAt = Node_next(ElementAt);
    }
    return Node_element(ElementAt);
}

void VStack_reset(VStack *_this) {
    VStack_deleteLinkedNodesRecursively(_this, _this->_top);
    _this->_size = 0;
    _this->_top = NULL;
}

void VStack_deleteLinkedNodesRecursively(VStack *_this, Node *firstNode) {
    if (firstNode != NULL) {
        VStack_deleteLinkedNodesRecursively(_this, Node_next(firstNode));
        Node_delete(firstNode);
    }
}