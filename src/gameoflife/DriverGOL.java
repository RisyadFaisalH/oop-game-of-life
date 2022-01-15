/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import javax.swing.*;

public class DriverGOL {
    public static void main(String[] args){
        BoardPanel boardPanel = new BoardPanel(40,40);
        Board board = new Board(40,40, boardPanel.getAliveCells());
        Game game = new Game(board);
        SwingUtilities.invokeLater(new App(game, boardPanel));
    }
}
