package week14;

public class MagicSquare {
    private static final int DRFAULT_MAX_ORDER = 99;
    private int _maxOrder;
    private int _order;
    private Board _board;

    public int maxOrder() { //maxOrder Getter
        return _maxOrder;

    }

    private void setMaxOrder(int newMaxOrder) { //maxOrder Setter
        this._maxOrder = newMaxOrder;

    }

    public MagicSquare() { // default constructor
        this.setMaxOrder(DRFAULT_MAX_ORDER);
        this._order = 3;
        this._board = null;
    }

    public MagicSquare(int givenMaxOrder) {
        this.setMaxOrder(givenMaxOrder);
        this._order = 3;
        this._board = null;
    }

    public OrderValidity checkOrderValidity(int order) {
        if (order < 3) {
            return OrderValidity.TooSmall;
        } else if (order > this._maxOrder) {
            return OrderValidity.TooLarge;
        } else if ((order % 2) == 0) {
            return OrderValidity.NotOddNumber;
        } else {
            return OrderValidity.Valid;
        }
    }


    public Board solve(int order) { //마방진을 푸는 메소드
        this._order = order;
        if (this.checkOrderValidity(this._order)!=OrderValidity.Valid) { //enum 클래스에서 값을 확인
            return null;

        } else {
            Board board = new Board(this._order); // 차수와 함께 Board 객체 생성자를 call 하여, Board 객체를 생성한다.
            CellLocation currentLoc = new CellLocation(0, order / 2); // 출발 위치 (보드의 맨 윗줄 한 가운데)를 현재의 위치로 설정한다.
            CellLocation nextLoc = new CellLocation(); //다음 위치에 해당하는 객체 생성

            board.setCell(currentLoc, 1); // 보드의 <출발 위치>에 1 을 채운다.
            int lastNUmber = order * order; //입력 값이 3인 경우 9를 만들기 위해서

            for (int number = 2; number <= lastNUmber; number++) {
                // 단계 1: <현재 위치>로부터 <다음 위치>인 “오른쪽 위” 위치를 계산한다
                nextLoc.setCol(currentLoc.col() + 1); //nextLoc 열을 오른쪽으로 이동
                nextLoc.setRow(currentLoc.row() - 1); // nextLoc 행을 위로 이동

                if (nextLoc.row() < 0) {//[anOrder, anOrder] 범위에 있는지를 판단 하여 원통처럼 붙어 있는 것처럼 다음을 움직임
                    nextLoc.setRow(order - 1);

                }
                if (nextLoc.col() > order - 1) {//[anOrder, anOrder] 범위에 있는지를 판단 하여 원통처럼 붙어 있는 것처럼 다음을 움직임
                    nextLoc.setCol(0);

                }

                // 단계 2: <다음 위치> 가 채워져 있으면
                // <다음 위치>를 <현재 위치>의 바로 한 줄 아래 칸 위치로 수정한다.

                if (!board.cellIsEmpty(nextLoc)) {
                    nextLoc.setCol(currentLoc.col());
                    nextLoc.setRow(currentLoc.row());
                    nextLoc.setRow(nextLoc.row() + 1);

                }
                // 단계 3: <다음 위치>를 새로운 <현재 위치>로 한다.
                currentLoc.setRow(nextLoc.row());
                currentLoc.setCol(nextLoc.col());
                // 단계 4: 새로운 <현재 위치>에 number 값을 넣는다.
                board.setCell(currentLoc, number);

            }

            return board;
        }
    }
}


