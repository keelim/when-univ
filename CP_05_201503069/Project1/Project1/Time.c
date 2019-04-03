//꼭 utf 8로 인코딩 하자.
#pragma once
#include "Time.h"


Timer* Timer_new()
{
	Timer* _this = NewObject(Timer);
	QueryPerformanceFrequency(&(_this->_frequency));
	return _this;
		
}

void Timer_delete(Timer* _this)
{
	free(_this);
}
void Timer_start(Timer* _this)
{
	QueryPerformanceCounter(&(_this->_startCounter));
}

void Timer_stop(Timer* _this)
{
	QueryPerformanceCounter(&(_this->_endCounter));
}

double Timer_duration(Timer* _this)
{
	double elasped = (double)(_this->_frequency.QuadPart);
	return (1000000.0 / (double)_this->_frequency.QuadPart);
}
