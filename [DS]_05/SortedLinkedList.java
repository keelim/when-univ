public class SortedLinkedList<E extends Comparable<E>> {
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

    private boolean anElementDoesExistAt(int anOrder) {
        return ((anOrder >= 0) && (anOrder < this._size));
    }

    public SortedLinkedList(int dataSize) {
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


    public E elementAt(int anOrder) {
        if (this.anElementDoesExistAt(anOrder)) {
            LinkedNode<E> currentNode = this._head;
            int nodeCount = 0;
            while (nodeCount < anOrder) {
                currentNode = currentNode.next();
                nodeCount++;
            }
            return currentNode.element();
        } else {
            return null;
        }
    }


    public E first() {
        if (this.isEmpty()) {
            return null; // 마지막 원소가 존재할 수 없으므로
        } else {
            return elementAt(0);
            // 또는 이렇게: return this._head.element();
        }
    }


    public E last() {
        if (this.isEmpty()) {
            return null; // 마지막 원소가 존재할 수 없으므로
        } else {
            return elementAt(this._size - 1);
        }
    }


    public boolean doesContain(E anElement) { //
        LinkedNode<E> current = this._head;
        while (current != null) {
            if (current.element().equals(anElement)) {
                return true;
            }
            current = current.next();
        }
        return false;
    }


    public boolean add(E anElement) { // Sorted Linked List 에서 비교를 하여서 정해진 위치에 넣는 것
        if (this.isFull()) {
            return false;
        } else {
            LinkedNode<E> nodeForAdd = new LinkedNode<E>(anElement, null);
            if (this.isEmpty()) {
                this.setHead(nodeForAdd);
            } else { // 리스트에는 적어도 하나의 노드가 있다.
                LinkedNode<E> current = this.head(); // 현재 비교하는 노드
                LinkedNode<E> previous = null; // current 의 앞 노드. 삽입을 하려면, 앞 노드를 알아야 한다.
                while (current != null) { // 리스트의 끝에 도달할 때 까지 비교 검색한다.
                    if (current.element().compareTo(anElement) > 0) { // 현재의 원소가 삽입할 anElement 보다 크면
                        break; // 삽입할 위치를 찾은 것이므로 비교 검색 중지
                    }
                    previous = current; // 아닐 경우 previous를 current 로 변경
                    current = current.next(); // current 를 다음 노드로 이동
                }
                if (previous == null) { // anElement 가 가장 작다. 맨 앞에 삽입한다
                    nodeForAdd.setNext(this.head());
                    this.setHead(nodeForAdd);
                } else {
                    nodeForAdd.setNext(current); //
                    previous.setNext(nodeForAdd);
                }
            }
            this.setSize(this.size() + 1); // 크기를 하나 증가시킨다.
            return true;
        }

    }


    public boolean replaceAt(E anElement, int anOrder) {
        if (!this.anElementDoesExistAt(anOrder)) {
            // 대체할 노드가 없거나, 잘못된 위치
            return false;
        } else {
            LinkedNode<E> current = this._head;
            for (int i = 0; i < anOrder; i++) {
                current = current.next();
                // 원소를 대체할 노드를 찾는다
            }
            current.setElement(anElement);
            return true;
        }
    }

    public void clear() {
        this._head = null;
        this._size = 0;
    }

    public Iterator<E> listIterator() {
        return new ListIterator();
    }

    public E max() {
        return this.last();
    }

    private class ListIterator implements Iterator<E> { //inner class iterator 구현
        private LinkedNode _nextNode;


        ListIterator() {
            this._nextNode = SortedLinkedList.this._head;

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

