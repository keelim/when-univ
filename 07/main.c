#include"AppController.h"

int main() {
    AppController *appController = AppController_new(); // AppController 생성
    AppController_run(appController); //실행
    AppController_delete(appController); //appController 소멸

    return 0;
}