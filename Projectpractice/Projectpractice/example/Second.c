#include <stdio.h>
#include <stdlib.h>

float doCalculate(char op, float operandA, float operandB);

int main(void) {
    float result = 0;

    result = doCalculate('+', 10.0, 20);
    printf("10 + 20 = %f\n", result);


    return 0;
}

float doCalculate(char op, float operandA, float operandB) {
    float result = 0;

    switch (op) {
        case '+':
            result = operandA + operandB;
            break;
        case '-':
            result = operandA - operandB;
            break;
        case '*':
            result = operandA * operandB;
            break;
        case '/':
            result = operandA/operandB;
            break;

    }


    return result;
}