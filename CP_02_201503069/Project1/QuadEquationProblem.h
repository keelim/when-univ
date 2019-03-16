
#include "Common.h"


typedef struct{ 
	QuadEquation _equation;
} QuadEquationProblem;

Boolean QuadEquationProblem_secondOrderTermCoefficientIsZero(QuadEquationProblem aProblem); //2차항이 0인지를 판단한다. 

Boolean QuadEquationProblem_determinantIsNegative(QuadEquationProblem aProblem); //판별 식의 값이 음수인지를 판단한다. 

float QuadEquationProblem_determinant(QuadEquationProblem aProblem); // 판별식의 값을 리턴을 한다. 

Solution QuadEquationProblem_solve(QuadEquationProblem aProblem); // 판별식의 값을 이용하여 문제를 해결 한다. 