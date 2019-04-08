#pragma once
#include "AppView.h"

void AppView_out(char* aMessage) {
	printf(aMessage);

}

int AppView_in_order() {
	int inputOrder = 0;
	printf("? 차수를 입력하세요:  ");
	scanf_s("%d", &inputOrder);
	
	return inputOrder;

}

void AppView_out_execusionTime(int anOrder, long anExecutionTime) {
	printf("차수:%2d, 시간 %ld (마이크로 초) \n", anOrder, anExecutionTime);

}
