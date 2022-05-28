public class ExperimentManager {
    private static final int DEFAULT_NUMBER_OF_SIZE_INCREASING_STEPS = 10;
    private static final int DEFAULT_INCREMENT_SIZE = 1000;
    private static final int DEFAULT_STARTING_SIZE = DEFAULT_INCREMENT_SIZE;
    private static final InsertionSort<Integer> INSERTION_SORT = new InsertionSort<>();
    private static final QuickSort<Integer> QUICK_SORT = new QuickSort<>();
    private Experiment _experiment;// 측정 실험을 실시할 객체
    private ParameterSet _parameterSet; // 측정 실험에 사용할 매개변수 집합
    private Integer[] _ascendingList; // 측정에서 정렬에 사용할 오름차순 데이터 리스트
    private Integer[] _descendingList; // 측정에서 정렬에 사용할 내림차순 데이터 리스트
    private Integer[] _randomList; // 측정에서 정렬에 사용할 무작위 데이터 리스트
    private long[] _measuredResultForInsertionSort; // 삽입 정렬의 측정 결과 저장할 곳
    private long[] _measuredResultForQuickSort; // 퀵 정렬의 측정 결과 저장할 곳

    private Experiment experiment() {
        return _experiment;
    }
    //getter
    private void setExperiment(Experiment _experiment) {
        this._experiment = _experiment;
    }

    //setter
    public ParameterSet parameterSet() {
        return _parameterSet;
    }

    //getter
    private void setParameterSet(ParameterSet _parameterSet) {
        this._parameterSet = _parameterSet;
    }

    //setter
    private Integer[] ascendingList() {
        return _ascendingList;
    }

    //getter
    private void setAscendingList(Integer[] _ascendingList) {
        this._ascendingList = _ascendingList;
    }

    //setter
    private Integer[] descendingList() {
        return _descendingList;
    }

    //getter
    private void setDescendingList(Integer[] _descendingList) {
        this._descendingList = _descendingList;
    }

    //setter
    private Integer[] randomList() {
        return _randomList;
    }

    //getter
    private void setRandomList(Integer[] _randomList) {
        this._randomList = _randomList;
    }

    //setter
    private long[] measuredResultForInsertionSort() {
        return _measuredResultForInsertionSort;
    }

    //getter
    private void setMeasuredResultForInsertionSort(long[] _measuredResultForInsertionSort) {
        this._measuredResultForInsertionSort = _measuredResultForInsertionSort;
    }
    //setter
    private long[] measuredResultForQuickSort() {
        return _measuredResultForQuickSort;
    }

    //getter
    private void seMmeasuredResultForQuickSort(long[] _measuredResultForQuickSort) {
        this._measuredResultForQuickSort = _measuredResultForQuickSort;
    }
    //setter
    public ExperimentManager() {
        this.setParameterSetWithDefaults();
    }

    //constructor
    private void prepareExperimentLists() {
        int maxDataSize = this.parameterSet().maxDataSize();
        this.setAscendingList(DataGenerator.ascendingList(maxDataSize));
        this.setDescendingList(DataGenerator.descendingList(maxDataSize));
        this.setRandomList(DataGenerator.randomList(maxDataSize));
    }

    private void setParameterSetWithDefaults() {
        this.setParameterSet(new ParameterSet(DEFAULT_STARTING_SIZE,
                DEFAULT_NUMBER_OF_SIZE_INCREASING_STEPS, DEFAULT_INCREMENT_SIZE));
    }

    private Integer[] experimentListOfOrder(ListOrder anOrder) {
        // 주어진 anOrder 에 해당하는 리스트를 돌려준다.
        switch (anOrder) {
            case Ascending:
                return this.ascendingList();
            case Descending:
                return this.descendingList();
            default:
                return this.randomList();
        }
    }

    public void prepareExperiment(ParameterSet aParameterSet) {
        // 실험을 준비한다.
        if (aParameterSet != null) {
            // 객체 생성할 때, 매개변수 집합은 기본 값으로 설정되어 있다.
            // 실험 준비 단계에서, 이렇게 새로운 매개변수 집합을 주어 변경할 수 있다.
            this.setParameterSet(aParameterSet);
        }
        this.setExperiment(new Experiment(this.parameterSet()));
        // 현재 상태의 매개변수 집합을 사용하여 Experiment 객체를 생성한다.
        this.prepareExperimentLists();
        // 측정 실험에서 정렬에 사용할 데이터 리스트를 생성하여 보관한다.
        // 다음의 내용은 생략 가능한, 내용적으로는 의미가 없는 실행이다.
        // 단지 실험 측정 결과를 안정화시키기 위한 목적일 뿐이다.
        this.performExperiment(ListOrder.Random);
        this.performExperiment(ListOrder.Random);
    }

    public long measuredResultForInsertionSortAt(int sizeStep) {
        return this.measuredResultForInsertionSort()[sizeStep];
    }

    public long measuredResultForQuickSortAt(int sizeStep) {
        return this.measuredResultForQuickSort()[sizeStep];
    }

    public void performExperiment(ListOrder anOrder) {
        // 측정 실험을 실행한다.
        // 주어진 anOrder 의 실험 리스트를 얻는다.
        Integer[] experimentList = this.experimentListOfOrder(anOrder);
        // 이 실험 리스트로 삽입과 퀵 각각의 정렬의 성능을 측정해서, 그 결과를 얻는다.
        this.setMeasuredResultForInsertionSort
                (this.experiment().durationsOfSort(INSERTION_SORT, experimentList));
        this.seMmeasuredResultForQuickSort(
                this.experiment().durationsOfSort(QUICK_SORT, experimentList));
    }
}
