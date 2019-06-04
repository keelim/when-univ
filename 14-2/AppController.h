#pragma once
#include "SortedArrayDictionary.h"
#include "SortedLinkedDictionary.h"
#include "UnsortedArrayDictionary.h"
#include "UnsortedLinkedDictionary.h"
#include "BinarySearchTreeDictionary.h"
#include "Common.h"
#include "Timer.h"



typedef struct _AppController AppController;

AppController* AppController_new (void);
void AppController_delete (AppController* _this);
void AppController_run (AppController* _this);

void AppController_generateTestDataByRandomNumbers (AppController* _this);
double AppController_timeForArrayDictionary_add (AppController* _this, SortedArrayDictionary* aDictionary, int aTestSize);
double AppController_timeForSortedArrayDictionary_search (AppController* _this, SortedArrayDictionary* aDictionary, int aTestSize);
double AppController_timeForSortedArrayDictionary_remove (AppController* _this, SortedArrayDictionary* aDictionary, int aTestSize);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
double AppController_timeForSortedLinkedDictionary_add (AppController* _this, SortedLinkedDictionary* aDictionary, int aTestSize);
double AppController_timeForSortedLinkedDictionary_search (AppController* _this, SortedLinkedDictionary* aDictionary, int aTestSize);
double AppController_timeForSortedLinkedDictionary_remove (AppController* _this, SortedLinkedDictionary* aDictionary, int aTestSize);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
double AppController_timeForUnsortedArrayDictionary_add (AppController* _this, UnsortedArrayDictionary* aDictionary, int aTestSize);
double AppController_timeForUnsortedArrayDictionary_search (AppController* _this, UnsortedArrayDictionary* aDictionary, int aTestSize);
double AppController_timeForunsortedArrayDictionary_remove (AppController* _this, UnsortedArrayDictionary* aDictionary, int aTestSize);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
double AppController_timeForUnsortedLinkedDictionary_add (AppController* _this, UnsortedLinkedDictionary* aDictionary, int aTestSize);
double AppController_timeForunsortedLinkedDictionary_search (AppController* _this, UnsortedLinkedDictionary* aDictionary, int aTestSize);
double AppController_timeForUnsortedLinkedDictionary_remove (AppController* _this, UnsortedLinkedDictionary* aDictionary, int aTestSize);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
double AppController_timeForBinarySearchTreeDictionary_add (AppController* _this, BinarySearchTreeDictionary* aDictionary, int aTestSize);
double AppController_timeForBinarySearchTreeDictionary_search (AppController* _this, BinarySearchTreeDictionary* aDictionary, int aTestSize);
double AppController_timeForBinarySearchTreeDictionary_remove (AppController* _this, BinarySearchTreeDictionary* aDictionary, int aTestSize);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
void AppController_showResults (AppController* _this, int aTestSize, double aTimeForAdd, double aTimeForMin, double aTimeForRemoveMax);
