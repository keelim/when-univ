public abstract class Sort<E extends Comparable<E>> {
    //protected 의 선언?
    protected void swap(E[] aList, int i, int j) { //swap 기본 템플릿
        E tempElement = aList[i];
        aList[i] = aList[j];
        aList[j] = tempElement;
    }

    protected Sort() {
    }

    public abstract boolean sort(E[] list, int aSize);
}