#include"Common.h"	
typedef struct {
	int  _anOrder;
	int _board[MAX_ORDER][MAX_ORDER];
} MagicSquare;

void MagicSquare_setOrder(MagicSquare* _this, int anOrder);   //정의
Boolean MagicSquare_orderIsValid(MagicSquare* _this); //정의
void MagicSquare_solve(MagicSquare* _this);		   //정의