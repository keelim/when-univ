#include <stdio.h>
#include <unistd.h>

int main(void)
{
    char *path = "/bin/ls";
    char *argv[] = {"/bin/ls", "-al", NULL};
    char *envp[] = {NULL};

    execve(path,argv, envp);

    printf("hello!\n");

    return 0;
}