#include <stdio.h>
#include <stdlib.h>

#define MAX 5

int a[MAX];

void print();

void select(int a, int n);

int main(void) {
    int first = 0, mid, last = MAX - 1, flag = 1, x;
    puts("숫자 5개를 입력하라");

    for (int i = 0; i < MAX; i++) {
        scanf_s("%d", &a[i]);
    }

    print();

    select(a, MAX);

    return 0;
}


void select(int a, int n) {
    for (int i = 0; i <n-1; i++) {
        int min = i;
        int j = i+1;
        while(j<n){
            if(a[min]>a[j])
                min = j;
            j++;
        }
    }
}

void print() {
    puts("배열 데이터");

    for (int i = 0; i < ; i++) {
        printf("%d\t", a[i]);
    }
    puts("");

}