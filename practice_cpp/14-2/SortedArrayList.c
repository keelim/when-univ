#include "SortedArrayList.h"


struct _SortedArrayList {
    int _capacity;
    int _size;
    Element *_elements;
};

SortedArrayList *SortedArrayList_new(int givenCapacity) {
    SortedArrayList *_this = NewObject(SortedArrayList);
    _this->_capacity = givenCapacity;
    _this->_elements = NewVector(Element, _this->_capacity);
    _this->_size = 0;

    return _this;
}

void SortedArrayList_delete(SortedArrayList *_this) {
    free(_this);
}

Boolean SortedArrayList_isEmpty(SortedArrayList *_this) {
    return (_this->_size == 0);
}

Boolean SortedArrayList_isFull(SortedArrayList *_this) {
    return (_this->_size >= _this->_capacity);
}


/************************************ 정렬된 값 삽입 ***************************************/

Boolean SortedArrayList_add(SortedArrayList *_this, Element anElement) {
    if (SortedArrayList_isFull(_this)) {
        return FALSE;
    } else {
        // 제1단계: 삽입할 위치를 결정한다
        int positionForAdd = SortedArrayList_positionUsingBinarySearch(_this, anElement);
        // 제2단계: 찾아진 삽입 위치에 주어진 원소를 삽입한다
        SortedArrayList_addAt(_this, anElement, positionForAdd);
        return TRUE;
    }

}

int SortedArrayList_positionUsingBinarySearch(SortedArrayList *_this, Element anElement) {
    int left = 0;
    int right = _this->_size - 1;
    int mid;
    while (left <= right) {
        mid = (left + right) / 2;
        if (anElement == _this->_elements[mid]) {
            return mid;
        } else if (anElement < _this->_elements[mid]) {
            right = mid - 1;
        } else if (anElement > _this->_elements[mid]) {
            left = mid + 1;
        }
    }
    return left;
}


void SortedArrayList_addAt(SortedArrayList *_this, Element anElement, int aPosition) {
    for (int i = (_this->_size - 1); i > aPosition; i--) {
        _this->_elements[i + 1] = _this->_elements[i];
    }
    _this->_elements[aPosition] = anElement;
    (_this->_size)++;
}


/************************************ 정렬된 값에서 최대 값 제거 ***************************************/
Element SortedArrayList_removeMax(SortedArrayList *_this) {
    int maxPosition;

    maxPosition = SortedArrayList_removeAt(_this, _this->_size - 1);

    return maxPosition;

}


Element SortedArrayList_removeAt(SortedArrayList *_this, int aPosition) {
    Element removeElement = _this->_elements[aPosition];

    for (int i = aPosition + 1; i < _this->_size; i++) {
        _this->_elements[i - 1] = _this->_elements[i];
    }
    _this->_size--;

    return removeElement;

}


/************************************ 정렬된 값에서 최소 값 반환 ***************************************/
Element SortedArrayList_min(SortedArrayList *_this) {
    int min;

    min = _this->_elements[0];

    return min;
}




