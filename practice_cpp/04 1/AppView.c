#include "AppView.h"

void AppView_out_msg_secondOrderTermCoefficientIsZero(void)
{
	printf("2차 항의 계수가 0이어서 이차 방정식이 아닙니다. \n");
}

void AppView_out_msg_determinantIsNegative(float aDeterminant)
{
	if (aDeterminant < EPSILON) {
		printf("> 판별식의 값이 음수이어서, 해가 존재하지 않습니다. ");
		printf("- 판별식의 값은 %.1f\n\n", aDeterminant);
	}
}

Boolean AppView_in_SolvingIsRequested(void)
{
	char answer;
	printf("방정식을 풀려면 'y', 풀이를 종료하려면 아무 키나 치시오: ");

	char inputLine[255];
	scanf_s("%s", inputLine, sizeof(inputLine));

	answer = inputLine[0];

	if (answer == 'y') {
		return TRUE;

	}
	else {
		return FALSE;
	}
}

void AppView_in_quadEquation(float* p_c0, float* p_c1, float* p_c2)
{
	printf("2차항의 계수를 입력하세요: ");
	scanf_s("%f", p_c2);

	printf("1차항의 계수를 입력하세요: ");
	scanf_s("%f", p_c1);

	printf("상수항의 계수를 입력하세요: ");
	scanf_s("%f", p_c0);
}

void AppView_out_quadEquation(float c0, float c1, float c2)
{
	Boolean aNonZeroTermDoesExist = FALSE;
	printf("주어진 방정식: ");
	if (!(FloatValueIsZero(c2))) {
		aNonZeroTermDoesExist = TRUE;
		printf("(%.1f)x*x", c2);
	}

	if (!FloatValueIsZero(c1)) {
		if (aNonZeroTermDoesExist) {
			printf(" + ");
		}
		aNonZeroTermDoesExist = TRUE;
		printf("(%.1f)x", c1);
	}

	if (!FloatValueIsZero(c0)) {
		if (aNonZeroTermDoesExist) {
			printf(" + ");
		}
		aNonZeroTermDoesExist = TRUE;
		printf("(%.1f)", c0);
	}

	if (!aNonZeroTermDoesExist) {
		printf("0");
	}
	printf(" = 0\n");
}

void AppView_out_solution(float root1, float root2)
{
	if (root1 == root2) {
		printf("중근 입니다. \n");
		printf("x=%.2f\n", root1);
	}
	else {
		printf("방정식의 해는 다음과 같습니다. \n");
		printf("x1 = %.2f \n x2 = %.2f\n\n", root1, root2);
	}
}

void AppView_out_msg_startSolvingQuadEquation()
{
	printf("이차 방정식 풀이를 시작 합니다. ");
}

void AppView_out_msg_endSolvingQuadEquation()
{
	printf("이차 방정식 풀이를 종료 합니다. ");
}
