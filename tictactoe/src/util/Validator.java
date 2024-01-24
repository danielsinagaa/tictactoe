package util;

import model.Board;

public class Validator {

    public boolean isMoveValid(Board board, int size, int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size && board.getBoard()[row][col] == '-';
    }

    public boolean isGameOver(Board board) {
        return isPlayerWinner(board, 'X') || isPlayerWinner(board, 'O') || isBoardFull(board);
    }

    private boolean isBoardFull(Board board) {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getBoard()[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPlayerWinner(Board board, char player) {

        for (int i = 0; i < board.getSize(); i++) {
            if (board.getBoard()[i][0] == player && checkRow(board, i, player)) {
                return true;
            }
            if (board.getBoard()[0][i] == player && checkColumn(board, i, player)) {
                return true;
            }
        }

        if (board.getBoard()[0][0] == player && checkDiagonal(board, 1, 1, player)) {
            return true;
        }
        if (board.getBoard()[0][board.getSize() - 1] == player && checkDiagonal(board, 1, -1, player)) {
            return true;
        }

        return false;
    }

    private boolean checkRow(Board board, int row, char player) {
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getBoard()[row][i] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(Board board, int col, char player) {
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getBoard()[i][col] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal(Board board ,int rowIncrement, int colIncrement, char player) {
        for (int i = 1; i < board.getSize(); i++) {
            if (board.getBoard()[i * rowIncrement][i * colIncrement] != player) {
                return false;
            }
        }
        return true;
    }
}
