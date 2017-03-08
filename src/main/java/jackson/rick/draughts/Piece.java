package jackson.rick.draughts;

/**
 * Created by rickjackson on 3/7/17.
 */
public class Piece {
    private int type;
    private int row;
    private int column;
    
    public Piece(int type) {
        this.type = type;
    }
    
    public Piece(int type, int row, int column) {
        this.type = type;
        this.row = row;
        this.column = column;
    }
    
    public int type() {
        return type;
    }
    
    public void king() {
        if (Math.abs(type) == 1) {
            type *= 2;
        }
    }
    
    public boolean isKing() {
        return Math.abs(type) == 2;
    }
    
    public int getRow() {
        return row;
    }
    
    public int getColumn() {
        return column;
    }
    
    public void setRow(int row) {
        this.row = row;
    }
    
    public void setColumn(int column) {
        this.column = column;
    }
    
    private void move(int[] i) {
        this.move(i[0], i[1]);
    }
    
    private void move(int row, int column) {
        this.row += row;
        this.column += column;
    }
    
    public void move(int index) {
        row = index / 4;
        column = row % 2 == 0 ? index * 2 - 1 : index * 2;
    }
    
    public int index() {
        return row % 2 == 0 ? (row * column + 1) / 2 : row * column / 2;
    }
}
