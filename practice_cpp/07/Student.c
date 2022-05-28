#include "Student.h"
#include <string.h>
#include"Common.h"


struct _Student { //def
    char _studentID[MAX_STUDENT_ID_LENGTH];
    int _score;
};

Student *Student_new(char *givenStudentID, int givenScore) { //Student consructor
    Student *_this = NewObject(Student); //generate

    strcpy(_this->_studentID, givenStudentID); //array copy
    _this->_score = givenScore;

    return _this;
}

void Student_delete(Student *_this) { //Student 소멸
    free(_this->_studentID);		 //Student 안에 있는 배열도 소멸 시켜야 한다. 
    free(_this);
}

char *Student_studentID(Student *_this) {
    char *copiedStudentID = NewVector(char, 10);
    strcpy(copiedStudentID, _this->_studentID); //복사를 하고 복사한 것을 리턴한다. 

    return copiedStudentID;
}

int Student_score(Student *_this) { //score getter
    return _this->_score;
}

Boolean Student_studentIDIsValid(char *aStudentID) { //학번의 유효성을 확인을 한다. 
    int length = 0;

    while (*aStudentID != '\0') { //null chracter check
        length++;
        aStudentID++;
    }

    return (length <= MAX_STUDENT_ID_LENGTH); //9개 이하인지 확인
}

Boolean Student_scoreIsValid(int aScore) { // 0<=  score <=100 인지를 확인
    return (aScore >= 0 && aScore <= 100);
}
