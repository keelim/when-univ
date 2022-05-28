#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int glob = 6;
int main(void)
{
    int var;
    pid_t var_pid;
    var = 88;
    printf("before fork \n");

    if((var_pid  = fork())==0){
        glob++;
        var++;
    } else {
        sleep(2);
    }

    printf("var_pid = %d, pid = %d, glob = %d, var %d\n", var_pid, getpid(), glob, var);
}