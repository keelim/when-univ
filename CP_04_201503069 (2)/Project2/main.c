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
	MagicSquare magicSquare; //MagicSqaure 객체 생성
	int inputOrder;         //inputOrder 

	AppView_out("<<< 마방진 풀이를 시작합니다. >>>\n"); //마방진 시작 메시지 출력
	inputOrder = AppView_in_order(); //차수의 입력을 받는다. 

	while (inputOrder != END_OF_RUN) { //차수 입력이 -1일 경우 종료
		MagicSquare_setOrder(&magicSquare, inputOrder); //객체를 전달하여 차수를 정의
		if (MagicSquare_orderIsValid(&magicSquare)) { // 마방진의 값이 유효한지를 확인
			MagicSquare_solve(&magicSquare);	     //마방진 풀이
			Main_showBoard(&magicSquare);           //Main 을 통하여 마방진 출력 
		}
		inputOrder = AppView_in_order();          //차수 재입력
	}
	AppView_out("\n <<< 마방진 풀이를 종료합니다. >>> \n"); //마방진종료 메시지 출력

	return 0;
}