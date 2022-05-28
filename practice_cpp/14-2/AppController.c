#include "AppController.h"

#define MIN_TEST_SIZE 1000
#define NUMBER_OF_TESTS 5
#define INTERVAL_SIZE 1000

struct _AppController {
    int *_testData;
    Timer *_timer;
};


AppController *AppController_new(void) {
    AppController *_this = NewObject (AppController);
    return _this;
}

void AppController_delete(AppController *_this) {
    free(_this->_testData);
    free(_this);
}

void AppController_run(AppController *_this) {
    AppView_out(MSG_StartPerformanceMeasuring);

    int numberOfTests = NUMBER_OF_TESTS;
    int intervalSize = INTERVAL_SIZE;
    int maxTestSize = MIN_TEST_SIZE + INTERVAL_SIZE * (NUMBER_OF_TESTS - 1);

    _this->_testData = NewVector(int, maxTestSize);

    AppController_generateTestDataByRandomNumbers(_this);
    AppView_out(MSG_TitleForUnsortedArrayList);
    /////////////////////////////////////////////////////////UnSortedArrayList///////////////////////////////////////////////////////
    int testSize = MIN_TEST_SIZE;
    for (int i = 0; i < numberOfTests; i++) {
        UnsortedArrayList *listForTest = UnsortedArrayList_new(maxTestSize);
        double timeForAdd = AppController_timeForUnsortedArrayList_add(_this, listForTest, testSize);
        double timeForRemove = AppController_timeForUnsortedArrayList_remove(_this, listForTest, testSize);
        double timerForSearch = AppController_timeForUnsortedArrayList_search(_this, listForTest, testSize);
        AppController_showResults(_this, testSize, timeForAdd, timeForRemove, timerForSearch);
        UnsortedArrayList_delete(listForTest);
        testSize += intervalSize;
    }
    /////////////////////////////////////////////////////////UnSortedArrayList///////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////SortedArrayList///////////////////////////////////////////////////////
    AppView_out(MSG_TitleForsortedArrayList);

    int testSize1 = MIN_TEST_SIZE;
    for (int i = 0; i < numberOfTests; i++) {
        SortedArrayList *listForTest = SortedArrayList_new(maxTestSize);
        double timeForAdd = AppController_timeForSortedArrayList_add(_this, listForTest, testSize);
        double timeForRemove = AppController_timeForSortedArrayList_remove(_this, listForTest, testSize);
        double timerForSearch = AppController_timeForSortedArrayList_search(_this, listForTest, testSize);
        AppController_showResults(_this, testSize1, timeForAdd, timeForRemove, timerForSearch);
        SortedArrayList_delete(listForTest);
        testSize1 += intervalSize;
    }
    /////////////////////////////////////////////////////////SortedArrayList///////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////UnSortedLinkedList///////////////////////////////////////////////////////
    AppView_out(MSG_TitleForUnsortedLinkedList);

    int testSize2 = MIN_TEST_SIZE;
    for (int i = 0; i < numberOfTests; i++) {
        UnsortedLinkedList *listForTest = UnsortedLinkedList_new(maxTestSize);
        double timeForAdd = AppController_timeForUnsortedLinkedList_add(_this, listForTest, testSize);
        double timeForRemove = AppController_timeForUnsortedLinkedList_remove(_this, listForTest, testSize);
        double timerForSearch = AppController_timeForUnsortedLinkedList_search(_this, listForTest, testSize);
        AppController_showResults(_this, testSize2, timeForAdd, timeForRemove, timerForSearch);
        UnsortedLinkedList_delete(listForTest);
        testSize2 += intervalSize;
    }
    /////////////////////////////////////////////////////////UnSortedLinkedList///////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////SortedLinkedList///////////////////////////////////////////////////////
    AppView_out(MSG_TitleForsortedLinkedList);

    int testSize3 = MIN_TEST_SIZE;
    for (int i = 0; i < numberOfTests; i++) {
        SortedLinkedList *listForTest = SortedLinkedList_new(maxTestSize);
        double timeForAdd = AppController_timeForSortedLinkedList_add(_this, listForTest, testSize);
        double timeForRemove = AppController_timeForSortedLinkedList_remove(_this, listForTest, testSize);
        double timerForSearch = AppController_timeForSortedLinkedList_search(_this, listForTest, testSize);
        AppController_showResults(_this, testSize3, timeForAdd, timeForRemove, timerForSearch);
        SortedLinkedList_delete(listForTest);
        testSize3 += intervalSize;
    }
    /////////////////////////////////////////////////////////SortedLinkedList///////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////BinarySearchTreeDictionary///////////////////////////////////////////////////////
    AppView_out(MSG_TitleForBinarySearchTreeDictionary);
    int testSize4 = MIN_TEST_SIZE;
    for (int i = 0; i < numberOfTests; i++) {
        BinarySearchTreeDictionary *listForTest = BinarySearchTreeDictionary_new(maxTestSize);
        double timeForAdd = AppController_timeForBinarySearchTreeDictionary_add(_this, listForTest, testSize);
        double timeForRemove = AppController_timeForBinarySearchTreeDictionary_remove(_this, listForTest, testSize);
        double timerForSearch = AppController_timeForBinarySearchTreeDictionary_search(_this, listForTest, testSize);
        AppController_showResults(_this, testSize4, timeForAdd, timeForRemove, timerForSearch);
        BinarySearchTreeDictionary_delete(listForTest);
        testSize4 += intervalSize;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    AppView_out(MSG_EndPerformanceMeasuring);
}

void AppController_generateTestDataByRandomNumbers(AppController *_this) {
    int maxTestSize = MIN_TEST_SIZE + INTERVAL_SIZE * (NUMBER_OF_TESTS - 1);
    srand((unsigned) time(NULL));

    for (int i = 0; i < maxTestSize; i++) {
        _this->_testData[i] = rand();
    }
}

double AppController_timeForSortedArrayList_add(AppController *_this, SortedArrayList *aList, int aTestSize) {
    Timer *timer = Timer_new();
    double duration = 0;
	
    for (int i = 0; i < aTestSize; i++) {
        Timer_start(timer);
        BinaryNode_newWith(Key_newWith(_this->_testData[i]), Object_newWith(_this->_testData[i]), NULL, NULL);
        if (!SortedArrayList_isFull(aList)) {
            SortedArrayList_add(aList, _this->_testData[i]);
        }
        Timer_stop(timer);
        duration += Timer_duration(timer);
    }
    Timer_delete(timer);
    return duration;
}

double AppController_timeForSortedArrayList_search(AppController *_this, SortedArrayList *aList,
                                                   int aTestSize) {
    Timer *timer = Timer_new();
    double duration = 0;
    for (int i = 0; i < aTestSize; i++) {
        Timer_start(timer);
        BinaryNode_newWith(Key_newWith(_this->_testData[i]), Object_newWith(_this->_testData[i]), NULL, NULL);
        if (!SortedArrayList_isFull(aList)) {
            SortedArrayList_positionUsingBinarySearch(aList, _this->_testData[i]);
        }
        Timer_stop(timer);
        duration += Timer_duration(timer);
    }
    Timer_delete(timer);
    return duration;
}

double AppController_timeForSortedArrayList_remove(AppController *_this, SortedArrayList *aList,
                                                   int aTestSize) {
    Timer *timer = Timer_new();
    double duration = 0;
    for (int i = 0; i < aTestSize; i++) {
        Timer_start(timer);
        BinaryNode_newWith(Key_newWith(_this->_testData[i]), Object_newWith(_this->_testData[i]), NULL, NULL);
        if (!SortedArrayList_isFull(aList)) {
            SortedArrayList_removeAt(aList, _this->_testData[i]);
        }
        Timer_stop(timer);
        duration += Timer_duration(timer);
    }
    Timer_delete(timer);
    return duration;
}

double AppController_timeForSortedLinkedList_add(AppController *_this, SortedLinkedList *aList,
                                                 int aTestSize) {
    Timer *timer = Timer_new();
    double duration = 0;
    for (int i = 0; i < aTestSize; i++) {
        Timer_start(timer);
        BinaryNode_newWith(Key_newWith(_this->_testData[i]), Object_newWith(_this->_testData[i]), NULL, NULL);
        SortedLinkedList_add(aList, _this->_testData[i]);
        Timer_stop(timer);
        duration += Timer_duration(timer);
    }
    Timer_delete(timer);
    return duration;
}

double AppController_timeForSortedLinkedList_search(AppController *_this, SortedLinkedList *aList,
                                                    int aTestSize) {
    Timer *timer = Timer_new();
    double duration = 0;
    for (int i = 0; i < aTestSize; i++) {
        Timer_start(timer);
        BinaryNode_newWith(Key_newWith(_this->_testData[i]), Object_newWith(_this->_testData[i]), NULL, NULL);
        SortedLinkedList_search(aList, _this->_testData[i]);
        Timer_stop(timer);
        duration += Timer_duration(timer);
    }
    Timer_delete(timer);
    return duration;
}

double AppController_timeForSortedLinkedList_remove(AppController *_this, SortedLinkedList *aList,
                                                    int aTestSize) {
    Timer *timer = Timer_new();
    double duration = 0;
    for (int i = 0; i < aTestSize; i++) {
        Timer_start(timer);
        BinaryNode_newWith(Key_newWith(_this->_testData[i]), Object_newWith(_this->_testData[i]), NULL, NULL);
        SortedLinkedList_remove(aList, _this->_testData[i]);
        Timer_stop(timer);
        duration += Timer_duration(timer);
    }
    Timer_delete(timer);
    return duration;
}

double AppController_timeForUnsortedArrayList_add(AppController *_this, UnsortedArrayList *aList,
                                                  int aTestSize) {
    Timer *timer = Timer_new();
    double duration = 0;
    for (int i = 0; i < aTestSize; i++) {
        Timer_start(timer);
        BinaryNode_newWith(Key_newWith(_this->_testData[i]), Object_newWith(_this->_testData[i]), NULL, NULL);
        if (!UnsortedArrayList_isFull(aList)) {
            UnsortedArrayList_add(aList, _this->_testData[i]);
        }
        Timer_stop(timer);
        duration += Timer_duration(timer);
    }
    Timer_delete(timer);
    return duration;
}

double AppController_timeForUnsortedArrayList_search(AppController *_this, UnsortedArrayList *aList,
                                                     int aTestSize) {
    Timer *timer = Timer_new();
    double duration = 0;
    for (int i = 0; i < aTestSize; i++) {
        Timer_start(timer);
        BinaryNode_newWith(Key_newWith(_this->_testData[i]), Object_newWith(_this->_testData[i]), NULL, NULL);
        if (!UnsortedArrayList_isFull(aList)) {
            UnsortedArrayList_search(aList, _this->_testData[i]);
        }
        Timer_stop(timer);
        duration += Timer_duration(timer);
    }
    Timer_delete(timer);
    return duration;
}

double AppController_timeForUnsortedArrayList_remove(AppController *_this, UnsortedArrayList *aList,
                                                     int aTestSize) {
    Timer *timer = Timer_new();
    double duration = 0;
    for (int i = 0; i < aTestSize; i++) {
        Timer_start(timer);
        BinaryNode_newWith(Key_newWith(_this->_testData[i]), Object_newWith(_this->_testData[i]), NULL, NULL);
        if (!UnsortedArrayList_isFull(aList)) {
            UnsortedArrayList_removeAt(aList, i);
        }
        Timer_stop(timer);
        duration += Timer_duration(timer);
    }
    Timer_delete(timer);
    return duration;
}

double AppController_timeForUnsortedLinkedList_add(AppController *_this, UnsortedLinkedList *aList,
                                                   int aTestSize) {
    Timer *timer = Timer_new();
    double duration = 0;
    for (int i = 0; i < aTestSize; i++) {
        Timer_start(timer);
        BinaryNode_newWith(Key_newWith(_this->_testData[i]), Object_newWith(_this->_testData[i]), NULL, NULL);
        UnsortedLinkedList_add(aList, _this->_testData[i]);
        Timer_stop(timer);
        duration += Timer_duration(timer);
    }
    Timer_delete(timer);
    return duration;
}

double AppController_timeForUnsortedLinkedList_search(AppController *_this, UnsortedLinkedList *aList,
                                                      int aTestSize) {
    Timer *timer = Timer_new();
    double duration = 0;
    for (int i = 0; i < aTestSize; i++) {
        Timer_start(timer);
        BinaryNode_newWith(Key_newWith(_this->_testData[i]), Object_newWith(_this->_testData[i]), NULL, NULL);
        UnsortedLinkedList_search(aList, _this->_testData[i]);
        Timer_stop(timer);
        duration += Timer_duration(timer);
    }
    Timer_delete(timer);
    return duration;
}

double AppController_timeForUnsortedLinkedList_remove(AppController *_this, UnsortedLinkedList *aList,
                                                      int aTestSize) {
    Timer *timer = Timer_new();
    double duration = 0;
    for (int i = 0; i < aTestSize; i++) {
        Timer_start(timer);
        BinaryNode_newWith(Key_newWith(_this->_testData[i]), Object_newWith(_this->_testData[i]), NULL, NULL);
        UnsortedLinkedList_remove(aList, _this->_testData[i]);
        Timer_stop(timer);
        duration += Timer_duration(timer);
    }
    Timer_delete(timer);
    return duration;
}

double AppController_timeForBinarySearchTreeDictionary_add(AppController *_this, BinarySearchTreeDictionary *aTree,
                                                           int aTestSize) {
    Timer *timer = Timer_new();
    double duration = 0;
    for (int i = 0; i < aTestSize; i++) {
        Timer_start(timer);
		Key* addKey=Key_newWith(_this->_testData[i]);
		Object* addObject=Object_newWith (_this->_testData[i]);
        BinarySearchTreeDictionary_addKeyAndObject(aTree, addKey, addObject);
        Timer_stop(timer);
        duration += Timer_duration(timer);
    }
    Timer_delete(timer);
    return duration;
}

double AppController_timeForBinarySearchTreeDictionary_search(AppController *_this, BinarySearchTreeDictionary *aTree,
                                                              int aTestSize) {
    Timer *timer = Timer_new();
    double duration = 0;
    for (int i = 0; i < aTestSize; i++) {
        Timer_start(timer);
		Key* search=Key_newWith (_this->_testData[i]);
        BinarySearchTreeDictionary_keyDoesExist(aTree, search);
        Timer_stop(timer);
        duration += Timer_duration(timer);
    }
    Timer_delete(timer);
    return duration;
}

double AppController_timeForBinarySearchTreeDictionary_remove(AppController *_this, BinarySearchTreeDictionary *aTree,
                                                              int aTestSize) {
    Timer *timer = Timer_new();
    double duration = 0;
    for (int i = 0; i < aTestSize; i++) {
        Timer_start(timer);
		Key* remove=Key_newWith (_this->_testData[i]);
        BinarySearchTreeDictionary_removeObjectForKey(aTree, remove);
        Timer_stop(timer);
        duration += Timer_duration(timer);
    }
    Timer_delete(timer);
    return duration;
}

void AppController_showResults(AppController *_this, int aTestSize, double aTimeForAdd,
                               double aTimeForRemove, double aTimerForSearch) {
    char results[255];
    sprintf(results, "크기: %4d, 삽입: %6ld, 삭제: %7ld,  검색: %7ld\n", aTestSize, (long) aTimeForAdd,
            (long) aTimeForRemove, (long) aTimerForSearch);
    AppView_out(results);
}
