#include "AppController.h"

void main() {
    AppController *_this = AppController_new();
    AppController_run(_this);
    AppController_delete(_this);
}