public class MeasuredResult {
    private int _size;
    private long _durationForAdd;
    private long _durationForMax;

    public int size() {
        return _size;
    }

    public void setSize(int newSize) {
        this._size = newSize;
    }

    public long durationForAdd() {
        return _durationForAdd;
    }

    public void setDurationForAdd(long newDurationForAdd) {
        this._durationForAdd = newDurationForAdd;
    }

    public long durationForMax() {
        return _durationForMax;
    }

    public void setDurationForMax(long _durationForMax) {
        this._durationForMax = _durationForMax;
    }

    public MeasuredResult(int givenSize, long givenDurationForAdd, long givenDurationForMax) {
        this._size = givenSize;
        this._durationForAdd = givenDurationForAdd;
        this._durationForMax = givenDurationForMax;
    }

    public MeasuredResult() {
        this(0, 0, 0);
    }
}
