package week13.program2;

public class Student {
    private String _studentNo;
    private Subject _korean;
    private Subject _english;
    private Subject _computer;

    public Student() {
        this._studentNo = null;
        this._korean = new Subject();
        _korean.setScore(0);
        this._english = new Subject();
        _english.setScore(0);
        this._computer = new Subject();
        _computer.setScore(0);
    }

    public String studentNo() {
        return _studentNo;
    }

    public void setStudentNo(String _studentNo) {
        this._studentNo = _studentNo;
    }

    public Subject korean() {
        return _korean;
    }

    public void setKorean(Subject _korean) {
        this._korean = _korean;
    }

    public Subject english() {
        return _english;
    }

    public void setEnglish(Subject _english) {
        this._english = _english;
    }

    public Subject computer() {
        return _computer;
    }

    public void setComputer(Subject _computer) {
        this._computer = _computer;
    }

    public double GPA() // 현재 가지고 있는 점수에 해당하는 학점을 돌려준다
    {
        double korean = korean().point();
        double english = english().point();
        double computer = computer().point();
        return (korean + english + computer) / 3;
    }

}