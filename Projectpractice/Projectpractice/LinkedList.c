//
// Created by h0033 on 2019-02-28.
//

#include <stdio.h>
#include <stdlib.h>

void add(int num);

struct data {
    int num;
    struct data *next;
};


struct data *bmp, *head, *tail;
int main(void) {
    int flag = 1, menu = 0, num = 0;
    struct data *p; //포인터 변수 > 주소 값을 가지는 것

    while (flag) {
        printf("메뉴 1. 추가 2. 삭제 3. 전체 출력 4. 메모리 해제 5. 종료\n");
        scanf_s("%d", &menu);
        switch (menu){
            case 1:
                printf("추가할 숫자를 입력하세요");
                scanf_s("%d", &num);
                add(num);
                break;
            case 2:
                printf("추가할 숫자를 입력하시오");
                scanf_s("%d", &num);

        }

    }


    return 0;
}

void add(int num) {
    bmp = (int*)malloc(sizeof(struct data));

    bmp->num = num;
    if(head == NULL)
        head=bmp;
    else
        tail->next=NULL;
    tail = bmp;
    tail->next = NULL;
}