#pragma once
#include "Common.h"

typedef struct _ONode ONode;
typedef char ElementForOStack ;

ONode* ONode_new ();

//노드 객체를 생성
void ONode_delete (ONode* _this);

//노드 객체를 소멸

void ONode_setElement (ONode* _this, ElementForOStack newElement);

ElementForOStack ONode_element (ONode* _this);

void ONode_setNext (ONode* _this, ONode* newNext);

ONode* ONode_next (ONode* _this);
