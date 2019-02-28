//
// Created by h0033 on 2019-02-28.
//

#include <stdio.h>
#include <stdlib.h>

void add(int num);

void delete(int num);

void printList();

void delList();

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
        switch (menu) {
            case 1:
                printf("추가할 숫자를 입력하세요");
                scanf_s("%d", &num);
                add(num);
                break;
            case 2:
                printf("추가할 숫자를 입력하시오");
                scanf_s("%d", &num);
                delete(num);
                break;

            case 3:
                printList();
                break;

            case 4:
                delList();

            case 5:
                flag = 0;
                break;
            default:
                puts("다시입력하라");
        }

    }


    return 0;
}

void delList() {
    bmp = head;
    while (bmp != NULL) {
        head = bmp->next;
        printf("%d 삭제\n", bmp->num);
        free(bmp);
        bmp = head;

    }
}

void printList() {
    bmp = head;
    while (bmp != NULL) {
        printf("데이터 : %d\n", bmp->next);
        bmp = bmp->next;
    }
}

void delete(int num) {
    static struct data *arr[3];
    bmp = head;
    while (bmp != NULL) {
        if (bmp == head) {
            arr[0] = NULL;
            arr[1] = bmp;
            arr[2] = bmp->next;

        } else {
            arr[0] = arr[1];
            arr[1] = arr[2];
            arr[2] = bmp->next;

        }
        if (bmp->next == num) {
            arr[0]->next == arr[2];
            free(arr[1]);
            break;
        }
        bmp = bmp->next;
    }
}

void add(int num) {
    bmp = (int *) malloc(sizeof(struct data));

    bmp->num = num;
    if (head == NULL)
        head = bmp;
    else
        tail->next = NULL;
    tail = bmp;
    tail->next = NULL;
}