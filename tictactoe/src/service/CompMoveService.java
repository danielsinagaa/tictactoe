package service;

import model.Board;
import util.Validator;

public class CompMoveService implements MoveService{

    public CompMoveService() {
    }

    @Override
    public Board move(Board board, char symbol) {
        Validator validator = new Validator();
        int row;
        int col;
        do {
            row = (int) (Math.random() * board.getSize());
            col = (int) (Math.random() * board.getSize());
        } while (!validator.isMoveValid(board, board.getSize(), row, col));
        char[][] boardRes = board.getBoard();
        boardRes[row][col] = symbol;
        board.setBoard(boardRes);
        System.out.println("COMPUTER ENTER MOVE ROW " + row + " AND COL " + col);
        return board;
    }
}
