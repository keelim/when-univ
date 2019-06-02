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
        Obj removedObject = null;
        if (this._root == null) {
            return null;
        } else if (aKey.compareTo(this._root.element().key()) == 0) {
            removedObject = this._root.element().object();
            if ((this._root.left() == null) && (this._root.right() == null)) { // root만 있는tree
                this._root = null;
            } else if (this._root.left() == null) { // root의 left tree 가 없다
                this._root = this._root.right();
            } else if (this._root.right() == null) { // root의 right tree 가 없다
                this._root = this._root.left();
            } else {// child의 left tree, right tree가 모두 있다
                this._root.setElement(removeRightMostElementOfLeftTree(this._root));
            }
            this.setSize(this.size() + 1);
            return removedObject;

        } else {
            return removeObjectForKeyFromSubtree(this._root, aKey);
        }

    }

    private DictionaryElement<Key, Obj> removeRightMostElementOfLeftTree(BinaryNode currentRoot) {
        // 현재의 currentRoot 의 원소를 대체할 원소인,
        // 왼쪽 트리의 가장 오른쪽 노드의 원소를 삭제하여 얻는다.
        // call 되는 시점에, currentRoot.left() 는 null 이 아니다
        BinaryNode<DictionaryElement<Key, Obj>> leftOfCurrentRoot = currentRoot.left();
        if (leftOfCurrentRoot.right() == null) { //null check
            currentRoot.setLeft(leftOfCurrentRoot.left());
            return leftOfCurrentRoot.element();
        } else {
            BinaryNode<DictionaryElement<Key, Obj>> parentOfRightMost = leftOfCurrentRoot;
            BinaryNode<DictionaryElement<Key, Obj>> rightMost = leftOfCurrentRoot.right();
            while (rightMost.right() != null) { //null check
                parentOfRightMost = rightMost;
                rightMost = rightMost.right();
            }
            parentOfRightMost.setRight(rightMost.left());
            return rightMost.element();
        }
    }

    private Obj removeObjectForKeyFromSubtree(BinaryNode currentRoot, Key aKey) {
        // 이 시점에, currentRoot 는 null이 아니고, currentRoot의 key는 "aKey" 와 일치하지 않는다.
        BinaryNode<DictionaryElement<Key, Obj>> root = currentRoot;
        if (aKey.compareTo(root.element().key()) < 0) { // left subtree에서 삭제해야 한다
            BinaryNode<DictionaryElement<Key, Obj>> child = root.left();
            if (child == null) {
                return null;
            } else {
                if (aKey.compareTo(child.element().key()) == 0) {
                    Obj removedObject = child.element().object();
                    if (child.left() == null && child.right() == null) { // child가 leaf
                        currentRoot.setLeft(null);
                    } else if (child.left() == null) { // child 의 left tree가 없다
                        currentRoot.setLeft(child.right());
                    } else if (child.right() == null) { // child 의 right tree 가 없다
                        currentRoot.setLeft(child.left());
                    } else { // child의 left tree, right tree가 모두 있다
                        currentRoot.setElement(removeRightMostElementOfLeftTree(child));
                    }
                    this.setSize(this.size() - 1);
                    return removedObject;
                } else {
                    return removeObjectForKeyFromSubtree(child, aKey);
                }
            }
        } else { // right subtree에서 삭제해야 한다
            BinaryNode<DictionaryElement<Key, Obj>> child = currentRoot.right();
            if (child == null) {
                return null;
            } else {
                if (aKey.compareTo(child.element().key()) == 0) {
                    Obj removedObject = child.element().object();
                    if (child.left() == null && child.right() == null) { // child가 leaf
                        currentRoot.setRight(null);
                    } else if (child.left() == null) { // child 의 left tree가 없다
                        currentRoot.setRight(child.right());
                    } else if (child.right() == null) { // child 의 right tree 가 없다
                        currentRoot.setRight(child.left());
                    } else { // child의 left tree, right tree가 모두 있다
                        currentRoot.setElement(removeRightMostElementOfLeftTree(child));
                    }
                    this.setSize(this.size() - 1);
                    return removedObject;
                } else {
                    return removeObjectForKeyFromSubtree(child, aKey);
                }
            }
        }
    }

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
