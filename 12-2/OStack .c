#pragma once

#include "Stack.h"
#include "Node.h"


struct _Stack {
	int _size;
	Node* _top;
};

void Stack_deleteLinkedNodes (Stack* _this);

void Stack_deleteLinkedNodesRecursively (Stack* _this, Node* node);

Stack* Stack_new () { //Stack 생성
	Stack* _this; 
	_this=NewObject (Stack); 
	_this->_top=NULL; 
	_this->_size=0; 
	return _this;
}

void Stack_delete (Stack* _this) { //Stack delete
	Stack_deleteLinkedNodes (_this);
	free (_this);
}

void Stack_deleteLinkedNodes (Stack* _this) {
	Stack_deleteLinkedNodesRecursively (_this, _this->_top);

}

Boolean Stack_isEmpty (Stack* _this) { //Stack 비어 있는지 확인
	return ((_this->_top) < 0);
}

Boolean Stack_isFull (Stack* _this) { //Stack 꽉차 있는지 확인
	return FALSE;
}

Boolean Stack_push (Stack* _this, Element anElement) { //Stack push
	Node* addedNode=Node_new ();
	Node_setElement (addedNode, anElement);
	Node_setNext (addedNode, _this->_top);
	_this->_top=addedNode;
	_this->_size++;
	return TRUE;
}

Element Stack_pop (Stack* _this) {  //Stack pop
	Element poppedElement;
	Node* poppedNode=_this->_top; 
	poppedElement=Node_element (poppedNode); 
	_this->_top=Node_next (poppedNode); 
	Node_delete (poppedNode); _this->_size--; 
	return  poppedElement;
}

int Stack_size (Stack* _this) {
	return _this->_size;
}

Element Stack_topElement (Stack* _this) { //Stack peek
	return Node_element (_this->_top);
}

Element Stack_elementAt (Stack* _this, int anOrder) { // elementAt 구현
	Node* ElementAt=_this->_top;
	for (int i=0; i < anOrder; i++) {
		ElementAt=Node_next (ElementAt);
	}
	return Node_element (ElementAt);
}

void Stack_reset (Stack* _this) {
	Stack_deleteLinkedNodesRecursively (_this, _this->_top);
	_this->_size=0;
	_this->_top=NULL;
}

void Stack_deleteLinkedNodesRecursively (Stack* _this, Node* firstNode) {
	if (firstNode != NULL) {
		Stack_deleteLinkedNodesRecursively (_this, Node_next (firstNode));
		Node_delete (firstNode);
	}
}