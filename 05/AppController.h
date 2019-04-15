#pragma once
#include"Common.h"
#include"MagicSquare.h"
#include "AppView.h"

typedef struct _AppController AppController; //def

AppController* AppController_new(void); //def

void AppController_run(AppController* _this); //def
void AppController_delete(AppController* _this); //def
void AppController_showBoard(AppController* _this, MagicSquare* aMagicSquare); //def
