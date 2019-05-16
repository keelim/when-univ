#pragma once
#include "SortedLinkedList.h"


struct _SortedLinkedList {
	int _size;
	Node *_head;
};

SortedLinkedList *SortedLinkedList_new() {
	SortedLinkedList *_this = NewObject(SortedLinkedList);
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

Boolean SortedLinkedList_add(SortedLinkedList *_this, Element anElement) { //앞에 추가 되는 것이 크다 생각을 하면 된다. 
	if (SortedLinkedList_isFull(_this)) {
		return FALSE;
	}
	else {
		Node* addNode = Node_new();
		if (SortedLinkedList_isEmpty(_this)) {
			_this->_head = addNode;
		}
		else {
			Node* current = _this->_head;
			Node* previous = NULL;
			while (current != NULL) {
				if (Node_element(current) > Node_element(previous)) {
					break;
				}
				previous = current;
				current = Node_next(current);
			}
			if (previous == NULL) {
				Node_setNext(addNode, _this->_head);
				_this->_head = addNode;
			}
			else {
				Node_setNext(addNode, current);
				_this->_head = addNode;
			}
		}
		_this->_size++;
		return TRUE;
	}

}

Element SortedLinkedList_min(SortedLinkedList *_this) { //사이즈 1일 떄를 고려를 하는 것
	if (SortedLinkedList_isEmpty(_this)) {
		return 0;
	}
	else {
		return Node_element(_this->_head);
	}
}

Element SortedLinkedList_removeMax(SortedLinkedList *_this) {
	if (SortedLinkedList_isEmpty(_this)) {
		return 0;
	}
	else if(_this->_size == 1) {
		Node* removedNode = NULL;
		Element removedElement;

		if (_this->_head != NULL) {
			removedNode = _this->_head;
			_this->_head = Node_next(_this->_head);
			removedElement = Node_element(removedNode);
			Node_delete(removedNode);
			return removedElement;
		}
		
	}
	else {

	}
	_this->_size--;
	
}
