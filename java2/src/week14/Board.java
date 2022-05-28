package week14;

public class Board {
    private static int EMPTY_CELL = -1;
    private int _order;
    private int[][] _cell;

    public Board(int givenOrder) { //파라미터로 차수가 전달되면 차수 해당하는 행과 열이 생성
        this.setOrder(givenOrder);
        this.setCells(new int[givenOrder][givenOrder]);

        for (int row = 0; row < givenOrder; row++) {
            for (int col = 0; col < givenOrder; col++) {
                this._cell[row][col] = Board.EMPTY_CELL;
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
        this._cell = newCells;

    }

    public int cellValue(CellLocation location) {// 주어진 celllocation 의 cell 값을 얻음
        return this._cell[location.row()][location.col()];

    }

    public void setCell(CellLocation location, int value) { // 주어진 location 의 cell 에 주어진 value 를 넣음
        this._cell[location.row()][location.col()] = value;

    }


    public boolean cellIsEmpty(CellLocation location) { //비어 있는 셀인지를 확인
        return (this.cellValue(location) == EMPTY_CELL);

    }
}
