public class CircularlyLinkedQueue<T> implements Queue<T> {

    private int _size;
    private int _capacity;
    private LinkedNode<T> _rearNode;

    private void setSize(int _size) {
        this._size = _size;
    }

    public LinkedNode<T> rearNode() {
        return _rearNode;
    }

    public void setRearNode(LinkedNode<T> _rearNode) {
        this._rearNode = _rearNode;
    }

    public CircularlyLinkedQueue(int queueCapacity) {
        this._size = 0;
        this._rearNode = null;
        this._capacity = queueCapacity;
    }

    public CircularlyLinkedQueue() {
        this._size = 0;
        this._rearNode = null;
        this._size = 100;
    }

    @Override
    public int size() {
        return this._size;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return (this._rearNode == null);
    }

    @Override
    public T front() {
        T frontElement = null;
        if (!this.isEmpty()) {
            frontElement = this._rearNode.next().element();
        }
        return frontElement;
    }

    @Override
    public T rear() {
        //todo

        return null;
    }

    @Override
    public boolean enQueue(T anElement) {
        LinkedNode<T> newRearNode = new LinkedNode<>(anElement, null);
        if (this.isEmpty()) {
            newRearNode.setNext(newRearNode);
        } else {
            newRearNode.setNext(this._rearNode.next());
            this._rearNode.setNext(newRearNode);
        }
        this._rearNode = newRearNode;
        this._size++;
        return true;

    }


    @Override
    public T deQueue() {
        T frontElement = null;
        if (!this.isEmpty()) {
            frontElement = this._rearNode.next().element();
            if (this._rearNode == this._rearNode.next()) { // 노드가 한 개: self-loop의 경우
                this._rearNode = null;
            } else { // 노드가 2 개 이상
                this._rearNode.setNext(this._rearNode.next().next());
            }
            this._size--;
        }
        return frontElement;

    }

    @Override
    public void clear() {
        this._rearNode = null;
        this._size = 0;
    }

    @Override
    public T elementAt(int anOrder) {
        LinkedNode<T> frontNode = this._rearNode.next();
        for (int i = 0; i < anOrder; i++) {
            frontNode = frontNode.next();
        }
        return frontNode.element();

    }

    @Override
    public Iterator<T> iterator() {
        return new CircularlyLinkedQueueIterator();
    }

    private class CircularlyLinkedQueueIterator implements Iterator<T> {
        private int count;
        private LinkedNode<T> _nextNode;

        private int count() {
            return count;
        }

        private void setCount(int count) {
            this.count = count;
        }

        private LinkedNode<T> nextNode() {
            return _nextNode;
        }

        private void setNextNode(LinkedNode<T> _nextNode) {
            this._nextNode = _nextNode;
        }

        private CircularlyLinkedQueueIterator() {
            this.setNextNode(CircularlyLinkedQueue.this.rearNode());
            this.setCount(CircularlyLinkedQueue.this.size());
        }

        @Override
        public boolean hasNext() {
            return (this.count() > 0);
        }

        @Override
        public T next() {
            if (this.hasNext()) {
                this.setNextNode(this.nextNode().next());
                T nextElement = this.nextNode().element();
                this.setCount(this.count() - 1);
                return nextElement;
            } else {
                return null;
            }
        }
    }


}