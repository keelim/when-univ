import java.util.Random;

public class Experiment { //������ ������ ���� �޼ҵ�
    private static final int DEFAULT_NUMBER_OF_ITERATION = 5;
    private static final int DEFAULT_FIRST_SIZE = 10000;
    private static final int DEFAULT_SIZE_INCREMENT = 10000;


    private int _numberOfIteration;
    private int _firstSize;
    private int _sizeIncrement;
    private Coin[] _data;
    private MeasuredResult[] _measuredResults;


    public int numberOfIteration() {
        return _numberOfIteration;
    }

    public void setNumberOfIteration(int _numberOfIteration) {
        this._numberOfIteration = _numberOfIteration;
    }

    public int firstSize() {
        return _firstSize;
    }

    public void setFirstSize(int _firstSize) {
        this._firstSize = _firstSize;
    }

    public int sizeIncrement() {
        return _sizeIncrement;
    }

    public void setSizeIncrement(int _sizeIncrement) {
        this._sizeIncrement = _sizeIncrement;
    }

    public Coin[] data() {
        return _data;
    }

    public void setData(Coin[] _data) {
        this._data = _data;
    }

    public MeasuredResult[] measuredResults() {
        return _measuredResults;
    }

    public void setMeasuredReuslts(MeasuredResult[] _measuredReuslts) {
        this._measuredResults = _measuredReuslts;
    }

    public int maxSize() { //�ִ� ����� ����Ѵ�.
        return this.firstSize() + this.sizeIncrement() * (this.numberOfIteration() - 1);
    }

    public Experiment(int givenNuberOfIteration, int ivenFristSize, int givebSizeIncrement) { //parameter constructor
        this._numberOfIteration = givenNuberOfIteration;
        this._firstSize = ivenFristSize;
        this._sizeIncrement = givebSizeIncrement;

        this.setData(new Coin[this.maxSize()]);
        this.setMeasuredReuslts(new MeasuredResult[this.numberOfIteration()]);
    }

    public Experiment() {
        this(DEFAULT_NUMBER_OF_ITERATION, DEFAULT_FIRST_SIZE, DEFAULT_SIZE_INCREMENT);
    }

    public void generateData() { //�����͸� ������ �Ѵ�.
        Random random = new Random();
        for (int i = 0; i < this.maxSize(); i++) { //maxSize = first Size() + this.sizeIncrement() * (this.numberOfIteration() - 1)
            int randomCoinValue = random.nextInt(this.maxSize()); //�������� ���� �ο��Ѵ�.
            this.data()[i] = new Coin(randomCoinValue); //�����͸� �߰��Ѵ�.

        }
    }

    public void measureForSortedArrayList() { //�� �ڷᱸ�� �� �ɸ� �ð��� ������ �ϴ� �޼ҵ�
        Coin maxCoin;

        long durationForAdd, durationForMax;
        long start, stop;

        int dataSize = this.firstSize();

        for (int iteration = 0; iteration < this.numberOfIteration(); iteration++) {
            SortedArrayList<Coin> list = new SortedArrayList<>(dataSize);
            durationForAdd = 0;
            durationForMax = 0;

            for (int i = 0; i < dataSize; i++) {
                start = System.nanoTime(); //���� �ð��� ����
                list.add(this.data()[i]);
                stop = System.nanoTime();
                durationForAdd += (stop - start);

                start = System.nanoTime();
                maxCoin = list.max();
                stop = System.nanoTime(); //���� �ð��� ����
                durationForMax += (stop - start); //���� ��ŭ�� �ɸ� �ð�����
            }
            this.measuredResults()[iteration] = new MeasuredResult(dataSize, durationForAdd, durationForMax);
            dataSize += this.sizeIncrement();
        }
    }


    public void measureForUnSortedArrayList() { // unsortedArrayList
        Coin maxCoin;

        long durationForAdd, durationForMax;
        long start, stop;

        int dataSize = this.firstSize();

        for (int iteration = 0; iteration < this.numberOfIteration(); iteration++) {
            UnSortedArrayList<Coin> list = new UnSortedArrayList<>(dataSize);

            durationForAdd = 0;
            durationForMax = 0;

            for (int i = 0; i < dataSize; i++) {
                start = System.nanoTime();
                list.add(this.data()[i]);
                stop = System.nanoTime();
                durationForAdd += (stop - start);

                start = System.nanoTime();
                maxCoin = list.max();
                stop = System.nanoTime();
                durationForMax += (stop - start);

            }
            this.measuredResults()[iteration] = new MeasuredResult(dataSize, durationForAdd, durationForMax);

            dataSize += this.sizeIncrement();

        }
    }

    public void measureForUnSortedLinkedList() { //UnsortedLinkedList ����
        Coin maxCoin;

        long durationForAdd, durationForMax;
        long start, stop;

        int dataSize = this.firstSize();

        for (int iteration = 0; iteration < this.numberOfIteration(); iteration++) {
            UnSortedLinkedList<Coin> list = new UnSortedLinkedList<>(dataSize);

            durationForAdd = 0;
            durationForMax = 0;

            for (int i = 0; i < dataSize; i++) {
                start = System.nanoTime();
                list.add(this.data()[i]);
                stop = System.nanoTime();
                durationForAdd += (stop - start);

                start = System.nanoTime();
                maxCoin = list.max();
                stop = System.nanoTime();
                durationForMax += (stop - start);

            }
            this.measuredResults()[iteration] = new MeasuredResult(dataSize, durationForAdd, durationForMax);

            dataSize += this.sizeIncrement();
        }
    }

    public void measureForSortedLinkedList() {  //SortedLinkedList ����
        Coin maxCoin;

        long durationForAdd, durationForMax;
        long start, stop;

        int dataSize = this.firstSize();

        for (int iteration = 0; iteration < this.numberOfIteration(); iteration++) {
            SortedLinkedList<Coin> list = new SortedLinkedList<>(dataSize);

            durationForAdd = 0;
            durationForMax = 0;

            for (int i = 0; i < dataSize; i++) {
                start = System.nanoTime();
                list.add(this.data()[i]);
                stop = System.nanoTime();
                durationForAdd += (stop - start);

                start = System.nanoTime();
                maxCoin = list.max();
                stop = System.nanoTime();
                durationForMax += (stop - start);

            }
            this.measuredResults()[iteration] = new MeasuredResult(dataSize, durationForAdd, durationForMax);

            dataSize += this.sizeIncrement();
        }

    }
}
