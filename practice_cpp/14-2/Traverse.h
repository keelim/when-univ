#pragma once

#include "Object.h"
#include "Key.h"
#include <string.h>

typedef struct _Traverse Traverse;

Traverse *Traverse_new(void); // ������

void Traverse_delete(Traverse *_this); // �Ҹ���

void Traverse_visit(Traverse *_this, Key* aKey, Object *anObject, int aDepth);

// ������ traverse �ϴ� ����,
// Dictionary ��ü ���� ��带 visit �� �������� �� ���� �����Ѵ�.
// �� �Լ��� ���Ǵ� ���뿡 ���� �޶��� �� �ִ�. (�Ű�����, �ϴ� ��)
// <aKey, anObject> : ���� �湮�ϴ� key-object ��
// aDepth: ����Ʈ������ <aKey, anObject> ���� ������ �ִ� ����� ����