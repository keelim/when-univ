package week10;

public class Student {
    private int _scoreKorean;
    private int _scoreEnglish;
    private int _scoreComputer;

    private char score2Grade(int aScore) // 현재 가지고 있는 점수에 해당하는 학점을 돌려준다
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

    public double grade2Point(char grade) {
        switch (grade) {
            case 'A':
                return 4.0;
            case 'B':
                return 3.0;
            case 'C':
                return 2.0;
            case 'D':
                return 1.0;
            default:
                return 0.0; // case 'F'
        }
    }


    public Student() {
        this._scoreKorean = 0;
        this._scoreEnglish = 0;
        this._scoreComputer = 0;
    }

    public int scoreKorean() {
        return _scoreKorean;
    }

    public void setScoreKorean(int _scoreKorean) {
        this._scoreKorean = _scoreKorean;
    }

    public char gradeKorean() {
        return this.score2Grade(this._scoreKorean);
    }

    public int scoreEnglish() {
        return _scoreEnglish;
    }

    public void setScoreEnglish(int _scoreEnglish) {
        this._scoreEnglish = _scoreEnglish;
    }

    public char gradeEnglish() {
        return this.score2Grade(this._scoreEnglish);
    }

    public int scoreComputer() {
        return _scoreComputer;
    }

    public void setScoreComputer(int _scoreComputer) {
        this._scoreComputer = _scoreComputer;
    }

    public char gradeComputer() {
        return this.score2Grade(this._scoreComputer);
    }

    public double gpa() {
        double gradePointKorean = grade2Point(score2Grade(scoreKorean()));
        double gradePointEnglish = grade2Point(score2Grade(scoreEnglish()));
        double gradePointComputer = grade2Point(score2Grade(scoreComputer()));
        return (gradePointKorean + gradePointEnglish + gradePointComputer) / (double) 3;
    }


}
