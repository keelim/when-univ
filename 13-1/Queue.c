#include "Queue.h"

struct _Queue {
    int _size; // 필요할 경우에만
    Node *_front;
    Node *_rear;
};

Queue *Queue_new() {
    Queue *_this;
    _this = NewObject(Queue);
    _this->_size = 0;
    _this->_front = NULL;
    _this->_rear = NULL;
    return _this; // At this point, q points an empty queue.
}

void  Queue_deleteLinkedNodesRecursively(Queue* _this, Node* firstNode){
    if (firstNode != NULL) {
        Queue_deleteLinkedNodesRecursively (_this, Node_next (firstNode));
        Node_delete (firstNode);
    }
}

void Queue_deleteLinkedChain(Queue *_this) { // linked chain 의 모든 노드를 차례로 소거한다.
    // 노드도 객체이므로 하나의 노드를 소거할 때, Node_delete() 를 사용.
    Queue_deleteLinkedNodesRecursively (_this, _this->_front);
}


void Queue_delete(Queue *_this) { // There may be some elements in the queue.
    Queue_deleteLinkedChain(_this);
    free(_this);
}

Boolean Queue_isEmpty(Queue *_this) {
    if (_this->_size == 0) {
        return TRUE;
    } else {
        return FALSE;
    }
}

Boolean Queue_isFull(Queue *_this) {
    return FALSE;
}

int Queue_size(Queue *_this) {
    return _this->_size;
}

Boolean Queue_add(Queue *_this, Element anElement) {
    Node *newRearNode;
    Node_setElement(newRearNode, anElement);
    Node_setNext(newRearNode, NULL);
    if (Queue_isEmpty(_this)) {
        _this->_front = newRearNode;
    } else {
        Node_setNext(newRearNode, Node_next(_this->_rear));
        Node_setNext(_this->_rear, newRearNode);
    }
    _this->_rear = newRearNode;
    _this->_size++;
    return TRUE;
}

Element Queue_remove(Queue *_this) {
    Element frontElement = NULL;
    frontElement = Node_element(Node_next(_this->_rear));
    if (!Queue_isEmpty(_this)) {
        if (_this->_rear == Node_next(_this->_rear)) {
            _this->_rear = NULL;
        } else {
            Node_setNext(_this->_rear, Node_next(_this->_rear));
        }
        _this->_size--;
    }
    return frontElement;
}

Element Queue_elementAt(Queue *_this, int anOrder) {
    Node *anOrderNode = Node_new();
    anOrderNode = Node_next(_this->_rear);
    for (int i = 0; i < anOrder; i++) {
        anOrderNode = Node_next(anOrderNode);
    }
    return Node_element(anOrderNode);
}



