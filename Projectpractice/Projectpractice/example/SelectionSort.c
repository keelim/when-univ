#include <stdio.h>
#include <stdlib.h>

#define MAX 5

int a[MAX];

void print();

int main(void) {

    puts("숫자 5개를 입력하시오");
    for (int i = 0; i < MAX; i++) {
        scanf_s("%d", &a[i]);
    }

    print();

    //SelctionSort
    for (int i = 0; i < MAX - 1; i++) {
        int min = i;
        int j = i + 1;

        while (j < MAX) {

            if (a[min] > a[j])
                min = j;
            j++;
        }

        if (min != 1) {
            int tmp = a[min];
            a[min] = a[i];
            a[i] = tmp;
        }

    }

    print();

    return 0;
}

void print() {
    int i;
    puts("배열 데이터");

    for (int i = 0; i < MAX; i++) {
        printf("%d\t", a[i]);
        puts("");
    }
}