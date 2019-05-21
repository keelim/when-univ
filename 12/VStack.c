#pragma once
#include "VStack.h"
#include "Node.h"

struct _VStack {
    int _size; // 필요 없으면 삭제 가능
    Node *_top;
};

VStack *VStack_new() { //Stack 생성
    VStack *_this;
    _this = NewObject(VStack);
    _this->_top = NULL;
    _this->_size = 0;
    return _this;

}

void VStack_deleteLinkedNodesRecursively(VStack *_this, Node *firstNode) {
    if (firstNode != NULL) {
        VStack_deleteLinkedNodesRecursively(_this, Node_next(firstNode)); // ①
        Node_delete(firstNode); // ②
    }
}

void VStack_deleteLinkedNodesre(VStack *_this) {
    VStack_deleteLinkedNodesRecursively(_this, _this->_top);
}

void VStack_deleteLinkedNodes(VStack *_this) {
    Node *currentNode = _this->_top;
    Node *nodeToBeDeleted = NULL;
    while (currentNode != NULL) {
        nodeToBeDeleted = currentNode;
        currentNode = Node_next(currentNode);
        Node_delete(nodeToBeDeleted);
    }
}


void VStack_delete(VStack *_this) { //Stack delete
    VStack_deleteLinkedNodes(_this);
    free(_this);

}

Boolean VStack_isEmpty(VStack *_this) { //Stack 비어 있는지 확인
    return _this->_size == 0;
}

Boolean VStack_isFull(VStack *_this) { //Stack 꽉차 있는지 확인
    return FALSE;
}

Boolean VStack_push(VStack *_this, Element anElement) { //Stack push
    Node *addedNode = Node_new();
    if (VStack_isFull(_this)) {
        return FALSE;
    }
    Node_setElement(addedNode, anElement);
    Node_setNext(addedNode, _this->_top);
    _this->_top = addedNode;
    _this->_size++;
    return TRUE;

}

Element VStack_pop(VStack *_this) {  //Stack pop

    Element poppedElement;
    Node *poppedNode = _this->_top;
    if (VStack_isEmpty(_this)) {
        return NULL;
    }
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
    return 0; //todo
}

Element VStack_elementAt(VStack *_this, int anOrder) { // elementAt 구현
    //todo
}

void VStack_reset(VStack *_this) {
    _this->_top = -1;
}
