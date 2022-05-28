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
	char pingstr[] = "ping\n"; //항상 ping 을 입력
	sem_t *sem;

	mkfifo(FIFO, 0666); //fifo 만들기

	fd = open(FIFO, O_RDWR | O_CREAT, S_IRWXU);

	sem_unlink("sema");
	if ((sem = sem_open("sema", O_CREAT, 0777, 1)) == SEM_FAILED)
	{
		perror("open");
		exit(1);
	} //세마포어 열기

	printf("서버를 시작합니다 클라이언트를 시작해주세요.\n");
	printf("Your turn!\n");

	int i;
	sem_getvalue(sem, &i);
	printf("세마포어를 값을 확인 합니다.%d\n", i);

	memset(buf, 0x00, BUF_SIZE); //1
	printf("입력을 해주세요: "); //1
	fgets(buf, BUF_SIZE, stdin); //fifo 입력 1
	write(fd, buf, strlen(buf)); //ping 1

	sem_wait(sem); // 0

	//완벽

	for (cnt = 1; cnt < 5; cnt++)
	{
		sem_wait(sem); // 0
		sem_getvalue(sem, &i);
		printf("세마포어 값을 확인 합니다.%d\n", i);
		memset(buf, 0x00, BUF_SIZE);
		read(fd, buf, BUF_SIZE); //pong을 읽음

		printf("[opponent] %s", buf); //pong
		printf("Your turn!\n");

		memset(buf, 0x00, BUF_SIZE); //초기화
		printf("입력을 해주세여: ");
		fgets(buf, BUF_SIZE, stdin); //ping
		write(fd, buf, strlen(buf)); //set

		/*
		 * To-do : complete game process
		 */
		if (strcmp(buf, pingstr))
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
