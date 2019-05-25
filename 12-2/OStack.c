#pragma once

#include "OStack.h"

struct _OStack {
	int _size;
	ONode* _top;
};

void OStack_deleteLinkedNodes (OStack* _this);

void OStack_deleteLinkedNodesRecursively (OStack* _this, ONode* node);

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
	return _this->_size == 0;
}

Boolean OStack_isFull (OStack* _this) { //Stack 꽉차 있는지 확인
	return FALSE;
}

Boolean OStack_push (OStack* _this, ElementForOStack anElement) { //Stack push
    ONode* addedNode=ONode_new ();
	ONode_setElement (addedNode, anElement);
	ONode_setNext (addedNode, _this->_top);
	_this->_top=addedNode;
	_this->_size++;
	return TRUE;
}

ElementForOStack OStack_pop (OStack* _this) {  //Stack pop
    ElementForOStack poppedElement;
	ONode* poppedNode=_this->_top;
	poppedElement=ONode_element (poppedNode);
	_this->_top=ONode_next (poppedNode);
	ONode_delete (poppedNode); _this->_size--;
	return  poppedElement;
}

int OStack_size (OStack* _this) {
	return _this->_size;
}

ElementForOStack OStack_topElement (OStack* _this) { //Stack peek
	if (OStack_isEmpty (_this)) {
		return -1;
	}
	else {
		return ONode_element (_this->_top);
	}
	
}

ElementForOStack OStack_elementAt (OStack* _this, int anOrder) { // elementAt 구현
    ONode* ElementAt=_this->_top;
	for (int i=0; i < anOrder; i++) {
		ElementAt=ONode_next (ElementAt);
	}
	return ONode_element (ElementAt);
}

void OStack_reset (OStack* _this) {
    OStack_deleteLinkedNodesRecursively (_this, _this->_top);
	_this->_size=0;
	_this->_top=NULL;
}

void OStack_deleteLinkedNodesRecursively (OStack* _this, ONode* firstNode) {
	if (firstNode != NULL) {
        OStack_deleteLinkedNodesRecursively (_this, ONode_next (firstNode));
		ONode_delete (firstNode);
	}
}