package week13.program2;

public class Subject {
    private int _score;


    public int score() {
        return _score;
    }

    public void setScore(int _score) {
        this._score = _score;
    }

    public char grade() {
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

    public double point() {
        switch (grade()) {
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


}
