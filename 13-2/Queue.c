#include "Queue.h" //배열로 구현


struct _Queue {
    //todo
};

Queue *Queue_new(int givenCapacity) {
    //todo
}


void Queue_delete(Queue *_this) { // There may be some elements in the queue.
//todo
}

Boolean Queue_isEmpty(Queue *_this) {
    if (_this->_size == 0) {
        return TRUE;
    } else {
        return FALSE;
    }
}

Boolean Queue_isFull(Queue *_this) {
    //todo
}

int Queue_size(Queue *_this) {
    //todo
}

Boolean Queue_add(Queue *_this, Element anElement) {
    //todo
}

Element Queue_remove(Queue *_this) {
    //todo
}

Element Queue_elementAt(Queue *_this, int anOrder) {
    //todo
}



