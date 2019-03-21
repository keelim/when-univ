// 201503069 김재현
#include "Common.h"

typedef struct {
	int _order;
	int _board[MAX_ORDER][MAX_ORDER];
} MagicSquare //헤더의 위치가 중요하다. 

Boolean MagicSquare_ordersVaild(MagicSquare);
void MagicSquare_solve(MagicSquare , int aBoard[MAX_ORDER][MAX_ORDER]);



