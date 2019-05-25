#pragma once

#include "VStack.h"

struct _VStack {
	int _size;
	VNode* _top;
};

void VStack_deleteLinkedNodes (VStack* _this);

void VStack_deleteLinkedNodesRecursively (VStack* _this, VNode* node);

VStack* VStack_new () { //Stack 생성
	VStack* _this;
	_this=NewObject (VStack);
	_this->_top=NULL; 
	_this->_size=0; 
	return _this;
}

void VStack_delete (VStack* _this) { //Stack delete
	VStack_deleteLinkedNodes (_this);
	free (_this);
}

void VStack_deleteLinkedNodes (VStack* _this) {
	VStack_deleteLinkedNodesRecursively (_this, _this->_top);

}

Boolean VStack_isEmpty (VStack* _this) { //Stack 비어 있는지 확인
	return ((_this->_top) < 0);
}

Boolean VStack_isFull (VStack* _this) { //Stack 꽉차 있는지 확인
	return FALSE;
}

Boolean VStack_push (VStack* _this, ElementForVStack anElement) { //Stack push
	VNode* addedNode=VNode_new ();
	VNode_setElement (addedNode, anElement);
	VNode_setNext (addedNode, _this->_top);
	_this->_top=addedNode;
	_this->_size++;
	return TRUE;
}

ElementForVStack VStack_pop (VStack* _this) {  //Stack pop
    ElementForVStack poppedElement;
	VNode* poppedNode=_this->_top;
	poppedElement=VNode_element (poppedNode);
	_this->_top=VNode_next (poppedNode);
	VNode_delete (poppedNode); _this->_size--;
	return  poppedElement;
}

int VStack_size (VStack* _this) {
	return _this->_size;
}

ElementForVStack VStack_topElement (VStack* _this) { //Stack peek
	return VNode_element (_this->_top);
}

ElementForVStack VStack_elementAt (VStack* _this, int anOrder) { // elementAt 구현
	VNode* ElementAt=_this->_top;
	for (int i=0; i < anOrder; i++) {
		ElementAt=VNode_next (ElementAt);
	}
	return VNode_element (ElementAt);
}

void VStack_reset (VStack* _this) {
	VStack_deleteLinkedNodesRecursively (_this, _this->_top);
	_this->_size=0;
	_this->_top=NULL;
}

void Stack_deleteLinkedNodesRecursively (VStack* _this, VNode* firstNode) {
	if (firstNode != NULL) {
		Stack_deleteLinkedNodesRecursively (_this, VNode_next (firstNode));
		VNode_delete (firstNode);
	}
}