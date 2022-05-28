#include "AppVIew.h"

void AppView_out(char* aMessage)
{
	printf(aMessage);
}

int AppView_in_order()
{
	int inputOrder = 0;
	printf("? ������ ������ �Է��ϼ���: ");
	scanf_s("%d", &inputOrder);

	return inputOrder;
}
