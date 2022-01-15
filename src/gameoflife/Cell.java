/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

/**
 *
 * @author Hp
 */
public class Cell {
    private State state;
    private int neighbor;

    /**
     * @return the state
     */
    public State getState() {
        return state;
    }

    /**
     * @return the neighbor
     */
    public int getNeighbor() {
        return neighbor;
    }

    /**
     * @param neighbor the neighbor to set
     */
    public void setNeighbor(int neighbor) {
        this.neighbor = neighbor;
    }
}
