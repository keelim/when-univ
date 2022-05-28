#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>

#define FIFO_FILE "./fifo_temp"
#define BUF_SIZE 100

int main(void)
{
    int cnt = 0;
    int fd ; 
    char buf[BUF_SIZE];

    mkfifo(FIFO_FILE,0666);
    fd = open(FIFO_FILE, O_RDONLY);

    while(1)
    {
        memset(buf,0x00, BUF_SIZE);
        read(fd, buf, BUF_SIZE);
        printf("%d : %s", ++cnt, buf);
    }

    close(fd);

    return 0;
}