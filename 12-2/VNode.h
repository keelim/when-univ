#pragma once
#include "Common.h"

typedef struct _VNode VNode;
typedef int VElement;

VNode* VNode_new ();

//노드 객체를 생성
void VNode_delete (VNode* _this);

//노드 객체를 소멸

void VNode_setElement (VNode* _this, VElement newElement);

VElement VNode_element (VNode* _this);

void VNode_setNext (VNode* _this, VNode* newNext);

VNode* VNode_next (VNode* _this);
