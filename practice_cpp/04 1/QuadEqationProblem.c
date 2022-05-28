#include "QuadEqationProblem.h"
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

	if (determinant < EPSILON) { //determinant�� 0�� ���� �����Ѵ�. 

		if (determinant < -EPSILON) { //���� ������ �� ���� ���� FALSE �� �����Ѵ�. �Ǻ��� <0
			return TRUE;

		}
		else { //else �� ���� �Ǻ��� == 0 �� ���
			return FALSE;

		}

	}
	else {
		return FALSE;

	}
}

void QuadEquationProblem_setEquation(QuadEquationProblem* _this, QuadEquation _problem)
{
	_this->_equation._c0 = _problem._c0;
	_this->_equation._c1 = _problem._c1;
	_this->_equation._c2 = _problem._c2;
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

	if (determinant < EPSILON) { //determinant < EPSILON d=0 �� �߱������� ���� �ϳ��� ����� �Ѵ�. 
		solution._root1 = (-_this->_equation._c1 + sqrtDeterminant) / (2.0f * _this->_equation._c2);
		solution._root2 = solution._root1;
	}


	solution._root1 = (-_this->_equation._c1 + sqrtDeterminant) / (2.0f * _this->_equation._c2);
	solution._root2 = (-_this->_equation._c1 - sqrtDeterminant) / (2.0f * _this->_equation._c2);

	if (fabs(solution._root1) < EPSILON) { //-0.0 �� ����� �� �� �������� ����.
		solution._root1 = (float)fabs(solution._root1);
	}

	if (fabs(solution._root2) < EPSILON) { //-0.0 �� ����� �� �� �������� ����.
		solution._root2 = (float)fabs(solution._root2);
	}

	return solution;
}
