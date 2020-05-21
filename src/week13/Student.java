package week13;

public class Student {
    private String _studentNo;
    private int _score;

    public Student() {
        this._studentNo = null;
        this._score = 0;
    }

    public String studentNo() {
        return _studentNo;
    }

    public void setStudentNo(String _studentNo) {
        this._studentNo = _studentNo;
    }

    public int score() {
        return _score;
    }

    public void setScore(int _score) {
        this._score = _score;
    }

    public char grade() // 현재 가지고 있는 점수에 해당하는 학점을 돌려준다
    {
        if (score() >= 90) {
            return 'A';
        } else if (score() >= 80) {
            return 'B';
        } else if (score() >= 70) {
            return 'C';
        } else if (score() >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

}