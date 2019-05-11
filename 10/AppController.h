#pragma once

#include "Common.h"
#include "AppView.h"
#include "Postfix.h"

#define MAX_NUMBER_OF_TOKENS 100

typedef struct _AppController AppController;

void AppController_run (AppController* _this);

AppController* AppController_new ();

void AppController_delete (AppController* _this);