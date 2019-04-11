#include "AppView.h"

void AppView_out(char* message)
{
}

void AppView_out_averageScore(float anAverageScore)
{

	printf("평균 점수는 %.2f 입니다. ", anAverageScore);

}

Boolean AppView_in_doesContinueToInputNextStudent() {
	printf("? 성적 입력하려면 'Y' , 입력을 종료하려면 다른 아무키나 치시오");

	char answer;
	answer = getcharDirectlyFromKeyBoard();

	return (answer == 'Y' || answer == 'y');
}

int AppView_in_score() {
	int score;
	printf("점수를 입력하여 주세요: ");//todo
	scanf_s("%d", &score);

	return score;
}

char getcharDirectlyFromKeyBoard()
{
	char charFromKeyBoard;
	charFromKeyBoard = _getch();

	return charFromKeyBoard;
}


void AppView_out_numberOfStudentsAboveAverage(int aNumber) {
	//todo
}
//
void AppView_out_maxScore(int aMaxScore) {

	printf("학생들의 최고점은 %d 입니다. ", aMaxScore);

}
void AppView_out_minScore(int aMinScore) {

	printf("학생들의 최저점은 %d 입니다. ", aMinScore);

}
void AppView_out_gradeCountFor(char aGrade, int aCount) {
	//todo
}

void AppView_out_studentinfo(int score, char grade) {
	//todo
}





