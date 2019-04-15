public class UnSortedLinkedList<E extends Comparable<E>> {
    private int _size; // 리스트가 가지고 있는 원소의 개수
    private LinkedNode<E> _head; // LinkedChain 의 맨 앞 노드

    public int size() {
        return this._size;
    }

    public void setSize(int _size) {
        this._size = _size;
    }

    public LinkedNode<E> head() {
        return _head;
    }

    public void setHead(LinkedNode<E> newHead) {
        this._head = newHead;
    }

    private boolean anElementDoesExistAt(int anOrder) { //차수 유효성 확인
        return ((anOrder >= 0) && (anOrder < this._size));
    }

    public UnSortedLinkedList(int dataSize) {
        this._head = null;
        this._size = 0;
    }

    public boolean isEmpty() {
        return (this._head == null);
        // 또는, return (this._size == 0) ;
    }

    public boolean isFull() {
        return false; // 언제나 full 이 아니다
    }

    public boolean addTo(E anElement, int anOrder) {
        if ((anOrder < 0 || (anOrder > this._size))) { // anOrder 가 유효한지 검사
            return false;
        } else if (this.isFull()) {
            return false;
        } else {
            LinkedNode<E> nodeForAdd = new LinkedNode<>(anElement, null);
            if (anOrder == 0) {  // 맨 앞 순서에 삽입. 앞 (previous) 노드가 존재하지 않는다
                nodeForAdd.setNext(this._head);
                this._head = nodeForAdd;

            } else { // 순서가 맨 앞이 아니므로, 반드시 앞 (previous) 노드가 존재한다.
                LinkedNode<E> previous = this._head;
                for (int i = 1; i < anOrder; i++) {
                    previous = previous.next(); // 삽입할 위치의 앞 노드를 찾는다
                }
                nodeForAdd.setNext(previous.next());
                previous.setNext(nodeForAdd);
            }
            this._size++;
            return true;
        }
    }

    public boolean addToFirst(E anElement) { // Version 2
        if (this.isFull()) {
            return false;
        } else {
            LinkedNode<E> nodeForAdd = new LinkedNode<>(anElement, this._head);
            this._head = nodeForAdd;
            this._size++;
            return true;
        }
    }

    public boolean addToLast(E anElement) {
        if (this.isFull()) {
            return false;
        } else {
            LinkedNode<E> nodeForAdd = new LinkedNode<>(anElement, null);
            if (this.isEmpty()) {
                this._head = nodeForAdd;
            } else {
                LinkedNode<E> last = this._head;
                while (last.next() != null) {
                    last = last.next();
                }
                last.setNext(nodeForAdd);
            }
            this._size++;
            return true;
        }
    }

    public boolean add(E anElement) {
        return this.addToFirst(anElement);
    }


    public void clear() {
        this._head = null;
        this._size = 0;
    }

    public ListIterator<E> listIterator() {
        return new ListIterator();
    }

    public E max() {
        if (this.isEmpty()) {
            return null;
        } else {
            E maxElement = this.head().element();
            ListIterator<E> iterator = this.listIterator();

            while (iterator.hasNext()) {
                E temp = iterator.next();
                if (maxElement.compareTo(temp) < 0) {
                    maxElement = temp;
                }
            }
            return maxElement;
        }
    }

    private class ListIterator<E> implements Iterator<E> { //inner class iterator 구현
        private LinkedNode _nextNode;

        ListIterator() {
            this._nextNode = UnSortedLinkedList.this._head;

        }

        @Override
        public boolean hasNext() {

            return (this._nextNode != null);

        } //다음값의 확인

        @Override
        public E next() { //현재 값을 리턴하고 다음 값으로 포지션 옮김
            if (this._nextNode == null) {
                return null;
            } else {
                E nextElement = (E) this._nextNode.element();
                this._nextNode = this._nextNode.next();
                return nextElement;
            }

        }
    }

}
