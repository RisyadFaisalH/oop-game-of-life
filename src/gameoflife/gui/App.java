/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife.gui;

import gameoflife.core.Board;
import gameoflife.core.Cell;
import gameoflife.core.Game;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.*;


public class App extends JFrame implements Runnable {

    private JButton playButton;
    private JButton resetButton;
    private Future<?> future;
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    JLabel generationLabel;

    private final int rows = 60;
    private final int cols = 60;
    private int numGeneration = 0;

    BoardPanel boardPanel;
    Game game;

    @Override
    public void run(){
        int width = 890;
        int height = 960;

        JFrame frame = new JFrame("Game of Life");
        frame.setSize(new Dimension(width, height));
        frame.setResizable(false);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(56, 64, 95));
        headerPanel.setBorder(new EmptyBorder(9, 6, 6, 6));
        headerPanel.setLayout(new GridLayout(1, 2, 5, 1));

        generationLabel = new JLabel("Generation: 0");
        generationLabel.setBorder(new EmptyBorder(4, 6, 4, 6));
        frame.add(generationLabel, BorderLayout.PAGE_END);

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
            numGeneration += 1;
            generationLabel.setText(String.format("Generation: %d", numGeneration));
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
        numGeneration = 0;
        generationLabel.setText(String.format("Generation: %d", 0));
    }
}
