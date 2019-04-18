public class Student implements Comparable<Student> {
    private static final int DEFAULT_SCORE = 0;
    private int _score;

    public int score() {
        return _score;
    }

    public void setScore(int newScore) {
        this._score = newScore;
    }

    public Student(int givenScore) {
        this._score = givenScore;
    }

    public Student() {
        this.setScore(DEFAULT_SCORE);
    }

    @Override
    public int compareTo(Student other) {
        if (this.score() < other.score()) {
            return -1;
        } else if (this.score() == other.score()) {
            return 0;
        } else {
            return +1;
        }
    }
}
