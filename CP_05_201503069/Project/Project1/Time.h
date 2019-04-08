#pragma once
#include"Common.h"
#include<Windows.h>

typedef struct {
	LARGE_INTEGER _frequency;
	LARGE_INTEGER _startCounter;
	LARGE_INTEGER _endCounter;

} Timer; //def Time struct

Timer* Timer_new();//def like constructor

void Timer_delete(Timer* _this); // def
void Timer_start(Timer* _this); // def
void Timer_stop(Timer* _this); // def

double Timer_duration(Timer* _this); //def