public class BinaryNode<E> { //트리를 위한 노드 임을 확인 가능
    private E _element;
    private BinaryNode<E> _left;
    private BinaryNode<E> _right;

    // Getter/Setter
    public E element() {
        return _element;
    } //getter

    public void setElement(E _element) {
        this._element = _element;
    } //setter

    public BinaryNode<E> left() {
        return _left;
    } //getter

    public void setLeft(BinaryNode<E> _left) {
        this._left = _left;
    } //setter

    public BinaryNode<E> right() {
        return _right;
    } //getter

    public void setRight(BinaryNode<E> _right) {
        this._right = _right;
    } //setter


    public BinaryNode() { //constructor
        this.setElement(null);
        this.setLeft(null);
        this.setRight(null);
    }

    public BinaryNode(E givenElement, BinaryNode<E> givenLeft, BinaryNode<E> givenRight) { //constructor
        this.setElement(givenElement);
        this.setLeft(givenLeft);
        this.setRight(givenRight);
    }
}