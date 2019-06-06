#include "Traverse.h"


struct _Traverse {
    Key *_key;
    Object *_object;
    int _depth;
};


Traverse *Traverse_new() {
    Traverse *_this = NewObject(Traverse);
    _this->_key = Key_new();
    _this->_object = Object_new();
    _this->_depth = 0;
    return _this;
}

void Traverse_delete(Traverse *_this) {
    Key_delete(_this->_key);
    Object_delete(_this->_object);
    free(_this);
}

void Traverse_visit(Traverse *_this, Key* aKey, Object *anObject, int aDepth) {
	_this->_key = aKey;
	_this->_object = anObject;
	_this->_depth = aDepth;
	AppView_out_traverseDisplay(_this->_key, _this->_depth);
}
