#include"Common.h"
#include "Ban.h"

#define DEFAULT_CAPACITY 100
struct _Ban {
	int _capacity;
	int _size;
	int* _elements; //동적 배열
};

int Ban_capacity(Ban* _this) {
	return _this->_capacity;
}

int Ban_size(Ban* _this) {
	return _this->_size;
}

Ban* Ban_new() {
	Ban* _this=NewObject(Ban);
	_this->_capacity=DEFAULT_CAPACITY;
	_this->_size=0;
	_this->_elements=NewVector(int, _this->_capacity);
	return _this;
}

Ban* Ban_newWidthCapacity(int givenCapacity) {
	Ban* _this=NewObject(Ban);
	_this->_capacity=givenCapacity;
	_this->_size=0;
	_this->_elements=NewVector(int, _this->_capacity);
	return _this;


}

Boolean Ban_isEmpty(Ban* _this) {
	return (_this->_size == 0);
}

Boolean Ban_isFull(Ban * _this) {
	return (_this->_size >= _this->_capacity);
}

Boolean Ban_scoreIsValid(int aScore) {
	return (aScore >= 0 && aScore <= 100);
}

void Ban_delete(Ban * _this) {
	free(_this->_elements);
	free(_this);
}

Boolean Ban_add(Ban * _this, int aScore) {
	if (Ban_isFull(_this)) {
		return FALSE;
	}
	else {
		_this->_elements[_this->_size]=aScore;
		_this->_size++;
		return TRUE;
	}
}

int Ban_elementAt(Ban * _this, int anOrder) {
	if (anOrder >= _this->_size) {
		return -1;
	}
	else {
		return (_this->_elements[anOrder]);
	}
}

char Ban_scoreToGrade(int aScore) {
	if (aScore >= 90) {
		return 'A';
	}
	else if (aScore >= 80) {
		return 'B';
	}
	else if (aScore >= 70) {
		return 'C';
	}
	else if (aScore >= 60) {
		return 'D';
	}
	else {
		return 'F';
	}
}

void Ban_sortStudentsByScore(Ban * _this) {
	int size=_this->_size; //quick sort 실행

	if (size >= 2) {
		int minPosition=0;
		for (int i=1; i < size; i++) {
			if (_this->_elements[i] < _this->_elements[size - 1]) {
				minPosition=i;
			}
		}

		SWAP(int, _this->_elements[minPosition], _this->_elements[size - 1]);

		Ban_quickSortRecursively(_this, 0, size - 2);
	}
}

void Ban_quickSortRecursively(Ban * _this, int left, int right) {
	if (left < right) {
		int mid=Ban_partition(_this, left, right);
		Ban_quickSortRecursively(_this, left, mid - 1);
		Ban_quickSortRecursively(_this, mid + 1, right);


	}
}

int Ban_partition(Ban * _this, int left, int right) {
	int pivot=left;
	int pivotScore=_this->_elements[pivot];

	right++;
	do {
		do { left++; } while (_this->_elements[left] > pivotScore);
		do { right--; } while (_this->_elements[right] < pivotScore);
		if (left < right) {
			SWAP(int, _this->_elements[left], _this->_elements[right]);
		}

	} while (left < right);
	SWAP(int, _this->_elements[pivot], _this->_elements[right]);

	return right;
}

float Ban_averageScore(Ban * _this) {
	float sumOfScores=(float)Ban_sumOfScoresRecursively(_this, 0, _this->_size - 1);
	float average=sumOfScores / (float)_this->_size;

	return average;
}

int Ban_maxScore(Ban * _this) {
	return Ban_maxOfScoresRecursively(_this, 0, _this->_size - 1);
}

int Ban_minScore(Ban * _this) {
	return Ban_minOfScoresRecurively(_this, 0, _this->_size - 1);
}

int Ban_numberOfStudentsAboveAverage(Ban * _this) {
	float average=Ban_averageScore(_this);
	int numberOfStudentsAboveAverage=0;

	for (int i=0; i < _this->_size; i++) {
		if ((float)_this->_elements[i] >= average) {
			numberOfStudentsAboveAverage++;
		}
	}
	return numberOfStudentsAboveAverage;
}

GradeCounter* Ban_countGrades(Ban * _this) {
	char currentGrade;
	GradeCounter* gradeCounter=GradeCounter_new();

	for (int i=0; i < _this->_size; i++) {
		currentGrade=Ban_scoreToGrade(_this->_elements[i]);
		GradeCounter_count(gradeCounter, currentGrade);
	}
	return gradeCounter;
}

int Ban_sumOfScoresRecursively(Ban * _this, int left, int right) { //재귀적인 함수의 구성
	if (left > right) {
		return 0;
	}
	else {
		return (_this->_elements[left] + Ban_sumOfScoresRecursively(_this, left + 1, right));
	}
}

int Ban_maxOfScoresRecursively(Ban * _this, int left, int right) { //반을 반으로 나누면서 최대닶을 찾는다. 
	int maxOfLeftPart;
	int maxOfRightPart;
	int mid;

	if (left == right) {
		return _this->_elements[left];
	}
	else {
		mid=(right + left) / 2;
		maxOfLeftPart=Ban_maxOfScoresRecursively(_this, left, mid);
		maxOfRightPart=Ban_maxOfScoresRecursively(_this, mid + 1, right);

		if (maxOfLeftPart >= maxOfRightPart) {
			return maxOfLeftPart;
		}
		else {
			return maxOfRightPart;
		}
	}
}

int Ban_minOfScoresRecurively(Ban * _this, int left, int right) { //반을 하나씩 줄여나가면서 최솟값을 찾는다. // 중요 

	int minPart;
	if (left == right) {
		return _this->_elements[left];
	}
	else {
		minPart=Ban_minOfScoresRecurively(_this, left + 1, right);
		if (_this->_elements >= minPart) {
			return minPart;
		}
		else {
			return _this->_elements[left];
		}
	}
}


