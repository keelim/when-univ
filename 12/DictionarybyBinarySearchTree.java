public class DictionaryByBinarySearchTree<Key extends Comparable<Key>, Obj> extends Dictionary<Key, Obj> {

    private BinaryNode<DictionaryElement<Key, Obj>> _root;

    protected BinaryNode<DictionaryElement<Key, Obj>> root() {
        return _root;
    } //getter

    public void setRoot(BinaryNode<DictionaryElement<Key, Obj>> _root) {
        this._root = _root;
    } //setter

    public DictionaryByBinarySearchTree() {
        this.clear();
    } //constructor 트리를 비운다.

    private DictionaryElement<Key, Obj> elementForKey(Key aKey) {
        if (aKey != null) { //null check
            BinaryNode<DictionaryElement<Key, Obj>> current = this.root(); //root를 참조
            while (current != null) { //null 일 때 까지 반복
                if (current.element().key().compareTo(aKey) == 0) { //같은면 반환
                    return current.element();
                } else if (current.element().key().compareTo(aKey) > 0) { //크면 왼쪽
                    current = current.left();
                } else { //작으면 오른쪽
                    current = current.right();
                }
            }
        }
        return null;
    }

    @Override
    public boolean isFull() {
        return false;
    } //full check

    @Override
    public boolean keyDoesExist(Key aKey) {
        return (this.elementForKey(aKey) != null);
    } //key 존재 확인

    @Override
    public Obj objectForKey(Key aKey) { //key 해당 object 반환
        DictionaryElement<Key, Obj> element = this.elementForKey(aKey);
        if (element != null) {
            return element.object();
        } else {
            return null;
        }
    }

    @Override
    public boolean addKeyAndObject(Key aKey, Obj anObject) {
        if (aKey == null) { //null check
            return false;
        }
        DictionaryElement<Key, Obj> elementForAdd = new DictionaryElement<>(aKey, anObject);
        BinaryNode<DictionaryElement<Key, Obj>> nodeForAdd = new BinaryNode<>(elementForAdd, null, null);
        if (this.root() == null) { //null 일 경우 root 로 add
            this.setRoot(nodeForAdd);
            this.setSize(1);
            return true;
        }
        BinaryNode<DictionaryElement<Key, Obj>> current = this.root();
        while (aKey.compareTo(current.element().key()) != 0) { //작거나 클 경우
            if (aKey.compareTo(current.element().key()) < 0) { //작을 경우
                if (current.left() == null) { //null check
                    current.setLeft(nodeForAdd);
                    this.setSize(this.size() + 1); //size++
                    return true;
                } else {
                    current = current.left(); //왼쪽으로 넘어간다.
                }
            } else {
                if (current.right() == null) { //null check
                    current.setRight(nodeForAdd);
                    this.setSize(this.size() + 1); //size++
                    return true;
                } else {
                    current = current.right();   //오른쪽으로 넘어간다.
                }
            }

        }
        return false;
    }

    @Override
    public Obj removeObjectForKey(Key aKey) {
        return null;
    }//todo 구현을 할 것 제거

    @Override
    public void clear() { //clear
        this.setSize(0);
        this.setRoot(null);
    }

    @Override
    public Iterator<DictionaryElement<Key, Obj>> iterator() {
        return new DictionaryIterator();
    } //return iterator

    private class DictionaryIterator implements Iterator<DictionaryElement<Key, Obj>> {
        private BinaryNode<DictionaryElement<Key, Obj>> _nextNode;
        private Stack<BinaryNode<DictionaryElement<Key, Obj>>> _stack;

        public BinaryNode<DictionaryElement<Key, Obj>> nextNode() {
            return _nextNode;
        }

        public void setNextNode(BinaryNode<DictionaryElement<Key, Obj>> _nextNode) {
            this._nextNode = _nextNode;
        }

        public Stack<BinaryNode<DictionaryElement<Key, Obj>>> stack() {
            return _stack;
        }

        public void setStack(Stack<BinaryNode<DictionaryElement<Key, Obj>>> _stack) {
            this._stack = _stack;
        }

        public DictionaryIterator() {
            this.setStack(new LinkedStack<BinaryNode<DictionaryElement<Key, Obj>>>());
            this.setNextNode(DictionaryByBinarySearchTree.this.root());
        }

        @Override
        public boolean hasNext() {
            return ((this.nextNode() != null || (!this.stack().isEmpty())));
        } //현재 가지고 있는 지 확인

        @Override
        public DictionaryElement<Key, Obj> next() { //다음으로 넘어간다. //스택을 이용하여 반복자를 활용을 한다.
            if (!this.hasNext()) {
                return null;
            } else {
                while (this.nextNode() != null) {
                    this.stack().push(this.nextNode());
                    this.setNextNode(this.nextNode().left());
                }
                BinaryNode<DictionaryElement<Key, Obj>> poppedNode = this.stack().pop();
                DictionaryElement<Key, Obj> nextElement = poppedNode.element();
                this.setNextNode(poppedNode.right());
                return nextElement;
            }

        }
    }

}
