#include "AppView.h"

void AppView_out(char* message) { //mesaage out
	printf("%s\n", message);
}

void AppView_out_averageScore(float anAverageScore) { //average out
	printf("\n평균 점수는 %.2f 입니다.\n ", anAverageScore);
}

Boolean AppView_in_doesContinueToInputNextStudent() {
    char answer;
    printf("? 성적 입력하려면 'Y' , 입력을 종료하려면 다른 아무키나 치시오 \n");
	answer = getcharDirectlyFromKeyBoard();

	return (answer == 'Y' || answer == 'y');
}

int AppView_in_score() {
	int score;

	printf("점수를 입력하시오: ");
	scanf_s("%d", &score);
	printf("\n");
	return score;

}

char getcharDirectlyFromKeyBoard() {
	char charFromKeyBoard;
	charFromKeyBoard = _getch();

	return charFromKeyBoard;
}


void AppView_out_numberOfStudentsAboveAverage(int aNumber) {
	printf("평균 이상인 학생은 모두 %d 명 입니다. \n", aNumber);
}

void AppView_out_maxScore(int aMaxScore) {

	printf("학생들의 최고점은 %d 입니다. \n", aMaxScore);

}

void AppView_out_minScore(int aMinScore) {

	printf("학생들의 최저점은 %d 입니다. \n\n", aMinScore);

}

void AppView_out_gradeCountFor(char aGrade, int aCount) {
	printf("%c 학점은 %d명 입니다. \n", aGrade, aCount);
}

void AppView_out_studentinfo(char* studentID, int score, char grade) {
	printf("학번:%s 점수: %d 학점: %c\n", studentID, score, grade);
}

void AppView_in_StudentID(char* aStudentID) {
	printf("학번을 입력하세요!: ");
	scanf("%s" ,aStudentID);
}

void AppView_out_msg_invaildStudentID(char* aStudentID, int maxLength) {
	printf("[오류] 학번 %s 의 길이가 너무 깁니다. 최대 %d 입니다. \n", aStudentID, maxLength);
}

void AppView_out_msg_inValidScore(int aScore) {
	printf("[오류] 성적이 0보다 작거나 커서 정상적인 점수가 아닙니다. \n");
}

void AppView_out_titleForSortedStudentList() {
	printf("\n 학생들의 성적 순 목록입니다. \n");
}


