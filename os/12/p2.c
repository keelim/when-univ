#include <stdio.h>
#include <stdlib.h>
#include <wiringPi.h>
#include <unistd.h>

#define LED_R 3
#define LED_Y 2
#define LED_G 0
#define SW_R 6
#define SW_Y 5
#define SW_G 4
#define SW_W 27

void init(void);

void off(void);

void blink(void);

int main(void) {
    init();
    blink();

    for (int i = 0; i < 5; i++) {
        if (i == 0){
            delay(250);
            digitalWrite(LED_Y, 1);
            delay(250);
            digitalWrite(LED_Y, 0);
        } else if(i==1){
            delay(250);
            digitalWrite(LED_Y, 1);
            delay(250);
            digitalWrite(LED_Y, 0);
            delay(250);
            digitalWrite(LED_Y, 1);
            delay(250);
            digitalWrite(LED_Y, 0);
        } else if(i==2){
            delay(250);
            digitalWrite(LED_Y, 1);
            delay(250);
            digitalWrite(LED_Y, 0);
            delay(250);
            digitalWrite(LED_Y, 1);
            delay(250);
            digitalWrite(LED_Y, 0);
            delay(250);
            digitalWrite(LED_R, 1);
            delay(250);
            digitalWrite(LED_R, 0);
        } else if(i==3){
            delay(250);
            digitalWrite(LED_Y, 1);
            delay(250);
            digitalWrite(LED_Y, 0);
            delay(250);
            digitalWrite(LED_Y, 1);
            delay(250);
            digitalWrite(LED_Y, 0);
            delay(250);
            digitalWrite(LED_R, 1);
            delay(250);
            digitalWrite(LED_R, 0);
            delay(250);
            digitalWrite(LED_R, 1);
            delay(250);
            digitalWrite(LED_R, 0);
        } else if(i==4){
            delay(250);
            digitalWrite(LED_Y, 1);
            delay(250);
            digitalWrite(LED_Y, 0);
            delay(250);
            digitalWrite(LED_Y, 1);
            delay(250);
            digitalWrite(LED_Y, 0);
            delay(250);
            digitalWrite(LED_R, 1);
            delay(250);
            digitalWrite(LED_R, 0);
            delay(250);
            digitalWrite(LED_R, 1);
            delay(250);
            digitalWrite(LED_R, 0);
            delay(250);
            digitalWrite(LED_G, 1);
            delay(250);
            digitalWrite(LED_G, 0);
        }


        while (1) {
            if (digitalRead(SW_R) == 0) {
                digitalWrite(LED_R, 1);

            } else if (digitalRead(SW_Y) == 0) {
                digitalWrite(LED_Y, 1);

            } else if (digitalRead(SW_G) == 0) {
                digitalWrite(LED_G, 1);

            } else if (digitalRead(SW_W) == 0) {
//                for (int i = 0; i < 3; i++) {
//                    digitalWrite(LED_R, 1);
//                    digitalWrite(LED_Y, 1);
//                    digitalWrite(LED_G, 1);
//                    delay(250);
//                    off();
//                    delay(500);
                break;
            }
            off();
        }


    }
    blink();
    return 0;
}


void init(void) {
    if (wiringPiSetup() == -1) {
        puts("Setup Fail");
        exit(1);
    } else {
        puts("ok");
    }
    pinMode(SW_R, INPUT);
    pinMode(SW_Y, INPUT);
    pinMode(SW_G, INPUT);
    pinMode(SW_W, INPUT);
    pinMode(LED_R, OUTPUT);
    pinMode(LED_Y, OUTPUT);
    pinMode(LED_G, OUTPUT);
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

        digitalWrite(LED_Y, 1);
        delay(250);
        digitalWrite(LED_Y, 0);

        digitalWrite(LED_G, 1);
        delay(250);
        digitalWrite(LED_G, 0);
        i++;
    }
}