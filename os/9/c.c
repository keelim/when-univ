#include <semaphore.h>
#include <stdio.h>
#include <errno.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/mman.h>
#include <fcntl.h>
#include <unistd.h>
#include <pthread.h>

int id, num, en_num, listen_id;
int lock;
int *ptr1, *ptr2;
sem_t *sem, *gsem, *hsem;
int is_first = -1;


void use()
{
    sem_getvalue(sem, &lock);
}

void init()
{

    if ((sem = sem_open("game", O_RDWR, 0644, 1)) == SEM_FAILED) // 채팅방 열려 있는 지 확인
    {
        perror("sem_open failed. (Number of players): ");
        printf("An error is occured, tell admin..");
        exit(1);
    }

    if ((gsem = sem_open("g", O_RDWR, 0644, 1)) == SEM_FAILED) // 채팅방 열려 있는 지 확인
    {
        perror("sem_open failed. (Number of players): ");
        printf("An error is occured, tell admin..");
        exit(1);
    }

    if ((hsem = sem_open("h", O_RDWR, 0644, 1)) == SEM_FAILED) // 채팅방 열려 있는 지 확인
    {
        perror("sem_open failed. (Number of players): ");
        printf("An error is occured, tell admin..");
        exit(1);
    }

    int memory1 = open("memory1", O_RDWR | O_CREAT, S_IRWXU); //메모리 1 만들기
    int memory2 = open("memory2", O_RDWR | O_CREAT, S_IRWXU); // 메모리 2 만들기

    ptr1 = mmap(NULL, sizeof(int), PROT_READ | PROT_WRITE, MAP_SHARED, memory1, 0); //공유 메모리 매핑
    if (ptr1 == MAP_FAILED)
    {
        close(memory1);
        perror("Error mmapping the file");
        exit(EXIT_FAILURE);
    }
    ptr2 = mmap(NULL, sizeof(int), PROT_READ | PROT_WRITE, MAP_SHARED, memory2, 0); //공유 메모리 2 매핑

    if (ptr2 == MAP_FAILED)
    {
        close(memory2);
        perror("Error mmapping the file");
        exit(EXIT_FAILURE);
    }

    sem_post(sem);
    sem_getvalue(sem, &lock);

    if (lock == 2)
    {
        id = 1111;
        listen_id = 2222;
    }
    else if (lock == 3)
    {
        id = 2222;
        listen_id = 1111;
    }

    use();
    if (lock > 3)
    {
        printf("%d", lock);
        printf("대기하고 있는 중입니다.");
        while (1)
        {
            use();
            printf("%d", lock);
            sleep(100000);
            if (lock < 3)
            {
                printf("대기 상태를 해제 하고 게임의 참가합니다.");
                sem_post(sem);
                sleep(1000);
                break;
            }
        }
    }

    printf("======== 3 6 9 G A M E ========\n\n");
    printf("Hello, Player %d\n", id);
    printf("Welcome to 369 game!");
    printf("\n\n===============================\n");
}

void inputNum(int id)
{
    int input_num;
    puts("input num : ");
    scanf("%d", &input_num);
    if (input_num == 9999)
    {
        int temp1, temp2;
        sem_getvalue(gsem, &temp1);
        sem_getvalue(hsem, &temp2);
        printf("gsem: %d, hsem: %d\n", temp1, temp2);
        inputNum(id);
    }
    ptr1[0] = input_num;
}

int main(int argc, char *argv[])
{

    // id = getpid();
    printf("Wating for server2!!\n"); //
    init();                           // 메시지 출력 //
    printf("Please wait for 3 seconds to synchronization.\n"); //

    printf("Please enter any key to start game\n"); //

    use();
    if (id == 1111)
    {
        sem_wait(gsem);
        getchar();
        inputNum(id);
        sem_post(gsem);
        puts("\n");
    }
    else
    {
        getchar();
        puts("it`s start\n\n");
        int temp;
        sem_getvalue(hsem, &temp);
        printf("hsem: %d\n" ,temp);
    }

    while (1)
    {
        printf("1\n");
        if (id == 1111)
        {
            sem_wait(hsem);
            puts("순2\n");
            printf("[%d] %d \n\n", id, ptr2[0]);
            sem_post(hsem);
            sleep(1);
            //출력

            //출력 입력
            sem_wait(hsem);
            printf("[%d] %d \n\n", listen_id, ptr2[0]);
            sem_post(hsem);

            sem_wait(gsem);
            inputNum(id);
            sem_post(gsem);
            sleep(1);
        }
        else
        { //출력
            printf(":\n");
            sem_wait(hsem);
            puts("순1\n");
            printf("[%d] %d", listen_id, ptr2[0]);
            sem_post(hsem);

            sem_wait(gsem);
            inputNum(id);
            sem_post(gsem);
            sleep(1);
            //출력

            sem_wait(gsem);
            printf("[%d] %d", id, ptr2[0]);
            sem_post(gsem);
            sleep(1);
        }
    }
}
