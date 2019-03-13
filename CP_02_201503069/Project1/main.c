#include "QuadEquationProblem.h"
#include "AppView.h"

int main() {
	QuadEquationProblem qeProblem;
	Boolean solvingIsRequested;
	QuadEquation equation;
	Solution solution;

	AppView_out_msg_startSolvingQuadEquation();//시작 메시지 출력
	solvingIsRequested = AppView_in_solvingIsRequested(); //응답확인

	while (solvingIsRequested) {
		AppView_in_quadEquation(&equation._c0, &equation._c1, &equation._c2);//2차 방정식 만들기
		AppView_out_quadEqation(equation._c0, equation._c1, equation._c2); //2차 방정식 완성
		//qeProblem._equation = equation;//속성 값을 바로 지정한다. --> 수정 필요

		if (QuadEquationProblem_secondOrderTermCoefficientIsZero(qeProblem)) {
			AppView_out_msg_secondOederTermCoefficientIsZero(); //오류 메시지 출력
		}
		else {
			if (QuadEquationProblem_determinantIsNegative(qeProblem)) { //부정?
				float determinant  = QuadEquationProblem_determinant(qeProblem);
				AppVIew_out_msg_determinantsIsNegative(determinant); //판별식의 맞지 않는다. 
			}
			else {
				//solution = QuadEquationProblem_solve(qeProblem); //문제 해결 --> 수정 필요
				AppView_out_solution(solution._root1, solution._root2);
			}
		}
		solvingIsRequested = AppView_in_solvingIsRequested();
	
	}
	AppView_out_msg_endSolvingQuadEquation();
	return 0;
}