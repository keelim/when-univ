#include "Object.h"

struct _Obejct{
    ObjectValue _value ;
};

Object *Object_new(void) {
    return NULL;
}

Object *Object_newWith(ObjectValue aValue) {
    return NULL;
}

void Object_delete(Object *_this) {

}

void Object_setValue(Object *_this, ObjectValue newValue) {

}

ObjectValue Object_value(Object *_this) {
    return 0;
}
