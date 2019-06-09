#pragma once
#include "Key.h"
#include "Object.h"

typedef struct _BinaryNode BinaryNode;

BinaryNode *BinaryNode_new(); // 기본 생성자
BinaryNode *BinaryNode_newWith(Key *aKey, Object *anObject, BinaryNode *aLeft, BinaryNode *aRight);

// 속성 값이 주어지는 생성자
void BinaryNode_delete(BinaryNode *_this);

void BinaryNode_setKey(BinaryNode *_this, Key *aKey);

Key *BinaryNode_key(BinaryNode *_this);

void BinaryNode_setObject(BinaryNode *_this, Object *anObject);

Object *BinaryNode_object(BinaryNode *_this);

void BinaryNode_setLeft(BinaryNode *_this, BinaryNode *aLeft);

BinaryNode *BinaryNode_left(BinaryNode *_this);

BinaryNode *BinaryNode_right(BinaryNode *_this);

void BinaryNode_setRight(BinaryNode *_this, BinaryNode *aLeft);