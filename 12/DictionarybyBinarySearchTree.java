public class DictionarybyBinarySearchTree<Key extends Comparable<Key>, Obj> extends Dictionary<Key, Obj> {

    private BinaryNode<DictionaryElement<Key, Obj>> _root;

    protected BinaryNode<DictionaryElement<Key, Obj>> root() {
        return _root;
    }

    public void setRoot(BinaryNode<DictionaryElement<Key, Obj>> _root) {
        this._root = _root;
    }

    public DictionarybyBinarySearchTree() {
        this.clear();
    }

    private DictionaryElement<Key, Obj> elementForKey(Key aKey) {
        if (aKey != null) {
            BinaryNode<DictionaryElement<Key, Obj>> current = this.root();
            while (current != null) {
                if (current.element().key().compareTo(aKey) == 0) {
                    return current.element();
                } else if (current.element().key().compareTo(aKey) > 0) {
                    current = current.left();
                } else {
                    current = current.right();
                }
            }
        }
        return null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean keyDoesExist(Key aKey) {
        return (this.elementForKey(aKey) != null);
    }

    @Override
    public Obj objectForKey(Key aKey) {
        DictionaryElement<Key, Obj> element = this.elementForKey(aKey);
        if (element != null) {
            return element.object();
        } else {
            return null;
        }
    }

    @Override
    public boolean addKeyAndObject(Key aKey, Obj anObject) {
        if (aKey == null) {
            return false; // In any case, "aKey" cannot be null for add.
        }
        DictionaryElement<Key, Obj> elementForAdd = new DictionaryElement<Key, Obj>(aKey, anObject);
        BinaryNode<DictionaryElement<Key, Obj>> nodeForAdd = new BinaryNode<DictionaryElement<Key, Obj>>(elementForAdd, null, null);
        if (this.root() == null) {
            this.setRoot(nodeForAdd);
            this.setSize(1);
            return true;
        }
        BinaryNode<DictionaryElement<Key, Obj>> current = this.root();
        while (aKey.compareTo(current.element().key()) != 0) {
            if (aKey.compareTo(current.element().key()) < 0) {
                if (current.left() == null) {
                    current.setLeft(nodeForAdd);
                    this.setSize(this.size() + 1);
                    return true;
                } else {
                    current = current.left();
                }
            } else {
                if (current.right() == null) {
                    current.setRight(nodeForAdd);
                    this.setSize(this.size() + 1);
                    return true;
                } else {
                    current = current.right();
                }
            }

        }
        return false;
    }

    @Override
    public Obj removeObjectForKey(Key aKey) {
        return null;
    }

    @Override
    public void clear() {
        this.setSize(0);
        this.setRoot(null);
    }

    @Override
    public Iterator<DictionaryElement<Key, Obj>> iterator() {
        return new DictionaryIterator();
    }

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
            this.setNextNode(DictionarybyBinarySearchTree.this.root());
        }

        @Override
        public boolean hasNext() {
            return ((this.nextNode() != null || (!this.stack().isEmpty())));
        }

        @Override
        public DictionaryElement<Key, Obj> next() {
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
