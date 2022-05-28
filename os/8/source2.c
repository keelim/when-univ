#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include <semaphore.h>

#define MAN 5

int key =4;
sem_t sem;


void use(void);

int main(void)
{
    pthread_t pt[MAN];
    int i, status;


    sem_init(&sem, 0, 4);

    for (int i = 0; i < MAN; i++)
    {
        pthread_create(&pt[i], NULL, (void*)&use, NULL);
    }

    pthread_join(pt[0], (void*)&status);
    pthread_join(pt[1], (void*)&status);
    pthread_join(pt[2], (void*)&status);
    pthread_join(pt[3], (void*)&status);
    pthread_join(pt[4], (void*)&status);

    sem_destroy(&sem);

    return 0;
    
}

void use(void){
    
    sem_wait(&sem);

    key--;
    printf("[%u] In (key:%d)\n", (unsigned int) pthread_self(), key);

    sleep(1);
    key++;
    
    sem_post(&sem);

    printf("[u] Out (key%d)\n", (unsigned int)pthread_self(), key);
}