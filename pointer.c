//
//#include<stdio.h>
//
////int main(void) {
//////    포인터? > 각 각에는 암호가 있다.
////    int chul = 1;
////    int young = 2;
////    int min = 3;
////
////    printf("chul address: %d password %d\n", &chul, chul);
////    printf("chul address: %d password %d\n", &young, young);
////    printf("chul address: %d password %d\n", &min, min);
////
//////    각 집에 방문을 하여 암호를 확인을 하는 것
////    int *mission;// 포인터 변수;
////    mission = &chul;
////    printf("mission address : %d, password %d\n", mission, *mission );
////
////    mission = &young;
////    printf("mission address : %d, password %d\n", mission, *mission );
////
////    mission = &min;
////    printf("mission address : %d, password %d\n", mission, *mission );
////
//////    각 주소값의 변수에서의 연산
////    mission = &chul;
////    *mission*=3;
////    printf("mission address : %d, password %d\n", mission, *mission );
////    printf("mission address : %d, password %d\n", &chul, chul );
////
////    int *spy = mission;
////    printf("\n --------------\n");
////    spy = &chul;
////    *spy -=2;
////    printf("spy address : %d, password %d\n", spy, *spy );
////    printf("chul address : %d, password %d\n", &chul, chul );
////
////
////
////
////    return 0;
////
////}

#include<stdio.h>

int main(void) {
    int arr[3] = {5, 10, 15};

    int*ptr = arr;
    for (int i = 0; i < 3; ++i) {
        printf("배열의 arr[%d] 의 값 %d\n", i, *(arr + i));
    }

    for (int i = 0; i < 3; ++i) {
        printf("배열의 ptr[%d] 의 값 %d\n", i, *(ptr + i));
    }

    return 0;

}