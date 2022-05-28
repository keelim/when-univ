#pragma once
#include "Time.h"

Timer* Timer_new() { //Timer constructor
	Timer* _this = NewObject(Timer);
	QueryPerformanceFrequency(&(_this->_frequency));
	return _this;

}

void Timer_delete(Timer* _this) { //delete
	free(_this);

}
void Timer_start(Timer* _this) { //start
	QueryPerformanceCounter(&(_this->_startCounter));

}

void Timer_stop(Timer* _this) { //stop
	QueryPerformanceCounter(&(_this->_endCounter));

}

double Timer_duration(Timer* _this) { //타이머의 시간 값을 측정
	double elasped = (double) (_this->_endCounter.QuadPart - _this->_startCounter.QuadPart);
	return (elasped * 1000000.0 / ((double) _this->_frequency.QuadPart));
	
} //마이크로초의 성능 측정
