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
sem_t *sem, *gsem, *hsem, *t;
int answer_count = 1; //서버에서 관리하는 값
int pointer = -1;
int s1, s2, s3;

void use()
{
    sem_getvalue(sem, &lock);
    sem_getvalue(gsem, &s1);
    sem_getvalue(hsem, &s2);
    sem_getvalue(t, &s3);
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

    if ((t = sem_open("tsem", O_CREAT, 0644, 1)) == SEM_FAILED)
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

    int p1pattern = 1;
    answer_count = 0;
    while (1) //2일 때만 열린다.
    {
        //읽고
        use();
        if (s1 == 2)
        {   
            answer_count++;
            int read = ptr1[0];
            if (p1pattern)
            {
                printf("[1111] %d\n", read);
            }
            else
            {
                printf("[2222] %d\n", read);
            }

            ptr2[0] = read;
            answer_count++;
            sem_wait(gsem);

            if (p1pattern)
            {
                p1pattern = 0;
                sem_post(hsem);
                sem_post(t);
            }
            else
            {
                p1pattern = 1;
                sem_post(t);
                sem_post(t);
                sem_post(hsem);
                sem_post(hsem);
            }
        }
        sleep(1000);
    }
    
}

