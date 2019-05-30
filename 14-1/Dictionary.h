#pragma once

#include "Common.h"
#include "BinaryNode.h"
#include "Traverse.h"

typedef struct _Dictionary Dictionary;

Dictionary *Dictionary_new(void);

void Dictionary_delete(Dictionary *_this);

Boolean Dictionary_isEmpty(Dictionary *_this);

Boolean Dictionary_isFull(Dictionary *_this);

int Dictionary_size(Dictionary *_this);

Boolean Dictionary_keyDoesExist(Dictionary *_this, Key *aKey);
//주어진 aKey 가 사전에 존재하는지를 알려준다.

Object *Dictionary_objectForKey(Dictionary *_this, Key *aKey);
//사전에서 주어진 aKey 값을 갖는 object를 찾아 그 object 객체의 소유권을 얻는다.
//존재하지 않으면 NULL을 얻는다.

Boolean Dictionary_addKeyAndObject(Dictionary *_this, Key *aKey, Object *anObject);

//사전에 (aKey, anObject) 쌍을 삽입한다. 정상 삽입되면 TRUE를 얻는다.
//aKey 값이 중복되면, 삽입되지 않고 FALSE 를 얻는다.
Object *Dictionary_removeObjectForKey(Dictionary *_this, Key *aKey);

//주어진 aKey 값을 갖는 object에 대해, (aKey, object) 쌍을 사전에서 삭제시키고, 그 object 객체의 소유권을 얻는다.
//주어진 aKey 가 존재하지 않으면 NULL을 얻는다.

Boolean Dictionary_replaceObjectForKey(Dictionary *_this, Key *aKey, Object *anObject);
//주어진 aKey 값을 갖는 기존의 object를 새로이 주어진 anObject로 대체한다

void Dictionary_scanInSortedOrder (Dictionary* _this, Traverse* aTraverse) ;
//사전의 모든 Object 객체를 Key 값 순서대로 방문한다.
//사전을 이진트리로 구현한다면, 그 방문 순서는 "inorder"가 될 것이다.
//각 객체를 방문할 때마다의 해야 할 일은 Class Traverse 객체를 사용하여 실행한다.
//Class Traverse는 공개 함수 Traverse_visit() 를 가지고 있어야 한다.
//이 class의 구현은 class Dictionary 의 사용자, 즉 여기서는 AppController 가 한다.
//Class Dictionary는 단지 class의 이름과 공개함수 Traverse_visit()의 사용법만 알고 있다.


