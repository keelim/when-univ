#pragma once
#include "SortedLinkedList.h"
#include "UnSortedLinkedList.h"
#include "Common.h"


typedef struct _AppController AppController;

AppController* AppController_new (void);
void AppController_delete (AppController* _this);
void AppController_run (AppController* _this);

void AppController_generateTestDataByRandomNumbers (AppController* _this);
double AppController_timeForSortedLinkedList_add (AppController* _this, SortedLinkedList* aList, int aTestSize);
double AppController_timeForSortedLinkedList_min (AppController* _this, SortedLinkedList* aList, int aTestSize);
double AppController_timeForSortedLinkedList_removeMax (AppController* _this, SortedLinkedList* aList, int aTestSize);

double AppController_timeForUnSortedLinkedList_add (AppController* _this, UnsortedLinkedList* aList, int aTestSize);
double AppController_timeForUnSortedLinkedList_min (AppController* _this, UnsortedLinkedList* aList, int aTestSize);
double AppController_timeForUnSortedLinkedList_removeMax (AppController* _this, UnsortedLinkedList* aList, int aTestSize);
void AppController_showResults (AppController* _this, int aTestSize, double aTimeForAdd, double aTimeForMin, double aTimeForRemoveMax);

