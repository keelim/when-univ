public class Student {
    private static final int DEFAULT_SCORE = 0;

    private int _score;

    public int score() {
        return this._score;
    } //score getter

    public void setScore(int _score) {
        this._score = _score;
    } //score setter

    public Student() {
        this.setScore(DEFAULT_SCORE);
    } // constructor

    public Student(int givenScore) {
        this.setScore(givenScore);
    } // parameter constructor

    @Override
    public boolean equals(Object aStudent) { //equlas ¿Á¡§¿«
        if (aStudent.getClass() != Student.class) {
            return false;

        } else {
            return (this.score() == ((Student) aStudent).score());

        }
    }
}
