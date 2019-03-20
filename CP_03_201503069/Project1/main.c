#include"Common.h"
#include"MagicSquare.h"
#include"AppView.h"



#define END_OF_RUN -1

void Main_showBoard(int anOrder, int aBoard[MAX_ORDER][MAX_ORDER]) {
	char messageBuffer[255];

	sprintf_s(messageBuffer, sizeof(messageBuffer), "> Magic Square Board: ORder %2d\n", anOrder);
	AppView_out(messageBuffer);
	AppView_out("    ");

	for (int col = 0; col < anOrder; col++) {
		sprintf_s(messageBuffer, sizeof(messageBuffer), "[%2d]", col);
		AppView_out(messageBuffer);
	}

	AppView_out("\n");

	for (int row = 0; row < anOrder; row++) {
		printf("[%2d]", row);//수정 해야 함
		for (int col = 0; col < anOrder; col++) {
			//수정해야 함
			printf(" %d", aBoard[row][col]);

		}
		printf("\n");
	}

	AppView_out("\n");




}


int main() {
	int inputOrder;
	int board[MAX_ORDER][MAX_ORDER];

	AppView_out("<<< 마방진 풀이를 시작합니다. >>>\n");
	inputOrder = AppView_in_order(); //scanf 를 통하여 입력을 받는다. 
	while (inputOrder != END_OF_RUN) { //음수이면 종료

		if (MagicSquare_ordersVaild(inputOrder)) { //유효값인지를 확인
			MagicSquare_solve(inputOrder, board); //값의 해결

			Main_showBoard(inputOrder, board);    //마방진 나타내기
		}

		inputOrder = AppView_in_order(); //재입력
	}
	AppView_out("\n <<< 마방진 풀이를 종료합니다. >>>\n");


	return 0;
} //main 종료
