#include"Common.h"	
typedef struct {
	int  _anOrder;
	int _board[MAX_ORDER][MAX_ORDER];
} MagicSquare;

void MagicSquare_setOrder(MagicSquare* _this, int anOrder);   //����
Boolean MagicSquare_orderIsValid(MagicSquare* _this); //����
void MagicSquare_solve(MagicSquare* _this);		   //����