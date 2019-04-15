// 2015030699 김재현
#include"AppView.h"

void AppView_out(char* aMessage) { //aMessage 출력
	printf(aMessage);

}

int AppView_in_order() { //차수를 입력
	int inputOrder = 0;
	printf("? 마방진 차수를 입력하세요: ");
	scanf_s("%d", &inputOrder);

	return inputOrder; //inputOrder를 리턴한다. 
}
