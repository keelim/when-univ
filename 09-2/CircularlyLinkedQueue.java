public class CircularlyLinkedQueue<E> implements Queue<E> {

    private static final int DEFAULT_CAPACITY = 100;
    private int _size;
    private int _capacity;

    private LinkedNode<E> _rearNode;

    public int capacity() {
        return _capacity;
    }

    public void setCapacity(int _capacity) {
        this._capacity = _capacity;
    }


    public void setSize(int _size) {
        this._size = _size;
    }

    public LinkedNode<E> rearNode() {
        return _rearNode;
    }

    public void setRearNode(LinkedNode<E> _rearNode) {
        this._rearNode = _rearNode;
    }



    public CircularlyLinkedQueue() {
        this.setSize(0);
        this.setCapacity(DEFAULT_CAPACITY);
        this.setRearNode(null);
    }

    public CircularlyLinkedQueue(int queueCapacity) {
        this.setSize(0);
        this.setCapacity(queueCapacity);
        this.setRearNode(null);
    }

    @Override
    public int size() {
        return this._size;
    }

    @Override
    public boolean isFull() { //메모리 무한정으로 가정 //capacity 값을 일단 생성
        return (this.size() == this.capacity()); //사이즈하고 허용수가 같으가?
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public E front() {
//        큐가 비어 있으면 null 을 돌려준다.
//        비어 있지 않으면, _rearNode 의 다음 node 가 front node 이다. 이 front node 의 element 를 돌려준다.
        E frontElement = null;
        if (!this.isEmpty()) {
            frontElement = this._rearNode.next().element();
        }
        return frontElement;

    }

    @Override
    public E rear() {
        E rearElement = null;
        if (!this.isEmpty()) {
            rearElement = this.rearNode().element();
        }
        return rearElement;
    }

    @Override
    public boolean enQueue(E anElement) {
//        가득 차 있을 경우: 이 경우, false 를 반환한다.
//        그러나, 연결체인으로 구현되어서, 가득 차 있는 경우는 실제로는 발생하지 않으므로,
//        이 코드가 실행되는 일, 즉 false 를 반환하는 일은 없을 것이다.
//        가득 차 있지 않을 경우
//        empty 라면? empty 가 아니라면?

        LinkedNode<E> newRearNode = new LinkedNode<>(anElement, null);
        if (this.isEmpty()) {
            newRearNode.setNext(newRearNode);
        } else {
            newRearNode.setNext(this.rearNode().next());
            this._rearNode.setNext(newRearNode);
        }
        this._rearNode = newRearNode;
        this._size++;
        return true;

    }

    @Override
    public E deQueue() {
//        비어 있으면: null 을 돌려준다.
//        만약 비어 있지 않으면: front element 를 삭제하여 돌려 준다.
        E frontElement = null;
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
    public void clear() { //null 과 0으로 초기화를 하면 된다.
        this.setRearNode(null);
        this.setSize(0);
    }

    @Override
    public E elementAt(int anOrder) {

        LinkedNode<E> frontNode = this._rearNode.next(); //0
        for (int i = 0; i < anOrder; i++) {
            frontNode.next();
        }
        return frontNode.element();

    }

    @Override
    public Iterator<E> iterator() {
        return new CircularlyLinkedQueueIterator();
    }

    private class CircularlyLinkedQueueIterator implements Iterator<E> {
        private LinkedNode<E> _nextNode;
        private int _count;

        private LinkedNode<E> nextNode() {
            return _nextNode;
        }

        private void setNextNode(LinkedNode<E> _nextNode) {
            this._nextNode = _nextNode;
        }

        private int count() {
            return _count;
        }

        private void setCount(int _count) {
            this._count = _count;
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

    //todo 1. 오류가 생긴다면 이 클래스만 처리하면 된다.
    //todo 2. 모델이 잘 못 되어 있나?
    //todo 3  CircularlyQueue의 특징은 무엇인가?
}
