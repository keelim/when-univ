public class CellLocation { //마방진을 풀기위하여 location을 설정하는 클래스
    private static final int UndefinedIndex = -1;
    private int _row; //행
    private int _col;//열

    public CellLocation() { //기본 생성자 파라미터 없이 생성 시
        this.setCol(UndefinedIndex);
        this.setRow(UndefinedIndex);

    }

    public CellLocation(int givenRow, int givenCol) { //파라미터 전달 시
        this.setRow(givenRow);
        this.setCol(givenCol);

    }

    public int row() { //row Getter
        return this._row;

    }

    public void setRow(int newRow) { //row Setter
        this._row = newRow;

    }

    public int col() { //row Getter
        return this._col;

    }

    public void setCol(int newCol) { //row Setter
        this._col = newCol;

    }
}
