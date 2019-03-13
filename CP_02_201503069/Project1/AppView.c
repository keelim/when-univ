#include "AppView.h"

Boolean AppView_in_solvingIsRequested(void)
{
	char answer;
	printf("방정식을 풀려면'y', 풀이를 종료하려면 아무 키나 치시오: ");

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

void AppView_in_quadEquation(float * p_c0, float * p_c1, float * p_c2)
{
	printf("2차항의 계수를 입력하시오: ");
	scanf_s("%f", p_c2);

	printf("1차항의 계수를 입력하시오: ");
	scanf_s("%f", p_c1);

	printf("상수항의 계수를 입력하시오: ");
	scanf_s("%f", p_c0);
}

void AppView_out_msg_startSolvingQuadEquation(void)
{
	printf("\n<<< 2차 방정식의 풀이를 시작합니다. >>>\n\n");
}

void AppView_out_msg_endSolvingQuadEquation(void)
{
	printf("<<< 2차 방정식의 풀이를 종료합니다.  >>>");
}

void AppView_out_msg_secondOederTermCoefficientIsZero()
{
	printf("2차 항의 계수가 0이서 이차 방정식이 아닙니다. ");
}

void AppVIew_out_msg_determinantsIsNegative(float aDterminant)
{// 재확인 필요
	if (aDterminant < 0) {
		printf("> 판별식의 값이 음수이어서, 해가 존재하지 않습니다. ");

	}
	else {
		printf("-판별식의 값은 (%.1f)", aDterminant);
	}
}



void AppView_out_quadEqation(float c0, float c1, float c2)
{ //MACRO 방식의 수정이 필요
	Boolean aNonZeroTermDoesExist = FALSE; //0인 계수가 없을 때

	if (!(fabsf(c2) < 0)) {
		aNonZeroTermDoesExist = TRUE;
		printf("(%f) x*x", c2);
	}
	if (!(fabsf(c1) < 0)) {
		if (aNonZeroTermDoesExist) {
			printf(" + ");
		}
		aNonZeroTermDoesExist = TRUE;
		printf("(%f) x", c1);
	}

	if (!(fabsf(c0) < 0)) {
		if (aNonZeroTermDoesExist) {
			printf(" + ");
		}
		aNonZeroTermDoesExist = TRUE;
		printf("(%f)", c0);
	}

	if (!aNonZeroTermDoesExist) {
		printf("0"); //모든 항의 계수가 0이어서 출력된 항이 없다. 
	}

	printf(" = 0\n");
}

void AppView_out_solution(float root1, float root2)
{
	printf("방정식의 해는 다음과 같습니다. \n");
	printf("x1 = %.1f \n x2 = %.1f\n", root1, root2);
}
