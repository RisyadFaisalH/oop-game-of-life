package gameoflife.gui;

import gameoflife.core.CellBehaviour;
import gameoflife.core.enums.State;

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
        setBackground(new Color(238, 238, 238));
    }

    @Override
    public void revive() {
        this.state = State.ALIVE;
        setBackground(new Color(29, 35, 53));
    }
}
