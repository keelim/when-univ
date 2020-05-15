/*
* Operating System 0X
* Process-to-Process Chat Program Prototypes
* SeongMin Kim, all rights reserved
*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/mman.h>
#include <fcntl.h>
/* Definitions */
#define BUF_SIZE 64

/* Function Prototypes */

int chat_start(void);
void chat_listen(void);
void chat_talk(void);

/* Global Variables */

int fifo_file;
int is_host = 0;
char room_name[BUF_SIZE];
char buf[BUF_SIZE];
char* path;



/* main Function */

int main(void)

{
    int tmp = 0;
    puts("========== Welcome to P2P Chat Program ==========");
    puts("");
    printf("\tEnter the room : ");
    scanf("%16s", room_name);
    puts("Searching for the room...");
    if (chat_start() == -1)
    {
        printf("An error is occured, tell admin..\n");
        return -1;
    }

    while (1)
    {
        if (is_host)
        {
            chat_talk();
            sleep(1);
            chat_listen();
            sleep(1);
        }

        else
        {
            chat_listen();
            sleep(1);
            chat_talk();
            sleep(1);

        }

    }

}

/* Let's start chat! */

int chat_start(void)
{
    char buf[8] = "";
    int mode = R_OK | W_OK;
	path = getenv("PWD");

	

    /* initializing buffers */

    setvbuf(stdin, 0, _IONBF, 0);

    setvbuf(stdout, 0, _IONBF, 0);

    /* initializing fifo file */

    if (access(room_name, mode) != 0)
    {
        // there ies no room yet

        sleep(1);
        is_host = 1;
        puts("Room not found. Entering as host..");
        mkfifo(room_name, 0664);
	    chmod(path, 700); //해결방법
    }

    else
    {
        sleep(1);
        puts("Room found. Entering as guest..");
    }

    if ((fifo_file = open(room_name, O_RDWR)) == -1)
    {
        perror("opening fifo file failed.");
        return -1;
    }

    puts("Done.");
    return 0;

}

void chat_listen(void)
{
    int read_count = 0;
    int fd;
    fd = open(room_name, O_RDONLY);
    memset(buf, 0x00, BUF_SIZE);
    while (read_count < 1)
    {
        read_count = read(fd, buf, BUF_SIZE);
    }

    printf("[opponent] %s\n", buf);
    close(fd);
}

void chat_talk(void)
{
    int fd;
    fd = open(room_name, O_WRONLY);
    memset(buf, 0x00, BUF_SIZE);
    fgets(buf, BUF_SIZE, stdin);
    if (is_host && !strcmp(buf, "END\n"))
    {
        system("pkill p2p_client");
    }

    write(fd, buf, strlen(buf));
    close(fd);
}