package jackson.rick.model;

/**
 * Created by rickjackson on 3/6/17.
 */
public class Board {
    private Position[][] board = new Position[4][4];
    
    public Board() {
        constructBoard();
    }
    
    void constructBoard() {
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                board[x][y] = new Position(x, y);
            }
        }
    }
}
