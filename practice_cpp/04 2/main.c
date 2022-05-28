#include"Common.h"
#include"MagicSquare.h"
#include"AppVIew.h"

void Main_showBoard(MagicSquare* aMagicSquare) { //����
	int anOrder = aMagicSquare->_anOrder;

	char messageBuffer[255];

	sprintf_s((messageBuffer), sizeof(messageBuffer), "> Magic Square Board: Order %2d\n", anOrder);
	AppView_out(messageBuffer);
	AppView_out("      ");

	for (int col = 0; col < anOrder; col++) {
		sprintf_s(messageBuffer, sizeof(messageBuffer), "[%2d] ", col);
		AppView_out(messageBuffer);
	}
	AppView_out("\n");

	for (int row = 0; row < anOrder; row++) {
		printf("[%2d]  ", row);
		for (int col = 0; col < anOrder; col++) {
			printf("  %d ", aMagicSquare->_board[row][col]);
		}
		AppView_out("\n");
	}
	printf("\n");
}

int main() {
	MagicSquare magicSquare; //MagicSqaure ��ü ����
	int inputOrder;         //inputOrder 

	AppView_out("<<< ������ Ǯ�̸� �����մϴ�. >>>\n"); //������ ���� �޽��� ���
	inputOrder = AppView_in_order(); //������ �Է��� �޴´�. 

	while (inputOrder != END_OF_RUN) { //���� �Է��� -1�� ��� ����
		MagicSquare_setOrder(&magicSquare, inputOrder); //��ü�� �����Ͽ� ������ ����
		if (MagicSquare_orderIsValid(&magicSquare)) { // �������� ���� ��ȿ������ Ȯ��
			MagicSquare_solve(&magicSquare);	     //������ Ǯ��
			Main_showBoard(&magicSquare);           //Main �� ���Ͽ� ������ ��� 
		}
		inputOrder = AppView_in_order();          //���� ���Է�
	}
	AppView_out("\n <<< ������ Ǯ�̸� �����մϴ�. >>> \n"); //���������� �޽��� ���

	return 0;
}