public class AppController { //완료
    public static final int MIN_ORDER = 3;   // 최솟값 선언
    public static final int MAX_ORDER = 99; //최댓값 선언

    private MagicSquare _magicSquare; //인스턴스 변수 생성

    public AppController() {
        this._magicSquare = new MagicSquare(AppController.MAX_ORDER); // 생성자 파라미터를 통하여 집어넣는다.
    }

    public void run() { // one public methods
        AppView.outputLine("<<< 마방진 풀이를 시작합니다 >>>");
        AppView.outputLine("");

        int currentOrder = AppView.inputOrder(); // 메시지를 내보내고 차수를 입력 받음
        OrderValidity currentValidity = OrderValidity.validityOf(currentOrder); //enum 클래스를 통하여 값 판별

        while (currentValidity != OrderValidity.EndOfRun) { // 차수가 음수이면 프로그램 종료

            if (currentValidity == OrderValidity.Valid) { // 차수가 유효한지 검사
                AppView.outputTitleWithOrder(currentOrder);
                Board solvedBoard = this._magicSquare.solve(currentOrder); // _magicSquare  객체에게 주어진 차수의 마방진을 풀도록 시킨다. // 결과로 마방진 판을 얻는다
                this.showBoard(solvedBoard); // 마방진을 화면에 보여준다

            } else {
                this.showOrderValidityErrorMessage(currentValidity); //에러 메시지 출력

            }
            currentOrder = AppView.inputOrder(); // 다음 마방진을 위해 차수를 입력 받음
            currentValidity = OrderValidity.validityOf(currentOrder); // 다음 마방진에서 사용되는 값 판별

        }
        AppView.outputLine("");
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
            AppView.outputRowNumber(row);

            for (int col = 0; col < board.order(); col++) {
                currentLoc.setRow(row);
                currentLoc.setCol(col);
                AppView.outputCellValue(board.cellValue(currentLoc));

            }
            AppView.outputLine("");
        }
    }

    private void showTitleForColumnIndexes(int order) { // board 에서 row, col 을 확인을 하여 출력 하는 함수
        AppView.output("      "); // 빈칸 6 개

        for (int col = 0; col < order; col++) {
            AppView.output(String.format("[%3d]", col));

        }

        AppView.outputLine("");
    }
}
