#include "Common.h"


typedef struct _Queue Queue;

Queue *Queue_new(int givenCapacity);

void Queue_delete(Queue *_this);

//Queue 객체의 점검
Boolean Queue_isEmpty(Queue *_this);

// 큐가 empty 이면 TRUE를, 아니면, FALSE를 얻는다.
Boolean Queue_isFull(Queue *_this);

//큐가 full 이면 TRUE를, 아니면, FALSE를 얻는다.
int Queue_size(Queue *_this);

//큐의 길이, 즉 큐가 가지고 있는 원소의 개수
//Queue 객체에 지시 
Boolean Queue_add(Queue *_this, Element anElement);

//큐의 rear에 item을 삽입한다

//삽입을 성공하면 TRUE, 실패하면 FALSE를 얻는다. 
Element Queue_remove(Queue *_this);
//큐의 front에서 Element를 삭제하고 그 값을 얻는다.

Element Queue_elementAt(Queue* _this, int anOrder);