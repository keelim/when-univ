import java.util.Random;

public class AppController {

    //private static final int LIST_CAPACITY = 5;

    //    public AppController(){ 용량 제한시 사용을 할 것
//        this.setList(new ArrayList<Student>(AppController.LIST_CAPACITY));
//    }

    private ArrayList<Student> _list;


    public AppController() { //constructor
        this.setList(new ArrayList<Student>());

    }

    public ArrayList<Student> list() { //list getter
        return _list;

    }

    public void setList(ArrayList<Student> newList) { //list setter
        this._list = newList;

    }

    public void run() {
        AppView.outputLine("<<< 리스트 기능 확인 프로그램을 시작합니다. >>>");
        MainMenu selectedMenuValue = this.selectMenu();

        while (selectedMenuValue != MainMenu.EndOfRun) { //END_OF_RUN 종료

            switch (selectedMenuValue) {
                case DoesContain:
                    this.doesContain();
                    break;
                case ElementAt:
                    this.elementAt();
                    break;
                case First:
                    this.first();
                    break;
                case Last:
                    this.last();
                    break;
                case OrderOf:
                    this.orderOf();
                    break;
                case AddTo:
                    this.addTo();
                    break;
                case AddToFirst:
                    this.addToFirst();
                    break;
                case AddToLast:
                    this.addToLast();
                    break;
                case Add:
                    this.add();
                    break;
                case RemoveFrom:
                    this.removeFrom();
                    break;
                case RemoveFirst:
                    this.removeFirst();
                    break;
                case RemoveLast:
                    this.removeLast();
                    break;
                case RemoveAny:
                    this.removeAny();
                    break;
                case ReplaceAt:
                    this.replaceAt();
                    break;

                default:
                    break;
            }
            selectedMenuValue = this.selectMenu(); //재입력

        }
        this.showStatics();
        AppView.outputLine("");
        AppView.outputLine("<<< 리스트 기능 확인 프로그램을 종료합니다. >>> ");

    }


    private void replaceAt() { //엘리먼트 교체
        AppView.outputLine("");
        AppView.outputLine("! replaceAt 작업을 시작합니다. : ");

        int order = this.inputOrder();

        if (order < 0 || order >= this.list().size()) {
            AppView.outputLine("!  입력된 순서 [" + order + "] 가 정상 범위[0.." + (this.list().size() - 1) + "] 에 있지 않습니다. ");
            return;
        }
        int score = this.inputScore();

        this.list().replaceAt(new Student(score), order);

        AppView.outputLine("주어진 순서 [" + order + "] 의 학생의 점수가 (" + score + ") 바뀌었습니다. ");
    }

    private void removeAny() { //임의 순서로 리스트에 있는 엘리먼트 제거
        AppView.outputLine("");
        AppView.outputLine("! RemoveAny 작업을 시작합니다. ");

        if (this.list().isEmpty()) {
            AppView.outputLine("리스트가 비어 있어서 삭제 작업을 할 수 가 없습니다.  ");

        } else {


            Student student = this.list().removeAny();

            if (student != null) {
                AppView.outputLine("! 입력된 순서 [임의 순서] 에서 삭제된 학생의 정보는 [" + student.score() + "] 입니다. ");

            } else {
                AppView.outputLine("! 입력된 순서 [임의 순서] 에서 학생을 삭제하는 작업을 실패하였습니다. ");

            }

        }
    }

    private void removeLast() { //리스트 맨 뒤 엘리먼트 제거
        AppView.outputLine("");
        AppView.outputLine("! RemoveLast 작업을 시작합니다. ");

        if (this.list().isEmpty()) {
            AppView.outputLine("리스트가 비어 있어서 삭제 작업을 할 수 가 없습니다.  ");

        } else {


            Student student = this.list().removeLast();
            if (student != null) {
                AppView.outputLine("! 입력된 순서 [맨 뒤] 에서 삭제된 학생의 정보는 [" + student.score() + "] 입니다. ");

            } else {
                AppView.outputLine("! 입력된 순서 [맨 뒤] 에서 학생을 삭제하는 작업을 실패하였습니다. ");

            }
        }
    }

    private void removeFirst() { //리스트 맨 앞 엘리먼트 제거
        AppView.outputLine("");
        AppView.outputLine("! RemoveFirst 작업을 시작합니다. ");
        if (this.list().isEmpty()) {
            AppView.outputLine("리스트가 비어 있어서 삭제 작업을 할 수 가 없습니다.  ");

        } else {

            Student student = this.list().removeFirst();
            if (student != null) {
                AppView.outputLine("! 입력된 순서 [맨 앞] 에서 삭제된 학생의 정보는 [" + student.score() + "] 입니다. ");

            } else {
                AppView.outputLine("! 입력된 순서 [맨 앞] 에서 학생을 삭제하는 작업을 실패하였습니다. ");

            }
        }
    }

    private void removeFrom() { //리스트 특정 인덱스 엘리먼트 제거
        AppView.outputLine("");
        AppView.outputLine("! RemoveFrom 작업을 시작합니다. : ");
        if (this.list().isEmpty()) {
            AppView.outputLine("리스트가 비어 있어서 삭제 작업을 할 수 가 없습니다.  ");
        } else {
            int order = this.inputOrder();
            if (order < 0 || order >= this.list().size()) {
                AppView.outputLine("!  입력된 순서 [" + order + "] 가 정상 범위[0.." + (this.list().size() - 1) + "] 에 있지 않습니다. ");
                AppView.outputLine("! 입력된 순서 [" + order + "] 에서 학생을 삭제하는 작업을 실패하였습니다. ");
                return;

            }
            Student student = this.list().removeFrom(order);
            if (student != null) {
                AppView.outputLine("! 입력된 순서 [" + order + "] 에서 삭제된 학생의 정보는 [" + student.score() + "] 입니다. ");

            } else {
                AppView.outputLine("! 입력된 순서 [" + order + "] 에서 학생을 삭제하는 작업을 실패하였습니다. ");

            }
        }
    }

    private void addToLast() { //리스트 맨 뒤 엘리먼트 추가
        AppView.outputLine("");
        AppView.outputLine("! AddToLast 작업을 시작합니다. ");
        if (this.list().isFull()) {
            AppView.outputLine("리스트가 꽉차서 작업을 시작할 수 없습니다. ");
        } else {
            int score = this.inputScore();
            if (this.list().addToLast(new Student(score))) {
                AppView.outputLine("입력된 점수는 (" + score + ")의 학생을 [맨 뒤]에 삽입하는 작업을 성공하였습니다. ");

            } else {
                AppView.outputLine("입력된 점수는 (" + score + ")의 학생을 [맨 뒤]에 삽입하는 작업을 실패하였습니다. ");

            }
        }
    }

    private void add() { //리스트 임의 순서 엘리먼트 추가

        AppView.outputLine("");
        AppView.outputLine("! add 작업을 시작합니다. : ");
        int random_num = new Random().nextInt(2);
        if (this.list().isFull()) {
            AppView.outputLine("리스트가 꽉차서 작업을 시작할 수 없습니다. ");

        } else {
            int score = this.inputScore();
            if (random_num == 0) {
                if (this.list().add(new Student(score))) {
                    AppView.outputLine("입력된 점수는 (" + score + ")의 학생을 [임의 순서]에 삽입하는 작업을 성공하였습니다. ");

                } else {
                    AppView.outputLine("입력된 점수는 (" + score + ")의 학생을 리스트에 삽입하는 작업을 실패하였습니다. ");

                }
            } else {
                if (this.list().add(new Student(score))) {
                    AppView.outputLine("입력된 점수는 (" + score + ")의 학생을 [임의 순서]에 삽입하는 작업을 성공하였습니다. ");

                } else {
                    AppView.outputLine("입력된 점수는 (" + score + ")의 학생을 리스트에 삽입하는 작업을 실패하였습니다. ");

                }
            }

        }
    }


    private void addToFirst() { //리스트 맨 앞 엘리먼트 추가
        AppView.outputLine("");
        AppView.outputLine("! addToFirst 작업을 시작합니다.: ");

        if (this.list().isFull()) {
            AppView.outputLine("리스트가 꽉차서 작업을 시작할 수 없습니다. ");
        } else {
            int score = this.inputScore();
            if (this.list().addToFirst(new Student(score))) {
                AppView.outputLine("입력된 점수는 (" + score + ")의 학생을 [맨 앞]에 삽입하는 작업을 성공하였습니다. ");

            } else {
                AppView.outputLine("입력된 점수는 (" + score + ")의 학생을 [맨 앞]에 삽입하는 작업을 실패하였습니다. ");

            }
        }
    }

    private void addTo() { //리스트 특정 인덱스 엘리먼트 추가
        AppView.outputLine("");
        AppView.outputLine("! addTo  작업을 시작합니다. ");

        int order = this.inputOrder();

        if (order < 0 || order > this.list().size()) {
            AppView.outputLine("!  입력된 순서 [" + order + "] 가 정상 범위[0.." + (this.list().size() - 1) + "] 에 있지 않습니다. ");
            return;
        }

        int score = this.inputScore();
        Student student = new Student(score);
        this.list().addTo(student, order);

        AppView.outputLine("! 입력된 순서 [" + order + "] 에 입력된 점수는 (" + student.score() + ")의 학생을 삽입하는데 성공하였습니다.  ");


    }

    private void orderOf() { //점수를 통하여 리스트의 인덱스 출력
        AppView.outputLine("");
        AppView.outputLine("! OrderOf 작업을 시작합니다. : ");
        AppView.output("학생의 점수를 입력하여 주세요: ");

        int score = this.inputScore();
        int orderIndex = this.list().orderOf(new Student(score));

        if (orderIndex == -1) {
            AppView.outputLine("입력된 점수 (" + score + ") 에 학생은 리스트에 없습니다. ");

        } else {
            AppView.outputLine("입력된 점수 (" + score + ") 에 학생의 순서는[" + orderIndex + "] 입니다. ");

        }
    }

    private void last() { //리스트 맨 뒤 엘리먼트 출력
        AppView.outputLine("");
        AppView.outputLine("! Last 작업을 시작 합니다. : ");
        Student student = this.list().last();

        if (student == null) {
            AppView.outputLine("배열이 비어 있습니다. ");

        } else {
            AppView.outputLine("[맨 뒤] 학생의 점수는 (" + student.score() + ") 입니다. ");

        }
    }

    private void first() { //리스트 맨 앞 엘리먼트 출력
        AppView.outputLine("");
        AppView.outputLine("! First 작업을 시작합니다. : ");

        Student student = this.list().first();

        if (student == null) {
            AppView.outputLine("배열이 비어 있습니다. ");

        } else {
            AppView.outputLine("[맨 앞] 학생의 점수는 (" + student.score() + ") 입니다. ");

        }
    }

    private void elementAt() { //입력 차수를 통하여 엘리먼트 출력
        AppView.outputLine("");
        AppView.outputLine("! ElementAt 작업을 시작합니다. : ");
        int order = this.inputOrder();
        Student student = this.list().elementAt(order);
        if (student == null) {
            AppView.outputLine("입력된 순서 [" + order + "] 에 존재하는 학생은 없습니다. ");

        } else {
            AppView.outputLine("입력된 순서 [" + order + "] 에 존재하는 학생의 점수는 (" + student.score() + ") 입니다. ");

        }
    }

    private void doesContain() { //리스트에 존재 여부 확인
        AppView.outputLine("");
        AppView.outputLine("! DoesContain 작업을 시작합니다. ");
        AppView.output("점수를 입력해 주세요: ");

        int score = this.inputScore();
        boolean flag = this.list().doesContain(new Student(score));

        if (flag) {
            AppView.outputLine(" 입력된 정수(" + score + ") 의 학생 리스트에 존재합니다. ");
        } else {
            AppView.outputLine(" 입력된 정수(" + score + ") 의 학생 리스트에 존재하지 않습니다. . ");

        }
    }

    private void showMenu() { //메뉴 출력
        AppView.outputLine("> 해야 할 작업의 번호를 선택해야 합니다. ");
        AppView.outputLine("DoesContain = 1, ElementAt = 2, First = 3, Last = 4, OrderOf = 5 ");
        AppView.outputLine("AddTo = 6, AddFirst = 7, AddToLast = 8, Add = 9, ");
        AppView.outputLine("RemoveFrom = 10, RemoveFirst = 11, RemoveLast = 12, RemoveAny = 13, ReplaceAt = 14, END_OF_RUN = 99 ");
        AppView.output("? 작업 번호를 입력하여 주세요: ");

    }


    private void showStatics() { //통계 함수 출력
        AppView.output("");
        AppView.outputLine("> 리스트 정보 입니다. ");
        AppView.outputLine("! 학생 수 : " + this.list().size());
        this.showList();

    }


    private MainMenu selectMenu() {//메뉴를 선택합니다.
        AppView.outputLine("");

        this.showList();
        this.showMenu();
        int selectedMenuNumber = AppView.inputInteger();

        MainMenu selectedMenuValue = MainMenu.value(selectedMenuNumber);
        return selectedMenuValue;

    }

    private void showList() { //현재 리스트가 가지고 있는 엘리먼트 출력
        AppView.output("! 현재 리스트 원소들 [");
        Student student = null;
        Iterator<Student> iterator = this.list().iterator(); //iterator 생성

        while (iterator.hasNext()) {
            student = iterator.next();
            AppView.output(" " + student.score() + " ");

        }
        AppView.outputLine("] ");

    }

    private int inputScore() { //점수 입력
        int score;

        while (true) {
            try {
                AppView.output("점수를 입력하시오: ");
                score = AppView.inputInteger();
                return score;
            } catch (NumberFormatException e) {
                AppView.outputLine("[오류] 입력된 수가 정수가 아닙니다. ");
            }
        }
    }

    private int inputOrder() { //차수 입력
        int score;
        while (true) {
            try {
                AppView.output("? 리스트에서의 순서 번호를 입력하세요: ");
                score = AppView.inputInteger();
                return score;

            } catch (NumberFormatException e) {
                AppView.outputLine("[오류]: 입력된 순서 번호는 정수가 아닙니다. ");

            }
        }
    }


}

