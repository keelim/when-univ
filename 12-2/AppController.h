#pragma once

#include "Common.h"
#include "AppView.h"
#include "Postfix.h"



typedef struct _AppController AppController;

void AppController_run (AppController* _this);

AppController* AppController_new ();

void AppController_delete (AppController* _this);