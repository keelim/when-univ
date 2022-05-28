﻿#include"Common.h"
typedef struct _GradeCounter GradeCounter;

GradeCounter* GradeCounter_new();
void GradeCounter_delete(GradeCounter* _this);

void GradeCounter_count(GradeCounter* _this, char aGrade);

int GradeCounter_numberOfA(GradeCounter* _this);
int GradeCounter_numberOfB(GradeCounter* _this);
int GradeCounter_numberOfC(GradeCounter* _this);
int GradeCounter_numberOfD(GradeCounter* _this);
int GradeCounter_numberOfF(GradeCounter* _this);