#include "Node.h"

struct _Node { //Node
    Element _element;
    Node *_next;
};

Node* Node_new() { //Node 생성
    Node *_this = NewObject(Node);
    return _this;
}


void Node_delete(Node *_this) { //소멸
    free(_this);
}

void Node_setElement(Node *_this, Element newElement) { //setter
    _this->_element = newElement;
}

Element Node_element(Node *_this) { //getter
    return _this->_element;
}

void Node_setNext(Node *_this, Node *newNext) { //setter
    _this->_next = newNext;
}

Node *Node_next(Node *_this) { //getter
    return _this->_next;
}

