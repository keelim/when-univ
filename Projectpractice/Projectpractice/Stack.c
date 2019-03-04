//
// Created by h0033 on 2019-03-04.
//
#include <stdio.h>

#define MAX 5
int a[MAX], top = -1;

void push(int x);

void pop();

int main(void) {
    puts("스택 데이터");
    for (int i = 0; i <= top; i++) {
        printf("%d\t", a[i]);
        printf("\n");

    }

    for (int i = 1; i < 7; i++) {
        push(i);
    }

    puts("스택 데이터");

    for (int i = 0; i <= top; i++) {
        printf("%d\t", a[i]);

    }

    pop();
    pop();
    pop();
    pop();
    pop();
    pop();

    puts("스택 데이터");
    for (int i = 0; i <= top; i++) {
        printf("%d\t", a[i]);

    }
    return 0;
}

void pop() {
    if (top < 0) {
        puts("스택이 비었습니다. ");
        return;
    }

    printf("%d id poped \n", a[top]);
    top--;

}

void push(int x) {
    if (top >= MAX - 1) {
        puts("스택이 꽉찼습니다.");
        return;
    }
    top++;
    a[top] = x;
    printf("%d is pushed\n", a[top]);

}