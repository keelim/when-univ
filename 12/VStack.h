#pragma once

#include "Common.h"

#define DEFAULT_STACK_CAPACITY 5
typedef int Element;

typedef struct _VStack VStack;

VStack *VStack_new();

void VStack_delete(VStack *_this);

Boolean VStack_isEmpty(VStack *_this);

Boolean VStack_isFull(VStack *_this);

Boolean VStack_push(VStack *_this, Element anElement);

Element VStack_pop(VStack *_this);

int VStack_size(VStack *_this);

Element VStack_topElement(VStack *_this); //스택의 Top 원소를 얻는다
//스택 자체는 변하지 않는다

Element VStack_elementAt(VStack *_this, int anOrder);

void VStack_reset(VStack *_this);

//스택 리스트의 anOrder 번째 원소를 얻는다

//Bottom 원소가 0 번째 순서


