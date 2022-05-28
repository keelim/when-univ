#pragma once
#include"Common.h"

typedef struct {
	float _c0;
	float _c1;
	float _c2;
} QuadEquation;

typedef struct {
	float _root1;
	float _root2;
} Solution;

typedef struct {
	QuadEquation _equation;
} QuadEquationProblem;

Boolean QuadEquationProblem_secondOrderTermCoefficientIsZero(QuadEquationProblem* _this); //����
Boolean QuadEquationProblem_determinantIsNegative(QuadEquationProblem* _this);  //����

void QuadEquationProblem_setEquation(QuadEquationProblem* _this, QuadEquation _problem); //����

float QuadEquationProblem_determinant(QuadEquationProblem* _this); //����
Solution QuadEquationProblem_solve(QuadEquationProblem* _this); //����
