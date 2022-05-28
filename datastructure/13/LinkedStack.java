public class LinkedStack<E> implements Stack<E> {
    private int _size;
    private LinkedNode<E> _top;

    @Override
    public int size() { //setter
        return this._size;
    }

    @Override
    public boolean isFull() { //Full check  노드적 구현으로 항상  false
        return false;
    }

    @Override
    public boolean isEmpty() { //empty check
        return this._size == 0;
    }

    @Override
    public void push(E anElement) {
        if (this.isFull()) { //full check
        } else {
            LinkedNode<E> nodeForAdd = new LinkedNode<>(anElement, null); //임시 노드 생성
            if (this.isEmpty()) { //empty check
                this._top = nodeForAdd;
            } else {
                LinkedNode<E> last = this._top;
                while (last.next() != null) {
                    last = last.next();
                }
                last.setNext(nodeForAdd);
            }
            this._size++;
        }
    }

    @Override
    public E pop() {//항상 full x
        E poppedElement;
        LinkedNode<E> poppedNode = this._top; //top node 참조
        poppedElement = poppedNode.element(); //top 엘라먼트 참조
        this._top = poppedNode.next(); //다음으로 넘김
        this._size--;
        return poppedElement;
    }

    @Override
    public E peek() { //top 엘리먼트 반환
        return this._top.element();
    }

    @Override
    public void clear() { //clear
        this._size = 0;
        this._top = null;
    }
}
