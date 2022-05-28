public class Experiment {
    private final ParameterSet _parameterSet; // Class의 함수에서 이 값을 변경할 수 없다.
    // 오로지, 생성자 안에서만 값을 설정할 수 있다.
    // 즉, 객체를 생성할 때 정해진 값을 그대로 유지한다.
    public ParameterSet parameterSet() {
        return _parameterSet;
    } //setter
    public Experiment(ParameterSet givenParameterSet) {
        this._parameterSet = givenParameterSet;
    }
    //getter

    private Integer[] copyListOfGivenSize(Integer[] aList, int copiedSize) {
        Integer[] copiedList = null; //배열을 복사를 한다.
        if (copiedSize <= aList.length) {
            copiedList = new Integer[copiedSize];
            for (int i = 0; i < copiedSize; i++) {
                copiedList[i] = aList[i];
            }
        }
        return copiedList; //복사 배열을 반환을 한다.
    }

    private long durationOfSingleSort(Sort<Integer> aSort, Integer[] aList, int size) {
        Timer timer = new Timer();
        timer.start();
        aSort.sort(aList, size);
        timer.stop();
        return timer.duration(); //시간 측정
    }

    public long[] durationsOfSort(Sort<Integer> aSort, Integer[] experimentList) {
    // 정렬 방법이 매개변수로 주어져 있음에 유의할 것: Class "Sort" 를 볼 것
        int numberOfSteps = this.parameterSet().numberOfSizeIncreasingSteps();
        // 크기 별로 실행할 측정 횟수
        long[] durations = new long[numberOfSteps]; // 측정 결과를 저장할 곳
        int sortingSize = this.parameterSet().startingSize(); // 정렬 데이터의 시작 크기
        int incrementSize = this.parameterSet().incrementSize(); // 정렬 데이터 증가 크기
        for (int step = 0; step < numberOfSteps; step++) {
            Integer[] listForSorting = this.copyListOfGivenSize(experimentList, sortingSize);
            // 측정에 사용할 데이터 리스트 복사
            durations[step] = this.durationOfSingleSort(aSort, listForSorting, sortingSize);
            // 측정하여, 그 결과를 저장
            sortingSize += incrementSize; // 다음 단계의 정렬 데이터 크기를 얻는다
        }
        return durations;
    }
}


