//
// Created by h0033 on 2019-02-27.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Test{
    int a;
    char b;
    float c;

    char shape[20];
};


void struct_1();

int main(void) {

    struct_1();

    struct Test t1, t2;
    strcpy_s(t1.shape, "circle");




    return 0;
}

void struct_1() {
    struct Test x, y;
    x.a =1;
    x.b = 'a';
    x.c = 1.2f;

    printf("x.a = %d, x.b = %c, x.c = %f\n", x.a, x.b, x.c);

    y.a =2;
    y.b = 'b';
    y.c = 2.4f;
    printf("y.a = %d, y.b = %c, y.c = %f\n", y.a, y.b, y.c);
}
