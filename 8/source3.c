#include <semaphore.h>
#include <stdio.h>
#include <errno.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <sys/mman.h>
#include <unistd.h>

int main(int argc, char ** argv)
{
    int fd;
    int i;
    int count = 0;
    int nloop = 5;
    int zero = 0;
    int* ptr;
    sem_t* sem;

    fd = open("log.txt", O_RDWR|O_CREAT, S_IRWXU);
    write(fd, &zero, sizeof(int));
    ptr = mmap(NULL, sizeof(int), PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);
    close(fd);

    sem_unlink("mysema");
    if((sem = sem_open("mysema", O_CREAT, 0644, 1)) == SEM_FAILED){
        perror("open");
        exit(1);
    }


    if(fork()==0){
        for(i=0;i<nloop;i++){
            sem_wait(sem);
            printf("child: %d\n", (*ptr));
            (*ptr)++;
            sleep(1);
            printf("child end\n");
            sem_post(sem);
            sleep(1);
        }
        exit(0);
    }

    for(i=0;i<nloop;i++)
    {
        sem_wait(sem);
        printf("parent : %d\n", (*ptr));
        (*ptr)++;
        sleep(1);
        printf("parent end\n");
        sem_post(sem);
        sleep(1);
    }

    sem_close(sem);
    exit(0);
}