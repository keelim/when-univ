//#include <stdio.h>
//#include <stdlib.h>
//
//int main(void) {
//
//
//	FILE *fp1, *fp2;
//	int data = 0;
//	fp1 = fopen_s(fp1, "a.txt", "w");
//	if (fp1 == NULL) {
//		printf("읽기 모드 파일 오픈 실패\n");
//		exit(0);
//
//	}
//
//	fp2 = fopen_s(fp2,"b.txt", "w");
//	if (fp2 == NULL) {
//		printf("쓰기 모드 파일 오픈 실패\n");
//		exit(0);
//	}
//
//	while ((data = fgetc(fp1)!=-1)) {
//		fputc(data, fp2);
//	}
//	fclose(fp1);
//	fclose(fp2);
//
//
//	return 0;
//}