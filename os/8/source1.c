#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>

#define MAN 5

int key =1;
pthread_mutex_t lock;

void use(void);

int main(void)
{
    pthread_t pt[MAN];
    int i, status;

    pthread_mutex_init(&lock, NULL);

    for (int i = 0; i < MAN; i++)
    {
        pthread_create(&pt[i], NULL, (void*)&use, NULL);
    }

    pthread_join(pt[0], (void*)&status);
    pthread_join(pt[1], (void*)&status);
    pthread_join(pt[2], (void*)&status);
    pthread_join(pt[3], (void*)&status);
    pthread_join(pt[4], (void*)&status);

    pthread_mutex_destroy(&lock);

    return 0;
    
}

void use(void){
    
    pthread_mutex_lock(&lock);

    key--;
    printf("[%u] In (key:%d)\n", (unsigned int) pthread_self(), key);

    sleep(1);
    key++;
    pthread_mutex_unlock(&lock);

    printf("[u] Out (key%d)\n", (unsigned int)pthread_self(), key);
}