#include "QuadEquationProblem.h"
#include <math.h> //Call by value Call by reference

//중근의 처리

Boolean QuadEquationProblem_secondOrderTermCoefficientIsZero(QuadEquationProblem aProblem) {//가지고 있는 2차 방정식의 2차항의 0 인지를 판단한다. 

	float abs_c2 = ( float ) abs(( int ) aProblem._equation._c2);
	if ( abs_c2 < EPSILON ) {
		return TRUE;

	}
	return FALSE;
}

Boolean QuadEquationProblem_determinantIsNegative(QuadEquationProblem aProblem) {// 완료 비제곱 마이너스 사에이씨

	float a = aProblem._equation._c2;
	float b = aProblem._equation._c1;
	float c = aProblem._equation._c0;
	float determinant = b * b - 4 * a*c;

	if ( determinant < EPSILON ) {

		if ( determinant < -EPSILON ) {
			return TRUE;

		} else {
			return FALSE;

		}

	} else {
		return FALSE;

	}
}

float QuadEquationProblem_determinant(QuadEquationProblem aProblem) {
	float a = aProblem._equation._c2;
	float b = aProblem._equation._c1;
	float c = aProblem._equation._c0;

	float determinant = b * b - 4 * (a * c);

	return determinant;
}

Solution QuadEquationProblem_solve(QuadEquationProblem aProblem) { //--> 중근의 처리는?
	Solution solution;

	float determinant = QuadEquationProblem_determinant(aProblem);
	float sqrtDeterminant = ( float ) sqrt(determinant);

	if ( determinant < EPSILON ) {
		solution._root1 = (-aProblem._equation._c1 + sqrtDeterminant) / (2.0f*aProblem._equation._c2);
		solution._root2 = solution._root1;
	}


	solution._root1 = (-aProblem._equation._c1 + sqrtDeterminant) / (2.0f*aProblem._equation._c2);
	solution._root2 = (-aProblem._equation._c1 - sqrtDeterminant) / (2.0f*aProblem._equation._c2);

	if ( fabs(solution._root1) < EPSILON ) {
		solution._root1 = fabs(solution._root1);
	}

	if ( fabs(solution._root2) < EPSILON ) {
		solution._root2 = fabs(solution._root2);
	}

	return solution;
}
