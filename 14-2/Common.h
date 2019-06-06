#pragma once

#include <stdlib.h>

typedef enum {
    FALSE, TRUE
} Boolean;
#define NewObject(TYPE) (TYPE*)malloc(sizeof(TYPE))
#define NewVector(TYPE, SIZE) (TYPE*)malloc(sizeof(TYPE)*SIZE)
typedef int Element;
#define MSG_StartPerformanceMeasuring "<<< 성능 측정을 시작합니다 >>>\n"
#define MSG_EndPerformanceMeasuring "\n<<< 성능 측정을 종료합니다 >>>\n\n"
#define MSG_TitleForUnsortedArrayList "\'Unsorted Array List\'의 성능 (단위:마이크로 초)\n"
#define MSG_TitleForsortedLinkedList "\'Unsorted Linked List\'의 성능 (단위:마이크로 초)\n"
#define MSG_TitleForUnsortedLinkedList "\'Sorted Linked List\'의 성능 (단위:마이크로 초)\n"
#define MSG_TitleForsortedArrayList "\'Sorted Array List\'의 성능 (단위:마이크로 초)\n"
#define MSG_TitleForBinarySearchTreeDictionary "\'BinarySearchTreeDictionary\'의 성능 (단위:마이크로 초)\n"


