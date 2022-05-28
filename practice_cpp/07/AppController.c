#include "AppController.h"
#include "Ban.h"
#include "GradeCounter.h"
#include "Student.h"

struct _AppController {
    Ban *ban;
};

#define MAX_NUMBER_OF_STUDENTS 100

AppController *AppController_new() {  //AppController constructor
    AppController *_this = NewObject(AppController);
    _this->ban = Ban_newWidthCapacity(MAX_NUMBER_OF_STUDENTS);

    return _this;
}

void AppController_run(AppController *_this) {  //AppController 실헹
    AppView_out("<<< 성적 처리를 시작 합니다.  >>>");

    Boolean inputAndStoreWasSuccessful; //Boolean 값 설정
    inputAndStoreWasSuccessful = AppController_inputAndStoreStudents(_this); //입력되는 학생의 유효성 확인

    if (inputAndStoreWasSuccessful) {
        if (Ban_isEmpty(_this->ban)) { //비어 있는지 확인
            AppView_out("[오류] 학생 정보가 입력되지 않았습니다. ");
        } else {
            AppController_showStatics(_this); //통계함수 출력
            Ban_sortStudentsByScore(_this->ban); //점수 순으로 정렬
            AppController_showStudentsSortedByScore(_this); //정렬된 순으로 학생들의 성적을 전부 출력

        }
    } else {
        AppView_out("[오류] 성적이 정상적으로 저장되지 않았습니다. ");
    }
    AppView_out("<<< 성적 처리를 종료합니다. >>>");
}

void AppController_delete(AppController *_this) {  //AppController 소멸
    Ban_delete(_this->ban); //안에 있는 배열 까지 같이 소멸
    free(_this); //free
}

Boolean AppController_inputIsValid(AppController *_this, char *aStudentID, int aScore) { //유효값인지 확인
    Boolean inputIsValid = TRUE;

    if (!Student_studentIDIsValid(aStudentID)) {
        AppView_out_msg_invaildStudentID(aStudentID, MAX_STUDENT_ID_LENGTH);
        inputIsValid = FALSE;
    }
    if (!Student_scoreIsValid(aScore)) {
        AppView_out_msg_inValidScore(aScore);
        inputIsValid = FALSE;
    }

    return inputIsValid;
}


Boolean AppController_inputAndStoreStudents(AppController *_this) {  //학생 입력 점수의 유효성을 확인
    int score;
    char studentID[100];

    Boolean storingAStudentWasSucessful = TRUE;
    Student *student;

    while (storingAStudentWasSucessful && AppView_in_doesContinueToInputNextStudent()) { //학생 입력 점수 와 flag while
        AppView_in_StudentID(studentID); //학번 입력
        score = AppView_in_score();     //점수 입력
		
        if (AppController_inputIsValid(_this, studentID, score)) { //유효성을 확인하고
            student = Student_new(studentID, score);              //Student 생성
            storingAStudentWasSucessful = Ban_add(_this->ban, student); //add
        }
    }

    return storingAStudentWasSucessful;
}


void AppController_showStatics(AppController *_this) {//통계함수 출력

    AppView_out_averageScore(Ban_averageScore(_this->ban));
    AppView_out_numberOfStudentsAboveAverage(Ban_numberOfStudentsAboveAverage(_this->ban));
    AppView_out_maxScore(Ban_maxScore(_this->ban));
    AppView_out_minScore(Ban_minScore(_this->ban));


    GradeCounter *gradeCounter = Ban_countGrades(_this->ban);
    AppView_out_gradeCountFor('A', GradeCounter_numberOfA(gradeCounter));
    AppView_out_gradeCountFor('B', GradeCounter_numberOfB(gradeCounter));
    AppView_out_gradeCountFor('C', GradeCounter_numberOfC(gradeCounter));
    AppView_out_gradeCountFor('D', GradeCounter_numberOfD(gradeCounter));
    AppView_out_gradeCountFor('F', GradeCounter_numberOfF(gradeCounter));
    GradeCounter_delete(gradeCounter);

}

void AppController_showStudentsSortedByScore(AppController *_this) { //정렬된 순으로의 함수 출력
    int score;
    char grade;
    char *id;

    AppView_out_titleForSortedStudentList();

    for (int order = 0; order < Ban_size(_this->ban); order++) {
        score = Student_score(Ban_elementAt(_this->ban, order));
        grade = Ban_scoreToGrade(score); //성적을 등급으로 변경
        id = Student_studentID(Ban_elementAt(_this->ban, order));
        AppView_out_studentinfo(id, score, grade); //학생들의 정보를 출력
    }
}