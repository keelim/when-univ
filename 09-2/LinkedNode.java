public class LinkedNode<E> {

    private E _element;
    private LinkedNode<E> _next;

    public E element() {
        return _element;
    }

    public void setElement(E _element) {
        this._element = _element;
    }

    public LinkedNode<E> next() {
        return _next;
    }

    public void setNext(LinkedNode<E> _next) {
        this._next = _next;
    }

    public LinkedNode(E givenElement, LinkedNode<E> givenNext) {
        this.setElement(givenElement);
        this.setNext(givenNext);

    }

    public LinkedNode() {
        this._element = null;
        this._next = null;
    }


}
