#include "Common.h"
#include <stdio.h>

//입력
Boolean AppView_in_solvingIsRequested(void);

void AppView_in_quadEquation(float* p_c0, float* p_c1, float* p_c2);

void AppView_out_msg_startSolvingQuadEquation(void);

void AppView_out_msg_endSolvingQuadEquation(void);

void AppView_out_msg_secondOederTermCoefficientIsZero();

void AppVIew_out_msg_determinantsIsNegative(float aDterminant);

void AppView_out_quadEqation(float c0, float c1, float c2);

void AppView_out_solution(float root1, float root2);

