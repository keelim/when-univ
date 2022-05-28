public class LinkedNode<E> {  //Stack 을 위한 노드
    private E _element;
    private LinkedNode<E> _next;

    public LinkedNode() { //constructor
        this._element = null;
        this._next = null;
    }

    public LinkedNode(E givenElement) { //constructor
        this._element = givenElement;
        this._next = null;
    }

    public LinkedNode(E givenElement, LinkedNode<E> givenNext) { //constructor
        this._element = givenElement;
        this._next = givenNext;
    }

    public E element() { //getter
        return _element;
    }

    public void setElement(E newElement) {
        this._element = newElement;
    } //setter

    public LinkedNode<E> next() {
        return _next;
    } // getter

    public void setNext(LinkedNode<E> newNext) {
        this._next = newNext;
    } //getter



}