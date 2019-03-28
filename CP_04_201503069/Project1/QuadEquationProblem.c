#include "QuadEquationProblem.h"
#include<math.h>


Boolean QuadEquationProblem_secondOrderTermCoefficientIsZero(QuadEquationProblem* _this)
{
	float abs_c2 = (float)abs((int)_this->_equation._c2);
	if (abs_c2 < EPSILON) {
		return TRUE;
	}
	return FALSE;
}

Boolean QuadEquationProblem_determinantIsNegative(QuadEquationProblem* _this)
{

	float a = _this->_equation._c2;
	float b = _this->_equation._c1;
	float c = _this->_equation._c0;
	
	float determinant = b * b - 4 * a * c;

	if (determinant < EPSILON) { //determinant의 0의 값을 한정한다. 

		if (determinant < -EPSILON) { //한정 값에서 더 작은 수를 FALSE 를 리턴한다. 판별식 <0
			return TRUE;

		}
		else { //else 의 경우는 판별식 == 0 인 경우
			return FALSE;

		}

	}
	else {
		return FALSE;

	}
}

void QuadEquationProblem_setEquation(QuadEquationProblem* _this, QuadEquation anEquation)
{
	_this->_equation._c0 = anEquation._c0;
	_this->_equation._c1 = anEquation._c1;
	_this->_equation._c2 = anEquation._c2;
}

float QuadEquationProblem_determinant(QuadEquationProblem* _this)
{
	float a = _this->_equation._c2;
	float b = _this->_equation._c1;
	float c = _this->_equation._c0;

	float determinant = b * b - 4 * (a * c);

	return determinant;
}

Solution QuadEquationProblem_solve(QuadEquationProblem* _this)
{
	Solution solution;

	float determinant = QuadEquationProblem_determinant(_this);
	float sqrtDeterminant = (float)sqrt(determinant);

	if (determinant < EPSILON) { //determinant < EPSILON d=0 은 중근임으로 값을 하나만 출력을 한다. 
		solution._root1 = (-_this->_equation._c1 + sqrtDeterminant) / (2.0f * _this->_equation._c2);
		solution._root2 = solution._root1;
	}


	solution._root1 = (-_this->_equation._c1 + sqrtDeterminant) / (2.0f * _this->_equation._c2);
	solution._root2 = (-_this->_equation._c1 - sqrtDeterminant) / (2.0f * _this->_equation._c2);

	if (fabs(solution._root1) < EPSILON) { //-0.0 이 출력이 될 수 있음으로 방지.
		solution._root1 = (float)fabs(solution._root1);
	}

	if (fabs(solution._root2) < EPSILON) { //-0.0 이 출력이 될 수 있음으로 방지.
		solution._root2 = (float)fabs(solution._root2);
	}

	return solution;
}
