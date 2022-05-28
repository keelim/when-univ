public class SortedLinkedList<E extends Comparable<E>> {
    private int _size; // ����Ʈ�� ������ �ִ� ������ ����
    private LinkedNode<E> _head; // LinkedChain �� �� �� ���


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
        // �Ǵ�, return (this._size == 0) ;
    }

    public boolean isFull() {
        return false; // ������ full �� �ƴϴ�
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
            return null; // ������ ���Ұ� ������ �� �����Ƿ�
        } else {
            return elementAt(0);
            // �Ǵ� �̷���: return this._head.element();
        }
    }


    public E last() {
        if (this.isEmpty()) {
            return null; // ������ ���Ұ� ������ �� �����Ƿ�
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


    public boolean add(E anElement) { // Sorted Linked List ���� �񱳸� �Ͽ��� ������ ��ġ�� �ִ� ��
        if (this.isFull()) {
            return false;
        } else {
            LinkedNode<E> nodeForAdd = new LinkedNode<E>(anElement, null);
            if (this.isEmpty()) {
                this.setHead(nodeForAdd);
            } else { // ����Ʈ���� ��� �ϳ��� ��尡 �ִ�.
                LinkedNode<E> current = this.head(); // ���� ���ϴ� ���
                LinkedNode<E> previous = null; // current �� �� ���. ������ �Ϸ���, �� ��带 �˾ƾ� �Ѵ�.
                while (current != null) { // ����Ʈ�� ���� ������ �� ���� �� �˻��Ѵ�.
                    if (current.element().compareTo(anElement) > 0) { // ������ ���Ұ� ������ anElement ���� ũ��
                        break; // ������ ��ġ�� ã�� ���̹Ƿ� �� �˻� ����
                    }
                    previous = current; // �ƴ� ��� previous�� current �� ����
                    current = current.next(); // current �� ���� ���� �̵�
                }
                if (previous == null) { // anElement �� ���� �۴�. �� �տ� �����Ѵ�
                    nodeForAdd.setNext(this.head());
                    this.setHead(nodeForAdd);
                } else {
                    nodeForAdd.setNext(current); //
                    previous.setNext(nodeForAdd);
                }
            }
            this.setSize(this.size() + 1); // ũ�⸦ �ϳ� ������Ų��.
            return true;
        }

    }

    public E max() {
        return this.last();
    }


}

