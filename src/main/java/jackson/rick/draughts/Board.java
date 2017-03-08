package jackson.rick.draughts;

import java.util.Map;

/**
 * Created by rickjackson on 3/7/17.
 */
public class Board {
    private Square[] board = new Square[32];
    
    public Board() {
        constructBoard();
        constructNodes();
    }
    
    private void constructBoard() {
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if (i % 2 == 0 || j % 2 == 0) {
                    if (i * j <= 12) {
                        board[i * j - 1] = new Square(i, j, new Piece(1));
                    } else if (i * j <= 20) {
                        board[i * j - 1] = new Square(i, j, new Piece(0));
                    } else {
                        board[i * j - 1] = new Square(i, j, new Piece(-1));
                    }
                }
            }
        }
    }
    
    private void constructNodes() {
        for (int i = 0; i < board.length; i++) {
            board[i].constructNode();
        }
    }
}
