#pragma once

#include "Common.h"

typedef struct _UnsortedArrayDictionary UnsortedArrayDictionary;

UnsortedArrayDictionary *UnsortedArrayDictionary_new(int givenCapacity);

void UnsortedArrayDictionary_delete(UnsortedArrayDictionary *_this);

Boolean UnsortedArrayDictionary_isEmpty(UnsortedArrayDictionary *_this);

Boolean UnsortedArrayDictionary_isFull(UnsortedArrayDictionary *_this);

Boolean UnsortedArrayDictionary_add(UnsortedArrayDictionary *_this, Element anElement);

Element UnsortedArrayDictionary_min(UnsortedArrayDictionary *_this);

Element UnsortedArrayDictionary_removeMax(UnsortedArrayDictionary *_this);

int UnsortedArrayDictionary_maxPositionRecursively(UnsortedArrayDictionary *_this, int left, int right);

int UnsortedArrayDictionary_minPositionRecursively(UnsortedArrayDictionary *_this, int left, int right);

Element UnsortedArrayDictionary_removeAt(UnsortedArrayDictionary *_this, int aPosition);

int UnsortedArrayDictionary_positionUsingBinarySearch(UnsortedArrayDictionary *_this, Element anElement);

Boolean UnsortedArrayDictionary_search(UnsortedArrayDictionary *_this, Element anElement);


