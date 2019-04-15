#include "GradeCounter.h"
struct _GradeCounter { 
	int numberOfA;
	int numberOfB;
	int numberOfC;
	int numberOfD;
	int numberOfF;
};

GradeCounter* GradeCounter_new() { //생성
	GradeCounter* _this=NewObject(GradeCounter);

	_this->numberOfA=0;
	_this->numberOfB=0;
	_this->numberOfC=0;
	_this->numberOfD=0;
	_this->numberOfF=0;

	return _this;
}

void GradeCounter_delete(GradeCounter* _this) { //소멸
	free(_this);
}

void GradeCounter_count(GradeCounter* _this, char aGrade) {
	switch (aGrade) {
	case 'A':
		_this->numberOfA++;
		break;
	case 'B':
		_this->numberOfB++;
		break;
	case 'C':
		_this->numberOfC++;
		break;
	case 'D':
		_this->numberOfD++;
		break;
	case 'F':
		_this->numberOfF++;
		break;
	}
}

int GradeCounter_numberOfA(GradeCounter* _this) { // a 접근
	return _this->numberOfA;
}

int GradeCounter_numberOfB(GradeCounter* _this) { //b 접근
	return _this->numberOfB;
}
int GradeCounter_numberOfC(GradeCounter* _this) {//c 접근
	return _this->numberOfC;
}
int GradeCounter_numberOfD(GradeCounter* _this) {//d 접근
	return _this->numberOfD;
}
int GradeCounter_numberOfF(GradeCounter* _this) {//e 접근
	return _this->numberOfF;
}