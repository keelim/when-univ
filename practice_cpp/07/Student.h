#include "Common.h"

#define MAX_STUDENT_ID_LENGTH 9

typedef struct _Student Student;

void Student_delete(Student *_this);

char *Student_studentID(Student *_this);

int Student_score(Student *_this);

Student *Student_new(char *givenStudentID, int givenScore);

Boolean Student_studentIDIsValid(char *aStudentID);

Boolean Student_scoreIsValid(int aScore);