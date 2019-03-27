#include"Common.h"
#include"MagicSquare.h"
#include"AppVIew.h"

void Main_showBoard(MagicSquare* aMagicSquare) { //정의

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