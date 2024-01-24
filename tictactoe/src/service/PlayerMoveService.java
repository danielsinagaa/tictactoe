package service;

import model.Board;
import util.Validator;
import java.util.Scanner;

public class PlayerMoveService implements MoveService{
    public PlayerMoveService() {
    }

    @Override
    public Board move(Board board, char symbol){
        Validator validator = new Validator();
        Scanner scanner = new Scanner(System.in);
        int row;
        int col;
        do {
            System.out.println("Player " + symbol + ", enter your move (row and column, separated by space): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
        } while (!validator.isMoveValid(board, board.getSize(), row, col));
        char[][] boardRes = board.getBoard();
        boardRes[row][col] = symbol;
        board.setBoard(boardRes);
        return board;
    }
}
