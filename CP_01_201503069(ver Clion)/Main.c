#include "AppView.h"
#include <math.h>

void main() {
	Boolean solvingIsRequested; 
	float c0, c1; //입력 변수 선언
	float root;  //출력 정답 변수 선언

	AppView_out_msg_startSolvingLinearEquation();          // 시작 메시지 출력
	solvingIsRequested = AppView_in_solvingIsRequested(); // 문제 풀이 여부 및 응답

	while (solvingIsRequested) {              // solvingIsRequested 를 통하여 
		AppView_in_linearEquation(&c0, &c1); // 일차방정식의 계수를 입력 받는다 ;
		AppView_out_linearEquation(c0, c1); // 입력 받은 일차방정식을 보여준다

		if (FloatValueIsZero(c1)) {                             // 일차항의 계수가 0 이면
			AppView_out_msg_firstOrderTermCoefficientIsZero(); // 일차항의 계수가 0

		}
		else {
			root = LinearEquation_solve(c0, c1); // 일차방정식을 푼다 ;
			AppView_out_root(root);             // 일차방정식의 해를 출력한다 ;

		}
		solvingIsRequested = AppView_in_solvingIsRequested(); // 문제 풀이 여부 및 응답 --> while condition

	}
	AppView_out_msg_endSolvingLinearEquation(); // 종료 메시지 출력
}
