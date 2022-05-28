#include"AppView.h"
#include"Common.h"
#include"Ban.h"

typedef struct _AppController AppController; //AppController def
AppController *AppController_new(); //def

void AppController_run(AppController *_this); //def
void AppController_delete(AppController *_this); //def
void AppController_showStatics(AppController *_this); //def
void AppController_showStudentsSortedByScore(AppController *_this); //def
Boolean AppController_inputAndStoreStudents(AppController *_this); //def
