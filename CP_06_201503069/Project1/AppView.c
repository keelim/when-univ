#include "AppView.h"

void AppView_out(char* message)
{
}

void AppView_out_averageScore(float anAverageScore)
{
	//todo
}

Boolean AppView_in_doesContinueToInputNextStudent() {
	printf("? 성적 입력하려면 'Y' , 입력을 종료하려면 다른 아무키나 치시오");

	char answer;
	answer = getcharDirectlyFromKeyBoard();

	return (answer == 'Y' || answer == 'y');
}

int AppView_in_score() {
	return 0; //todo
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
	//todo
}
void AppView_out_minScore(int aMinScore) {
	//todo
}
void AppView_out_gradeCountFor(char aGrade, int aCount) {
	//todo
}

void AppView_out_studentinfo(int score, char grade) {
	//todo
}





