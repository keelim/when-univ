#include"Common.h"
#include "Ban.h"


#define DEFAULT_CAPACITY 100
struct _Ban {
    int _capacity;
    int _size;
    Student **_elements; //동적 배열
    GradeCounter *_getGradeCounter;
};

void Ban_quickSort(Ban *pBan);

int Ban_capacity(Ban *_this) //capacity getter
{
    return _this->_capacity;
}

int Ban_size(Ban *_this) //size getter
{
    return _this->_size;
}

Ban *Ban_new() //Ban constructor
{
    Ban *_this = NewObject(Ban);
    _this->_capacity = DEFAULT_CAPACITY;
    _this->_size = 0;
    _this->_elements = NewVector(Student*, _this->_capacity);
    return _this;
}

Ban *Ban_newWidthCapacity(int givenCapacity) //Ban parameter constructor
{
    Ban *_this = NewObject(Ban);
    _this->_capacity = givenCapacity;
    _this->_size = 0;
    _this->_elements = NewVector(Student*, _this->_capacity);
    return _this;
}

Boolean Ban_isEmpty(Ban *_this) //비어 있는지를 확인
{
    return (_this->_size == 0);
}

Boolean Ban_isFull(Ban *_this) //꽉 차 있는지를 확인
{
    return (_this->_size >= _this->_capacity);
}

Boolean Ban_scoreIsValid(int aScore) //점수의 유효성을 확인
{
    return (aScore >= 0 && aScore <= 100);
}

void Ban_delete(Ban *_this) { //todo 전체 적인 수정을 어떻게 할 것인가
    free(_this);
}

Boolean Ban_add(Ban *_this, Student *aStudnet) //Ban의 점수를 추가
{
    if (Ban_isFull(_this)) {
        return FALSE;
    } else {
        _this->_elements[_this->_size] = aStudnet;
        _this->_size++;
        return TRUE;
    }
}

Student *Ban_elementAt(Ban *_this, int anOrder) //특정 인데스에서의 엘리먼트 추가
{
    if (anOrder >= _this->_size) {
        return NULL;
    } else {
        return (_this->_elements[anOrder]);
    }
}

char Ban_scoreToGrade(int aScore) //해당 점수의 맞는 등급을 리턴
{
    if (aScore >= 90) {
        return 'A';
    } else if (aScore >= 80) {
        return 'B';
    } else if (aScore >= 70) {
        return 'C';
    } else if (aScore >= 60) {
        return 'D';
    } else {
        return 'F';
    }
}

void Ban_sortStudentsByScore(Ban *_this) {//점수 순으로 정렬을 한다.
    Ban_quickSort(_this);

}

// Quick Sort를 위한 비공개 함수
void Ban_quickSort(Ban *_this) {
    int size = Ban_size(_this); // 정렬할 데이터는 _this->_elements[0] 부터 _this->_elements[size-1] 까지 이다 // 퀵 정렬을 실행한다
    if (size >= 2) { // 개수가 2 이상이면 // 최소값의 위치를 찾는다
        int minPosition = 0;
        for (int i = 1; i < size; i++) {
            if (Student_score(_this->_elements[i]) < Student_score(_this->_elements[minPosition])) { minPosition = i; }
        } // 최소값을 원소 구간의 맨 끝으로 옮긴다.
        SWAP(Student*, _this->_elements[minPosition],
             _this->_elements[size - 1]); // 정렬을 시작한다
        Ban_quickSortRecursively(_this, 0, size - 2);
    }
}

void Ban_quickSortRecursively(Ban *_this, int left, int right) {//quicksort 실행
    int mid;
    if (left < right) {
        mid = Ban_partition(_this, left, right);
        Ban_quickSortRecursively(_this, left, mid - 1);
        Ban_quickSortRecursively(_this, mid + 1, right);
    }

}

int Ban_partition(Ban *_this, int left, int right) //quick Sort에 필요한 파티션을 선택
{
    int pivot = left;
    int pivotScore = Student_score(_this->_elements[pivot]);
    int toLeft = right + 1;
    int toRight = left;
    do {
        do { toRight++; } while (Student_score(_this->_elements[toRight]) > pivotScore);
        do { toLeft--; } while (Student_score(_this->_elements[toLeft]) < pivotScore);

        if (toRight < toLeft) {SWAP (Student*, _this->_elements[toRight], _this->_elements[toLeft]); }

    } while (toRight < toLeft);
    SWAP (Student*, _this->_elements[pivot], _this->_elements[toLeft]);
    return toLeft;
}

int Ban_maxOfScoresRecursively(Ban *_this, int left, int right) { //재귀적으로 반을 나누어서 최댓값을 택한다.
    int maxOfLeftPart;
    int maxOfRightPart;
    int mid;
    int score;
    if (left == right) { //초항을 잘 만지면 된다.
        score = Student_score(_this->_elements[left]);
        return score;

    } else {
        mid = (right + left) / 2;
        maxOfLeftPart = Ban_maxOfScoresRecursively(_this, left, mid); //재귀적 call 반에서의 최댓값
        maxOfRightPart = Ban_maxOfScoresRecursively(_this, mid + 1, right);

        if (maxOfLeftPart >= maxOfRightPart) { //더 큰 값을 선택
            return maxOfLeftPart;
        } else {
            return maxOfRightPart;
        }
    }
}

int Ban_minOfScoresRecurively(Ban *_this, int left, int right) { //재귀적으로 Ban에서 하나씩 줄여 나가는 생각으로 최솟값을 찾는다.

    int minPart;
    int score;
    if (left == right) {
        score = Student_score(_this->_elements[left]);
        return score;
    } else {
        minPart = Ban_minOfScoresRecurively(_this, left + 1, right); //다시 call
        if (Student_score(_this->_elements[left]) >= minPart) { //todo 일단 다시 확인
            return minPart; //적은 파트 리턴
        } else {
            score = Student_score(_this->_elements[left]);
            return score; //적은 값을 리턴
        }
    }
}

int Ban_sumOfScoresRecursively(Ban *_this, int left, int right) { //재귀적으로 학생들의  총 점수를 얻는다.
    if (left > right) { return 0; }
    else {
        int score = Student_score(_this->_elements[left]);
        return (score + Ban_sumOfScoresRecursively(_this, left + 1, right));
    }
}


float Ban_averageScore(Ban *_this) {
    float sumOfScores = (float) Ban_sumOfScoresRecursively(_this, 0, _this->_size - 1);
    float average = sumOfScores / (float) _this->_size;

    return average;
}

int Ban_maxScore(Ban *_this) {
    return Ban_maxOfScoresRecursively(_this, 0, _this->_size - 1);
}

int Ban_minScore(Ban *_this) {
    return Ban_minOfScoresRecurively(_this, 0, _this->_size - 1);
}

int Ban_numberOfStudentsAboveAverage(Ban *_this) {
    {
        float average = Ban_averageScore(_this);
        int score;
        int numberOfStudentsAboveAverage = 0;
        for (int i = 0; i < _this->_size; i++) {
            score = Student_score(_this->_elements[i]);
            if ((float) score >= average) { numberOfStudentsAboveAverage++; }
        }
        return numberOfStudentsAboveAverage;
    }
}


GradeCounter *Ban_countGrades(Ban *_this) {
    char currentGrade;
    int score;
    GradeCounter *gradeCounter = GradeCounter_new();
    for (int i = 0; i < _this->_size; i++) {
        score = Student_score(_this->_elements[i]);
        currentGrade = Ban_scoreToGrade(score);
        GradeCounter_count(gradeCounter, currentGrade);
    }
    return gradeCounter;
}





