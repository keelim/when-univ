#pragma once
#include "Common.h"

#define DEFAULT_STACK_CAPACITY 200
typedef int Element;

typedef struct _Stack Stack;

Stack* Stack_new ();

void Stack_delete (Stack* _this);

Boolean Stack_isEmpty (Stack* _this);

Boolean Stack_isFull (Stack* _this);

void Stack_push (Stack* _this, Element anElement);

Element Stack_pop (Stack* _this);

int Stack_size (Stack* _this);

Element Stack_topElement (Stack* _this); //스택의 Top 원소를 얻는다
//스택 자체는 변하지 않는다

Element Stack_elementAt (Stack* _this, int anOrder);

void Stack_reset (Stack* _this);

//스택 리스트의 anOrder 번째 원소를 얻는다

//Bottom 원소가 0 번째 순서


