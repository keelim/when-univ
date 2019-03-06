//
// Created by h0033 on 2019-02-27.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Person {
    char name[20];
    int age;
};

data[3] = {{"aaa", 12}, {"bbb", 12}, {"ccc", 12}};


int main(void) {
    struct Person arr[2];
    int i;

    strcpy_s(arr[0].name, "ddd");
    arr[0].age = 52;

    strcpy_s(arr[1].name, "eee");
    arr[1].age = 52;

    for (int j = 0; j < 3; ++j) {
        printf("name:%s, age:%d, \n", data[i].name, data[i].age);
    }


    return 0;
}

