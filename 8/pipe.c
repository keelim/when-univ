#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

#define BUFF_SIZE 100

int main(void)
{
    int pipe_parent[2];
    int pipe_child[2];
    char buf[BUFF_SIZE];
    pid_t pid;

    pipe(pipe_parent);
    pipe(pipe_child);

    pid = fork();

    if (pid == 0)
    {
        sprintf(buf, "(child) test_pipe");
        write(pipe_child[1], buf, strlen(buf));
        memset(buf, 0x00, BUFF_SIZE);

        read(pipe_parent[0], buf, BUF_SIZE);
        printf("child : %s\n", buf);
    }
    else
    {
        sprinf(buf, "(parent) test_pipe");
        write(pipe_child[1], buf, strlen(buf));
        memset(buf, 0x00, BUFF_SIZE);

        read(pipe_parent[0], buf, BUF_SIZE);
        printf("parent : %s\n", buf);
    }
    sleep(1);
    return 0;
}