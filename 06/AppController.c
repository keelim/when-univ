#include "AppController.h"
#include "Ban.h"
#include"GradeCounter.h"

struct _AppController {
	Ban* ban;
};

#define MAX_NUMBER_OF_STUDENTS 100

AppController* AppController_new() //AppController constructor
{
	AppController* _this=NewObject(AppController);
	_this->ban=Ban_newWidthCapacity(MAX_NUMBER_OF_STUDENTS);

	return _this;
}

void AppController_run(AppController* _this) //AppController 실헹
{
	AppView_out("<<< 성적 처리를 시작 합니다.  >>>");
	Boolean inputAndStoreWasSuccessful; //Boolean 값 설정
	inputAndStoreWasSuccessful=AppController_inputAndStoreStudents(_this); //입력되는 학생의 유효성 확인

	if (inputAndStoreWasSuccessful) {
		if (Ban_isEmpty(_this->ban)) {
			AppView_out("[오류] 학생 정보가 입력되지 않았습니다. ");
		}
		else {
			AppController_showStatics(_this); //통계함수 출력
			Ban_sortStudentsByScore(_this->ban); //점수 순으로 정렬
			AppController_showStudentsSortedByScore(_this); //정렬된 순으로 학생들의 성적을 전부 출력

		}
	}
	else {
		AppView_out("[오류] 성적이 정상적으로 저장되지 않았습니다. ");
	}
	AppView_out("<<< 성적 처리를 종료합니다. >>>");
}

void AppController_delete(AppController* _this) //AppController 소멸
{
	Ban_delete(_this->ban); //안에 있는 배열 까지 같이 소멸
	free(_this);
}

Boolean AppController_inputAndStoreStudents(AppController* _this) //학생 입력 점수의 유효성을 확인
{
	int score;
	Boolean storingAStudentWasSucessful=TRUE;

	while (storingAStudentWasSucessful && AppView_in_doesContinueToInputNextStudent()) { //학생 입력 점수 와 flag while
		score=AppView_in_score();
		if (Ban_scoreIsValid(score)) {
			storingAStudentWasSucessful=Ban_add(_this->ban, score);  //추가가 되었는지를 확인
		}
		else {
			AppView_out("[오류] 0보다 작거나 100보다 커서, 정상적인 점수가 아닙니다. \n");
		}
	}

	return storingAStudentWasSucessful;
}



void AppController_showStatics(AppController* _this) //통계함수를 출력
{
	AppView_out_averageScore(Ban_averageScore(_this->ban));  //평균이상의 점수
	AppView_out_numberOfStudentsAboveAverage(Ban_numberOfStudentsAboveAverage(_this->ban)); //평균 점수가 몇명인지를 출력
	AppView_out_maxScore(Ban_maxScore(_this->ban)); //최저점 출력
	AppView_out_minScore(Ban_minScore(_this->ban)); //최고점 출력


	GradeCounter* gradeCounter=GradeCounter_new();
	gradeCounter=Ban_countGrades(_this->ban);

	AppView_out_gradeCountFor('A', GradeCounter_numberOfA(gradeCounter)); //각 등급의 해당하는 학생들의 수 출력
	AppView_out_gradeCountFor('B', GradeCounter_numberOfB(gradeCounter)); //각 등급의 해당하는 학생들의 수 출력
	AppView_out_gradeCountFor('C', GradeCounter_numberOfC(gradeCounter)); //각 등급의 해당하는 학생들의 수 출력
	AppView_out_gradeCountFor('D', GradeCounter_numberOfD(gradeCounter)); //각 등급의 해당하는 학생들의 수 출력
	AppView_out_gradeCountFor('F', GradeCounter_numberOfF(gradeCounter)); //각 등급의 해당하는 학생들의 수 출력

	GradeCounter_delete(gradeCounter); //Grade_Counter

}

void AppController_showStudentsSortedByScore(AppController* _this) //정렬된 순으로의 함수 출력
{
	AppView_out("학생들의 성적 순 목록입니다. \n");

	int score;
	char grade;

	for (int order=0; order < Ban_size(_this->ban); order++) {
		score=Ban_elementAt(_this->ban, order);
		grade=Ban_scoreToGrade(score); //성적을 등급으로 변경
		AppView_out_studentinfo(score, grade); //학생들의 정보를 출력

	}
}
