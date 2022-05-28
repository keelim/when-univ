#include <stdio.h>
#include <unistd.h>

int main(void)
{
    char *path = "/bin/date";
    char *argv[] = {"/bin/date","--date","today",NULL};
    char *envp[] = {NULL};

    execve(path,argv, envp);

    printf("hello\n");
    return 0;
}
