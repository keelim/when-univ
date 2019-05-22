public class ParameterSet {

    private int _startingSize;
    private int _numberOfSizeIncreasingSteps;
    private int _incrementSize;

    public int startingSize() {
        return _startingSize;
    }

    public void setStartingSize(int _startingSize) {
        this._startingSize = _startingSize;
    }

    public int numberOfSizeIncreasingSteps() {
        return _numberOfSizeIncreasingSteps;
    }

    public void setNumberOfSizeIncreasingSteps(int _numberOfSizeIncreasingSteps) {
        this._numberOfSizeIncreasingSteps = _numberOfSizeIncreasingSteps;
    }

    public int incrementSize() {
        return _incrementSize;
    }

    public void setIncrementSize(int _incrementSize) {
        this._incrementSize = _incrementSize;
    }

    public ParameterSet(int _startingSize, int _numberOfSizeIncreasingSteps, int _incrementSize) {
        this._startingSize = _startingSize;
        this._numberOfSizeIncreasingSteps = _numberOfSizeIncreasingSteps;
        this._incrementSize = _incrementSize;
    }

    public int maxDataSize() {
        return (this.startingSize() + (this.incrementSize() * (this.numberOfSizeIncreasingSteps() - 1)));
    }

}