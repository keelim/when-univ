public class BinaryNode<E> { // Private instance variables
    private E _element;
    private BinaryNode<E> _left;
    private BinaryNode<E> _right;

    // Getter/Setter
    public E element() {
        return _element;
    }

    public void setElement(E _element) {
        this._element = _element;
    }

    public BinaryNode<E> left() {
        return _left;
    }

    public void setLeft(BinaryNode<E> _left) {
        this._left = _left;
    }

    public BinaryNode<E> right() {
        return _right;
    }

    public void setRight(BinaryNode<E> _right) {
        this._right = _right;
    }
    // Constructors public
    BinaryNode() {
        this.setElement(null);
        this.setLeft(null);
        this.setRight(null);
    }

    public BinaryNode(E givenElement, BinaryNode<E> givenLeft, BinaryNode<E> givenRight) {
        this.setElement(givenElement);
        this.setLeft(givenLeft);
        this.setRight(givenRight);
    }
}