#pragma once
#include "Common.h"
#include "AppController.h"
#include "AppView.h"
#include "Message.h"
#include "Time.h"
#include <stdio.h>

#define MIN_TEST_SIZE 1000
#define NUMBER_OF_TESTS 5
#define INTERVAL_SIZE 1000

struct _AppController {
	int* _testData;
	Timer* _timer;
};


AppController* AppController_new(void)
{
	AppController* _this = NewObject(AppController);
	return _this;
}


void AppController_delete(AppController* _this)
{
	free(_this);

}

void AppController_run(AppController* _this)
{
	AppView_out(MSG_StartPerformanceMeasuring);
	
	int numberOfTests = NUMBER_OF_TESTS;
	int intervalSize = INTERVAL_SIZE;
	int maxTestSize = MIN_TEST_SIZE + INTERVAL_SIZE * (NUMBER_OF_TESTS - 1);
	
	_this->_testData = NewVector(int, maxTestSize);
	
	// 유의: 사용을 종료한 후, 이것을 소멸시킬 위치는?
	AppController_generateTestDataByRandomNumbers(_this );
	AppView_out(MSG_TitleForUnsortedArrayList);
	
	int testSize = MIN_TEST_SIZE;
	for (int i = 0; i < numberOfTests; i++) {
		UnsortedArrayList* listForTest = UnsortedArrayList_new(maxTestSize);
		double timeForAdd = AppController_timeForUnsortedArrayList_add(_this, listForTest, testSize);
		double timeForRemoveMax = AppController_timeForUnsortedArrayList_removeMax(_this, listForTest, testSize);
		AppController_showResults(_this, testSize, timeForAdd, timeForRemoveMax);
		UnsortedArrayList_delete(listForTest);
		testSize += intervalSize;
	}
	AppView_out(MSG_EndPerformanceMeasuring);

}


void AppController_generateTestDataByRandomNumbers(AppController* _this)
{
	int maxTestSize = MIN_TEST_SIZE + INTERVAL_SIZE * (NUMBER_OF_TESTS - 1);
	srand((unsigned)time(NULL));

	for (int i = 0; i < maxTestSize; i++) {
		_this->_testData[i] = rand();
	}
}


double AppController_timeForUnsortedArrayList_add(AppController* _this, UnsortedArrayList* aList, int aTestSize)
{
	Timer* timer = Timer_new();
	double duration = 0;
	for (int i = 0; i < aTestSize; i++) {
		Timer_start(timer);
		if (!UnsortedArrayList_isFull(aList)) {
			UnsortedArrayList_add(aList, _this->_testData[i]);
		}
		Timer_stop(timer);
		duration += Timer_duration(timer);
	}
	Timer_delete(timer);
	return duration;
}


double AppController_timeForUnsortedArrayList_removeMax(AppController* _this, UnsortedArrayList* aList, int aTestSize)
{
	Element max;
	double duration = 0;
	Timer* timer = Timer_new();
	for (int i = 0; i < aTestSize; i++) {
		Timer_start(timer);
		if (!UnsortedArrayList_isEmpty(aList)) {
			max = UnsortedArrayList_removeMax(aList);
		}
		Timer_stop(timer);
		duration += Timer_duration(timer);
	}
	Timer_delete(timer);
	return duration;
}


void AppController_showResults(AppController* _this, int aTestSize, double aTimeForAdd, double aTimeForRemoveMax)
{
	char results[255];
	sprintf(results, "크기: %4d, 삽입: %6ld, 최대값삭제: %7ld\n", aTestSize, (long)aTimeForAdd, (long)aTimeForRemoveMax);
	AppView_out(results);
}

