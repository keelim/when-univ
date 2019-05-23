#pragma once
#include "OStack.h"

struct _OStack {
	int _size;
	Node* _top;
};

void OStack_deleteLinkedNodes (OStack* _this);

void OStack_deleteLinkedNodesRecursively (OStack* _this, Node* node);

OStack* OStack_new () { //Stack 생성
    OStack* _this;
	_this=NewObject (OStack);
	_this->_top=NULL; 
	_this->_size=0; 
	return _this;
}

void OStack_delete (OStack* _this) { //Stack delete
    OStack_deleteLinkedNodes (_this);
	free (_this);
}

void OStack_deleteLinkedNodes (OStack* _this) {
    OStack_deleteLinkedNodesRecursively (_this, _this->_top);

}

Boolean OStack_isEmpty (OStack* _this) { //Stack 비어 있는지 확인
	return ((_this->_top) < 0);
}

Boolean OStack_isFull (OStack* _this) { //Stack 꽉차 있는지 확인
	return FALSE;
}

Boolean OStack_push (OStack* _this, Element anElement) { //Stack push
	Node* addedNode=Node_new ();
	Node_setElement (addedNode, anElement);
	Node_setNext (addedNode, _this->_top);
	_this->_top=addedNode;
	_this->_size++;
	return TRUE;
}

Element OStack_pop (OStack* _this) {  //Stack pop
	Element poppedElement;
	Node* poppedNode=_this->_top; 
	poppedElement=Node_element (poppedNode); 
	_this->_top=Node_next (poppedNode); 
	Node_delete (poppedNode); _this->_size--; 
	return  poppedElement;
}

int OStack_size (OStack* _this) {
	return _this->_size;
}

Element OStack_topElement (OStack* _this) { //Stack peek
	return Node_element (_this->_top);
}

Element OStack_elementAt (OStack* _this, int anOrder) { // elementAt 구현
	Node* ElementAt=_this->_top;
	for (int i=0; i < anOrder; i++) {
		ElementAt=Node_next (ElementAt);
	}
	return Node_element (ElementAt);
}

void OStack_reset (OStack* _this) {
    OStack_deleteLinkedNodesRecursively (_this, _this->_top);
	_this->_size=0;
	_this->_top=NULL;
}

void OStack_deleteLinkedNodesRecursively (OStack* _this, Node* firstNode) {
	if (firstNode != NULL) {
        OStack_deleteLinkedNodesRecursively (_this, Node_next (firstNode));
		Node_delete (firstNode);
	}
}