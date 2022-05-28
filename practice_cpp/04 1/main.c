#include "QuadEqationProblem.h"
#include"AppView.h"

int main() {
	QuadEquationProblem qeProblem; //QuadEqautionProblem ��ü ����
	QuadEquation equation;        //QuadEquation ��ü ����
	Solution solution;           //Solution ��ü ����

	AppView_out_msg_startSolvingQuadEquation(); //���� �޽��� ���
	while (AppView_in_SolvingIsRequested()) {  //'y'�� �Է������� Ȯ�� �Ѵ�. 
		AppView_in_quadEquation(&equation._c0, &equation._c1, &equation._c2); //quadEuqation�� �Ķ���� ����
		QuadEquationProblem_setEquation(&qeProblem, equation); //setEquation ��ü ����
		AppView_out_quadEquation(equation._c0, equation._c1, equation._c2); //���� ǥ���� �Ѵ�. 

		if (QuadEquationProblem_secondOrderTermCoefficientIsZero(&qeProblem)) { //�������� ��ȿ���� ��ü�� ���Ͽ� Ȯ��
			AppView_out_msg_secondOrderTermCoefficientIsZero(); //�������� ���� �޽����� ���
		}
		else {
			if (QuadEquationProblem_determinantIsNegative(&qeProblem)) { //�Ǻ����� 0���������� ��ü�� Ȯ��
				float determinant = QuadEquationProblem_determinant(&qeProblem); //�Ǻ��� Ȯ��
				AppView_out_msg_determinantIsNegative(determinant); //�Ǻ��� 0���� �޽��� ���
			}
			else {
				solution = QuadEquationProblem_solve(&qeProblem); 		//��ü�� ���Ͽ� ���� ������ Ǯ��
				AppView_out_solution(solution._root1, solution._root2);//���� ������ ���
			}
		}
		AppView_out_msg_endSolvingQuadEquation(); //���Է��� �޴´�. 
	}
	return 0;
}