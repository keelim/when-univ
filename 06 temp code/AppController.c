#include "AppController.h"
#include "Ban.h"
#include"GradeCounter.h"

struct _AppController {
	Ban* ban;
};

#define MAX_NUMBER_OF_STUDENTS 100

AppController* AppController_new()
{
	AppController* _this = NewObject(AppController);
	_this->ban = Ban_newWidthCapacity(MAX_NUMBER_OF_STUDENTS);

	return _this;
}

void AppController_run(AppController* _this)
{
	AppView_out("<<< 성적 처리를 시작 합니다.  >>>");
	Boolean inputAndStoreWasSuccessful;
	inputAndStoreWasSuccessful = AppController_inputAndStoreStudents(_this);

	if (inputAndStoreWasSuccessful) {
		if (Ban_isEmpty(_this->ban)) {
			AppView_out("[오류] 학생 정보가 입력되지 않았습니다. ");
		}
		else {
			AppController_showStatics(_this);
			Ban_sortStudentsByScore(_this->ban);
			AppController_showStudentsSortedByScore(_this);

		}
	}
	else {
		AppView_out("[오류] 성적이 정상적으로 저장되지 않았습니다. ");
	}
	AppView_out("<<< 성적 처리를 종료합니다. >>>");
}

void AppController_delete(AppController* _this)
{
	Ban_delete(_this->ban);
	free(_this);
}

Boolean AppController_inputAndStoreStudents(AppController* _this)
{
	int score;
	Boolean storingAStudentWasSucessful = TRUE;

	while (storingAStudentWasSucessful && AppView_in_doesContinueToInputNextStudent()) {
		score = AppView_in_score();
		if (Ban_scoreIsValid(score)) {
			storingAStudentWasSucessful = Ban_add(_this->ban, score);
		}
		else {
			AppView_out("[오류] 0보다 작거나 100보다 커서, 정상적인 점수가 아닙니다. \n");
		}
	}

	return storingAStudentWasSucessful;
}



void AppController_showStatics(AppController* _this)
{
	AppView_out_averageScore(Ban_averageScore(_this->ban));
	AppView_out_numberOfStudentsAboveAverage(Ban_numberOfStudentsAboveAverage(_this->ban));
	AppView_out_maxScore(Ban_maxScore(_this->ban));
	AppView_out_minScore(Ban_minScore(_this->ban));


	GradeCounter* gradeCounter = GradeCounter_new();
	gradeCounter = Ban_countGrades(_this->ban);

	AppView_out_gradeCountFor('A', GradeCounter_numberOfA(gradeCounter));
	AppView_out_gradeCountFor('B', GradeCounter_numberOfB(gradeCounter));
	AppView_out_gradeCountFor('C', GradeCounter_numberOfC(gradeCounter));
	AppView_out_gradeCountFor('D', GradeCounter_numberOfD(gradeCounter));
	AppView_out_gradeCountFor('F', GradeCounter_numberOfF(gradeCounter));

	GradeCounter_delete(gradeCounter);

}

void AppController_showStudentsSortedByScore(AppController* _this)
{
	AppView_out("학생들의 성적 순 목록입니다. \n");

	int score;
	char grade;

	for (int order = 0; order < Ban_size(_this->ban); order++) {
		score = Ban_elementAt(_this->ban, order);
		grade = Ban_scoreToGrade(score); //성적을 등급으로 변경
		AppView_out_studentinfo(score, grade);

	}
}
