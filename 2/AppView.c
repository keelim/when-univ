#include "AppView.h"
#include <stdio.h>
#include <math.h>


void AppView_out_msg_endSolvingLinearEquation() {
    printf("일차 방정식 풀이를 시작 합니다. ");

}

void AppView_out_msg_startSolvingLinearEquation() {
    printf("일차 방정식 풀이를 종료 합니다. ");
}

Boolean AppView_in_solvingIsRequested() {
    char answer;
    printf("방정식을 풀려면 'y', 풀이를 종료하려면 다른 아무 키나 치시오: ");
    char inputLine[255];
    scanf("%s", inputLine); // “return” key 로 입력 완료된 한 줄을 가져온다.
    answer = inputLine[0]; // 문자열의 첫번째 문자를 입력값으로 받는다
    if (answer == 'y') {
        return TRUE;
    } else {
        return FALSE;
    }
}

void AppView_in_linearEquation(float *p_c0, float *p_c1) {
    printf("1 차항의 계수를 입력하시오: ");
    scanf("%f", p_c1);
    printf("상수항의 계수를 입력하시오: ");
    scanf("%f", p_c0);
}

void AppView_out_linearEquation(float c0, float c1) {
    printf(">주어진 방정식: (%f) x + (%f) = 0 \n", c1, c0);
}

void AppView_out_msg_firstOrderTermCoefficientIsZero() {
    printf("일차 항의 계수가 0 입니다. ");
}

void AppView_out_root(float root) {
    printf(">방정식의 해는 다음과 같습니다:\n");
    printf("x = %f\n", root);
}


float LinearEquation_solve(float c0, float c1) {
    if (fabsf(c1) < 0.000001) {  // 1차항의 계수가 0 인지를 검사
        if (c1 * c0 >= 0.0) {  // 두 계수의 부호가 같다
            return -MAXFLOAT; // 1차항의 계수가 0 이면, 결과는 -∞
        } else {  // 두 계수의 부호가 다르다
            return +MAXFLOAT;  // 1차항의 계수가 0 이면, 결과는 +∞
        }
    } else {
        return (-c0) / c1; // 정상적인 경우의 계산
    }
}
