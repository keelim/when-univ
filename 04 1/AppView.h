#pragma once
#include"Common.h"
#include <stdio.h>
#include<math.h>

void AppView_out_msg_secondOrderTermCoefficientIsZero(void);
void AppView_out_msg_determinantIsNegative(float aDeterminant);

Boolean AppView_in_SolvingIsRequested(void);
void AppView_in_quadEquation(float* p_c0, float* p_c1, float* p_c2);

void AppView_out_quadEquation(float c0, float c1, float c2);
void AppView_out_solution(float root1, float root2);

void AppView_out_msg_startSolvingQuadEquation();
void AppView_out_msg_endSolvingQuadEquation();
