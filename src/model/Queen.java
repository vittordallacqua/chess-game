// ChessGame/src/model/Queen.java
package model;

public class Queen extends ChessPiece {

    public Queen(boolean white) {
        super(white);
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, ChessPiece[][] board) {
        boolean isDiagonal = Math.abs(toRow - fromRow) == Math.abs(toCol - fromCol);
        boolean isStraight = (fromRow == toRow || fromCol == toCol);

        if (isDiagonal || isStraight) {
            if (!hasObstacle(fromRow, fromCol, toRow, toCol, board)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasObstacle(int fromRow, int fromCol, int toRow, int toCol, ChessPiece[][] board) {
        int rowStep = Integer.compare(toRow, fromRow);
        int colStep = Integer.compare(toCol, fromCol);
        int r = fromRow + rowStep, c = fromCol + colStep;

        while (r != toRow || c != toCol) {
            if (board[r][c] != null)
                return true;
            r += rowStep;
            c += colStep;
        }
        return false;
    }

    @Override
    public String getImagePath() {
        return white ? "/resources/images/white-queen.png" : "/resources/images/black-queen.png";
    }
}