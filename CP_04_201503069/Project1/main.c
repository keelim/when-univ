#include"QuadEuqationProblem.h"
#include"AppView.h"

int main() {
	QuadEquationProblem qeProblem;
	QuadEquation equation;
	Solution solution;

	AppView_out_msg_startSolvingQuadEquation();
	while (AppView_out_msg_startSolvingQuadEquation) {
		AppView_in_quadEquation(&equation._c0, &equation._c1, &equation._c2);
		QuadEquationProblem_setEquation(&qeProblem, equation);
		AppView_out_quadEquation(equation._c0, equation._c1, equation._c2);

		if (QuadEquationProblem_secondOrderTermCoefficientIsZero(&qeProblem)) {
			AppView_out_msg_secondOrderTermCoefficientIsZero();
		}
		else {
			if (QuadEquationProblem_determinantIsNegative(&qeProblem)) {
				float determinant = QuadEquationProblem_determinant(&qeProblem);
				AppView_out_msg_determinantIsNegative(determinant);
			}
			else {
				solution = QuadEquationProblem_solve(&qeProblem);				
				AppView_out_solution(solution._root1, solution._root2);
			}
		}
		AppView_out_msg_endSolvingQuadEquation();
	}
	return 0;
}