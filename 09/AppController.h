#pragma once
#include "AppView.h"
#include "Stack.h"
#include "Common.h"

#define Esc 27
#define isDigit(CHAR) (('0' <= CHAR) && (CHAR <='9'))
#define isAlpha(CHAR)   ((('A' <= CHAR) && (CHAR <= 'Z')) || (('a' <= CHAR) && (CHAR <= 'z')))

typedef struct _AppController AppController;

AppController * AppController_new ();

void AppController_run (AppController * _this);

void AppController_delete (AppController * _this);

void AppController_showStatistics (AppController * _this);