#pragma once
#include "Stack.h"
#include "Node.h"

struct _Stack {
    int _size; // 필요 없으면 삭제 가능
    Node *_top;
};

Stack *Stack_new() { //Stack 생성
    Stack *_this;
    _this = NewObject(Stack);
    _this->_top = NULL;
    _this->_size = 0;
    return _this;

}

void Stack_deleteLinkedNodesRecursively(Stack *_this, Node *firstNode) {
    if (firstNode != NULL) {
        Stack_deleteLinkedNodesRecursively(_this, Node_next(firstNode)); // ①
        Node_delete(firstNode); // ②
    }
}

void Stack_deleteLinkedNodesre(Stack *_this) {
    Stack_deleteLinkedNodesRecursively(_this, _this->_top);
}

void Stack_deleteLinkedNodes(Stack *_this) {
    Node *currentNode = _this->_top;
    Node *nodeToBeDeleted = NULL;
    while (currentNode != NULL) {
        nodeToBeDeleted = currentNode;
        currentNode = Node_next(currentNode);
        Node_delete(nodeToBeDeleted);
    }
}


void Stack_delete(Stack *_this) { //Stack delete
    Stack_deleteLinkedNodes(_this);
    free(_this);

}

Boolean Stack_isEmpty(Stack *_this) { //Stack 비어 있는지 확인
    return _this->_size == 0;
}

Boolean Stack_isFull(Stack *_this) { //Stack 꽉차 있는지 확인
    return FALSE;
}

Boolean Stack_push(Stack *_this, Element anElement) { //Stack push
    Node *addedNode = Node_new();
    if (Stack_isFull(_this)) {
        return FALSE;
    }
    Node_setElement(addedNode, anElement);
    Node_setNext(addedNode, _this->_top);
    _this->_top = addedNode;
    _this->_size++;
    return TRUE;

}

Element Stack_pop(Stack *_this) {  //Stack pop

    Element poppedElement;
    Node *poppedNode = _this->_top;
    if (Stack_isEmpty(_this)) {
        return NULL;
    }
    poppedElement = Node_element(poppedNode);
    _this->_top = Node_next(poppedNode);
    Node_delete(poppedNode);
    _this->_size--;
    return poppedElement;

}

int Stack_size(Stack *_this) {
    return _this->_size;
}

Element Stack_topElement(Stack *_this) { //Stack peek
    return 0; //todo
}

Element Stack_elementAt(Stack *_this, int anOrder) { // elementAt 구현
    //todo
}

void Stack_reset(Stack *_this) {
    _this->_top = -1;
}
