<<<<<<< HEAD
#pragma once

#include "AppController.h"

int main () {
	AppController* appController=AppController_new ();
	AppController_run (appController);
	AppController_delete (appController);
	return 0;
=======
﻿#include"AppController.h"

int main() {
    AppController *appController = AppController_new(); // AppController 생성
    AppController_run(appController); //실행
    AppController_delete(appController); //appController 소멸

    return 0;
>>>>>>> 0a8e1b0fec1b30a22f98a81d940362cc4ab26cc9
}