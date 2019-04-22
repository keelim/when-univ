
#include <stdio.h>

#define NewObject(TYPE) (TYPE*)malloc(sizeof(TYPE))
#define NewVector(TYPE, SIZE) (TYPE*)malloc(sizeof(TYPE)*SIZE)
#define  SWAP(TYPE, X, Y) {TYPE temp=X; X=Y; Y=temp;}


int fact(int n);

int findMax1(int *a, int left, int right);

int findMax2(int *a, int left, int right);

int main(void) {

    printf("%d", fact(3));

}

int fact(int n) {
    if (n == 1) {
        return 1;
    } else {
        return n * fact(n - 1);
    }

}

int findMax1(int *a, int left, int right) {
    int maxofPart;
    if (left == right) {
        return a[left];
    } else {
        maxofPart = findMax1(a, left + 1, right);
        if (maxofPart > a[left]) {
            return maxofPart;
        } else {
            return a[left];
        }
    }


}

int findMax2(int *a, int left, int right) {
    int currLoc = left + 1;
    int max = a[left];
    while (currLoc <= right) { //while loop를 통하여 설정
        if (max < a[currLoc]) {
            max = a[currLoc];
        }
        currLoc++;
    }
    return max;
}

int findMax3(int a[], int left, int right) {
    if (left == right) {
        return a[left];
    }
    int mid = (left + right) / 2;
    int maxLeft = findMax3(*a, left, mid);
    int maxRight = findMax3(*a, mid + 1, right);
    if (maxLeft > maxRight) {
        return maxLeft;
    } else {
        return maxRight;
    }

}

void showReverse(char s[]) { //배열을 이해하는데 제일 편한 코드 같긴하다.
    if (*s != 0) {
        showReverse(*s + 1);
        printf(*s);
    }

}

int partition(int a[], int left, int right) {
    int pivot = left;
    int toRight = left;
    int toLeft = right + 1;
    do {
        do { toRight++; } while (a[toRight] > a[pivot]);
        do { toLeft--; } while (a[toLeft] < a[pivot]);

        if (toRight < toLeft) {
            SWAP(int, a[toLeft], a[toRight]);
        }
    } while (toRight < toLeft);
    SWAP(int, a[left], a[toLeft]);

    return toLeft;
}

void quickRecursively(int a[], int left, int right) {
    if (left < right) {
        int mid = partition(*a, left, right);
        quickRecursively(*a, left, mid - 1);
        quickRecursively(*a, left, mid + 1);
    }
}

