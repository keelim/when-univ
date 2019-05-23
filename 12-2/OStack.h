#pragma once
#include "Common.h"
#include "ONode.h"

#define DEFAULT_STACK_CAPACITY 5

typedef struct _OStack OStack;

OStack* OStack_new ();

void OStack_delete (OStack* _this);

Boolean OStack_isEmpty (OStack* _this);

Boolean OStack_isFull (OStack* _this);

Boolean OStack_push (OStack* _this, Element anElement);

Element OStack_pop (OStack* _this);

int OStack_size (OStack* _this);

Element OStack_topElement (OStack* _this); //스택의 Top 원소를 얻는다
//스택 자체는 변하지 않는다

Element OStack_elementAt (OStack* _this, int anOrder);

void OStack_reset (OStack* _this);

//스택 리스트의 anOrder 번째 원소를 얻는다

//Bottom 원소가 0 번째 순서


