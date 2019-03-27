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

Boolean QuadEquationProblem_secondOrderTermCoefficientIsZero(); //정의
Boolean QuadEquationProblem_determinantIsNegative();  //정의

void QuadEquationProblem_setEquation(); //정의

float QuadEquationProblem_determinant(QuadEquationProblem* _this); //정의
Solution QuadEquationProblem_solve(QuadEquationProblem* _this); //정의
