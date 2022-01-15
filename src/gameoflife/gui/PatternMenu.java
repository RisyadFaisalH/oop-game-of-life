package gameoflife.gui;

import gameoflife.core.Pattern;
import gameoflife.core.enums.PatternStore;
import gameoflife.core.Point;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PatternMenu extends JPopupMenu {
    JMenuItem itemGlider, itemBlinker, itemBeacon, itemGliderGun;
    CellPanel[][] cellPanels;
    int x, y;
    int rows, cols;

    public PatternMenu(CellPanel[][] cellPanels, int x, int y, int rows, int cols) {
        this.cellPanels = cellPanels;
        this.x = x;
        this.y = y;
        this.rows = rows;
        this.cols = cols;

        itemGlider = new JMenuItem("Glider");
        addEventListener(itemGlider, PatternStore.GLIDER);
        add(itemGlider);

        itemBlinker = new JMenuItem("Blinker");
        addEventListener(itemBlinker, PatternStore.BLINKER);
        add(itemBlinker);

        itemBeacon = new JMenuItem("Beacon");
        addEventListener(itemBeacon, PatternStore.BEACON);
        add(itemBeacon);

        itemGliderGun = new JMenuItem("Glider Gun");
        addEventListener(itemGliderGun, PatternStore.GLIDER_GUN);
        add(itemGliderGun);
    }

    private void addEventListener(JMenuItem item, PatternStore pattern) {
        item.addActionListener(e -> {
            ArrayList<Point> points = Pattern.createPattern(y, x, pattern);
            for (Point point: points) {
                cellPanels[(point.getY() + rows) % rows][ (point.getX() + cols) % cols].revive();
            }
        });
    }
}
