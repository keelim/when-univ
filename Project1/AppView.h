#include <math.h>
#include "Common.h"

// Boolean 사용함으로 Common.h include
void AppView_out_msg_startSolvingLinearEquation();

void AppView_out_msg_endSolvingLinearEquation();

Boolean AppView_in_solvingIsRequested();

void AppView_out_linearEquation(float c0, float c1);

void AppView_out_root(float root);

void AppView_out_msg_firstOrderTermCoefficientIsZero(void);

void AppView_in_linearEquation(float *p_c0, float *p_c1);

float  LinearEquation_solve(float c0, float c1);