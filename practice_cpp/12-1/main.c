#include <stdio.h>
#include "AppController.h"

int main() {
    AppController* _this = AppController_new(); //AppController  생성
    AppController_run(_this); //AppController 실행
    AppController_delete(_this); //AppController 소멸
}
