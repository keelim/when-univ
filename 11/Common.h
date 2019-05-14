#pragma once
#include <stdlib.h>

typedef enum {FALSE, TRUE} Boolean;
typedef int Element;
#define NewVector(TYPE, SIZE) (TYPE*)malloc(sizeof(TYPE)*SIZE)
#define NewObject(TYPE) (TYPE*)malloc(sizeof(TYPE))
#define MSG_StartPerformanceMeasuring "<<< 성능 측정을 시작합니다 >>>\n"
#define MSG_EndPerformanceMeasuring "\n<<< 성능 측정을 종료합니다 >>>\n"
#define MSG_TitleForUnsortedLinkedList "\'Unsorted Linked List\'의 성능 (단위:마이크로 초)\n"
#define MSG_TitleForsortedLinkedList "\'Sorted Linked List\'의 성능 (단위:마이크로 초)\n"


