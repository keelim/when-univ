#include "Queue.h"

struct _Queue {
	int _size; 
	Node* _rear;
	Node* _front;
};

Queue* Queue_new () {
	Queue* _this;
	_this=NewObject (Queue);
	_this->_size=0;
	_this->_rear=NULL;
	return _this; 
}

void  Queue_deleteLinkedNodesRecursively (Queue* _this, Node* firstNode) { //재귀적으로 종료를 한다.
	if (firstNode != NULL) {
		Queue_deleteLinkedNodesRecursively (_this, Node_next (firstNode));
		Node_delete (firstNode);
	}
}

void Queue_deleteLinkedChain (Queue* _this) { 
	// linked chain 의 모든 노드를 차례로 소거한다.
	// 노드도 객체이므로 하나의 노드를 소거할 때, Node_delete() 를 사용.
	Queue_deleteLinkedNodesRecursively (_this, _this->_rear);
}


void Queue_delete (Queue* _this) { // There may be some elements in the queue.
	Queue_deleteLinkedChain (_this);
	free (_this);
}

Boolean Queue_isEmpty (Queue* _this) {
	if (_this->_size == 0) {
		return TRUE;
	}
	else {
		return FALSE;
	}
}

Boolean Queue_isFull (Queue* _this) {
	return FALSE;
}

int Queue_size (Queue* _this) {
	return _this->_size;
}

Boolean Queue_add (Queue* _this, Element anElement) { //노드적 add 
	Node* newRearNode=Node_new ();
	Node_setElement (newRearNode, anElement);
	Node_setNext (newRearNode, NULL);
	if (Queue_isEmpty (_this)) {
		_this->_rear =newRearNode;
		_this->_front = newRearNode;
	}
	else {
		Node_setNext (_this->_rear, newRearNode);
		_this->_rear=Node_next (_this->_rear);
	}

	_this->_size++;
	

	return TRUE;
}

Element Queue_remove (Queue* _this) { //노드적 remove
	Element frontElement;
	if (Queue_isEmpty (_this)) {
		return FALSE;
	}
	else if (Queue_size (_this) == 1) {
		Element anElement=Node_element (_this->_front);

		Node* deleteNode=_this->_front;
		Node_delete (deleteNode);
		_this->_front=NULL;
		_this->_rear=NULL;
		_this->_size--;

		return anElement;

			
	}
	else {
		Element anElement=Node_element (_this->_front);

		Node* deleteNode=_this->_front;
		_this->_front=Node_next (_this->_front);
		Node_delete (deleteNode);
		_this->_size--;

		return anElement;
	}
	return frontElement;
}

Element Queue_elementAt (Queue* _this, int anOrder) {
	Node* anOrderNode=Node_new ();
	anOrderNode=Node_next (_this->_rear);
	for (int i=0; i < anOrder; i++) {
		anOrderNode=Node_next (anOrderNode);
	}
	return Node_element (anOrderNode);
}



