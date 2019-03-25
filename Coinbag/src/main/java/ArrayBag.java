public class ArrayBag<E> {

    private static final int DEFAULT_CAPACITY = 100;
    private int _capacity;
    private int _size;
    private E _elements[];


    private int capacity() { //capacity getter
        return _capacity;
    }

    private void setCapacity(int _capacity) { //capacity setter
        this._capacity = _capacity;
    }

    public int size() { //size getter
        return this._size;
    }

    private void setSize(int _size) {//size setter
        this._size = _size;
    }

    private E[] elements() {//elements getter
        return _elements;
    }

    private void setElements(E[] _elements) {//elements setter
        this._elements = _elements;
    }

    @SuppressWarnings("unchecked")

    public ArrayBag() { //ArrayBag constructor
        this.setCapacity(ArrayBag.DEFAULT_CAPACITY); //capacity를 지정
        this.setElements((E[]) new Object[this._capacity]); //element를 지정
        this.setSize(0); //size를 지정

    }

    @SuppressWarnings("unchecked")

    public ArrayBag(int capacity) { //Arraybag constructor
        this.setCapacity(capacity);
        this.setElements((E[]) new Object[this._capacity]);
        this.setSize(0);
    }



    public boolean isEmpty() {//비어 있는지를 확인
        return (this.size() == 0); //size 가 0인지를 확인
    }

    public boolean isFull() {//가득차 있느지를 확인
        return (this.size() == this.capacity());
    }

    private int indexOf(E anElement) { //값의 인데스를 확인
        int foundIndex = -1;
        for (int i = 0; i < this.size() && foundIndex < 0; i++) {
            if (this.elements()[i].equals(anElement)) {
                foundIndex = i;
            }
        }
        return foundIndex;
    }

    public boolean doesContain(E anElement) { //들어 있는지를 확인
        return (this.indexOf(anElement) >= 0);
    }

    public int frequencyOf(E anElement) { //빈도수를 확인
        int frequencyCount = 0;
        for (int i = 0; i < this.size(); i++) {
            if (this.elements()[i].equals(anElement)) {
                frequencyCount++;
            }
        }
        return frequencyCount;

    }

    public boolean add(E anElement) { //가득차면 false 를 리턴하고 가능하면 추가 한다.

        if (this.isFull()) {
            return false;
        } else {
            this.elements()[this.size()] = anElement;
            this.setSize(this.size() + 1);
            return true;
        }

    }

    public boolean remove(E anElement) { //제거한다.
        int foundIndex = -1;
        boolean found = false;

        for (int i = 0; i < this.size() && !found; i++) {
            if (this.elements()[i].equals(anElement)) {
                foundIndex = i;
                found = true;
            }
        }

        if (!found) {
            return false;
        } else {
            for (int i = foundIndex; i < this.size() - 1; i++) {
                this.elements()[i] = this.elements()[i + 1];
            }

            this.elements()[this.size() - 1] = null;
            this.setSize(this.size() - 1);
            return true;
        }

    }

    public void clear() { //전부 초기화 null로 초기화 하고 size를 0으로 맞춘다.
        for (int i = 0; i < this.size(); i++) {
            this.elements()[i] = null;
        }
        this.setSize(0);
    }

    E elementAt(int anOrder) { //인덱스 위치의 객체를 반환한다.
        if ((0 <= anOrder) && (anOrder < this.size())) {
            return this.elements()[anOrder];

        } else {
            return null;

        }
    }

}
