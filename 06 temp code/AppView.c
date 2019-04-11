#include "AppView.h"

void AppView_out(char* message) { //메시지 출력
	printf("%s\n", message);
}

void AppView_out_averageScore(float anAverageScore) { //평균 메시지 출력
	printf("평균 점수는 %.2f 입니다.\n ", anAverageScore);
}

Boolean AppView_in_doesContinueToInputNextStudent() { //직접적인 입력
	printf("? 성적 입력하려면 'Y' , 입력을 종료하려면 다른 아무키나 치시오 \n");
	char answer;
	answer=getcharDirectlyFromKeyBoard();

	return (answer == 'Y' || answer == 'y');
}

int AppView_in_score() { //점수 입력
	int score;
	printf("점수를 입력하시오: ");
	scanf_s("%d", &score);

	return score;
}

char getcharDirectlyFromKeyBoard() { //키보드 직접 입력
	char charFromKeyBoard;
	charFromKeyBoard=_getch();

	return charFromKeyBoard;
}


void AppView_out_numberOfStudentsAboveAverage(int aNumber) { //평균 이상은 몇명인지?
	printf("평균 이상인 학생은 모두 %d 입니다. \n\n", aNumber);
}

void AppView_out_maxScore(int aMaxScore) {//학생 최고 점수

	printf("학생들의 최고점은 %d 입니다. \n", aMaxScore);

}
void AppView_out_minScore(int aMinScore) { //학생 최소 점수
	printf("학생들의 최저점은 %d 입니다. \n\n", aMinScore);

}
void AppView_out_gradeCountFor(char aGrade, int aCount) { //학생 등급에 따른 명 수 출력
	printf("%c 학점은 %d명 입니다. \n\n", aGrade, aCount);
}

void AppView_out_studentinfo(int score, char grade) { //학생 정보 출력
	printf("점수: %d 학점: %c\n", score, grade);
}





