/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.*;


public class App extends JFrame implements Runnable {

    private JFrame frame;
    private JButton playButton;
    private JButton resetButton;
    private JPanel headerPanel;
    private Future<?> future;
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    private final int rows = 20;
    private final int cols = 20;

    BoardPanel boardPanel;

    Game game;

    public App() {

    }
    
    public void run(){
        int width = 500;
        int height = 500;

        frame = new JFrame("Game of Life");
        frame.getContentPane().setBackground(Color.MAGENTA);
        frame.setSize(new Dimension(width, height));
        frame.setResizable(false);

        headerPanel = new JPanel();
        headerPanel.setLayout(new GridLayout(1, 2, 1, 1));

        playButton = new JButton("Play");
        playButton.addActionListener(e ->{
            if (playButton.getText().equals("Play")) {
                this.play();
            } else {
                this.pause();
            }
        });

        resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            this.reset();
        });

        headerPanel.add(playButton);
        headerPanel.add(resetButton);
        frame.add(headerPanel, BorderLayout.PAGE_START);

        boardPanel = new BoardPanel(rows, cols);
        frame.add(boardPanel, BorderLayout.CENTER);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    private void play() {
        playButton.setText("Pause");
        boardPanel.setEnabled(false);
        resetButton.setEnabled(false);
        game = new Game(new Board(rows, cols, boardPanel.getAliveCells()));
        future = executorService.scheduleAtFixedRate(() -> {
            ArrayList<Cell> changedCells = game.evolve();
            boardPanel.repaintGrid(changedCells);
        }, 0, 300, TimeUnit.MILLISECONDS);
    }

    private void pause() {
       playButton.setText("Play");
       boardPanel.setEnabled(true);
       resetButton.setEnabled(true);
       future.cancel(true);
    }

    private void reset() {
        boardPanel.resetGrid();
    }
}
