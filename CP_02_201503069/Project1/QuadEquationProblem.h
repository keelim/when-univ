#include "Common.h"

typedef struct{ //수정 해야 함
	QuadEquation _equation;
} QuadEquationProblem;

Boolean QuadEquationProblem_secondOrderTermCoefficientIsZero(QuadEquationProblem aProblem);

Boolean QuadEquationProblem_determinantIsNegative(QuadEquationProblem aProblem);

float QuadEquationProblem_determinant(QuadEquationProblem aProblem);

Solution QuadEquationProblem_solve(QuadEquationProblem aProblem);