typedef struct _AppController AppController;

AppController*  AppController_new (void) ; //AppController 객체를 생성한다
void  AppController_delete (AppController* _this) ; //주어진 AppController 객체를 소멸시킨다
void AppController_run (AppController* _this) ; //App을 실행한다

