#include "UnsortedArrayDictionary.h"

struct _UnsortedArrayDictionary {
    int _capacity;
    int _size;
    Element *_elements;
};

UnsortedArrayDictionary *UnsortedArrayDictionary_new(int givenCapacity) {
    UnsortedArrayDictionary *_this = NewObject(UnsortedArrayDictionary);
    _this->_capacity = givenCapacity;
    _this->_elements = NewVector(Element, _this->_capacity);
    _this->_size = 0;
    return _this;
}

void UnsortedArrayDictionary_delete(UnsortedArrayDictionary *_this) {
    free(_this);
}


Boolean UnsortedArrayDictionary_isEmpty(UnsortedArrayDictionary *_this) {
    if (_this->_size == 0)
        return TRUE;
    else
        return FALSE;
}

Boolean UnsortedArrayDictionary_isFull(UnsortedArrayDictionary *_this) {
    if (_this->_size == _this->_capacity)
        return TRUE;
    else
        return FALSE;

}

Boolean UnsortedArrayDictionary_add(UnsortedArrayDictionary *_this, Element anElement) {
    if (UnsortedArrayDictionary_isFull(_this)) {
        return FALSE;
    } else {
        _this->_elements[_this->_size] = anElement;
        (_this->_size)++;
        return TRUE;
    }
}

Element UnsortedArrayDictionary_removeMax(UnsortedArrayDictionary *_this) {
    int maxPosition;
    Element max;
    maxPosition = UnsortedArrayDictionary_maxPositionRecursively(_this, 0, _this->_size - 1);
    max = UnsortedArrayDictionary_removeAt(_this, maxPosition);
    return max;

}

int UnsortedArrayDictionary_maxPositionRecursively(UnsortedArrayDictionary *_this, int left, int right) {
    if (left == right) { // data의 크기가 1
        return left;
    } else { // data의 크기가 2 이상
        int mid = (left + right) / 2;
        int maxPositionOfLeftPart = UnsortedArrayDictionary_maxPositionRecursively(_this, left, mid);
        int maxPositionOfRightPart = UnsortedArrayDictionary_maxPositionRecursively(_this, mid + 1, right);
        if (_this->_elements[maxPositionOfLeftPart] >= _this->_elements[maxPositionOfRightPart]) {
            return maxPositionOfLeftPart;
        } else {
            return maxPositionOfRightPart;
        }
    }
}

Element UnsortedArrayDictionary_removeAt(UnsortedArrayDictionary *_this, int aPosition) {
    // aPosition 의 값은 반드시 _this->_size의 값보다 작아야 한다
    Element removedElement = _this->_elements[aPosition];
    for (int i = (aPosition + 1); i < (_this->_size); i++) {
        _this->_elements[i - 1] = _this->_elements[i];
    }
    _this->_size--;
    return removedElement;
}


/************************************ 최소 값 얻기 ***************************************/
Element UnsortedArrayDictionary_min(UnsortedArrayDictionary *_this) {
    int minPosition;
    minPosition = UnsortedArrayDictionary_minPositionRecursively(_this, 0, _this->_size - 1);
    return _this->_elements[minPosition];
}


int UnsortedArrayDictionary_minPositionRecursively(UnsortedArrayDictionary *_this, int left, int right) {
    if (left == right) { // data의 크기가 1
        return left;
    } else { // data의 크기가 2 이상
        int mid = (left + right) / 2;
        int minPositionOfLeftPart = UnsortedArrayDictionary_maxPositionRecursively(_this, left, mid);
        int minPositionOfRightPart = UnsortedArrayDictionary_maxPositionRecursively(_this, mid + 1, right);
        if (_this->_elements[minPositionOfLeftPart] <= _this->_elements[minPositionOfRightPart]) {
            return minPositionOfLeftPart;
        } else {
            return minPositionOfRightPart;
        }
    }
}

int UnsortedArrayDictionary_positionUsingBinarySearch(UnsortedArrayDictionary *_this, Element anElement) {

}

Boolean UnsortedArrayDictionary_search(UnsortedArrayDictionary *_this, Element anElement) {
    int i = 0;
    while (i < sizeof(_this->_elements)){
        if (_this->_elements[i] == anElement) {
            return TRUE;
        }
		i++;
    }
    return FALSE;
}
