#pragma once
#include "SortedArrayList.h"
#include "SortedLinkedList.h"
#include "UnsortedArrayList.h"
#include "UnsortedLinkedList.h"
#include "BinarySearchTreeDictionary.h"
#include "Common.h"
#include "Timer.h"



typedef struct _AppController AppController;

AppController* AppController_new (void);
void AppController_delete (AppController* _this);
void AppController_run (AppController* _this);

void AppController_generateTestDataByRandomNumbers (AppController* _this);
double AppController_timeForArrayList_add(AppController *_this, SortedArrayDictionary *aDictionary, int aTestSize);
double AppController_timeForSortedArrayList_search(AppController *_this, SortedArrayDictionary *aDictionary,
                                                   int aTestSize);
double AppController_timeForSortedArrayList_remove(AppController *_this, SortedArrayDictionary *aDictionary,
                                                   int aTestSize);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
double AppController_timeForSortedLinkedList_add(AppController *_this, SortedLinkedDictionary *aDictionary,
                                                 int aTestSize);
double AppController_timeForSortedLinkedList_search(AppController *_this, SortedLinkedDictionary *aDictionary,
                                                    int aTestSize);
double AppController_timeForSortedLinkedList_remove(AppController *_this, SortedLinkedDictionary *aDictionary,
                                                    int aTestSize);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
double AppController_timeForUnsortedArrayList_add(AppController *_this, UnsortedArrayDictionary *aDictionary,
                                                  int aTestSize);
double AppController_timeForUnsortedArrayList_search(AppController *_this, UnsortedArrayDictionary *aDictionary,
                                                     int aTestSize);
double AppController_timeForunsortedArrayList_remove(AppController *_this, UnsortedArrayDictionary *aDictionary,
                                                     int aTestSize);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
double AppController_timeForUnsortedLinkedList_add(AppController *_this, UnsortedLinkedDictionary *aDictionary,
                                                   int aTestSize);
double AppController_timeForunsortedLinkedList_search(AppController *_this, UnsortedLinkedDictionary *aDictionary,
                                                      int aTestSize);
double AppController_timeForUnsortedLinkedList_remove(AppController *_this, UnsortedLinkedDictionary *aDictionary,
                                                      int aTestSize);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
double AppController_timeForBinarySearchTreeDictionary_add (AppController* _this, BinarySearchTreeDictionary* aDictionary, int aTestSize);
double AppController_timeForBinarySearchTreeDictionary_search (AppController* _this, BinarySearchTreeDictionary* aDictionary, int aTestSize);
double AppController_timeForBinarySearchTreeDictionary_remove (AppController* _this, BinarySearchTreeDictionary* aDictionary, int aTestSize);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
void AppController_showResults (AppController* _this, int aTestSize, double aTimeForAdd, double aTimeForMin, double aTimeForRemoveMax);
