#include<stdio.h>


int countSmallerLetters (char s[]) {
    int count=0;
    if (*s == '\0') {
        return 0;
    }
    else {
        if ('a' <= *s && *s <= 'z') {
            count++;
        }
        return count + countSmallerLetters (s + 1);
    }

}

void printReverse (char s[]) {
    if (*s != '\0') {
        printReverse (s + 1);
        putchar (*s);
    }
}

int main (void) {
    printReverse ("hello");
    printf ("%d", countSmallerLetters ("hello"));
}

int findMax (int a[], int left, int right) {
    int maxPart;
    if (left == right) {
        return a[left];
    }
    else {
        maxPart=findMax (a, left + 1, right);
        if (a[left] >= maxPart) {
            return a[left];
        }
        else {
            return maxPart;
        }
    }
}
int findMax3(int a[], int left, int right){
    int maxLeft;
    int maxright;
    int mid;
    if(left == right){
        return a[left];
    } else {
        mid = (left+right)/2;
        maxLeft =
    }

}
