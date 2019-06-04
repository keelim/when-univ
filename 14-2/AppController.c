#include "AppController.h"


#define MIN_TEST_SIZE 1000
#define NUMBER_OF_TESTS 5
#define INTERVAL_SIZE 1000

struct _AppController{
    int* _testData;
    Timer* _timer;
};


AppController *AppController_new(void) {
    AppController* _this=NewObject (AppController);
    return _this;
}

void AppController_delete(AppController *_this) {
    free (_this->_testData);
    Timer_delete (_this->_timer);
    free (_this);
}

void AppController_run(AppController *_this) {
    //todo 작성
}

void AppController_generateTestDataByRandomNumbers(AppController *_this) {
    int maxTestSize=MIN_TEST_SIZE + INTERVAL_SIZE * (NUMBER_OF_TESTS - 1);
    srand ((unsigned)time(NULL));

    for (int i=0; i < maxTestSize; i++) {
        _this->_testData[i]=rand ();
    }
}

double
AppController_timeForArrayDictionary_add(AppController *_this, SortedArrayDictionary *aDictionary, int aTestSize) {
    return 0;
}

double AppController_timeForSortedArrayDictionary_search(AppController *_this, SortedArrayDictionary *aDictionary, int aTestSize) {
    return 0;
}

double AppController_timeForSortedArrayDictionary_remove(AppController *_this, SortedArrayDictionary *aDictionary, int aTestSize) {
    return 0;
}

double AppController_timeForSortedLinkedDictionary_add(AppController *_this, SortedLinkedDictionary *aDictionary,
                                                       int aTestSize) {
    return 0;
}

double AppController_timeForSortedLinkedDictionary_search(AppController *_this, SortedLinkedDictionary *aDictionary,
                                                          int aTestSize) {
    return 0;
}

double AppController_timeForSortedLinkedDictionary_remove(AppController *_this, SortedLinkedDictionary *aDictionary,
                                                          int aTestSize) {
    return 0;
}

double AppController_timeForUnsortedArrayDictionary_add(AppController *_this, UnsortedArrayDictionary *aDictionary,
                                                        int aTestSize) {
    return 0;
}

double AppController_timeForUnsortedArrayDictionary_search(AppController *_this, UnsortedArrayDictionary *aDictionary,
                                                           int aTestSize) {
    return 0;
}

double AppController_timeForunsortedArrayDictionary_remove(AppController *_this, UnsortedArrayDictionary *aDictionary,
                                                           int aTestSize) {
    return 0;
}

double AppController_timeForUnsortedLinkedDictionary_add(AppController *_this, UnsortedLinkedDictionary *aDictionary,
                                                         int aTestSize) {
    return 0;
}

double AppController_timeForunsortedLinkedDictionary_search(AppController *_this, UnsortedLinkedDictionary *aDictionary,
                                                            int aTestSize) {
    return 0;
}

double AppController_timeForUnsortedLinkedDictionary_remove(AppController *_this, UnsortedLinkedDictionary *aDictionary,
                                                            int aTestSize) {
    return 0;
}

double
AppController_timeForBinarySearchTreeDictionary_add(AppController *_this, BinarySearchTreeDictionary *aDictionary,
                                                    int aTestSize) {
    return 0;
}

double
AppController_timeForBinarySearchTreeDictionary_search(AppController *_this, BinarySearchTreeDictionary *aDictionary,
                                                       int aTestSize) {
    return 0;
}

double
AppController_timeForBinarySearchTreeDictionary_remove(AppController *_this, BinarySearchTreeDictionary *aDictionary,
                                                       int aTestSize) {
    return 0;
}

void AppController_showResults(AppController *_this, int aTestSize, double aTimeForAdd, double aTimeForMin,
                               double aTimeForRemoveMax) {

}
