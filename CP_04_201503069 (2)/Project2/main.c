#include"Common.h"
#include"MagicSquare.h"
#include"AppVIew.h"

void Main_showBoard(MagicSquare* aMagicSquare) { //정의
	int anOrder = aMagicSquare->_anOrder;

	char messageBuffer[255];

	sprintf_s((messageBuffer), sizeof(messageBuffer), "> Magic Square Board: Order %2d\n", anOrder);
	AppView_out(messageBuffer);
	AppView_out("      ");

	for (int col = 0; col < anOrder; col++) {
		sprintf_s(messageBuffer, sizeof(messageBuffer), "[%2d]", col);
		AppView_out(messageBuffer);
	}
	AppView_out("\n");

	for (int row = 0; row < anOrder; row++) {
		printf("[%2d]", row);
		for (int col = 0; col < anOrder; col++) {
			printf("  %d", aMagicSquare->_board[row][col]);
		}
	}
	printf("\n");
}

int main() {
	MagicSquare magicSquare;
	int inputOrder;

	AppView_out("<<< 마방진 풀이를 시작합니다. >>>\n");
	inputOrder = AppView_in_order();

	while (inputOrder != END_OF_RUN) {
		MagicSquare_setOrder(&magicSquare, inputOrder);
		if (MagicSquare_orderIsValid(&magicSquare)) {
			MagicSquare_solve(&magicSquare);
			Main_showBoard(&magicSquare);
		}
		inputOrder = AppView_in_order();
	}
	AppView_out("\n <<< 마방진 풀이를 종료합니다. >>> \n");

	return 0;
}