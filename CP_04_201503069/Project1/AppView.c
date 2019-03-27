#include "AppView.h"

void AppView_in_quadEquation(float* p_c0, float* p_c1, float* p_c2)
{
	printf("2차항의 계수를 입력하세요");
	scanf("%f", p_c2);

	printf("1차항의 계수를 입력하세요");
	scanf("%f", p_c1);

	printf("상수항의 계수를 입력하세요");
	scanf("%f", p_c0);
}

void AppView_out_msg_startSolvingQuadEquation()
{
	printf("이차 방정식 풀이를 시작 합니다. ");
}

void AppView_out_msg_endSolvingQuadEquation()
{
	printf("이차 방정식 풀이를 종료 합니다. ");
}
