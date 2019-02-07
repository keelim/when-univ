#include <stdio.h>

void pmade(int name) ;

int main() {
    printf("Hello, World!\n");

    pmade(3);

    return 0;
}

void pmade(int name) {
    printf("%d now ", name);
}