#pragma once

#include "Common.h"
#include "AppView.h"
#include "Postfix.h"

#define MAX_NUMBER_OF_TOKENS 200

typedef struct _AppController AppController;

<<<<<<< HEAD
void AppController_run (AppController* _this);

AppController* AppController_new ();

void AppController_delete (AppController* _this);
=======
AppController* AppController_new (); //def

void AppController_delete (AppController* _this); //def

void AppController_run(AppController *_this);
>>>>>>> 0a8e1b0fec1b30a22f98a81d940362cc4ab26cc9
