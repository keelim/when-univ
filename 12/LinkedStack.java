public class LinkedStack<E> implements Stack<E> {
    private int _size;
    private LinkedNode<E> _top;

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
        return this._size == 0;
    }

    @Override
    public boolean push(E anElement) {
        if (this.isFull()) {
            return false;
        } else {
            LinkedNode<E> nodeForAdd = new LinkedNode<>(anElement, null);
            if (this.isEmpty()) {
                this._top = nodeForAdd;
            } else {
                LinkedNode<E> last = this._top;
                while (last.next() != null) {
                    last = last.next();
                }
                last.setNext(nodeForAdd);
            }
            this._size++;
            return true;
        }
    }

    @Override
    public E pop() {
        E poppedElement;
        LinkedNode<E> poppedNode = this._top;
        poppedElement = poppedNode.element();
        this._top = poppedNode.next();
        this._size--;
        return poppedElement;
    }

    @Override
    public E peek() {
        return this._top.element();
    }

    @Override
    public void clear() {
        this._size = 0;
        this._top = null;
    }
}
