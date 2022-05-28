﻿#pragma once
#include<stdio.h>
#include "MagicSquare.h"
#define EMPTY_CELL -1

typedef struct {
	int _row;
	int _col;
} CellLocation;


MagicSquare* MagicSquare_new(){
	MagicSquare* _this;
	_this = NewObject(MagicSquare);
	
	return _this;
}

void MagicSquare_setOrder(MagicSquare* _this, int anOrder) {
	_this->_anOrder = anOrder;

}

int MagicSquare_order(MagicSquare* _this) {
	return _this->_anOrder;

}

Boolean MagicSquare_orderIsValid(MagicSquare* _this) {
	int anOrder = _this->_anOrder;

	if(anOrder < 3) {
		AppView_out("<<< ? 최소 차수가 3이하보다 작습니다.   >>>  \n");

		return FALSE;
	} else if(anOrder > MAX_ORDER) { //99 ??? ????
		char messageBuffer[255];
		sprintf_s(messageBuffer, sizeof(messageBuffer), "> 입력하신 차수가 %d 보다 큽니다.  \n", MAX_ORDER);
		AppView_out(messageBuffer);
		return FALSE;

	} else if((anOrder % 2) == 0) {
		AppView_out("> 입력하신 차수가 짝수 입니다. \n");
		return FALSE;

	} else {
		return TRUE;

	}
}

void MagicSquare_solve(MagicSquare* _this) {
	int row, col;
	int anOrder = _this->_anOrder; //
	int* aBoard = _this->_board;

	for(row = 0; row < anOrder; row++) {
		for(col = 0; col < anOrder; col++) {
			_this->_board[row][col] = EMPTY_CELL;
		}

	}

	CellLocation cu_loc;
	CellLocation next_loc;
	cu_loc._row = 0;
	cu_loc._col = anOrder / 2;
	next_loc._row = 0;
	next_loc._col = anOrder / 2;

	int CellValue = 1;
	_this->_board[cu_loc._row][cu_loc._col] = CellValue;

	int lastCellValue = anOrder * anOrder;
	CellValue = 2;

	for(CellValue = 2; CellValue <= lastCellValue; CellValue++) { //CellValue  ?? ?????? ???.
		next_loc._row -= 1;
		if(next_loc._row < 0) {
			next_loc._row = anOrder - 1;

		}
		next_loc._col += 1;
		if(next_loc._col >= anOrder) {
			next_loc._col = 0;

		}

		if(_this->_board[next_loc._row][next_loc._col] != EMPTY_CELL) {
			next_loc._row = cu_loc._row + 1;
			next_loc._col = cu_loc._col;

		}
		_this->_board[next_loc._row][next_loc._col] = CellValue;
		cu_loc = next_loc;

	}
}


void MagicSquare_delete(MagicSquare* _this) {
	free(_this);

}