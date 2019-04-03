#pragma once
#include "AppController.h"

struct _AppController {
	int name;
};


AppController* AppController_new()
{
	AppController* _this;
	_this = NewObject(AppController);
	return _this;
}

void AppController_run(AppController* _this)
{

	AppView_out("<<< 마방진 풀이를 시작합니다. >>>\n");
	MagicSquare* magicSquare = MagicSquare_new();
	int inputOrder = AppView_in_order();

	while (inputOrder != END_OF_RUN) {
		MagicSquare_setOrder(magicSquare, inputOrder);
		if (MagicSquare_orderIsValid(magicSquare)) {
			MagicSquare_solve(magicSquare);
			AppController_showBoard(_this, magicSquare);
		}
		inputOrder = AppView_in_order();
	}
	MagicSquare_delete(magicSquare);
	AppView_out("\n <<< 마방진 풀이를 종료합니다. >>> \n");

}

void AppController_delete(AppController* _this)
{
	free(_this);
}

void AppController_showBoard(AppController* _this, MagicSquare* aMagicSquare)
{
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


