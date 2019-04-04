public class ArrayList<E> {
    private static final int DEFAULT_CAPACITY = 100;

    private int _size;
    private int _capacity;
    private E[] _elements;

    public int size() {
        return _size;
    }

    public void setSize(int newSize) {
        this._size = newSize;
    }

    public int Capacity() {
        return _capacity;
    }

    public void setCapacity(int newCapacity) {
        this._capacity = newCapacity;
    }

    public E[] elements() {
        return _elements;
    }

    public void setElements(E[] newElements) {
        this._elements = newElements;
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int givenCapacity) {
        this.setCapacity(givenCapacity);
        this.setElements((E[]) new Object[this.Capacity()]);
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY); //자기 자신을 호출
    }
}
