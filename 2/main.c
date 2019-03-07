#include "AppView.h"
#include "Common.h"
#include <math.h>

void main() {
    Boolean solvingIsRequested;
    float c0, c1;
    float root;

    AppView_out_msg_startSolvingLinearEquation(); // 시작 메시지 출력
    solvingIsRequested = AppView_in_solvingIsRequested(); // 문제 풀이 여부를 묻고 응답을 얻는다.

    while (solvingIsRequested) {
        AppView_in_linearEquation(&c0, &c1); // 일차방정식의 계수를 입력 받는다 ;
        AppView_out_linearEquation(c0, c1); // 입력 받은 일차방정식을 보여준다

        if (fabsf(c1) < 0.000001) { // 일차항의 계수가 0 이면
            AppView_out_msg_firstOrderTermCoefficientIsZero(); // 일차항의 계수가 0 이라는 메시지를 출력한다

        } else {
            root = LinearEquation_solve(c0, c1); // 일차방정식을 푼다 ;
            AppView_out_root(root); // 일차방정식의 해를 출력한다 ;

        }
        solvingIsRequested = AppView_in_solvingIsRequested();
    }
    AppView_out_msg_endSolvingLinearEquation(); // 종료 메시지 출력
}

