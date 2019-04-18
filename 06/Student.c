#include "Student.h"
#include <string.h>
#include"Common.h"


struct _Student {
    char _studentID[MAX_STUDENT_ID_LENGTH];
    int _score;
};

Student *Student_new(char *givenStudentID, int givenScore) {
    Student *_this = NewObject(Student);
    strcpy(_this->_studentID, givenStudentID);
    _this->_score = givenScore;
    return _this;
}

void Student_delete(Student *_this) {
    free(_this->_studentID);
    free(_this);

}

char *Student_studentID(Student *_this) {
    char *copiedStudentID = NewVector(char, 10);
    strcpy(copiedStudentID, _this->_studentID);
    return copiedStudentID;
}

int Student_score(Student *_this) {
    return _this->_score;
}

Boolean Student_studentIDIsValid(char *aStudentID) {
    int length = 0;
    while (*aStudentID != '\0') {
        length++;
        aStudentID++;
    }

    return (length <= MAX_STUDENT_ID_LENGTH);
}

Boolean Student_scoreIsValid(int aScore) {
    return (aScore >= 0 && aScore <= 100);
}
