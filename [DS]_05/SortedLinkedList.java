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

    public int orderOf(E anElement) { // 순차 검색
        int order = 0;
        LinkedNode<E> currentNode = this._head;
        while (currentNode != null &&
                (!currentNode.element().equals(anElement))) {
            order++;
            currentNode = currentNode.next();
        }
        if (currentNode == null) { // Not Found
            return -1; // 존재하지 않으면 -1 을 돌려주기로 한다
        } else {
            return order;
        }
    }

    public boolean doesContain(E anElement) { // Version 3
        LinkedNode<E> current = this._head;
        while (current != null) {
            if (current.element().equals(anElement)) {
                return true;
            }
            current = current.next();
        }
        return false;
    }


    public boolean add(E anElement) {
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

    public E removeFrom(int anOrder) {
        if (!this.anElementDoesExistAt(anOrder)) { // 삭제할 원소가 없거나, 잘못된 위치
            return null;
        } else {
            // 리스트는 비어 있지 않으며, 삭제할 원소가 있음
            LinkedNode<E> removed = null;
            if (anOrder == 0) { // 삭제할 원소가 맨 앞 원소
                removed = this._head;
                this._head = this._head.next();
            } else { // 삭제할 원소의 위치는 맨 앞이 아니며, 따라서 원소가 두 개 이상
                LinkedNode<E> previous = this._head;
                for (int i = 1; i < anOrder; i++) {
                    previous = previous.next(); // 삭제할 위치의 앞 노드를 찾는다
                }
                removed = previous.next();
                previous.setNext(removed.next());
            }
            this._size--;
            return removed.element();
        }
    }

    public boolean remove(E anElement) { // Version 2
        // 단계 1: 주어진 원소의 위치를 찾는다
        LinkedNode<E> previous = null;
        LinkedNode<E> current = this._head;

        while ((current != null) && (!current.element().equals(anElement))) {
            previous = current;
            current = current.next();
        }
        // 단계 2: 주어진 원소가 존재하면 삭제한다.
        if (current == null) {
            return false; // Not Found
        } else {
            if (current == this._head) { // 삭제할 노드가 맨 앞 노드
                this._head = this._head.next();
            } else { // 삭제할 노드 앞에 노드 (previous) 가 존재
                previous.setNext(current.next());
            }
            this._size--;
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
                // 원소s를 대체할 노드를 찾는다
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

