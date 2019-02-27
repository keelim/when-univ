#include <stdio.h>
#include <stdlib.h>

int main(void) {

	//for (size_t i = 0; i < 10; i++) {
	//	printf("%d\n", i);
	//}

	//return 0;

	//int *pvar; //포인터 변수
	//int var = 10;
	//pvar = &var;

	//
	//printf("value == %d, address = 0x%X\n", var, &var);
	//printf("value == %d, address = 0x%X\n", *pvar, pvar);


	//var = 20;

	//printf("value == %d, address = 0x%X\n", var, &var);
	//printf("value == %d, address = 0x%X\n", *pvar, pvar);


	int *pArray, i;
	pArray = (int*)malloc(sizeof(int) * 10);

	for (size_t i = 0; i < 10; i++) {
		*(pArray + i) = i;
	}

	for (size_t i = 0; i < 10; i++) {
		printf("%d : %d\n", i, *(pArray + i));

	}
	free(pArray);

	return 0;


	
}