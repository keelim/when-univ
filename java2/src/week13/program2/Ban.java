package week13.program2;

public class Ban {
    private int _capacity;
    private int _numberOfStudents;
    private Student[] _students;
    private double _average;
    private int _numberOfStudentsWithAboveAverage;


    public Ban(int givenCapacity) {
        this._capacity = givenCapacity;
        this._students = new Student[this._capacity];
        this._numberOfStudents = 0;
        this._average = 0.0;

        this._numberOfStudentsWithAboveAverage = 0;
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
            double gpa = 0.0;
            for (int i = 0; i < this._numberOfStudents; i++) {
                Student currentStudent = this._students[i];
                gpa += currentStudent.GPA();
            }
            this._average = gpa / this._numberOfStudents;
            this._numberOfStudentsWithAboveAverage = 0;
            for (int i = 0; i < this._numberOfStudents; i++) {
                if (this._students[i].GPA() >= this._average) {
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

}
