package service;

import model.Board;

public interface MoveService {
    public Board move(Board board, char currentPlayer);
}
