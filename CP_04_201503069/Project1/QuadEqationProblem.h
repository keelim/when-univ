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

Boolean QuadEquationProblem_secondOrderTermCoefficientIsZero(QuadEquationProblem* _this); //정의
Boolean QuadEquationProblem_determinantIsNegative(QuadEquationProblem* _this);  //정의

void QuadEquationProblem_setEquation(); //정의 새로이 해야 함

float QuadEquationProblem_determinant(QuadEquationProblem* _this); //정의
Solution QuadEquationProblem_solve(QuadEquationProblem* _this); //정의
