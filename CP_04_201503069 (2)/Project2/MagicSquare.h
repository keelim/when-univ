#include"Common.h"	
typedef struct {
	int  _anOrder;
	int _col;
	int _row;
} MagicSquare;

void MagicSquare_setOrder(MagicSquare *, int);   //정의
Boolean MagicSquare_orderIsValid(MagicSquare*); //정의
void MagicSquare_solve(MagicSquare*);		   //정의