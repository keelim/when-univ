public abstract class Sort<E extends Comparable<E>> {
    protected void swap(E[] aList, int i, int j) {
        E tempElement = aList[i];
        aList[i] = aList[j];
        aList[j] = tempElement;
    }

    protected Sort() {
    }

    public abstract boolean sort(E[] list, int aSize);
}