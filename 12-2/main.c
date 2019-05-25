#pragma once

#include "AppController.h"

int main () {
	AppController* appController=AppController_new (); //AppController 생성
	AppController_run (appController); //AppController 실행
	AppController_delete (appController); //AppController 제거
	return 0;
}