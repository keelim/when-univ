#include"AppView.h"
#include"Common.h"
#include"Ban.h"
typedef struct _AppController AppController;
AppController* AppController_new();

void AppController_run(AppController* _this);
void AppController_delete(AppController* _this);
Boolean AppController_inputAndStoreStudents(AppController* _this);
void AppController_showStatics(AppController* _this);
void AppController_showStudentsSortedByScore(AppController* _this);
