#include "AppView.h"
#include <stdio.h>
#include <math.h>


void AppView_out_msg_startSolvingLinearEquation() {
	printf("\n <<< 일차 방정식 풀이를 시작 합니다. >>> \n\n"); //시작 메시지 출력

}

void AppView_out_msg_endSolvingLinearEquation() {
	printf("<<< 일차 방정식 풀이를 종료 합니다. >>> \n"); //종료 메시지 출력
}

Boolean AppView_in_solvingIsRequested() {
	char answer; 
	printf("방정식을 풀려면 'y', 풀이를 종료하려면 다른 아무 키나 치시오: ");

	char inputLine[255]; //충분한 공간을 할당 하여 대비
	scanf_s("%s", inputLine, sizeof(inputLine)); // “return” key 로 입력 완료된 한 줄을 가져온다.
	answer = inputLine[0]; // 문자열의 첫번째 문자를 입력값으로 받는다

	if (answer == 'y') {
		return TRUE; //enum 을 통한 불리언

	}
	else {
		return FALSE; //enum 을 통한 불리언

	}
}

void AppView_in_linearEquation(float *p_c0, float *p_c1) {
	printf("1 차항의 계수를 입력하시오: "); 
	scanf_s("%f", p_c1); //scanf() --> scanf_s 변경

	printf("상수항의 계수를 입력하시오: ");
	scanf_s("%f", p_c0); //scanf() --> scanf_s 변경
}

void AppView_out_linearEquation(float c0, float c1) {
	printf(">주어진 방정식: (%.1f) x + (%.1f) = 0 \n", c1, c0); //%.1f 소수 첫째 자리 출력
}

void AppView_out_msg_firstOrderTermCoefficientIsZero() {
	printf("[오류] 1 차항의 계수가 0이어서, 방정식을 풀 수 없습니다.\n\n"); //일차 방정식 특성상 1차항 이 0일 경우 성립 x 오류 메시지 출력
}

void AppView_out_root(float root) {
	printf(">방정식의 해는 다음과 같습니다:\n"); //root 정답 출력
	printf("x = %.1f\n\n", root); //%.1f (소수 첫번 째)
}


float LinearEquation_solve(float c0, float c1) {
	if (FloatValueIsZero(c1)) {  // 1차항의 계수가 0 인지를 검사
		if (c1 * c0 >= 0.0) {   // 두 계수의 부호가 같다
			return -MAXFLOAT;  // 1차항의 계수가 0 이면, 결과는 -∞
		}
		else {  // 두 계수의 부호가 다르다
			return +MAXFLOAT;  // 1차항의 계수가 0 이면, 결과는 +∞
		}
	}
	else {
		return (-c0) / c1; // 정상적인 경우의 계산
	}
}
