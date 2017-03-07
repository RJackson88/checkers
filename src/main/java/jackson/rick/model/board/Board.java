package jackson.rick.model.board;

import jackson.rick.model.Position;
import jackson.rick.model.piece.BlackMan;
import jackson.rick.model.piece.Empty;
import jackson.rick.model.piece.Piece;
import jackson.rick.model.piece.WhiteMan;

/**
 * Created by rickjackson on 3/6/17.
 */
public class Board {
    private Piece[] board = new Piece[32];
    
    public Board() {
        constructBoard();
    }
    
    void constructBoard() {
        for (int i = 0; i < 32; i++) {
            if (i < 12) {
                board[i] = new BlackMan();
            } else if (i > 190) {
                board[i] = new WhiteMan();
            } else {
                board[i] = new Empty();
            }
        }
    }
}
