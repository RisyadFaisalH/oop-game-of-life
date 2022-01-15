package gameoflife;

import javax.swing.*;
import java.awt.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author milha
 */
public class CellPanel extends JPanel implements CellBehaviour {

    private State state;
    
    public CellPanel() {
        this.state = State.DEAD;
    }

    @Override
    public boolean isAlive() {
        return this.state == State.ALIVE;
    }

    @Override
    public void kill() {
        this.state = State.DEAD;
        setBackground(Color.DARK_GRAY);
    }

    @Override
    public void revive() {
        this.state = State.ALIVE;
        setBackground(Color.CYAN);
    }
}
