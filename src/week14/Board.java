package week14;

public class Board {
    private static int EMPTY_CELL = -1;
    private int _order;
    private int[][] _cells;

    public Board(int givenOrder) { //파라미터로 차수가 전달되면 차수 해당하는 행과 열이 생성
        this.setOrder(givenOrder);
        this.setCells(new int[givenOrder][givenOrder]);

        for (int row = 0; row < givenOrder; row++) {
            for (int col = 0; col < givenOrder; col++) {
                this.setCellValue(row, col, Board.EMPTY_CELL); //기존 비어 있는 값은 -1 로 설정

            }

        }
    }


    public int order() { //마방진의 차수를 얻는다.
        return _order;

    }

    private void setOrder(int newOrder) { // order Setter
        this._order = newOrder;

    }

    private void setCells(int[][] newCells) { //order Getter
        this._cells = newCells;

    }

    public int cellValue(CellLocation location) {// 주어진 celllocation 의 cell 값을 얻음
        return this._cells[location.row()][location.col()];

    }

    public void setCellValue(CellLocation location, int value) { // 주어진 location 의 cell 에 주어진 value 를 넣음
        this._cells[location.row()][location.col()] = value;

    }

    private void setCellValue(int row, int col, int value) {// 주어진 위치 (row, col) 의 cell 에 주어진 값 value 넣음
        this._cells[row][col] = value;

    }

    public boolean cellIsEmpty(CellLocation location) { //비어 있는 셀인지를 확인
        return (this.cellValue(location) == EMPTY_CELL);

    }
}
