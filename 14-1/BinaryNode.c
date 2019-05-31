#include "BinaryNode.h"

struct _BinaryNode {
    Key *_key;
    Object *_object;
    BinaryNode *_left;
    BinaryNode *_right;
};

BinaryNode *BinaryNode_new(Key *key, Object *pObject, void *pVoid, void *pVoid1) {
    //todo
}

BinaryNode *BinaryNode_newWith(Key *aKey, Object *anObject, BinaryNode *aLeft, BinaryNode *aRight) {
    //todo
}

void BinaryNode_delete(BinaryNode *_this) {
    Key_delete(_this->_key);
    Object_delete(_this->_object);
    free(_this->_left);
    free(_this->_right);
}

void BinaryNode_setKey(BinaryNode *_this, Key *aKey) {
    _this->_key = aKey;
}

Key *BinaryNode_key(BinaryNode *_this) {
    return _this->_key;
}

void BinaryNode_setObject(BinaryNode *_this, Object *anObject) {
    _this->_object = anObject;
}

Object *BinaryNode_object(BinaryNode *_this) {
    return _this->_object;
}

void BinaryNode_setLeft(BinaryNode *_this, BinaryNode *aLeft) {
    _this->_left = aLeft;
}

BinaryNode *BinaryNode_left(BinaryNode *_this) {
    return _this->_left;
}

void BinaryNode_setRight(BinaryNode *_this, BinaryNode *aRight) {
    _this->_right = aRight;
}

BinaryNode *BinaryNode_right(BinaryNode *_this) {
    return _this->_right;
}
