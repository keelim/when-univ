#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>

sem_t semaphore[3];

void *threadRoutine(void *argumentPointer)
{
    long id = (long) argumentPointer;
    int i;
    for(int i=0; i<10000;i++)
    {
        printf("sem_wait _%ld를 시도중입니다.\n", i-id)
        sem_wait(&semaphore[1-id]);
        printf("sem_wait_%ld 성공 \n", l-id);

        printf("sem_wait _%ld를 시도중입니다.\n", id)
        sem_wait(&semaphore[id]);
        printf("sem_wait_%ld 성공 \n", id);

        printf("sem_wait _%ld를 시도중입니다.\n", i-id)
        sem_wait(&semaphore[1-id]);
        printf("sem_wait_%ld 성공 \n", l-id);

        printf("sem_wait _%ld를 시도중입니다.\n", id)
        sem_wait(&semaphore[id]);
        printf("sem_wait_%ld 성공 \n", id);
    }

    return NULL:
}

int main()
{
    pthread_t threadDs[3];

    sem_init(&semaphore[0], 0, 1);
    sem_init(&semaphore[1], 0, 1);

    pthread_create(&threadDs[0], NULL);
    pthread_create(&threadDs[1], NULL);

    printf("No Deadlock !!\n");
    return 0;
}