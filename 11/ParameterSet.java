public class ParameterSet {
    private int _startingSize;
    private int _numberOfSizeIncreasingSteps;
    private int _incrementSize;

    public int startingSize() {
        return _startingSize;
    }//getter

    public void setStartingSize(int _startingSize) {
        this._startingSize = _startingSize;
    }//setter

    public int numberOfSizeIncreasingSteps() {
        return _numberOfSizeIncreasingSteps;
    }//getter

    public void setNumberOfSizeIncreasingSteps(int _numberOfSizeIncreasingSteps) {//setter
        this._numberOfSizeIncreasingSteps = _numberOfSizeIncreasingSteps;
    }

    public int incrementSize() {
        return _incrementSize;
    }//getter

    public void setIncrementSize(int _incrementSize) {
        this._incrementSize = _incrementSize;
    }//setter

    public ParameterSet(int _startingSize, int _numberOfSizeIncreasingSteps, int _incrementSize) {
        this._startingSize = _startingSize;
        this._numberOfSizeIncreasingSteps = _numberOfSizeIncreasingSteps;
        this._incrementSize = _incrementSize;
    } //constructor

    public int maxDataSize() { //maxData 를 계산을 하여 반환
        return this.startingSize() + (this.incrementSize() * (this.numberOfSizeIncreasingSteps() - 1));
    }

}