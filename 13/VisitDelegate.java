public interface VisitDelegate<Key extends Comparable<Key>, Obj> {
    void visitForSortedOrder(DictionaryElement<Key, Obj> anElement, int aLevel);

    void visitForReverseOfSortedOrder(DictionaryElement<Key, Obj> anElement, int aLevel);
}
