#include"AppView.h"

void AppView_out(char* aMessage) {
	printf(aMessage);

}

int AppView_in_order() {
	int inputOrder = 0;
	printf("? 마방진 차수를 입력하세요: ");
	scanf_s("%d", &inputOrder);

	return inputOrder;
}
