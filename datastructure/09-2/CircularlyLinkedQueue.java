public class CircularlyLinkedQueue<E> implements Queue<E> { //환영 큐

    private int _size;
    private int _capacity; //
    private LinkedNode<E> _rearNode;

    private void setSize(int _size) { //getter
        this._size = _size;
    }

    public LinkedNode<E> rearNode() {//getter
        return _rearNode;
    }

    public void setRearNode(LinkedNode<E> _rearNode) { //setter
        this._rearNode = _rearNode;
    }

    public CircularlyLinkedQueue(int queueCapacity) { //constructor
        this._size = 0;
        this._rearNode = null;
        this._capacity = queueCapacity;
    }

    public CircularlyLinkedQueue() { //constructor
        this._size = 0;
        this._rearNode = null;
        this._size = 100;
    }

    @Override
    public int size() { //getter
        return this._size;
    }

    @Override
    public boolean isFull() { //Full check 거의 false capacity 비교 시 처리를 할 것
        return false;
    }

    @Override
    public boolean isEmpty() { //empty check
        return (this._rearNode == null);
    }

    @Override
    public E front() {
        E frontElement = null;
        if (!this.isEmpty()) { //empty check
            frontElement = this._rearNode.next().element();
        }
        return frontElement;
    }

    @Override
    public E rear() {
        E rearElement = null;
        if (!this.isEmpty()) { //empty check
            rearElement = this._rearNode.element();
        }

        return rearElement;
    }

    @Override
    public boolean enQueue(E anElement) { //enqueue
        LinkedNode<E> newRearNode = new LinkedNode<>(anElement, null);
        if (this.isEmpty()) { //empty check
            newRearNode.setNext(newRearNode); //다음 노드를 정한다.
        } else {
            newRearNode.setNext(this._rearNode.next()); //다음 노드를 정한다.
            this._rearNode.setNext(newRearNode); //다음 노드를 정한다.
        }
        this._rearNode = newRearNode;
        this._size++; //사이즈를 늘린다.
        return true;

    }


    @Override
    public E deQueue() { //dequeue
        E frontElement = null;
        if (!this.isEmpty()) { //emptfy check
            frontElement = this._rearNode.next().element();  //front()//front element 확인
            if (this._rearNode == this._rearNode.next()) { // 노드가 한 개: self-loop의 경우
                this._rearNode = null;
            } else { // 노드가 2 개 이상
                this._rearNode.setNext(this._rearNode.next().next()); //다음 노드를 설정
            }
            this._size--; //사이즈를 줄인다.
        }
        return frontElement;
    }

    @Override
    public void clear() { //Circular queue 초기화
        this._rearNode = null;
        this._size = 0;
    }

    @Override
    public E elementAt(int anOrder) { //위치를 찾아낸다.
        LinkedNode<E> anOrderNode = this._rearNode.next();
        for (int i = 0; i < anOrder; i++) {
            anOrderNode = anOrderNode.next();
        }
        return anOrderNode.element();
    }

    @Override
    public Iterator<E> iterator() { //LinkedIterator
        return new CircularlyLinkedQueueIterator();
    }

    private class CircularlyLinkedQueueIterator implements Iterator<E> {
        private int count;
        private LinkedNode<E> _nextNode;

        private int count() {
            return count;
        }

        private void setCount(int count) {
            this.count = count;
        }

        private LinkedNode<E> nextNode() {
            return _nextNode;
        }

        private void setNextNode(LinkedNode<E> _nextNode) {
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
        public E next() {
            if (this.hasNext()) {
                this.setNextNode(this.nextNode().next());
                E nextElement = this.nextNode().element();
                this.setCount(this.count() - 1);
                return nextElement;
            } else {
                return null;
            }
        }
    }


}