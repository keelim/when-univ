#pragma once
#include "Dictionary.h"
typedef struct _AppController AppController;

#define Esc 27
#define isAlpha(CHAR) ((('A' <= CHAR) && (CHAR <= 'Z')) || (('a' <= CHAR) && (CHAR <= 'z')))


AppController* AppController_new();

void AppController_delete(AppController* _this);

void AppController_showInternalShapeOfBinaryTree(AppController* _this, Traverse* aTraverse) ;

void AppController_run(AppController* _this);

void AppController_add(AppController *_this, char keyValue);

void AppController_remove(AppController *_this);

void AppController_showSize(AppController *_this);

void AppController_ignore(AppController *_this);

void AppController_esc(AppController *_this);

void AppController_exist(AppController *_this, char i);