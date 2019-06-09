#include "UnsortedLinkedList.h"


struct _UnsortedLinkedList {
    int _size;
    Node *_head;
};

UnsortedLinkedList *UnsortedLinkedList_new() {
    UnsortedLinkedList *_this = NewObject (UnsortedLinkedList);
    _this->_head = NULL;
    _this->_size = 0;
    return _this;
}

void UnsortedLinkedList_delete(UnsortedLinkedList *_this) {
    free(_this);
}

Boolean UnsortedLinkedList_isEmpty(UnsortedLinkedList *_this) {

    if (_this->_size == 0) {
        return TRUE;
    } else {
        return FALSE;
    }
}

Boolean UnsortedLinkedList_isFull(UnsortedLinkedList *_this) {
    return FALSE;
}

Boolean UnsortedLinkedList_add(UnsortedLinkedList *_this, Element anElement) {

    Node *addNode;
    addNode = Node_new();
    Node_setElement(addNode, anElement);
    Node_setNext(addNode, _this->_head);
    _this->_head = addNode;
    _this->_size++;

    return TRUE;
}

Element UnsortedLinkedList_min(UnsortedLinkedList *_this) {
    Node *currentNode = _this->_head;
    Element min = Node_element(currentNode);

    while (currentNode != NULL) {
        if (Node_element(currentNode) < min) {
            min = Node_element(currentNode);
        }
        currentNode = Node_next(currentNode);
    }
    return min;
}

Element UnsortedLinkedList_removeMax(UnsortedLinkedList *_this) {
    // 리스트가 비어있다면
    if (UnsortedLinkedList_isEmpty(_this)) {
        return 0;
    } else {
        // 최댓값을 찾아 저장한다.
        Element max = Node_element(_this->_head);

        Node *previousOfMax = _this->_head; // 최대값 이전 노드를 가리키기 위한 노드.
        Node *currentNode = _this->_head;
        Node *nextNode = Node_next(_this->_head);

        // 연결 리스트가 비어있는경우
        if (_this->_size == 0) {
            return 0;
        } else {
            // 현재 노드의 다음노드가 NULL 이 아닌동안
            while (Node_next(currentNode) != NULL) {
                nextNode = Node_next(currentNode); // nextNode : 다음노드 값으로 이동

                // 다음노드 값이 더 큰 값이면
                if (max < Node_element(nextNode)) {
                    max = Node_element(nextNode);
                    previousOfMax = currentNode; //previousOfMax 는 맥스 값이 바뀔때마다 갱신.(만약 처음 값이 제일 크다면 _this->_head에)
                }
                currentNode = Node_next(currentNode); // 현재 노드를 다음노드로 이동.
            }

            // 현재 while 문을 빠져나오면 max 노드가 정해져있다.(여기서 맨 처음 노드인지만 확인하여 조건문)
            // previousOfMax 값이 맨 처음인 경우
            if (max == Node_element(previousOfMax)) // previousOfMax == _this->head 조건문을 쓰게되면 max값이 1번째, 2번째가 같음.
            {
                _this->_head = Node_next(previousOfMax);
                Node_delete(previousOfMax); // previousOfMax를 제거(맥스 값이 있는 노드)
            } else {
                Node *tmpNode = Node_next(previousOfMax); // 삭제하는 노드를 잠시 저장.
                Node_setNext(previousOfMax, Node_next(Node_next(previousOfMax))); // 노드의 다다음 노드로 연결.
                Node_delete(tmpNode); // tmpNode를 제거(맥스 값이 있는 노드)
            }

            _this->_size--;

            return max;
        }
    }
}

Boolean UnsortedLinkedList_search(UnsortedLinkedList *_this, Element anElement) {
    Node* pointer = _this->_head;
    while(pointer != NULL){
        if(Node_element(pointer) == anElement){
            return TRUE;
        }
        pointer = Node_next(pointer);
    }
    return FALSE;
}

Element UnsortedLinkedList_remove(UnsortedLinkedList *_this, Element anElement) {
    //first Node delete
    Node* pointer = _this->_head;
    Element removeElement = Node_element(pointer);
    _this->_head = Node_next(pointer);
    Node_delete(pointer);
    _this->_size--;

    return removeElement;
}
