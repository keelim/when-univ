public abstract class Sort<E extends Comparable<E>> {

    //protect 같은 패키지나 상속을 하는 클래스만 실행 가능

    protected void swap(E[] aList, int i, int j) { //swap 기본 템플릿
        E tempElement = aList[i];
        aList[i] = aList[j];
        aList[j] = tempElement;
    }

    protected Sort() {
    }

    public abstract boolean sort(E[] list, int aSize);
}