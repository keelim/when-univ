#include "Common.h"
#include "string.h"
#include "OStack.h"
#include "AppView.h"

typedef struct _Infix Infix;

#define isDigit(CHAR) (('0' <= CHAR) && (CHAR <='9'))
#define DEFAULT_MAX_NUMBER_OF_TOKENS 100

Infix* Infix_new (); //Infix 생성

void Infix_delete (Infix* _this); //Infix 소멸

 void Infix_setExpression (Infix* _this, char* newExpression); 
 //Infix expression 설정
Boolean Infix_toPostfix (Infix* _this);
// infix  -> to postfix
char* Infix_postfix (Infix* _this);