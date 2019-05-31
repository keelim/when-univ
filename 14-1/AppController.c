#include "AppController.h"
//todo
struct _AppController {
    Dictionary *_dictionary;
};

AppController *AppController_new() {
    AppController *_this = NewObject(AppController);
    _this->_dictionary = Dictionary_new();
    return _this;
}

void AppController_delete(AppController *_this) {
    Dictionary_delete(_this->_dictionary);
    free(_this);
}

void AppController_showInternalShapeOfBinaryTree(AppController *_this, Traverse *aTraverse) {
    Dictionary_scanInSortedOrder(_this->_dictionary, aTraverse);
}

void AppController_run(AppController* _this){

}
