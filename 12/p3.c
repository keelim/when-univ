#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <wiringPi.h>
#include <string.h>
#include <semaphore.h>
#include <unistd.h>

#define LED_R 3
#define LED_Y 2
#define LED_G 0
#define SW_R 6
#define SW_Y 5
#define SW_G 4
#define SW_W 27

int arr[5];
int brr[5];

pthread_t buttonR, buttonY, buttonG, buttonW;
sem_t sem_r, sem_y, sem_g, sem_w;
int flag_r, flag_y, flag_g, flag_w;

void init(void);

void off(void);

void blink(void);

// 추가 LED 알림
void game_start(void);

void game_sucess(void);

void game_fail(void);

//게임 내용
int ran_num(void);    //랜덤 넘버 만들기
void check_val(void); //세마포어
int check();

//void *bindLED(void *data);

void * red(void *pVoid);
void * yellow(void *pVoid);
void * green(void *pVoid);
void * white(void *pVoid);

void arrayLED(int temp);

int main(void) {
    init();

    int final_flag = 0;
    int i = 1;
    //게임 시작 1단계
    while (i <= 5) {
        memset(brr, 0, sizeof(brr)); // 단계 마다 입력 배열 만 초기화
        for (int j = 0; j < i; j++) {
            int temp = arr[j]; //1 빨, 2 노랑, 3 그린
            printf("array num: ");
            arrayLED(temp);
            sleep(1);
        } // 여기까지 배열 출력
        puts("\n");

        // 배열 값 받아 배열 B 저장 하얀색 눌러야 함 --> 여기는 나중에 구현
        for (int j = 0; j < i; j++) {
            //입력을 받아야 한다.
            int check_num = check();
            printf("check num: %d\n ", check_num);

            brr[j] = check_num;
            printf("brr[%d] %d ", j, brr[j]);

            sleep(1);
        }

        while (1) //흰 색 누르기를 기다린다.
        {
            check_val();
            if (flag_w >= 2) {
                sem_wait(&sem_w);
                break;
            }
        }

        // 배열 A B 비교 --> 게임 성공
        for (int j = 0; j < i; j++) {
            int first = arr[j];  //rule
            int second = brr[j]; //input

            if (first != second) {
                final_flag = 1;
                break;
            }
            sleep(1);
        }

        if (final_flag == 1) {
            break;
        }
        i++;
    }

    if (final_flag == 0) {
        sleep(1);
        puts("game sucess\n");
        game_sucess();
    } else {
        puts("game fail\n");
        game_fail();
    }

    int result;

    pthread_join(buttonR, (void *) &result);
    pthread_join(buttonY, (void *) &result);
    pthread_join(buttonW, (void *) &result);
    pthread_join(buttonG, (void *) &result);

    return 0;
}

/////////////////////////////////////////////////////////////////////////////////// 함수//

void init(void) {
    if (wiringPiSetup() == -1) {
        puts("Setup Fail");
        exit(1);
    } else
        puts("ok");


    pinMode(SW_R, INPUT);
    pinMode(SW_Y, INPUT);
    pinMode(SW_G, INPUT);
    pinMode(SW_W, INPUT);
    pinMode(LED_R, OUTPUT);
    pinMode(LED_Y, OUTPUT);
    pinMode(LED_G, OUTPUT);
    // 입출력 버튼 생성
    for (int i = 0; i < 5; i++) {
        int num = ran_num();
        arr[i] = num;
        printf("%d ", arr[i]);
    } //랜덤 넘버 출력


    //세마포어 초기화
    sem_init(&sem_r, 0, 1);
    sem_init(&sem_y, 0, 1);
    sem_init(&sem_g, 0, 1);
    sem_init(&sem_w, 0, 1);

    game_start();

    //쓰레드 설정
//    pthread_create(&buttonR, NULL, bindLED, (void *) SW_R);
//    pthread_create(&buttonG, NULL, bindLED, (void *) SW_G);
//    pthread_create(&buttonY, NULL, bindLED, (void *) SW_Y);
//    pthread_create(&buttonW, NULL, bindLED, (void *) SW_W);

    pthread_create(&buttonR, NULL, red, NULL);
    pthread_create(&buttonG, NULL, yellow, NULL);
    pthread_create(&buttonY, NULL, green, NULL);
    pthread_create(&buttonW, NULL, white, NULL);

    sleep(1);
    off();
}

void off(void) {

    digitalWrite(LED_R, 0);
    digitalWrite(LED_Y, 0);
    digitalWrite(LED_G, 0);
}

void blink(void) {
    int i = 0;

    while (i < 3) {
        digitalWrite(LED_R, 1);
        delay(250);
        digitalWrite(LED_R, 0);
        delay(250);
        digitalWrite(LED_Y, 1);
        delay(250);
        digitalWrite(LED_Y, 0);
        delay(250);
        digitalWrite(LED_G, 1);
        delay(250);
        digitalWrite(LED_G, 0);
        delay(250);
        i++;
    }
}

void game_start() {
    blink();
}

void game_sucess() {
    blink();
}

void game_fail() {
    int i = 0;

    while (i < 3) {

        delay(250);
        digitalWrite(LED_R, 1);
        digitalWrite(LED_Y, 1);
        digitalWrite(LED_G, 1);
        delay(250);
        digitalWrite(LED_R, 0);
        digitalWrite(LED_Y, 0);
        digitalWrite(LED_G, 0);
        delay(250);
        i++;
    }
}

int ran_num(void) {
    int num = (rand() % 3) + 1;

    return num;
}

void check_val() {
    sem_getvalue(&sem_r, &flag_r);
    sem_getvalue(&sem_y, &flag_y);
    sem_getvalue(&sem_g, &flag_g);
    sem_getvalue(&sem_w, &flag_w);

//    printf("r: %d, y: %d, g: %d, w: %d", flag_r, flag_y, flag_g, flag_w);
}

int check() {
    while (1) {
        sleep(1);
        check_val();
        if (flag_r >= 2) {
            printf("%d\n", flag_r);
            sem_wait(&sem_r);
            return 1;
        } else if (flag_y >= 2) {
            printf("%d\n", flag_y);
            sem_wait(&sem_y);
            return 2;
        } else if (flag_g >= 2) {
            printf("%d\n", flag_g);
            sem_wait(&sem_g);
            return 3;
        }
    }
}

void * red(void *pVoid) {
    while (1) {
        check_val();
        if (digitalRead(SW_R) == 0) {
            puts("red\n");

            digitalWrite(LED_R, 0);
            delay(250);
            digitalWrite(LED_R, 1);
            delay(250);
            digitalWrite(LED_R, 0);

            sem_post(&sem_r);
            sleep(1);
        }
    }
}



void * yellow(void *pVoid) {
    while (1) {
        if (digitalRead(SW_Y) == 0) {
            puts("yellow\n");
            digitalWrite(LED_Y, 1);
            sem_post(&sem_y);
            sleep(1);
        }
        off();
    }
}

void * green(void *pVoid){
    while (1) {
        if (digitalRead(SW_G) == 0) {
            puts("green\n");
            digitalWrite(LED_G, 1);
            sem_post(&sem_g);
            sleep(1);
        }
        off();
    }
}

void * white(void *pVoid){
    while (1) {
        if (digitalRead(SW_W) == 0) {
            puts("white\n");
            sem_post(&sem_w);
            sleep(1);
        }
    }
}

//void *bindLED(void *data) //입력도 추가를 해야 한다.
//{
//
//    if ((int) data == SW_R) {
//        while (1) {
//            check_val();
//            if (digitalRead(SW_R) == 0) {
//                puts("red\n");
//
//                digitalWrite(LED_R, 0);
//                delay(250);
//                digitalWrite(LED_R, 1);
//                delay(250);
//                digitalWrite(LED_R, 0);
//
//                sem_post(&sem_r);
//                sleep(1);
//            }
//        }
//    } else if ((int) data == SW_Y) {
//        while (1) {
//            if (digitalRead(SW_Y) == 0) {
//                puts("yellow\n");
//                digitalWrite(LED_Y, 1);
//                sem_post(&sem_y);
//                sleep(1);
//            }
//            off();
//        }
//    } else if ((int) data == SW_G) {
//        while (1) {
//            if (digitalRead(SW_G) == 0) {
//                puts("green\n");
//                digitalWrite(LED_G, 1);
//                sem_post(&sem_g);
//                sleep(1);
//            }
//            off();
//        }
//    } else { //white
//        //얘는 조금 다르게 설정을 해야 한다.
//        while (1) {
//            if (digitalRead(SW_W) == 0) {
//                puts("white\n");
//                sem_post(&sem_w);
//                sleep(1);
//            }
//        }
//    }
//}

void arrayLED(int temp) {
    printf("%d \n", temp);

    if (temp == 1) {
        digitalWrite(LED_R, 1);
        delay(100);
        digitalWrite(LED_R, 0);
    } else if (temp == 2) {
        digitalWrite(LED_Y, 1);
        delay(100);
        digitalWrite(LED_Y, 0);
    } else if (temp == 3) {
        digitalWrite(LED_G, 1);
        delay(100);
        digitalWrite(LED_G, 0);
    }
}