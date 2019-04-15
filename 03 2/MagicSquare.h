// 201503069 김재현
#include "Common.h"

typedef struct {
	int _order;
	int _board[MAX_ORDER][MAX_ORDER];
} MagicSquare; //객체 정의;

Boolean MagicSquare_ordersVaild(MagicSquare); //header MagicSquare_ordersValid
void MagicSquare_solve(MagicSquare , int aBoard[MAX_ORDER][MAX_ORDER]); //header MagicSquare_solve



