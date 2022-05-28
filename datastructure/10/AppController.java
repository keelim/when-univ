public class AppController {

    private static final int TEST_SIZE = 10000; //테스트 사이즈 설정
    private static final int FIRST_PART_SIZE = 5;
    private static final InsertionSort<Integer> INSERTION_SORT = new InsertionSort<>();
    private static final QuickSort<Integer> QUICK_SORT = new QuickSort<>();

    // 비공개 변수들
    private Integer[] _list;
    private ListOrder _listOrder;

    public Integer[] list() {
        return _list;
    } //getter

    public void setList(Integer[] _list) {
        this._list = _list;
    } //setter

    public ListOrder listOrder() {
        return _listOrder;
    } //getter

    public void setListOrder(ListOrder _listOrder) {
        this._listOrder = _listOrder;
    } //setter

    public AppController() { //Constructor

    }

    public void run() {
        AppView.outputLine
                ("<<< 정렬 알고리즘의 정렬 결과를 검증하는 프로그램을 시작합니다 >>>"); //시작 메시지 출력
        AppView.outputLine("");
        AppView.outputLine("> 정렬 결과의 검증:"); //결과 검증
        AppView.outputLine("");
        this.validateWithAscendingList(); //오름차순 시작
        this.validateWithDescendingList(); //내림차순 시작
        this.validateWithRandomList(); //무작위 시작
        AppView.outputLine("<<< 정렬 알고리즘의 정렬 결과를 검증하는 프로그램을 종료합니다 >>>");
    }

    private void validateWithAscendingList() {
        this.setListOrder(ListOrder.Ascending); //오름차순으로 설정
        this.setList(DataGenerator.ascendingList(AppController.TEST_SIZE)); //테스트 사이즈 설정
        this.showFirstPartOfDataList(); //리스트 FIRST_PART_SIZE 만큼의 배열의 원소를 출력
        this.validateSortsAndShowResult(); //Sorting 결과의 출력을 확인
    }

    private void validateWithDescendingList() {
        this.setListOrder(ListOrder.Descending); //내림차순으로 설정
        this.setList(DataGenerator.descendingList(AppController.TEST_SIZE)); //테스트 사이즈 설정
        this.showFirstPartOfDataList(); //리스트 FIRST_PART_SIZE 만큼의 배열의 원소를 출력
        this.validateSortsAndShowResult(); //Sorting 결과의 출력을 확인
    }

    private void validateWithRandomList() {
        this.setListOrder(ListOrder.Random); //랜덤으로 설정
        this.setList(DataGenerator.randomList(AppController.TEST_SIZE)); //테스트 사이즈 설정
        this.showFirstPartOfDataList(); //리스트 FIRST_PART_SIZE 만큼의 배열의 원소를 출력
        this.validateSortsAndShowResult(); //Sorting 결과의 출력을 확인
    }

    private void showFirstPartOfDataList() {
        AppView.output(
                "[" + this.listOrder().orderName() + " 리스트] 의 앞 부분: ");
        for (int i = 0; i < FIRST_PART_SIZE; i++) {
            int intro = this.list()[i];
            AppView.output(intro + " "); //리스트의 앞 부분을 표시를 한다.
        }
        AppView.outputLine("");
    }

    private void validateSort(Sort<Integer> aSort) { //정렬을 하여 사용을 한다.
        Integer[] list = this.copyList(this._list); //배열의 복사가 일어난다.
        aSort.sort(list, list.length); //정렬
        this.showValidationMessage(aSort, list); //정렬되어 메시지를 출력을 한다.
    }

    private void validateSortsAndShowResult() { //결과를 출력을 해준다.
        this.validateSort(AppController.INSERTION_SORT);
        this.validateSort(AppController.QUICK_SORT);
        AppView.outputLine("");
    }

    private void showValidationMessage(Sort<Integer> aSort, Integer[] aList) { //유효한 지를 출력을 한다.
        AppView.output(
                "[" + this.listOrder().orderName() + " 리스트]를 [" +
                        aSort.getClass().getSimpleName() + "] 한 결과는 ");
        if (this.sortedListIsValid(aList)) {
            AppView.outputLine("올바릅니다. ");
        } else {
            AppView.outputLine("올바르지 않습니다.  ");
        }

    }

    private Integer[] copyList(Integer[] aList) {
        // 주어진 배열 객체 aList[] 의 복사본을 만들어 돌려준다.
        // aList[] 자체는 복사하지만,
        // 배열의 원소 객체 자체는 복사하지 않고 공유한다.
        Integer[] copiedList;
        copiedList = aList.clone(); //깊은 복사? 얕은 복사?
//        System.arraycopy(aList, 0, copiedList, 0, aList.length); //System.arrayCopy 이용
        return copiedList;
    }

    private boolean sortedListIsValid(Integer[] aList) { //정렬의 정상 유무를 확인을 한다.
// 주어진 aList 의 원소들이 오름차순으로 되어 있으면 true 를 돌려준다.
        for (int i = 0; i < (aList.length - 1); i++) {
            if (aList[i].compareTo(aList[i + 1]) > 0) {
                return false; // 오름차순이 아닌 순서를 발견
            }
        }
        return true; // 리스트 전체가 오름차순으로 되어 있다.
    }


}
