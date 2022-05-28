#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>

#define FIFO_FILE "./fifo_temp"
#define BUF_SIZE 100

int main(void)
{
    int cnt =0;
    int fd;
    char buf[BUF_SIZE];

    fd = open(FIFO_FILE, O_WRONLY);

    while(1)
    {
        memset(buf, 0x00, BUF_SIZE);
        fgets(buf, BUF_SIZE,stdin);
        write(fd, buf, strlen(buf));
    }

    close(fd);

    return 0;
    
}
