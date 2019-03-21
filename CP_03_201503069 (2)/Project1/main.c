// 201503069 김재현
#include"Common.h"
#include"MagicSquare.h"
#include"AppView.h"



#define END_OF_RUN -1

void Main_showBoard(MagicSquare aMagicSquare) {
	int anOrder = aMagicSquare._order;
	
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
			printf("  %d", aMagicSquare._board[row][col]);

		}
		printf("\n");
	}

	AppView_out("\n");




}


int main() {
	MagicSquare magicSquare;
	
	AppView_out("<<< 마방진 풀이를 시작합니다. >>>\n");
	int inputOrder = AppView_in_order(); //scanf 를 통하여 입력을 받는다. 
	while (inputOrder != END_OF_RUN) { //음수이면 종료
		magicSquare._order = inputOrder;
		if (MagicSquare_ordersVaild(magicSquare)) { //유효값인지를 확인
			MagicSquare_solve(magicSquare, magicSquare._board); //값의 해결

			Main_showBoard(magicSquare);    //마방진 나타내기
		}

		inputOrder = AppView_in_order(); //재입력
	}
	AppView_out("\n <<< 마방진 풀이를 종료합니다. >>>\n");


	return 0;
}
