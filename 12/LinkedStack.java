public class LinkedStack<E> implements Stack {
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
    public Object pop() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }

    @Override
    public void clear() {

    }
}
