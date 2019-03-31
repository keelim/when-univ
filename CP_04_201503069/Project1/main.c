#include "QuadEquationproblem.h"
#include"AppView.h"

int main() {
	QuadEquationProblem qeProblem; //QuadEqautionProblem 객체 생성
	QuadEquation equation;        //QuadEquation 객체 생성
	Solution solution;           //Solution 객체 생성

	AppView_out_msg_startSolvingQuadEquation(); //시작 메시지 출력
	while (AppView_in_SolvingIsRequested()) {  //'y'의 입력인지를 확인 한다. 
		AppView_in_quadEquation(&equation._c0, &equation._c1, &equation._c2); //quadEuqation의 파라미터 전달
		QuadEquationProblem_setEquation(&qeProblem, equation); //setEquation 객체 전달
		AppView_out_quadEquation(equation._c0, equation._c1, equation._c2); //식의 표현을 한다. 

		if (QuadEquationProblem_secondOrderTermCoefficientIsZero(&qeProblem)) { //이차항이 유효한지 객체를 통하여 확인
			AppView_out_msg_secondOrderTermCoefficientIsZero(); //이차항이 제로 메시지를 출력
		}
		else {
			if (QuadEquationProblem_determinantIsNegative(&qeProblem)) { //판별식이 0이하인지를 객체로 확인
				float determinant = QuadEquationProblem_determinant(&qeProblem); //판별식 확인
				AppView_out_msg_determinantIsNegative(determinant); //판별식 0이하 메시지 출력
			}
			else {
				solution = QuadEquationProblem_solve(&qeProblem); 		//객체를 통하여 이차 방정식 풀기
				AppView_out_solution(solution._root1, solution._root2);//이차 방정식 출력
			}
		}
		AppView_out_msg_endSolvingQuadEquation(); //재입력을 받는다. 
	}
	return 0;
}