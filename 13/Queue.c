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

void Queue_deleteLinkedChain(Queue *_this) { // linked chain 의 모든 노드를 차례로 소거한다.
    // 노드도 객체이므로 하나의 노드를 소거할 때, Node_delete() 를 사용.

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
    //todo
    return FALSE;
}

Element Queue_remove(Queue *_this) {
    //todo
    return 0;
}

Element Queue_elementAt(Queue *_this, int anOrder) {

    return 0;
}



