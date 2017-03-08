package jackson.rick.draughts;

/**
 * Created by rickjackson on 3/7/17.
 */
public class Square {
    Node<Square> node;
    private final int row;
    private final int column;
    private Piece piece;
    private int index;
    
    public Square(int row, int column) {
        this.row = row;
        this.column = column;
        constructNode();
    }
    
    public Square(int row, int column, Piece piece) {
        this.row = row;
        this.column = column;
        this.piece = piece;
        constructNode();
    }
    
    public int getRow() {
        return row;
    }
    
    public int getColumn() {
        return column;
    }
    
    public int getIndex() {
        return row * column;
    }
    
    public int index() {
        return index(this.row, this.column);
    }
    
    int index(int row, int column) {
        return row % 2 == 0 ? row * column / 2 : (row * column + 1) / 2;
    }
    
    public int getArrayIndex() {
        return index() - 1;
    }
    
    public Piece getPiece() {
        return piece;
    }
    
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    
    void constructNode() {
        node.constructNode(this.row, this.column);
    }
    
    private static class Node<E extends Square> {
        E square;
        int upLeft;
        int upRight;
        int downRight;
        int downLeft;
        
        Node(E square) {
            this.square = square;
        }
    
        public void constructNode(int row, int column) {
            setUpLeft(row, column);
            setUpRight(row, column);
            setDownRight(row, column);
            setDownLeft(row, column);
        }
        
        void setUpLeft(int row, int column) {
            upLeft = square.index(row - 1, column - 1);
        }
        
        void setUpLeft(int[] a) {
            upLeft = square.index(a[0] - 1, a[1] - 1);
        }
        
        void setUpRight(int row, int column) {
            upRight = square.index(row - 1, column + 1);
        }
        
        void setUpRight(int[] a) {
            upRight = square.index(a[0] - 1, a[1] + 1);
        }
        
        void setDownRight(int row, int column) {
            downRight = square.index(row + 1, column - 1);
        }
        
        void setDownRight(int[] a) {
            downRight = square.index(a[0] + 1, a[1] + 1);
        }
        
        void setDownLeft(int row, int column) {
            downLeft = square.index(row + 1, column - 1);
        }
        
        void setDownLeft(int[] a) {
            downLeft = square.index(a[0] + 1, a[1] - 1);
        }
    }
}
