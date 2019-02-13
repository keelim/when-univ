
#include<stdio.h>

int main(void) {
//    int sbuway_1 = 10;
//    int sbuway_2 = 20;
//    int sbuway_3 = 30;

    int subway[3];
//    초기화 하지 않으면 더미 값이 들어간다.
//    subway[0] = 10;
//    subway[1] = 20;
//    subway[2] = 30;
//
//    for (int i = 0; i < sizeof(subway)/ sizeof(int); ++i) {
//        printf("%d\n", subway[i]);
//    }

//    int arr[10] = {0};
//     하나라도 선언을 하면 전부 0으로 초기화가 된다.
//    for (int i = 0; i < sizeof(arr)/ sizeof(int); ++i) {
//        printf("%d\n", arr[i]);
//    }

//    float arr_f[5] = {0};
//    for (int j = 0; j < sizeof(arr_f)/ sizeof(float); ++j) {
//        printf("%f\n", arr_f);
//        printf("안녕");
//    }

    char c_array[10]= {'c', 'o', 'd', 'i', 'n', 'g'};

    for (int i = 0; i < sizeof(c_array); ++i) {
        printf("%c\n", c_array[i]);
    }




    return 0;

}