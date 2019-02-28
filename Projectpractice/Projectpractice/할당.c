#include<stdio.h>
#include<stdlib.h>

int main_할당(void) {

	int *p; //포인터 변수
	p = (int*)malloc(sizeof(int));
	*p = 10;
	printf("%d\n", *p);

	free(p);

	return 0;

}