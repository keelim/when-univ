public class Student implements Comparable<Student> {
    private static final int DEFAULT_SCORE = 0;
    private int _score;

    public int score() { //getter
        return _score;
    }

    public void setScore(int newScore) {
        this._score = newScore;
    } //setter

    public Student(int givenScore) {
        this._score = givenScore;
    } //constructor

    public Student() {
        this.setScore(DEFAULT_SCORE);
    } //constructor

    @Override
    public int compareTo(Student other) { //comparable 을 구현한 함수
        if (this.score() < other.score()) {
            return -1;
        } else if (this.score() == other.score()) { //같을 경우 0
            return 0;
        } else {
            return +1;
        }
    }
}
