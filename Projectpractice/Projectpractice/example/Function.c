#include <stdio.h>
#include <stdlib.h>

void swap(int a, int i);

void function_ex();

void function_ex2();

void function_ex3();

int dofactorial(int n);

void function_ex4();

void function_ex5();

float doCalculate(char op, float opA, float opB);

int main(void) {

//    function_ex();
//    function_ex2();
//    function_ex3();
//    function_ex4();
//    function_ex5();

    float result = 0;

    result = doCalculate('+', 10.0, 20);


    return 0;
}

float doCalculate(char op, float opA, float opB) {

    float (*pCalculate)(float opA, float opB);

    switch (op){
        case '+' : pCalculate = doAdd(opA, opB); break;
        case '-' : pCalculate = doSub(opA, opB); break;
        case '*' : pCalculate = doMul(opA, opB); break;
        case '/' : pCalculate = doDiv(opA, opB); break;

    }
    return 0;
}

void function_ex5() {
    int n, result;
    printf("input the factorial number : ");
    scanf_s("%d", &n);
    result = dofactorial(n);
    printf("%d != %d\n", n, result);
}

void function_ex4() {
    int n, result;
    printf("input the factorial number : ");
    scanf_s("%d", &n);
    result = dofactorial(n);
    printf("%d!= %d\n", n, result);
}

int dofactorial(int n) {

    int ret = 1, i;
    for (int i = n; i > 0; i--) {
        ret *= i;
    }
    return ret;
}

void function_ex3() {
    int result = 1, n, i;
    printf("input the factorial number : ");
    scanf_s("%d", &n);

    for (i = n; i > 0; i--) {
        result *= i;
    }

    printf("%d=! %d\n", n, result);
}

void function_ex2() {
    int a = 10, b = 20;
    swap(&a, &b);
    printf("a = %d, b = %d\n", a, b);
}

void function_ex() {
    int a = 10, b = 20;
    swap(a, b);
    printf("varl1=%d, varl2=%d\n", a, b);
}

void swap(int a, int i) {
    int temp;

    temp = a;
    a = i;
    i = temp;

    printf("varl = %d, var2 = %d\n", a, i);
}