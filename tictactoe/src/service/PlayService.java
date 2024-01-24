package service;

import model.Board;
import util.Symbol;
import util.Validator;

import java.util.Scanner;

public class PlayService {

    public PlayService() {
    }

    public void execute(){
        CompMoveService compMoveService = new CompMoveService();
        PlayerMoveService playerMoveService = new PlayerMoveService();
        Validator validator = new Validator();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the Tic-Tac-Toe board (3, 5, 7, 9, etc.) = ");
        int size = scanner.nextInt();
        Board board = initializeBoard(new Board(size));
        initializeBoard(board);
        char currentPlayer = 'X';

        System.out.println("GAME OVER? = " + validator.isGameOver(board));
        while (!validator.isGameOver(board)) {
            printBoard(board);
            if (currentPlayer == 'X') {
                playerMoveService.move(board, Symbol.X.getValue());
            } else {
                compMoveService.move(board, Symbol.O.getValue());
            }
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        printBoard(board);
        if (validator.isPlayerWinner(board, 'X')) {
            System.out.println("Player X wins!");
        } else if (validator.isPlayerWinner(board, 'O')) {
            System.out.println("Player O wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    private void printBoard(Board board) {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                System.out.print(board.getBoard()[i][j] + " ");
            }
            System.out.println();
        }
    }

    private Board initializeBoard(Board board) {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                board.getBoard()[i][j] = '-';
            }
        }
        return board;
    }
}
