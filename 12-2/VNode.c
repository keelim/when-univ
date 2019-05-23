#pragma once
#include "VNode.h"

struct _VNode {
	VElement _element;
	VNode* _next;
};

VNode* VNode_new () {
	VNode* _this=NewObject (VNode);
	return _this;
}

void VNode_delete (VNode* _this) {
	free (_this);
}

void VNode_setElement (VNode* _this, VElement newElement) {
	_this->_element=newElement;
}

VElement VNode_element (VNode* _this) {
	return _this->_element;
}

void VNode_setNext (VNode* _this, VNode* newNext) {
	_this->_next=newNext;
}

VNode* VNode_next (VNode* _this) {
	return _this->_next;
}

