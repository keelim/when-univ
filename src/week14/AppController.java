package week14;

public class AppController {
    public static final int MIN_ORDER = 3;   // 최솟값 선언
    public static final int MAX_ORDER = 99; //최댓값 선언
    private Board _board;
    private MagicSquare _magicSquare; //인스턴스 변수 생성
    private AppView _appView;

    public AppController() {
        this._appView = new AppView();
        this._board = null;
        this._magicSquare = new MagicSquare(); // 생성자 파라미터를 통하여 집어넣는다.
    }

    public void run() { // one public methods
        AppView.outputLine("<<< 마방진 풀이를 시작합니다 >>>");
        OrderValidity currentOrderValidity;

        int order = this.inputOrder(); // 메시지를 내보내고 차수를 입력 받음 //

        while (order >= 0) { // 차수가 음수이면 프로그램 종료
            currentOrderValidity = this._magicSquare.checkOrderValidity(order);
            if (currentOrderValidity == OrderValidity.Valid) { // 차수가 유효한지 검사
                this.showTitleWithOrder(order);
                this._board = this._magicSquare.solve(order);
                this.showBoard(this._board);


            } else {
                this.showOrderValidityErrorMessage(currentOrderValidity); //에러 메시지 출력
            }
            order = this.inputOrder(); // 다음 마방진을 위해 차수를 입력 받음
        }
        AppView.outputLine("<<< 마방진 풀이를 종료합니다 >>>");
    }


    private void showOrderValidityErrorMessage(OrderValidity orderValidity) { // currentValidity 가 Valid 가 아닌 다른 값일 때의 오류 메시지를 만든다. .

        switch (orderValidity) {
            case TooSmall:
                AppView.outputLine(
                        "[오류] 차수가 너무 작습니다. " + AppController.MIN_ORDER +
                                "보다 크거나 같아야 합니다. "
                );
                break;

            case TooLarge:
                AppView.outputLine(
                        "[오류] 차수가 너무 큽니다.  " + AppController.MAX_ORDER +
                                "보다 작거나 같아야 합니다. "
                );
                break;

            case NotOddNumber:
                AppView.outputLine("[오류] 차수가 짝수 입니다. . 홀수 이어야 합니다. ");
                break;

            default:
                break;

        }
    }

    private void showBoard(Board board) { // 전체 판을 출력하는 메소드
        CellLocation currentLoc = new CellLocation();
        this.showTitleForColumnIndexes(board.order());

        for (int row = 0; row < board.order(); row++) {
            AppView.showRowNumber(row);

            for (int col = 0; col < board.order(); col++) {
                currentLoc.setRow(row);
                currentLoc.setCol(col);
                this.showCellValue(board.cellValue(currentLoc));

            }
            AppView.outputLine("");
        }
    }

    private void showTitleForColumnIndexes(int order) { // board 에서 row, col 을 확인을 하여 출력 하는 함수
        this._appView.output("      ");

        for (int col = 0; col < order; col++) {
            this._appView.output(String.format("[%2d] ", col));
        }

        AppView.outputLine("");
    }

    public  void showTitleWithOrder(int order) {
        System.out.println("!Magic Square Board Order: " + order);
    }

    private void showRowNumber(int number){
        this._appView.outputLine("[%2d]", number);

    }

    private void showCellValue(int value){
        this._appView.outputLine("%5d", value);
    }

    private int inputOrder(){
        this._appView.output("\n마방진 차수를 입력하시오(음수를 입력하면 종료합니다. ):");
        return  this._appView.inputInt();
    }
}
