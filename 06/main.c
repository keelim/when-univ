#include"AppController.h"

int main() {
    AppController *appController = AppController_new(); // AppController 생성
    AppController_run(appController); //실행
    AppController_delete(appController);

    return 0;
}