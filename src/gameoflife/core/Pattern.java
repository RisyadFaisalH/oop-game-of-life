/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife.core;

import gameoflife.core.enums.PatternStore;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Hp
 */
public class Pattern {
    
    public static ArrayList<Point> createPattern(int x, int y, PatternStore pattern){
        if (pattern == PatternStore.BEACON) {
            return new ArrayList<>(
                    Arrays.asList(
                            new Point(x, y),
                            new Point(x + 1, y),
                            new Point(x, y + 1),
                            new Point(x + 2, y + 3),
                            new Point(x + 3, y + 3),
                            new Point(x + 3, y + 2)
                    ));
        } else if (pattern == PatternStore.BLINKER) {
            return new ArrayList<>(
                    Arrays.asList(
                            new Point(x, y),
                            new Point(x + 1, y),
                            new Point(x + 2, y)
                    ));
        } else if (pattern == PatternStore.GLIDER_GUN) {
            return new ArrayList<>(
                    Arrays.asList(
                            new Point(x + 1,y + 6),
                            new Point(x + 1,y + 5),
                            new Point(x + 2, y + 5),
                            new Point(x + 2,y + 6),
                            new Point(x + 11, y + 5),
                            new Point(x + 11, y + 6),
                            new Point(x + 11, y + 7),
                            new Point(x + 12, y + 4),
                            new Point(x + 12, y + 8),
                            new Point(x + 13, y + 3),
                            new Point(x + 13, y + 9),
                            new Point(x + 14, y + 3),
                            new Point(x + 14, y + 9),
                            new Point(x + 15, y + 6),
                            new Point(x + 16, y + 4),
                            new Point(x + 16, y + 8),
                            new Point(x + 17, y + 5),
                            new Point(x + 17, y + 6),
                            new Point(x + 17, y + 7),
                            new Point(x + 18, y + 6),
                            new Point(x + 21, y + 3),
                            new Point(x + 21, y + 4),
                            new Point(x + 21, y + 5),
                            new Point(x + 22, y + 3),
                            new Point(x + 22, y + 4),
                            new Point(x + 22, y + 5),
                            new Point(x + 23, y + 2),
                            new Point(x + 23, y + 6),
                            new Point(x + 25, y + 1),
                            new Point(x + 25, y + 2),
                            new Point(x + 25, y + 6),
                            new Point(x + 25, y + 7),
                            new Point(x + 35, y + 3),
                            new Point(x + 35, y + 4),
                            new Point(x + 36, y + 3),
                            new Point(x + 36, y + 4)
                    ));
        } else {
            return new ArrayList<>(
                    Arrays.asList(
                            new Point(x + 2, y),
                            new Point(x + 2, y + 1),
                            new Point(x + 2, y + 2),
                            new Point(x + 1, y + 2),
                            new Point(x, y + 1)
                    ));
        }
    }
}
