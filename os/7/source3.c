#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>

int glob = 2;

void minus(int *cnt);
void plus(int *cnt);

int main(int argc, char *argv[])
{
    pthread_t pt[2];
    int id;
    int status;
    int a = 10;
    int b = 11;

    printf("[main] pid = %u/ tid = %u / hello \n",
           (unsigned int)getpid(), (unsigned int)pthread_self());

    minus(&a);
    plus(&b);

    return 0;
}

void minus(int *cnt)
{
    int i;
    int var = 10;

    for (int i = 0; i < *cnt; i++)
    {
        glob = glob - 1;
        var = var - 1;
        printf("[-] pid=%u / tid =%u / cnd=%3d / glob=%d / var%d\n",
               (unsigned int)getpid(), (unsigned int)pthread_self(), i + 1, glob, var);
        sleep(1);
    }
}

void plus(int *cnt)
{
    int i;
    int var = 10;

    for (i = 0; i < *cnt; i++)
    {
        glob = glob + 1;
        var = var + 1;
        printf("[+] pid=%u / tid =%u / cnd=%3d / glob=%d / var%d\n",
               (unsigned int)getpid(), (unsigned int)pthread_self(), i + 1, glob, var);
        sleep(1);
    }
}