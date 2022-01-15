/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife.core;

import gameoflife.core.enums.State;

/**
 *
 * @author Hp
 */
public class Cell extends Point implements CellBehaviour {
    private State state;
    private int neighbor;
    
    public Cell(int x, int y){
        super(x,y);
        state = State.DEAD;
        neighbor = 0;
    }

    public State getState() {
        return state;
    }

    public int getNeighbor() {
        return neighbor;
    }

    public void subtractNeighbor(){
        neighbor = neighbor - 1;
    }

    public void addNeighbor(){
        neighbor = neighbor + 1;
    }

    public boolean isAlive(){
        return state == State.ALIVE;
    }

    public void kill(){
        state = State.DEAD;
    }

    public void revive(){
        state = State.ALIVE;
    }

    public boolean isNextAlive() {
        return (!isAlive() && getNeighbor() == 3)
                || (isAlive() && getNeighbor() >= 2 && getNeighbor() <= 3);
    }
}
