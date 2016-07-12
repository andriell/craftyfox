package com.github.andriell.gui;

import java.awt.*;

/**
 * Created by Rybalko on 12.07.2016.
 */
public class GuiHelper {
    public static void gridFormatter(Container c, int[] start, int[] cols, int[] rows, Component[][] components) {
        int i = 0, j, x, y = start[1];
        for (int row:rows) {
            j = 0;
            x = start[0];
            for (int col:cols) {
                if (components[i] != null && components[i][j] != null) {
                    components[i][j].setLocation(x, y);
                    components[i][j].setSize(col, row);
                    c.add(components[i][j]);
                }
                x += col;
                j++;
            }
            y += row;
            i++;
        }
    }
}
