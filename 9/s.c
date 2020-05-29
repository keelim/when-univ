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

int id, c1_id = 1111, c2_id = 2222;
int lock;
int *ptr1, *ptr2;
sem_t *sem, *gsem, *hsem;
int answer_count = 1; //서버에서 관리하는 값
int pointer = -1;

void use()
{
    sem_getvalue(sem, &lock);
}

int game(int a, int answer)
{
    int temp = answer;
    while (temp > 0)
    { //369 인지
        if (temp % 10 == 3 || temp % 10 == 6 || temp % 10 == 0)
        {
            pointer = 1;
        }
        temp /= 10;
    }

    if (!pointer || answer == a || (pointer || a == -1))
    {
        return 1;
    }

    return 0; //패배
}

void ready()
{
    while (1)
    {
        use();
        if (lock >= 3)
        {
            printf("Done.\n");
            break;
        }
    }
}

void init()
{
    int memory1 = open("memory1", O_RDWR | O_CREAT, S_IRWXU); //메모리 1 만들기
    if (write(memory1, "", 1) == -1)
    {
        close(memory1);
        perror("Error writing last byte of the file");
        exit(EXIT_FAILURE);
    }

    int memory2 = open("memory2", O_RDWR | O_CREAT, S_IRWXU); // 메모리 2 만들기
    if (write(memory2, "", 1) == -1)
    {
        close(memory2);
        perror("Error writing last byte of the file");
        exit(EXIT_FAILURE);
    }

    ptr1 = mmap(NULL, 4048, PROT_READ | PROT_WRITE, MAP_SHARED, memory1, 0); //공유 메모리 매핑
    if (ptr1 == MAP_FAILED)
    {
        close(memory1);
        perror("Error mmapping the file");
        exit(EXIT_FAILURE);
    }

    ptr2 = mmap(NULL, 4048, PROT_READ | PROT_WRITE, MAP_SHARED, memory2, 0); //공유 메모리 2 매핑
    if (ptr2 == MAP_FAILED)
    {
        close(memory2);
        perror("Error mmapping the file");
        exit(EXIT_FAILURE);
    }

    sem_unlink("game");
    sem_unlink("g");
    sem_unlink("h");

    if ((sem = sem_open("game", O_CREAT, 0644, 1)) == SEM_FAILED)
    { //채팅방 세마포어 만들기
        perror("open");
        exit(1); //1
    }

    if ((gsem = sem_open("g", O_CREAT, 0644, 1)) == SEM_FAILED)
    { //순서 세마포어
        perror("open");
        exit(1); //1
    }

    if ((hsem = sem_open("h", O_CREAT, 0644, 1)) == SEM_FAILED)
    { //순서 세마포어
        perror("open");
        exit(1); //1
    }
}

int main(int argc, char *argv[])
{
    init();
    printf("Please wait until server is ready ...\n");
    ready();

    id = getpid();

    printf("Server %d is ready for play!\n", id);
    printf("Client %d hi with slot 0\n", c1_id);
    printf("Client %d hi with slot 1\n", c2_id); //


    while (1)
    {
        int temp;
        sem_getvalue(gsem, &temp);
        printf("gsem: %d\n", temp);
        //answer_count=1
        //읽고
        sem_wait(gsem);
        //판단
        int read = ptr1[0];
        printf("[1111] %d\n", read);

        // int answer = game(read, answer_count);
        // if (0)
        // { //!answer
        //     //패배 1의 패배
        //     printf("패배 입니다.\n");
        //     break;
        // } //저장

        ptr2[0] = read;
        printf("%d\n", ptr2[0]);
        answer_count++;
        sem_post(hsem);
        sem_wait(gsem);
        //읽고
        printf("[2222] %d", ptr1[0]);
        sem_post(gsem);
        //판단
        // answer = game(read, answer_count);
        // if (0)
        // {
        //     printf("패배 입니다.\n");
        //     break;
        // }
        //저장
        ptr2[0] = read;
        answer_count++;
        sem_post(hsem);
        sleep(1);
    }
}
