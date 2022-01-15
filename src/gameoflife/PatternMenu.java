package gameoflife;

import javax.swing.*;
import java.util.ArrayList;

public class PatternMenu extends JPopupMenu {
    JMenuItem itemGlider, itemBlinker, itemBeacon;
    CellPanel[][] cellPanels;
    int x, y;

    public PatternMenu(CellPanel[][] cellPanels, int x, int y) {
        this.cellPanels = cellPanels;
        this.x = x;
        this.y = y;

        itemGlider = new JMenuItem("Glider");
        addEventListener(itemGlider, PatternStore.GLIDER);
        add(itemGlider);

        itemBlinker = new JMenuItem("Blinker");
        addEventListener(itemBlinker, PatternStore.BLINKER);
        add(itemBlinker);

        itemBeacon = new JMenuItem("Beacon");
        addEventListener(itemBeacon, PatternStore.BEACON);
        add(itemBeacon);
    }

    private void addEventListener(JMenuItem item, PatternStore pattern) {
        item.addActionListener(e -> {
            ArrayList<Point> points = Pattern.createPattern(x, y, pattern);
            for (Point point: points) {
                cellPanels[point.getX()][point.getY()].revive();
            }
        });
    }
}
