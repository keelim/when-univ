#pragma once
#include"Common.h"	

typedef struct { //def struct magicSquare
	int  _anOrder;
	int _board[MAX_ORDER][MAX_ORDER];
} MagicSquare;

MagicSquare* MagicSquare_new(); //def like constructor like java

int MagicSquare_order(MagicSquare* _this);

Boolean MagicSquare_orderIsValid(MagicSquare* _this); //def

void MagicSquare_setOrder(MagicSquare* _this, int anOrder); //def
void MagicSquare_solve(MagicSquare* _this);	//def	 
void MagicSquare_delete(MagicSquare* _this); //def