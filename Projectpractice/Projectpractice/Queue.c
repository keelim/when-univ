//
// Created by h0033 on 2019-03-05.
//
#include <stdio.h>
#include <stdlib.h>

#define MAX 5

int a[MAX], first = 0, last = -1;

void enQueue(int x);

void print();

void deQueue();

int main(void) {
    int j;
    for (int i = 0; i <= MAX; i++) {
        puts("큐에 데이ㅓ 추가");
        scanf_s("%d", &j);
        enQueue(j);
    }
    print();
    deQueue();
    return 0;
}

void deQueue() {
    if (first > last) {
        puts("큐가 비었습니다. ");
        return;
    }
    printf("%d is out\n", a[first]);
    first++;
}

void print() {
    puts("큐에 저장된 데이터");
    for (int i = first; i <= last; i++) {
        printf("%d\t", a[i]);
    }
    puts("");


}

void enQueue(int x) {
    if (last >= MAX - 1) {
        puts("큐가 꽉 찾습니다. ");
        return;
    }
    last++;
    a[last] = x;
}
