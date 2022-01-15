package gameoflife;

import javax.swing.*;

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

    private boolean isAliveState;
    
    public CellPanel() {
        this.isAliveState = false;
    }
    
    public CellPanel(boolean isAliveState) {
        this.isAliveState = isAliveState;
    }
    
    @Override
    public boolean isAlive() {
        return this.isAliveState;
    }

    @Override
    public void kill() {
        this.isAliveState = false;
    }

    @Override
    public void revive() {
        this.isAliveState = true;
    }
}
