#pragma once
#include "AppController.h"
#include"Time.h"

struct _AppController {
	int control;
};


AppController* AppController_new() {
	AppController* _this;
	_this = NewObject(AppController);
	return _this;

}

void AppController_run(AppController* _this) {
	MagicSquare* magicSquare;
	int order, count;
	Timer* timer;
	long excutionTime;

	timer = Timer_new();
	AppView_out("<<< 프로그램 성능 측정 시작 >>>\n");
	AppView_out("\n프로그램 100회 반복 실행 \n");

	for (order = 9; order <= MAX_ORDER; order += 10) {
		magicSquare = MagicSquare_new(); //MagicSquare* 생성
		Timer_start(timer);             //timer 시작
		for (count = 0; count < 100; count++) { //100회 반복
			MagicSquare_setOrder(magicSquare, order); //차수 설정
			MagicSquare_solve(magicSquare);			 //마방진 해결

		}
		Timer_stop(timer);                       //timer 정지
		MagicSquare_delete(magicSquare);        //magic square free()
		excutionTime = Timer_duration(timer);            //타이머 계산
		AppView_out_execusionTime(order, excutionTime); //타이머 출력

	}
	AppView_out("\n<<< 프로그램 성능 측정 완료 >>>\n");


	//AppView_out("<<< MagicSqaure solve start >>>\n");
	//MagicSquare* magicSquare = MagicSquare_new(); //magicSquare
	//int inputOrder = AppView_in_order(); //차수 입력

	//while (inputOrder != END_OF_RUN) {
	//	MagicSquare_setOrder(magicSquare, inputOrder); //차수 설정
	//	if (MagicSquare_orderIsValid(magicSquare)) {  // 유효성 확인
	//		MagicSquare_solve(magicSquare);          //마방진 해결
	//		AppController_showBoard(_this, magicSquare);//마방진 출력
	//	}
	//	inputOrder = AppView_in_order();   //차수 재 입력
	//}
	//MagicSquare_delete(magicSquare);      //magicSquare free()
	//AppView_out("\n <<< MagicSquare solve end >>> \n");

}

void AppController_delete(AppController* _this) {
	free(_this);

}

void AppController_showBoard(AppController* _this, MagicSquare* aMagicSquare) {
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