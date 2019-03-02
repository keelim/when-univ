#include <stdio.h>
#include <stdlib.h>

int a[5];

void print();

int main(void) {

    puts("숫자5개를 입력하시오");
    for (int i = 0; i < 5; i++) {
        scanf_s("%d", &a[i]);
    }

    print();

    for (int i = 0; i < 5; i++) {
        int j = i - 1;
        int tmp = a[i];
        while (j >= 0 && tmp < a[j]) {
            a[j + 1] = a[j];
            j--;
        }
        a[j + 1] = tmp;

    }

    print();

    return 0;
}

void print() {
    puts("배열 데이터");

    for (int i = 0; i < 5; i++) {
        printf("%d\t", a[i]);
    }
    puts("");

}