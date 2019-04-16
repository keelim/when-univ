#include "AppView.h"

void AppView_out(char* message)
{
	printf("%s\n", message);
}

void AppView_out_averageScore(float anAverageScore) {
	printf("\n평균 점수는 %.2f 입니다.\n ", anAverageScore);
}

Boolean AppView_in_doesContinueToInputNextStudent(){
	printf("? 성적 입력하려면 'Y' , 입력을 종료하려면 다른 아무키나 치시오 \n");
	char answer;
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

char getcharDirectlyFromKeyBoard()
{
	char charFromKeyBoard;
	charFromKeyBoard = _getch();

	return charFromKeyBoard;
}


void AppView_out_numberOfStudentsAboveAverage(int aNumber) {
	printf("평균 이상인 학생은 모두 %d 입니다. \n", aNumber);
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

void AppView_out_studentinfo(int score, char grade) {
	printf("점수: %d 학점: %c\n", score, grade);
}





