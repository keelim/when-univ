public class AppController {

    private static final int LIST_CAPACITY = 5;

    private ArrayList<Student> _list;

    public ArrayList<Student> list() {
        return _list;
    }

    public void setList(ArrayList<Student> newList) {
        this._list = newList;
    }

    public AppController() {
        this.setList(new ArrayList<Student>(AppController.LIST_CAPACITY));
    }

    public void run() {

        AppView.outputLine("<<< 리스트 기능 확인 프로그램을 시작합니다. >>>");

        this.showMenu();
        MainMenu selectedMenuValue = this.selectMenu();

        while (selectedMenuValue != MainMenu.END_OF_RUN) { //END_OF_RUN 일시 종료
            switch (selectedMenuValue) {
                case DoesContain:
                    //todo
                    break;
                case Elemnetat:
                    //todo
                    break;
                case First:
                    //todo
                    break;
                case Last:
                    //todo
                    break;
                case OrderOf:
                    //todo
                    break;
                case AddTo:
                    //todo
                    break;
                case AddToFirst:
                    //todo
                    break;
                case AddToLast:
                    //todo
                    break;
                case Add:
                    //todo
                    break;
                case RemoveFrom:
                    //todo
                    break;
                case RemoveFirst:
                    //todo
                    break;
                case RemoveLast:
                    //todo
                    break;
                case RemoveAny:
                    //todo
                    break;
                case ReplaceAt:
                    //todo
                    break;
                default:
                    break;

            }
            selectedMenuValue = this.selectMenu();

        }
        this.showStatics(); //todo 통계를 보여준다.

        AppView.outputLine("");
        AppView.outputLine("<<< 리스트 기능 확인 프로그램을 종료합니다. >>> ");

    }

    private void showMenu() {
        AppView.outputLine("> 해야 할 작업의 번호를 선택해야 합니다. ");
        AppView.outputLine("DoesContain = 1, ElemntAt = 2, First = 3, Last = 4, OrderOf = 5 ");
        AppView.outputLine("AddTo = 6, AddFirst = 7, AddToLast = 8, Add = 9, ");
        AppView.outputLine("RemoveFrom = 10, RemoveFisrt = 11, RemoveLast = 12, RemoveAny = 13, RelpaceAt = 14, END_OF_RUN = 99 ");
        AppView.output("작업 번호를 입력 하세요: "); //todo

    }



    private void showStatics() {
        //todo
    }


    private MainMenu selectMenu() {//메뉴를 선택합니다.
        AppView.outputLine("");
        this.showList();
        this.showMenu();

        int selectedMenuNumber = AppView.inputInteger();
        MainMenu selectedMenuValue = MainMenu.value(selectedMenuNumber);

        //todo

        return null;
    }

    private void showList() {
        //todo
    }
}
