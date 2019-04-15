public class LinkedBag<E> {
    private int _size;
    private LinkedNode<E> _head;


    public LinkedBag() { //LinkedBag constructor
        this._size = 0;
        this._head = null;

    }


    public int size() { //size getter
        return this._size;
    }

    private void setSize(int _size) {
        this._size = _size;
    }

    private LinkedNode<E> head() {
        return _head;
    }

    private void setHead(LinkedNode<E> _head) {
        this._head = _head;
    }

    public boolean isEmpty() {//비어 있는지를 확인
        return (this.size() == 0); //size 가 0인지를 확인
    }

    public boolean isFull() {
        return false;
    }


    public boolean doesContain(E anElement) { //들어 있는지를 확인
        LinkedNode<E> currentNode = this.head();
        while (currentNode != null) {
            if (currentNode.element().equals(anElement)) {
                return true;
            }

            currentNode = currentNode.next();
        }
        return false;
    }


    public int frequencyOf(E anElement) { //빈도수를 확인
        int frequencyCount = 0;
        LinkedNode<E> currentNode = this.head();
        while (currentNode != null) {
            if (currentNode.element().equals(anElement)) {
                frequencyCount++;
            }
            currentNode = currentNode.next();
        }
        return frequencyCount;

    }

    public boolean add(E anElement) { //가득차면 false 를 리턴하고 가능하면 추가 한다.

        if (this.isFull()) {
            return false;
        } else {
            LinkedNode<E> newNode = new LinkedNode<>();
            newNode.setElement(anElement);
            newNode.setNext(this.head());
            this.setHead(newNode);
            this._size++;
            return true;
        }

    }

    public boolean remove(E anElement) { //제거한다.
        if (this.isEmpty()) {
            return false;
        } else {
            LinkedNode<E> previousNode = null;
            LinkedNode<E> currentNode = this.head();
            boolean found = false;

            while (currentNode != null && !found) {
                if (currentNode.element().equals(anElement)) {
                    found = true;
                } else {
                    previousNode = currentNode;
                    currentNode = currentNode.next();
                }
            }


            if (!found) {
                return false;
            } else {
                if (currentNode == this.head()) {
                    this._head = this.head().next(); //boundary condition
                } else {
                    previousNode.setNext(currentNode.next());
                    this._size--;

                }
                return true;
            }
        }
    }

    public E removeAny() {
        if (this.isEmpty()) {
            return null;
        } else {
            E removedElement = this.head().element();
            this._head = this.head().next();
            this._size--;
            return removedElement;
        }
    }

    public void clear() { //전부 초기화 null로 초기L화 하고 size를 0으로 맞춘다.
        this._size = 0;
        this.setHead(null);
    }

    E elementAt(int anOrder) { //인덱스 위치의 객체를 반환한다.
        if ((anOrder < 0) || (anOrder >= this.size())) {
            return null;
        } else {
            LinkedNode<E> currentNode = this.head();
            for (int i = 0; i < anOrder; i++) {
                currentNode = currentNode.next();
            }
            return currentNode.element();
        }
    }

    public E any() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.head().element();
        }

    }

}
