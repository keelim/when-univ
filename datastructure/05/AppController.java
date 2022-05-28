public class AppController {
    private Experiment _experiment;

    public Experiment experiment() { //experiment getter
        return _experiment;
    }

    public void setExperiment(Experiment newExperiment) { //experiment setter
        this._experiment = newExperiment;
    }

    public AppController() { //AppController constructor
        this.setExperiment(new Experiment());
        this.experiment().generateData();
    }

    public void run() {

        AppView.outputLine("<<< 리스트 성능 측정 프로그램을 시작합니다.  >>> ");
        AppView.outputLine("! 리스트 구현에 따른 차이를 알아봅니다. (단위: Micro Second)");


        AppView.outputLine("");
        AppView.outputLine("<UnSorted Array List >");
        this.experiment().measureForUnSortedArrayList(); //UnSortedArrayList 측정
        this.showExperimentResults(); //결과 출력


        AppView.outputLine("");
        AppView.outputLine("<Sorted Array List >");
        this.experiment().measureForSortedArrayList(); //성능 측정 실행
        this.showExperimentResults(); //결과를 화면에 출력한다. 복잡한거니 controller 에서

        //Linked Unsorted
        AppView.outputLine("");
        AppView.outputLine("<UnSorted Linked List >");
        this.experiment().measureForUnSortedLinkedList(); //UnSortedLinkedList 측정
        this.showExperimentResults(); //결과 출력


        //Linked sorted
        AppView.outputLine("");
        AppView.outputLine("<Sorted Linked List >");
        this.experiment().measureForSortedLinkedList(); //SortedLinkedList 측정
        this.showExperimentResults(); //결과 출력

        AppView.outputLine("<<< 리스트 성능 측정 프로그램을 종료 합니다, >>>");


    }

    private void showExperimentResults() { //결과 출력
        MeasuredResult[] results = this.experiment().measuredResults();
        for (int i = 0; i < this.experiment().numberOfIteration(); i++) {
            AppView.outpuResults(
                    results[i].size(),
                    results[i].durationForAdd() / 1000,
                    results[i].durationForMax() / 1000
            );
        }

    }
}

