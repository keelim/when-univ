
#include <stdio.h>
#include <stdlib.h>

int main(void) {

    FILE *fp1, *fp2;
    int a;

    fp1 = fopen_s(fp1,"a.txt", "w");

    if (fp1 == NULL) {
        printf("쓰기 모드 파일 오픈 실패\n");
        exit(0);
    }

    puts("문자 하나를 입력하라");
    a = getchar();
    fputc(a, fp1);
    fclose(fp1);

    fp2 = fopen_s(fp2,"a.txt", "r");
    if (fp2 == NULL) {
        printf("읽기 모드 파일 오픈 실패\n");
        exit(0);
    }

    a = fgetc(fp2);
    printf("파일내용:%c\n", (char) a);
    fclose(fp2);


    return 0;
}
