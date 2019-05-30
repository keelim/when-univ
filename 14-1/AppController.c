#include "AppController.h"


void AppController_showInternalShapeOfBinaryTree(AppController *_this, Traverse *aTraverse) {
    Dictionary_scanInSortedOrder (_this->_dictionary, aTraverse) ;
}
