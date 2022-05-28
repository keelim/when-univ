#include "AppView.h"

void AppView_out_msg_secondOrderTermCoefficientIsZero(void)
{
	printf("2�� ���� ����� 0�̾ ���� �������� �ƴմϴ�. \n");
}

void AppView_out_msg_determinantIsNegative(float aDeterminant)
{
	if (aDeterminant < EPSILON) {
		printf("> �Ǻ����� ���� �����̾, �ذ� �������� �ʽ��ϴ�. ");
		printf("- �Ǻ����� ���� %.1f\n\n", aDeterminant);
	}
}

Boolean AppView_in_SolvingIsRequested(void)
{
	char answer;
	printf("�������� Ǯ���� 'y', Ǯ�̸� �����Ϸ��� �ƹ� Ű�� ġ�ÿ�: ");

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
	printf("2������ ����� �Է��ϼ���: ");
	scanf_s("%f", p_c2);

	printf("1������ ����� �Է��ϼ���: ");
	scanf_s("%f", p_c1);

	printf("������� ����� �Է��ϼ���: ");
	scanf_s("%f", p_c0);
}

void AppView_out_quadEquation(float c0, float c1, float c2)
{
	Boolean aNonZeroTermDoesExist = FALSE;
	printf("�־��� ������: ");
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
		printf("�߱� �Դϴ�. \n");
		printf("x=%.2f\n", root1);
	}
	else {
		printf("�������� �ش� ������ �����ϴ�. \n");
		printf("x1 = %.2f \n x2 = %.2f\n\n", root1, root2);
	}
}

void AppView_out_msg_startSolvingQuadEquation()
{
	printf("���� ������ Ǯ�̸� ���� �մϴ�. ");
}

void AppView_out_msg_endSolvingQuadEquation()
{
	printf("���� ������ Ǯ�̸� ���� �մϴ�. ");
}
