#include"Common.h"
#include"MagicSquare.h"
#include"AppView.h"



#define END_OF_RUN -1

void Main_showBoard(int anOrder, int aBoard[MAX_ORDER][MAX_ORDER]) {
	char messageBuffer[255];

	sprintf_s(messageBuffer,sizeof(messageBuffer), "> Magic Square Board: ORder %2d\n", anOrder);
	AppView_out(messageBuffer);
	AppView_out("    ");

	for (int col = 0; col < anOrder; col++) {
		sprintf_s(messageBuffer,sizeof(messageBuffer), "[%2d]", col);
		AppView_out(messageBuffer);
	}

	AppView_out("\n");

	for (int row = 0; row < anOrder; row++) {
		//수정해야 함
		for (int col = 0; col < anOrder; col++) {
			//수정해야 함
		}
	}

	AppView_out("\n");
	



}


int main() {
	int inputOrder;
	int board[MAX_ORDER][MAX_ORDER];

	AppView_out("<<< 마방진 풀이를 시작합니다. >>>\n");
	inputOrder = AppView_in_order();

	return 0;
}
