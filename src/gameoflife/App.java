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
    private Future<?> future;
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    final int width = 500;
    final int height = 500;

    final int rows = 20;
    final int cols = 20;

    BoardPanel boardPanel;
    Game game;

    public App() {
    }
    
    public void run(){
        frame = new JFrame("Game of Life");
        frame.getContentPane().setBackground(Color.MAGENTA);
        frame.setSize(new Dimension(width, height));
        frame.setResizable(false);
        
        playButton = new JButton("Play");
        playButton.addActionListener(e ->{
            if(playButton.getText().equals("Play")){
                this.play();
            }else{
                this.pause();
            }
        });
        
        frame.add(playButton, BorderLayout.PAGE_START);
        boardPanel = new BoardPanel(rows, cols);
        frame.add(boardPanel, BorderLayout.CENTER);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    
    private void play() {
        playButton.setText("Pause");
        boardPanel.setEnabled(false);
        Game game = new Game(new Board(rows, cols, boardPanel.getAliveCells()));
        future = executorService.scheduleAtFixedRate(() -> {
            ArrayList<Cell> changedCells = game.evolve();
            boardPanel.repaintGrid(changedCells);
        }, 300, 300, TimeUnit.MILLISECONDS);
    }
    

    private void pause() {
       playButton.setText("Play");
       boardPanel.setEnabled(true);
       
       future.cancel(true);
    }
}
