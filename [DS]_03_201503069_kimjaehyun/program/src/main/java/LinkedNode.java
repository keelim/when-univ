public class LinkedNode<E> {
    private E _element; //¿¤¸®¸ÕÆ®
    private LinkedNode<E> _next; //next Node

    public LinkedNode() { //Linked node constructor
        this._element = null;
        this._next = null;
    }

    public LinkedNode(E givenElement) { // LinkedNode constructor
        this._element = givenElement;
        this._next = null;
    }

    public LinkedNode(E givenElement, LinkedNode<E> givenNext) { //Linkednode constructor
        this._element = givenElement;
        this._next = givenNext;
    }

    public E element() { //element getter
        return _element;
    }

    public void setElement(E newElement) { //element setter
        this._element = newElement;
    }

    public LinkedNode<E> next() { // next node getter
        return _next;
    }

    public void setNext(LinkedNode<E> newNext) { //nextNode setter
        this._next = newNext;
    }

}
