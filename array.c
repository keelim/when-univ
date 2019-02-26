#include<stdio.h>

void sum(int i);

void alphabet();

void array_change();

int main(void) {

    sum(100);
    alphabet();
    array_change();

    return 0;

}

void array_change() {
    int es[10];
    for (int i = 0; i < sizeof(es); ++i) {
        es[i] = i;
    }

    for (int i = 0; i < sizeof(es); ++i) {
        printf("%d ", es[i]);
    }

    for (int j = 0; j < sizeof(es); ++j) {
        es[j] = 0;
    }

    for (int i = 0; i < sizeof(es); ++i) {
        printf("%d ", es[i]);
    }

}

void alphabet() {
    for (int i = 97; i <= 122; ++i) {
        printf("출력값 %c\n", (char)i);
    }
}

void sum(int i) {
    int a = 0;
    for (int j = 0; j <= i; ++j) {
        a += j;
    }

    printf("출력값: %d", a);
}