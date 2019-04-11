
public class UnSortedArrayList<E extends Comparable<E>> {
    private static final int DEFAULT_CAPACITY = 1000;

    private int _size;
    private int _capacity;
    private E[] _elements;

    public int size() {
        return _size;
    } //size getter

    public void setSize(int newSize) {
        this._size = newSize;
    } //size setter

    public int capacity() {
        return _capacity;
    } //capacity getter

    public void setCapacity(int newCapacity) {
        this._capacity = newCapacity;
    } //capacity setter

    public E[] elements() {
        return _elements;
    } //elements getter

    public void setElements(E[] newElements) {
        this._elements = newElements;
    } //elements setter

    @SuppressWarnings("unchecked")
    public UnSortedArrayList(int givenCapacity) { //parameter constructor
        this.setCapacity(givenCapacity);
        this.setElements((E[]) new Comparable[this.capacity()]);
    }

    public UnSortedArrayList() {
        this(DEFAULT_CAPACITY); //자기 자신을 호출

    }  //constructor

    public boolean isEmpty() {
        return (this.size() == 0);
    }

    public boolean isFull() {
        return (this.size() == this.capacity());
    }


    private boolean anElementDoesExistAt(int anOrder) {
        return ((anOrder >= 0) && (anOrder < this.size()));

    }

    public E elementAt(int anOrder) {
        int position = anOrder;

        if (this.anElementDoesExistAt(anOrder)) {
            return this._elements[position];

        } else {
            return null;

        }
    }

    public E last() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this._elements[this.size() - 1];
        }
    }

    public E first() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this._elements[0];
        }

    }

    public boolean addTo(E anElement, int anOrder) {
        if (this.isFull()) {
            return false;

        } else if (anOrder < 0 || anOrder > this.size()) {
            return false;

        } else {
            this.makeRoomAt(anOrder);
            this.elements()[anOrder] = anElement;
            this._size++;
            return true;
        }
    }

    private void makeRoomAt(int aPosition) {
        for (int i = this.size(); i > aPosition; i--) {
            this.elements()[i] = this.elements()[i - 1]; //필요한 부분을 땡긴다.
        }
    }

    public boolean addToFirst(E anElement) {
        if (this.isFull()) {
            return false;
        } else {
            this.makeRoomAt(0);
            this._elements[0] = anElement;
            this._size++;
            return true;
        }
    }

    public boolean addToLast(E anElement) {
        return this.addTo(anElement, this.size());
    }

    public boolean add(E anElement) {
        return this.addToLast(anElement);
    }


    public E max() {
        if (this.isEmpty()) {
            return null;
        } else {
            E maxElement = this.elements()[0];
            for (int i = 1; i < this.size(); i++) {
                if (maxElement.compareTo(this.elements()[i]) < 0) {
                    maxElement = this.elements()[i];
                }
            }
            return maxElement;
        }
    }


}
