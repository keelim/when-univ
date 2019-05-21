#include "Common.h"
typedef struct _Node Node;

Node *Node_new();

//노드 객체를 생성
void Node_delete(Node* _this);

//노드 객체를 소멸
void Node_setElement(Node *_this, Element newElement);

Element Node_element(Node *_this);

void Node_setNext(Node *_this, Node *newNext);

Node *Node_next(Node *_this);