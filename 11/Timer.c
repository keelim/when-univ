#pragma once
#include "Timer.h"
#include "Common.h"
#include <Windows.h>

struct _Timer {
    LARGE_INTEGER frequency;
    LARGE_INTEGER startCounter;
    LARGE_INTEGER stopCounter;
};

Timer *Timer_new() {
    Timer *_this = NewObject(Timer);
}

void Timer_delete(Timer *_this) {
    free(_this);
}

void Timer_start(Timer *_this) {
    QueryPerformanceCounter(&(_this->startCounter));
}

void Timer_stop(Timer *_this) {
    QueryPerformanceCounter(&(_this->stopCounter));
}

double Timer_duration(Timer *_this) {
    double elapsed = (double) (_this->stopCounter.QuadPart - _this->startCounter.QuadPart);
    return elapsed * 1000000.0 / (double) _this->frequency.QuadPart; // 실행 시간을 마이크로 초로 변환한다.
}
