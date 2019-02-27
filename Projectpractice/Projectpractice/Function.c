#include <stdio.h>
#include <stdlib.h>

void swap(int a, int i);

int main(void) {

    int a = 10, b = 20;

    swap(a, b);

    printf("varl1=%d, varl2=%d\n", a, b);

    return 0;
}

void swap(int a, int i) {
    int temp;

    temp = a;
    a = i;
    i = temp;

    printf("varl = %d, var2 = %d\n", a, i);
}