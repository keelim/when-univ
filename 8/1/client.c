#include <semaphore.h>
#include <stdio.h>
#include <errno.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <sys/mman.h>
#include <unistd.h>
#include <string.h>

#define BUF_SIZE 1337
#define FIFO "./pingpong"

int main(void)
{
	int cnt = 0;
	int fd;
	int score = 100;
	char buf[BUF_SIZE];
	char pongstr[] = "pong\n"; //항상 pong 을 입력
	sem_t *sem;

	fd = open(FIFO, O_RDWR, S_IRWXU);

	if ((sem = sem_open("sema", O_CREAT, 0777, 1)) == SEM_FAILED)
	{
		perror("open");
		exit(1);
	}

	int i;
	sem_getvalue(sem, &i);
	printf("세마포어 값을 확인 합니다. %d\n", i);

	printf("클라이언트를 시작합니다.\n");

	sem_post(sem); //1
	for (cnt = 1; cnt < 5; cnt++)
	{
		sem_wait(sem); //0

		sem_getvalue(sem, &i);
		printf("세마포어 값을 확인 합니다. %d\n", i);

		memset(buf, 0x00, BUF_SIZE);
		read(fd, buf, BUF_SIZE); /// ping을 읽음

		printf("[opponent] %s", buf); //ping
		printf("Your turn!\n");

		memset(buf, 0x00, BUF_SIZE); //
		printf("입력을 해주세요: ");
		fgets(buf, BUF_SIZE, stdin); //buf pong
		write(fd, buf, strlen(buf)); //작성

		if (strcmp(buf, pongstr))
		{
			score -= 20;
			printf("wrong! %d\n", score);
		}
		sem_post(sem);
		sem_getvalue(sem, &i);
		printf("세마포어 값을 확인 합니다. %d\n", i);
		sleep(1);
	}

	printf("Done! Your score : %d\n", score);

	sem_close(sem);
	close(fd);

	return 0;
}
