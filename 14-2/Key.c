#include "Key.h"

struct _Key{
    KeyValue _value ;
};

Key *Key_new(void) {
    return NULL;
}

Key *Key_newWith(KeyValue aValue) {
    return NULL;
}

void Key_delete(Key *_this) {

}

void Key_setValue(Key *_this, KeyValue newValue) {

}

KeyValue Key_value(Key *_this) {
    return 0;
}

int Key_compareTo(Key *_this, Key *aKey) {
    return 0;
}
