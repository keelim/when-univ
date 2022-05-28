#include<conio.h>
#include"Common.h"
void AppView_out(char* aString); //메시지 출력
void AppView_out_averageScore(float anAverageScore);//평균 점수 출력
void AppView_out_numberOfStudentsAboveAverage(int aNumber);//평균 이상 학생
void AppView_out_maxScore(int aMaxScore);  //최고점
void AppView_out_minScore(int aMinScore); //최저점
void AppView_out_gradeCountFor(char aGrade, int aCount); //학점 명수 센다.

void AppView_out_studentinfo(char* studentID, int score, char grade); //학생 정보 출력

Boolean AppView_in_doesContinueToInputNextStudent(); //입력 확인
int AppView_in_score(); //점수 입력

char getcharDirectlyFromKeyBoard(); //direct 입력

void AppView_out_msg_invaildStudentID(char* aStudentID, int maxLength);

void AppView_out_msg_inValidScore(int aScore);

void AppView_in_StudentID(char* aStudentID);

void AppView_out_titleForSortedStudentList();


