#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <wiringPi.h>
#include <pthread.h>
#include <unistd.h>
#include <semaphore.h>

#define LED_R 3
#define LED_Y 2
#define LED_G 0
#define SW_R 6
#define SW_Y 5
#define SW_G 4
#define SW_W 27
#define max_num 6

void init(void);
void off(void);
void blink(void);
void game_start(void);
void game_sucess(void);
void game_fail(void);
int random_num(void);
void turn_on(int pin);
void bindLed(int pin);

pthread_t p_thread[4];
int id;
int pin;
int status;
int a[max_num] = {
    0,
};
int b[max_num] = {
    0,
};
sem_t sem;
int sem_value;

int main(void)
{
    init();

    pthread_join(p_thread[0], (void *)&status);
    pthread_join(p_thread[1], (void *)&status);
    pthread_join(p_thread[2], (void *)&status);
    pthread_join(p_thread[3], (void *)&status); // 여기까지 pin 하고 Led 묶어놓기

    //// 쓰레드 준비
    game_start(); //

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 여기부터 게임 진행
    int level = 1;
    while (level <= 5)
    {
        memset(a, 0, sizeof(a));
        memset(b, 0, sizeof(b)); //다시 초기화
        game_start();            //
        //랜덤 값 생성 단계별로
        for (int i = 0; i < level; i++)
            a[i] = random_num(); //랜덤 생성

        input();       //입력 LED
        white_input(); // 하얀색 입력이 되면 종료

        //세마포어 검증

        if (a.length() != level || b.length() != level)
        { // 예외 처리 (하얀 색 그냥 누르거나 단계로 누르지 않음)
            game_fail();
            return 0; //게임 종료
        }
        // 비교 시작
        for (int i = 0; i < level; i++)
        { //단계별로 입력이니 단계
            int ea = a[i];
            int eb = b[i];

            if (ea != eb)
            {
                game_fail();
                return 0; // 게임 종료
            }

        } // 비교 한 후 이상이 없으면

        game_sucess(); // 레벨 증가
        level++:
    }

    return 0;
}

void init(void)
{
    if (wiringPiSetUp() == -1)
    {
        puts("Setup Fail");
        exit(1);
    }
    pinMode(SW_R, INPUT);
    pinMode(SW_Y, INPUT);
    pinMode(SW_G, INPUT);
    pinMode(SW_W, INPUT);
    pinMode(LED_R, OUTPUT);
    pinMode(LED_Y, OUTPUT);
    pinMode(LED_G, OUTPUT);

    id = pthread_create(p_thread[0], NULL, (void &)&bindLed, &pin); //화
    id = pthread_create(p_thread[1], NULL, (void &)&bindLed, &pin); //화
    id = pthread_create(p_thread[2], NULL, (void &)&bindLed, &pin); //화
    id = pthread_create(p_thread[3], NULL, (void &)&bindLed, &pin); //화

    ///세마포어
    sem_init(s & em, 0, 5); //5로 초기화
    off();
}

void off(void)
{
    digitalWrite(LED_R, 0);
    digitalWrite(LED_Y, 0);
    digitalWrite(LED_G, 0);
}

void blink(void)
{
    int i = 0;

    while (i < 3)
    {
        digitalWrite(LED_R, 1);
        delay(250);
        digitalWrite(LED_R, 0);

        digitalWrite(LED_Y, 1);
        delay(250);
        digitalWrite(LED_Y, 0);

        digitalWrite(LED_G, 1);
        delay(250);
        digitalWrite(LED_G, 0);
        i++;
    }
}

void game_fail(void)
{
    int i = 0;

    while (i < 3)
    {
        digitalWrite(LED_R, 0);
        digitalWrite(LED_Y, 0);
        digitalWrite(LED_G, 0);

        delay(250);

        digitalWrite(LED_R, 1);
        digitalWrite(LED_Y, 1);
        digitalWrite(LED_G, 1);

        delay(250);
        i++;
    }
}

void game_start(void)
{
    blink();
}

void game_sucess(void)
{
    blink();
}

int random_num()
{
    int n = rand() % 3 if (n == 0) return 1;
    else if (n == 1) return 2;
    else return 3;
}

void turn_on(int pin)
{
    if (pin == 1)
    {
        digitalWrite(LED_R, 0);
        delay(100);
        digitalWrite(LED_R, 1);
        delay(100);
        digitalWrite(LED_R, 0);
    }
    else if (pin == 2)
    {
        digitalWrite(LED_Y, 0);
        delay(100);
        digitalWrite(LED_Y, 1);
        delay(100);
        digitalWrite(LED_T, 0);
    }
    else
    {
        digitalWrite(LED_G, 0);
        delay(100);
        digitalWrite(LED_G, 1);
        delay(100);
        digitalWrite(LED_G, 0);
    }
}

void bindLed(int pin)
{
}

void input()
{
    // 값 입력 받기

    sem_post(&sem);
}

void white_input()
{ // 각각의 버튼의 세마포어 post 를 붙인다.
    //화이트는 세마포어 값을 저장하고 연결

    sem_getvalue(&sem, &sem_value);
}