#include "Common.h"
#include "Node.h"
#include "Queue.h"
#include "AppView.h"

#define Esc 27
#define isDigit(CHAR) (('0' <= CHAR) && (CHAR <='9'))
#define isAlpha(CHAR) ((('A' <= CHAR) && (CHAR <= 'Z')) || (('a' <= CHAR) && (CHAR <= 'z')))

typedef struct _AppController AppController;

//생성과 소멸
AppController *AppController_new(void);

void AppController_delete(AppController *_this);

//전체 제어
void AppController_run(AppController *_this);

//문자 별 행위를 처리
void AppController_add(AppController *_this, char aChar);

void AppController_removeN(AppController *_this, char aChar);

void AppController_remove1(AppController *_this);

void AppController_showSize(AppController *_this);

void AppController_showAllFromFront(AppController *_this);

void AppController_showFront(AppController *_this);

void AppController_ignore(AppController *_this);

void AppController_esc(AppController *_this);

//행위 별 문자 수를 센다
void AppController_initCharCounts(AppController *_this);

void AppController_countInput(AppController *_this);

void AppController_countIgnored(AppController *_this);

void AppController_countAdded(AppController *_this);

void AppController_endInput(AppController *_this);

int AppController_numberOfInputChars(AppController *_this);

int AppController_numberOfIgnoredChars(AppController *_this);

int AppController_numberOfNormallyProcessedChars(AppController *_this);

int AppController_numberOfAddedChars(AppController *_this);

void AppController_showStatistics(AppController *_this);