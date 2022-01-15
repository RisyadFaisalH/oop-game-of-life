package gameoflife.core;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import gameoflife.core.Board;
import gameoflife.core.Cell;

import java.util.ArrayList;

/**
 *
 * @author milha
 */
public class Game {
    private Board board;

    public Game(Board board) {
        this.board = board;
    }
    
    public ArrayList<Cell> evolve() {
        ArrayList<Cell> changedCell = new ArrayList<>();
        Board nextBoard = new Board(board.getRows(), board.getCols());

        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getCols(); j++) {
                if (board.getCell(i, j).isNextAlive()) {
                    nextBoard.populate(i, j);
                } else {
                    nextBoard.unpopulate(i, j);
                }

                if (board.getCell(i, j).getState() != nextBoard.getCell(i, j).getState()) {
                    changedCell.add(nextBoard.getCell(i, j));
                }
            }
        }

        board = nextBoard;

        return changedCell;
    }
}
