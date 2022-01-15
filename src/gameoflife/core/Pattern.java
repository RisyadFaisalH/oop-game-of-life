/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife.core;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Hp
 */
public class Pattern {
    
    public static ArrayList<Point> createPattern(int x, int y, PatternStore pattern){
        if(pattern == PatternStore.BEACON){
            return new ArrayList<>(
                    Arrays.asList(
                            new Point(x, y),
                            new Point(1 + x, y),
                            new Point(x, 1 + y),
                            new Point(x + 2, y + 3),
                            new Point(x + 3, y + 3),
                            new Point(x + 3, y + 2)
                    )
            );
        }else if (pattern == PatternStore.BLINKER){
            return new ArrayList<>(
                    Arrays.asList(
                            new Point(x, y),
                            new Point(x + 1, y),
                            new Point(x + 2, y)
                    )
            );
        }else{
            return new ArrayList<>(
                    Arrays.asList(
                            new Point(x + 2, y),
                            new Point(x + 2, y + 1),
                            new Point(x + 2, y + 2),
                            new Point(x + 1, y + 2),
                            new Point(x, y + 1)
                    )
            );
        }
    }
}
