#pragma once
#include"AppController.h"

int main() {
	AppController* appController; // appController generate pointer
	appController = AppController_new(); // execute contructor
	AppController_run(appController); //run(app Controller)
	AppController_delete(appController); //delete (app Controller)

	return 0;
}