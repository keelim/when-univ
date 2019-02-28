//
// Created by h0033 on 2019-03-01.
//
#include <stdio.h>
#include <stdlib.h>

#define MAX 5

int main(void) {

    int a[MAX];
    int tmp;

    printf("숫자 5개를 입력하라");
    for (int i = 0; i < MAX; ++i) {
        scanf_s("%d", &a[i]);
    }
    puts("배열 데이터");
    for (int j = 0; j < MAX; ++j) {
        printf("%d\t", a[j]);
    }
    puts("");


    for (int k = 0; k < MAX - 1; ++k) {
        for (int i = 0; i < MAX - k - i; ++i) {
            if (a[i] > a[k + 1]) {
                tmp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = tmp;

            }
        }
    }

    puts("배열데이터");
    for (int l = 0; l < MAX; ++l) {
        printf("%d\t", a[l] );
    }

    puts("");


    return 0;
}