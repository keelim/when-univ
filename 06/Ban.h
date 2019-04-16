#include"Common.h"
#include"GradeCounter.h"
typedef struct _Ban Ban;

int Ban_capacity(Ban* _this);
int Ban_size(Ban* _this);

Ban* Ban_new();
Ban* Ban_newWidthCapacity(int givenCapacity);
Boolean Ban_isEmpty(Ban* _this);
Boolean Ban_isFull(Ban* _this);
Boolean Ban_scoreIsValid(int aScore);
void Ban_delete(Ban* _this);
Boolean Ban_add(Ban* _this, int aScore);
int Ban_elementAt(Ban* _this, int anOrder);
char Ban_scoreToGrade(int score);

void Ban_sortStudentsByScore(Ban* _this); //성적 순으로 정렬
void Ban_quickSortRecursively(Ban* _this, int left, int right); //recursicve 구현
int Ban_partition(Ban* _this, int left, int right);
float Ban_averageScore(Ban* _this);
int Ban_maxScore(Ban* _this);
int Ban_minScore(Ban* _this);
int Ban_numberOfStudentsAboveAverage(Ban* _this);

GradeCounter* Ban_countGrades(Ban* _this);
	

