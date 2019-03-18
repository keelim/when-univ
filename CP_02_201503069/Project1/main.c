#include "AppView.h"
#include "QuadEquationProblem.h"

int main() {
	QuadEquationProblem qeProblem; //문제 정의
	Boolean solvingIsRequested;   // 입력값 정의
	QuadEquation equation;       // 이차 방정식 정의
	Solution solution;          // 정답 정의

	AppView_out_msg_startSolvingQuadEquation();            //시작 메시지 출력
	solvingIsRequested = AppView_in_solvingIsRequested(); //응답확인

	while ( solvingIsRequested ) {
		AppView_in_quadEquation(&equation._c0, &equation._c1, &equation._c2);//2차 방정식 만들기
		AppView_out_quadEqation(equation._c0, equation._c1, equation._c2);  //2차 방정식 완성
		qeProblem._equation = equation;                                    //속성 값을 바로 지정한다. 

		if ( QuadEquationProblem_secondOrderTermCoefficientIsZero(qeProblem) ) { // 2차 항의 계수가 0인지를 판단한다. 
			AppView_out_msg_secondOederTermCoefficientIsZero();                 //오류 메시지 출력

		} else {
			if ( QuadEquationProblem_determinantIsNegative(qeProblem) ) {		 //부정? --> 가지고 있는 것이 판별식이 0인가?
				float determinant = QuadEquationProblem_determinant(qeProblem); // 판별식의 값을 리턴 한다. 
				AppVIew_out_msg_determinantsIsNegative(determinant);		   //판별식의 맞지 않는다. 

			} else {
				solution = QuadEquationProblem_solve(qeProblem);		 //문제 해결 
				AppView_out_solution(solution._root1, solution._root2); // 해결되는 내용을 출력 한다. 

			}
		}
		solvingIsRequested = AppView_in_solvingIsRequested(); // 응답 및 재학인

	}
	AppView_out_msg_endSolvingQuadEquation(); //종료 메시지 출력

	return 0;
}