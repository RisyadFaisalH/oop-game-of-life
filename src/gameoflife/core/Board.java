package gameoflife.core;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author milha
 */
public class Board {
    
    private final Cell[][] cells;

    private final Point[] moves = {
            new Point(0, 1),
            new Point(1, 1),
            new Point(1, 0),
            new Point(1, -1),
            new Point(0, -1),
            new Point(-1, 1),
            new Point(-1, 0),
            new Point(-1, -1)
    };

    private final int rows;
    private final int cols;

    public Board(int x, int y) {
        this.rows = x;
        this.cols = y;
        this.cells = new Cell[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                this.cells[i][j] = new Cell(i, j);
            }
        }
    }
    
    public Board(int x, int y, ArrayList<Point> aliveCells) {
        this.rows = x;
        this.cols = y;
        this.cells = new Cell[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                this.cells[i][j] = new Cell(i, j);
            }
        }

        for (Point aliveCell : aliveCells) {
            populate(aliveCell.getX(), aliveCell.getY());
        }
    }
    
    public void populate(int x, int y) {
        if(cells[x][y].isAlive()) return;

        cells[x][y].revive();
        for (Point move: moves) {
            int changedX = (((x + move.getX()) + this.rows) % this.rows);
            int changedY = (((y + move.getY()) + this.cols) % this.cols);
            cells[changedX][changedY].addNeighbor();
        }
    }
    
    public void unpopulate(int x, int y) {
        if(!cells[x][y].isAlive()) return;

        cells[x][y].kill();
        for (Point move: moves) {
            int changedX = (((x + move.getX()) + this.rows) % this.rows);
            int changedY = (((y + move.getY()) + this.cols) % this.cols);
            cells[changedX][changedY].subtractNeighbor();
        }
    }
    
    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
