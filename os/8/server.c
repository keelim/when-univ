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

#define BUF_SIZE	1337
#define FIFO_FILE "./pingpong.txt"

int main(void)
{
	int cnt = 0;
	int fd;
	int score = 100;
	char buf[BUF_SIZE];
	char pingstr[] = "ping\n"; //항상 ping 을 입력
	sem_t* sem;	

	

	/*
	 * To-do : initialize for game
	 * get named semaphore, fifo, etc. 
	 */
	//1 먼저 시작

	fd = open(FIFO_FILE, O_RDWR|O_CREAT, S_IRWXU);

	sem_unlink("pingpongsema"); 

	if((sem = sem_open("pingpongsema", O_CREAT, 0644, 1))==SEM_FAILED){
		perror("open");
		exit(1); 
	} //세마포어

	/*
	 * To-do : Round1 ping
	 * without [opponent] string
	*/

	int i;
	
	printf("서버를 시작합니다 클라이언트를 시작해주세요.\n");
	
	printf("Your turn!\n");
	memset(buf, 0x00, BUF_SIZE);

	sem_wait(sem); // 서버 세마포어 사용
	printf("입력 ");
	fgets(buf, BUF_SIZE, stdin); //fifo 입력
	write(fd, buf, strlen(buf)); //ping
	sem_post(sem);
	//완벽
	


	for (cnt=1; cnt<5; cnt++)
	{
		sem_wait(sem);

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
			/*
			 * To-do : handle wrong case
			 */
			score-=20;
			printf("wrong! %d\n", score);
			

		}
		sem_post(sem);
		sleep(1);
	}

	printf("Done! Your score : %d\n", score);

	sem_close(sem);
	close (fd);

	return 0;
}
