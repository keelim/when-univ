#pragma once
#include "SortedLinkedList.h"


struct _SortedLinkedList {
	int _size;
	Node* _head;
};

SortedLinkedList* SortedLinkedList_new () {
	SortedLinkedList* _this=NewObject (SortedLinkedList);
	_this->_head=NULL;
	_this->_size=0;
	return _this;
}

void SortedLinkedList_delete (SortedLinkedList* _this) {
	free (_this);
}

Boolean SortedLinkedList_isEmpty (SortedLinkedList* _this) {
	Boolean flag=FALSE;
	if (_this->_size == 0) {
		flag=TRUE;
	}
	return flag;

}

Boolean SortedLinkedList_isFull (SortedLinkedList* _this) {
	return FALSE;
}

Boolean SortedLinkedList_add (SortedLinkedList* _this, Element anElement) { //앞에 추가 되는 것이 크다 생각을 하면 된다. 
	Node* currentNode;
	Node* addedNode=Node_new ();
	Node_setElement (addedNode, anElement);
	Node_setNext (addedNode, NULL);


	if (SortedLinkedList_isEmpty (_this)) {			// 
		_this->_head=addedNode;
		_this->_size++;

		return TRUE;
	}
	else if (Node_element (_this->_head) >= anElement) {//  _this->_head 

		Node_setNext (addedNode, _this->_head);
		_this->_head=addedNode;
		_this->_size++;

		return TRUE;
	} 
	else {
		Node* previous=_this->_head;
		currentNode=Node_next (_this->_head);

		while (currentNode != NULL) {

			if (anElement > Node_element (currentNode)) {
				previous=currentNode;
				currentNode=Node_next (currentNode);

			}
			else {
				//Node* temp = Node_next(currentNode);
				Node_setNext (previous, addedNode);
				Node_setNext (addedNode, currentNode);
				_this->_size++;
				return TRUE;
			}

		}
		Node_setNext (previous, addedNode);
		// �������� ��带 �߰��Ѵ�.

		_this->_size++;

		return TRUE;
	}
}

Element SortedLinkedList_min (SortedLinkedList* _this) { //사이즈 1일 떄를 고려를 하는 것
	if (SortedLinkedList_isEmpty (_this)) {
		return 0;
	}
	else {
		return Node_element (_this->_head);
	}
}

Element SortedLinkedList_removeMax (SortedLinkedList* _this) {
	if (SortedLinkedList_isEmpty (_this)) {
		return 0;
	}
	else if (_this->_size == 1) {
		Node* removedNode=NULL;
		Element removedElement;

		if (_this->_head != NULL) {
			removedNode=_this->_head;
			_this->_head=Node_next (_this->_head);
			removedElement=Node_element (removedNode);
			Node_delete (removedNode);
			return removedElement;
		}

	}
	else {
		Node* removedNode=_this->_head;
		for (int i=0; i < _this->_size - 1; i++) {
			removedNode=Node_next (removedNode);
		}
		return Node_element (removedNode);

	}
	_this->_size--;

}
