#include <stdio.h>
#include <stdlib.h>
#include <time.h>


void showQuestion(int i, int num1, int num2);

int getRandomNumber(int i);

int main_cal(void) {

    srand(time(NULL));
    int count = 0;
    for (int i = 1; i <5 ; ++i) {

        int num1 = getRandomNumber(i);
        int num2 = getRandomNumber(i);

        showQuestion(i, num1, num2);

        int answer = -1;
        scanf_s("%d", &answer);
        if(answer == -1){
            printf("program exit");
            break;
        } else {}



    }

    return 0;

}

int getRandomNumber(int i) {
    return rand() % (i * 7) +1;
}

void showQuestion(int i, int num1, int num2) {
    printf("\n\n\n########################### %d password ###########\n", i);
    printf("\n\t%d x %d is? \n\n", num1, num2);
    printf("###############################################\n");
    printf("\n insert password (exit : -1 ) >>");
}