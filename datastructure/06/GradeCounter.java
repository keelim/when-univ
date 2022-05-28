public class GradeCounter {
    private int _numberOfA;
    private int _numberOfB;
    private int _numberOfC;
    private int _numberOfD;
    private int _numberOfF;


    public int numberOfA() {
        return _numberOfA;
    }

    private void setNumberOfA(int newNumberOfA) {
        this._numberOfA = newNumberOfA;
    }

    public int numberOfB() {
        return _numberOfB;
    }

    private void setNumberOfB(int newNumberOfB) {
        this._numberOfB = newNumberOfB;
    }

    public int numberOfC() {
        return _numberOfC;
    }

    private void setNumberOfC(int newNumberOfC) {
        this._numberOfC = newNumberOfC;
    }

    public int numberOfD() {
        return _numberOfD;
    }

    private void setNumberOfD(int newNumberOfD) {
        this._numberOfD = newNumberOfD;
    }

    public int numberOfF() {
        return _numberOfF;
    }

    private void setNumberOfF(int newNumberOfF) {
        this._numberOfF = newNumberOfF;
    }

    public GradeCounter() { //grade counter setting
        this.setNumberOfA(0);
        this.setNumberOfB(0);
        this.setNumberOfC(0);
        this.setNumberOfD(0);
        this.setNumberOfF(0);
    }

    public void count(char aGrade) {
        switch (aGrade) {
            case 'A':
                this.setNumberOfA(this.numberOfA() + 1);
                break;
            case 'B':
                this.setNumberOfB(this.numberOfB() + 1);
                break;
            case 'C':
                this.setNumberOfC(this.numberOfC() + 1);
                break;
            case 'D':
                this.setNumberOfD(this.numberOfD() + 1);
                break;
            case 'F':
                this.setNumberOfF(this.numberOfF() + 1);
                break;
        }
    }
}
