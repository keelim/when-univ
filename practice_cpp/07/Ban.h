#include"Common.h"
#include"GradeCounter.h"
#include "Student.h"

typedef struct _Ban Ban;

void Ban_delete(Ban *_this);

void Ban_sortStudentsByScore(Ban *_this); //성적 순으로 정렬

void Ban_quickSortRecursively(Ban *_this, int left, int right); //recursicve 구현

int Ban_capacity(Ban *_this);

int Ban_size(Ban *_this);

int Ban_partition(Ban *_this, int left, int right);

int Ban_maxScore(Ban *_this);

int Ban_minScore(Ban *_this);

int Ban_numberOfStudentsAboveAverage(Ban *_this);

char Ban_scoreToGrade(int aScore);

float Ban_averageScore(Ban *_this);

Ban *Ban_new();

Ban *Ban_newWidthCapacity(int givenCapacity);

Boolean Ban_isEmpty(Ban *_this);

Boolean Ban_isFull(Ban *_this);

Boolean Ban_scoreIsValid(int aScore);

Boolean Ban_add(Ban *_this, Student *aStudent);

Student *Ban_elementAt(Ban *_this, int anOrder);

GradeCounter *Ban_countGrades(Ban *_this);
	

