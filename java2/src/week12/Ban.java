package week12;

public class Ban {//반으로 처리
    private int _capacity;
    private int _numberOfStudents;
    private Student[] _students;
    private double _average;
    private int _numberOfStudentsWithAboveAverage;
    private int _numberOfStudentsFoRGradeA;
    private int _numberOfStudentsFoRGradeB;
    private int _numberOfStudentsFoRGradeC;
    private int _numberOfStudentsFoRGradeD;
    private int _numberOfStudentsFoRGradeF;

    public Ban(int givenCapacity) {
        this._capacity = givenCapacity;
        this._students = new Student[this._capacity];
        this._numberOfStudents = 0;
        this._average = 0.0;

        this._numberOfStudentsWithAboveAverage = 0;
        this._numberOfStudentsFoRGradeA = 0;
        this._numberOfStudentsFoRGradeB = 0;
        this._numberOfStudentsFoRGradeC = 0;
        this._numberOfStudentsFoRGradeD = 0;
        this._numberOfStudentsFoRGradeF = 0;
    }

    public Student[] students() {
        return _students;
    }

    public int capacity() {
        return this._capacity;
    }

    public int numberOfStudents() {
        return this._numberOfStudents;
    }

    public Boolean isEmpty() {
        return this._numberOfStudents == 0;
    }

    public Boolean isFull() {
        return this._numberOfStudents == this._capacity;
    }

    public Student studentAtOrder(int order) {
        if ((order < 0) || (order >= this._numberOfStudents)) {
            return null;
        } else {
            return this._students[order];
        }
    }

    public Boolean addStudent(Student student) {
        if (this.isFull()) {
            return false;
        } else {
            this._students[this._numberOfStudents] = student;
            this._numberOfStudents++;
            return true;
        }
    }

    public void calcAverageInfo() {
        if (this.isEmpty()) {
            this._average = 0.0;
            this._numberOfStudentsWithAboveAverage = 0;
        } else {
            int sum = 0;
            for (int i = 0; i < this._numberOfStudents; i++) {
                Student currentStudent = this._students[i];
                sum += currentStudent.score();
            }
            this._average = (double) sum / (double) this._numberOfStudents;
            this._numberOfStudentsWithAboveAverage = 0;
            for (int i = 0; i < this._numberOfStudents; i++) {
                if ((double) this._students[i].score() >= this._average) {
                    this._numberOfStudentsWithAboveAverage++;
                }
            }
        }
    }

    public double average() {
        return this._average;
    }

    public int numberOfStudentsWithAboveAverage() {
        return this._numberOfStudentsWithAboveAverage;
    }

    public void countStudentsByGrade() {
        this._numberOfStudentsFoRGradeA = 0;
        this._numberOfStudentsFoRGradeB = 0;
        this._numberOfStudentsFoRGradeC = 0;
        this._numberOfStudentsFoRGradeD = 0;
        this._numberOfStudentsFoRGradeF = 0;
        char currentGrade;

        for (int i = 0; i < this._numberOfStudents; i++) {
            currentGrade = this._students[i].grade();
            if (currentGrade == 'A') {
                this._numberOfStudentsFoRGradeA++;
            } else if (currentGrade == 'B') {
                this._numberOfStudentsFoRGradeB++;
            } else if (currentGrade == 'C') {
                this._numberOfStudentsFoRGradeC++;
            } else if (currentGrade == 'D') {
                this._numberOfStudentsFoRGradeD++;
            } else {
                this._numberOfStudentsFoRGradeF++;
            }

        }
    }

    public int numberOfStudentsFoRGradeA() {
        return _numberOfStudentsFoRGradeA;
    }

    public int numberOfStudentsFoRGradeB() {
        return _numberOfStudentsFoRGradeB;
    }

    public int numberOfStudentsFoRGradeC() {
        return _numberOfStudentsFoRGradeC;
    }

    public int numberOfStudentsFoRGradeD() {
        return _numberOfStudentsFoRGradeD;
    }

    public int numberOfStudentsFoRGradeF() {
        return _numberOfStudentsFoRGradeF;
    }
}
