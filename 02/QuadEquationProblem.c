#include "QuadEquationProblem.h"
#include <math.h> 



Boolean QuadEquationProblem_secondOrderTermCoefficientIsZero(QuadEquationProblem aProblem) {//가지고 있는 2차 방정식의 2차항의 0 인지를 판단한다. 

	float abs_c2 = ( float ) abs(( int ) aProblem._equation._c2); //0인 것만을 출력해야 한다. 그 이하는 판별식이 0임으로 조건 x
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

	if ( determinant < EPSILON ) { //determinant의 0의 값을 한정한다. 

		if ( determinant < -EPSILON ) { //한정 값에서 더 작은 수를 FALSE 를 리턴한다. 판별식 <0
			return TRUE;

		} else { //else 의 경우는 판별식 == 0 인 경우
			return FALSE;

		}

	} else {
		return FALSE;

	}
}

float QuadEquationProblem_determinant(QuadEquationProblem aProblem) { //판별식을 리턴한다. 
	float a = aProblem._equation._c2;
	float b = aProblem._equation._c1;
	float c = aProblem._equation._c0;

	float determinant = b * b - 4 * (a * c);

	return determinant;
}

Solution QuadEquationProblem_solve(QuadEquationProblem aProblem) { //이차 방정식을 푸는 함수 이다. 
	Solution solution;

	float determinant = QuadEquationProblem_determinant(aProblem);
	float sqrtDeterminant = ( float ) sqrt(determinant);

	if ( determinant < EPSILON ) { //determinant < EPSILON d=0 은 중근임으로 값을 하나만 출력을 한다. 
		solution._root1 = (-aProblem._equation._c1 + sqrtDeterminant) / (2.0f*aProblem._equation._c2);
		solution._root2 = solution._root1;
	}


	solution._root1 = (-aProblem._equation._c1 + sqrtDeterminant) / (2.0f*aProblem._equation._c2);
	solution._root2 = (-aProblem._equation._c1 - sqrtDeterminant) / (2.0f*aProblem._equation._c2);

	if ( fabs(solution._root1) < EPSILON ) { //-0.0 이 출력이 될 수 있음으로 방지.
		solution._root1 = (float) fabs(solution._root1);
	}

	if ( fabs(solution._root2) < EPSILON ) { //-0.0 이 출력이 될 수 있음으로 방지.
		solution._root2 = (float) fabs(solution._root2);
	}

	return solution;
}
