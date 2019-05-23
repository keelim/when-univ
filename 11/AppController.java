public class AppController {

    // 비공개 변수들
    private Integer[] _list;
    private ListOrder _listOrder;
    private ExperimentManager _manager;

    public AppController() { //Constructor
        this.setManager(new ExperimentManager());

    }

    public Integer[] list() {
        return _list;
    } //getter

    public void setList(Integer[] _list) {
        this._list = _list;
    } //setter

    public ListOrder listOrder() {
        return _listOrder;
    }

    public void setListOrder(ListOrder _listOrder) {
        this._listOrder = _listOrder;
    } //setter

    public ExperimentManager manager() {
        return _manager;
    }//getter

    public void setManager(ExperimentManager _manager) {
        this._manager = _manager;
    }//setter

    public void run() {
        AppView.outputLine("<<<정렬 성능 비교 프로그램을 시작합니다 >>>");
        AppView.outputLine("");
        {
            AppView.outputLine(">> 2 가지 정렬의 성능 비교: 삽입, 퀵 <<");
            this.manager().prepareExperiment(null); // ExperimentManager 객체에게 실험을 준비시킨다.
            // 이번 실험에서는 매개변수 값으로 기본 설정 값을 사용한다. // 기본 설정 값은 Class "ExperimentManager" 에 설정되어 있다.
            this.measureAndShowFor(ListOrder.Ascending); //성능 측정
            this.measureAndShowFor(ListOrder.Descending);//성능 측정
            this.measureAndShowFor(ListOrder.Random);//성능 측정
        }
        AppView.outputLine("<<< 정렬 성능 비교 프로그램을 종료합니다 >>>");
    }

    private void showTableTitle(ListOrder anOrder) {
        AppView.outputLine("> " + anOrder.orderName() + " 데이터를 사용하여 실행한 측정:"); //테이블 제목 출력
    }

    private void showTableHead() { //테이블 헤드 출력
        AppView.outputLine(String.format("%8s", " ") +
                String.format("%16s", "<Insertion Sort>") +
                String.format("%16s", "<Quick Sort>"));
    }

    private void showTableContent() { //테이블 내용 출력
        //파라미터 셋을 통하여 계산 및 출력
        int startingSize = this.manager().parameterSet().startingSize();
        int incrementSize = this.manager().parameterSet().incrementSize();
        int numberOfSteps = this.manager().parameterSet().numberOfSizeIncreasingSteps();
        for (int step = 0; step < numberOfSteps; step++) {
            int sortingSize = startingSize + (incrementSize * step);
            AppView.outputLine("[" + String.format("%5d", sortingSize) + "]" +
                    String.format("%16d", this.manager().measuredResultForInsertionSortAt(step)) +
                    String.format("%16d", this.manager().measuredResultForQuickSortAt(step)));
        }
    }

    private void showResultTable(ListOrder anOrder) { // 주어진 anOrder 에 대하여, 성능 측정 결과를 보여준다.
//        통합적인 출력
        this.showTableTitle(anOrder);
        this.showTableHead();
        this.showTableContent();
        AppView.outputLine("");
    }

    private void measureAndShowFor(ListOrder anOrder) {
        this.manager().performExperiment(anOrder);
        this.showResultTable(anOrder);
    }

}
