public class CircularArrayQueue<E> implements Queue<E> {

    // Constants
    private static final int DEFAULT_CAPACITY = 100;
    // Instance Variables
    private int _maxLength; // capacity+1

    private int _frontPosition;

    private int _rearPosition;
    private E[] _elements;

    public int maxLength() {
        return _maxLength;
    }

    public void setMaxLength(int _maxLength) {
        this._maxLength = _maxLength;
    }

    public int frontPosition() {
        return _frontPosition;
    }

    public void setFrontPosition(int _frontPosition) {
        this._frontPosition = _frontPosition;
    }

    public int rearPosition() {
        return _rearPosition;
    }

    public void setRearPosition(int _rearPosition) {
        this._rearPosition = _rearPosition;
    }

    public E[] elements() {
        return _elements;
    }

    public void setElements(E[] _elements) {
        this._elements = _elements;
    }

    public int capacity() {
        return (this.maxLength() - 1); //환형 큐의 특징
    }

    @SuppressWarnings("unchecked")
    public CircularArrayQueue(int givenCapacity) {
        this.setMaxLength(givenCapacity + 1);
        this.setElements((E[]) new Object[this.maxLength()]);
    }

    public CircularArrayQueue() {
        this(CircularArrayQueue.DEFAULT_CAPACITY);
    }

    @Override
    public int size() { //환형 큐에서의 size method
        if (this.rearPosition() >= this.frontPosition()) {
            return (this.rearPosition() - this.frontPosition());
        } else {
            return (this.rearPosition() + this.maxLength() - this.frontPosition());
        }
    }

    @Override
    public boolean isFull() {
//        다음 삽입될 위치가 this.frontPosition() 과 같으면 true 를, 아니면 false 를 반환.
        int nextRearPosition = (this._rearPosition + 1) % this._maxLength;
        return (nextRearPosition == this._frontPosition);
    }

    @Override
    public boolean isEmpty() {//front rear position이 같을 때
        return (this._frontPosition == this._rearPosition);

    }

    @Override
    public E front() {
//        비어 있는 경우 null 을 반환
//        비어 있지 않은 경우 큐의 맨 앞에 있는 원소를 반환
        E frontElement = null;
        if (!this.isEmpty()) {
            frontElement = this._elements[this._frontPosition + 1];
        }
        return frontElement;

    }

    @Override
    public E rear() {
//        비어 있는 경우 null 을 반환
//        비어 있지 않은 경우 큐의 맨 뒤에 있는 원소를 반환
        E rearElement = null;
        if (!this.isEmpty()) {
            rearElement = this._elements[this._rearPosition];
        }
        return rearElement;

    }

    @Override
    public boolean enQueue(E anElement) {
        if (this.isFull()) {
            return false;
        } else {
            this.setRearPosition((this._rearPosition + 1) % this._maxLength);
            this.elements()[this.rearPosition()] = anElement;
            return true;
        }
    }

    @Override
    public E deQueue() {
        E frontElement = null;
        if (!this.isEmpty()) {
            this._frontPosition = (this._frontPosition + 1) % this._maxLength;
            frontElement = this._elements[this._frontPosition];
            this._elements[this._frontPosition] = null;
        }
        return frontElement;

    }

    @Override
    public void clear() {
        this._frontPosition = 0;
        this._rearPosition = 0;
        for (int i = 0; i < this.maxLength(); i++) {
            this._elements[i] = null;
        }

    }

    @Override
    public E elementAt(int anOrder) {
        return this.elements()[((this.frontPosition() + 1 + anOrder) % this.maxLength())];
    }

    @Override
    public Iterator<E> iterator() {
        return new CircularArrayQueueIterator();
    }

    private class CircularArrayQueueIterator implements Iterator<E> {

        private int _nextOrder;

        public void setNextOrder(int _nextOrder) {
            this._nextOrder = _nextOrder;
        }

        public int nextOrder() {
            return _nextOrder;
        }

        public CircularArrayQueueIterator() {
            this.setNextOrder(0);
        }

        @Override
        public boolean hasNext() {
            return (this.nextOrder() < CircularArrayQueue.this.size());
        }

        @Override
        public E next() {
            E nextElement = null;
            if (this.hasNext()) {
                nextElement = CircularArrayQueue.this.elements()[this.nextOrder()];
                this.setNextOrder(this.nextOrder() + 1);
            }
            return nextElement;
        }
    }
}
