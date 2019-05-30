public class LinkedStack<E extends Comparable<E>> implements Stack<E> {
    private int _size;
    private LinkedNode<E> _node;

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
        if(this.isFull()){
            return false;
        } else {
            LinkedNode<E> nodeForAdd = new LinkedNode<>(anElement, null);
            if(this.isEmpty()){
                this._node = nodeForAdd;
            } else {
                LinkedNode<E> last = this._node;
                while(last.next() != null){
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
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public void clear() {

    }
}
