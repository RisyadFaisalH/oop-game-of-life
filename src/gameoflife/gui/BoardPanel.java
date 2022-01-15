package gameoflife.gui;

import gameoflife.core.Cell;
import gameoflife.core.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author milha
 */
public class BoardPanel extends JPanel{
    CellPanel[][] cellPanel;
    
    int rows;
    int cols;
    
    public BoardPanel(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        
        GridLayout layout = new GridLayout(rows, cols, 1, 1);
        setLayout(layout);
        
        this.cellPanel = new CellPanel[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                cellPanel[i][j] = new CellPanel();
                addEventListener(i, j);
                add(cellPanel[i][j]);
            }
        }

        setBackground(new Color(56, 64, 95));
        setVisible(true);
    }

    public void repaintGrid(ArrayList<Cell> changedCells) {
        for (Cell changedCell: changedCells) {
            if (changedCell.isAlive()) {
                cellPanel[changedCell.getX()][changedCell.getY()].revive();
            } else {
                cellPanel[changedCell.getX()][changedCell.getY()].kill();
            }
        }
        repaint();
    }

    public void resetGrid() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                cellPanel[i][j].kill();
            }
        }
    }

    public ArrayList<Point> getAliveCells() {
        ArrayList<Point> aliveCells = new ArrayList<>();
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                if(cellPanel[i][j].isAlive()) {
                    aliveCells.add(new Point(i, j));
                }
            }
        }

        return aliveCells;
    }

    private void handleSingleClick(CellPanel panel) {
        if (panel.isAlive()) {
            panel.kill();
        } else {
            panel.revive();
        }
    }

    private void addEventListener(int x, int y){
        cellPanel[x][y].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if(isEnabled()) {
                    if (e.isPopupTrigger()) {
                        PatternMenu menu = new PatternMenu(cellPanel, x, y, rows, cols);
                        menu.show(e.getComponent(), e.getX(), e.getY());
                    } else {
                        handleSingleClick(cellPanel[x][y]);
                    }
                }
            }
        });
    }
}
