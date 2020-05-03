#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>

int id, num, en_num;

void init(){
    printf("======== 3 6 9 G A M E ========\n\n");
    pritnf("Hello, Player %d\n", id);
    printf("Welcone to 369 game!");
    printf("\n\n===============================");
}

void game(){
    printf("You lose!\n\n");
    printf("You win!\n\n");
}
int main(int argc, char *argv[])
{   


    id = getpid();
    printf("Wating for server!!\n");
    // 서버와 를 동기화  부분

    printf("sem_open failed (Number of plyers) : ");
    printf("An error is occured, tell admin..");

    printf("Please wait for 3 seconds to synchronization.\n");
    // 서버 기다리는 부분

    void init(); // 메시지 출력

    printf("Please enter any key to start game");

    while(1){
        num = inputNum();
        printf("[%d] %d", id, num);

        game();
        en_num = getEnNum();
        game();
    }

    printf("Client is closing .....:  Done");
    return 0;
}
