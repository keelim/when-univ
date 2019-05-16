public class QuickSort<E extends Comparable<E>> extends Sort<E> {

    private int pivot(E[] aList, int left, int right) { //피봇값을 리턴을 한다.
        return left;
    }

    private int partition(E[] aList, int left, int right) { //파티션 함수 중간 값을 정해주는 것이다.
        E pivot = aList[pivot(aList, left, right)];
        int toRight = left;
        int toLeft = right + 1;
        do {
            do {
                toRight++;
            } while (aList[toRight].compareTo(pivot) < 0); //피봇값을 기준으로 움직인다.
            do {
                toLeft--;
            } while (aList[toLeft].compareTo(pivot) > 0); //피봇값을 기준으로 움직인다.

            if (toRight < toLeft) { //toLeft 가 크면 swap
                this.swap(aList, toRight, toLeft);
            }
        } while (toRight < toLeft);

        this.swap(aList, left, toLeft); //left 와 toleft swap
        return toLeft;
    }

    private void quickSortRecursively(E[] aList, int left, int right) {
        if (left < right) {
            int mid = this.partition(aList, left, right); //partition method를 통하여 중간 값 결정
            this.quickSortRecursively(aList, left, mid - 1); //중간 이전
            this.quickSortRecursively(aList, mid + 1, right); //중간 이후
        }

    }


    @Override
    public boolean sort(E[] aList, int aSize) { //Sorting을 하고 있다.
        if ((aSize < 1) || (aSize > aList.length)) {
            return false;
        }
        int maxLoc = 0;
        for (int i = 1; i < aSize; i++) {
            if (aList[i].compareTo(aList[maxLoc]) > 0) {
                maxLoc = i;
            }
        }
        this.swap(aList, maxLoc, aSize - 1);
        this.quickSortRecursively(aList, 0, aSize - 2);
        return true;
    }
}
