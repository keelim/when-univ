#include<stdio.h>
#include<stdlib.h>

int main(void) {
	int*p, i;
	p = (int*)malloc(sizeof(int)*5);

	/*for ( i = 0; i < 5; i++) {
		*(p + i) = i + 1;
		printf(p);
		printf(*p);
	}

	for ( i = 0; i < 5; i++) {
		printf("%d\n", p[i]);
	}*/

	p = 5;
	printf(p);
	printf(*p);



	free(p);

	return 0;


}
