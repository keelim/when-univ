#include "Common.h"
#include "Stack.h"
#include <string.h>
#include "AppView.h"


typedef struct _Postfix Postfix;

Postfix *Postfix_new(int givenMaxNumberOfTokens);

void Postfix_delete(Postfix *_this);

void Postfix_setExpression(Postfix *_this, char *anExpression);

//계산할 postfix 수식인 expression[] 을 postfix 객체에 전달한다.
Boolean Postfix_evaluate(Postfix *_this);

//현재 객체가 가지고 있는 postfix 수식을 계산하도록 지시한다.
//정상적으로 계산이 되었으면 TRUE를, 아니면 FALSE를 return 받는다.
int Postfix_evaluatedValue(Postfix *_this);
//계산된 결과 값을 Postifx 객체로부터 얻는다.

Postfix_showTokenAndStack(Postfix* _this, char currentToken);