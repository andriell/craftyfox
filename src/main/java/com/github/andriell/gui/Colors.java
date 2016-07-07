package com.github.andriell.gui;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;

/**
 * Created by Rybalko on 07.07.2016.
 */
public class Colors {
    public static Color[] colors;
    public static CompoundBorder[] borders;
    private static int position = 0;

    static {
        colors = new Color[27];
        borders = new CompoundBorder[27];
        int i = 0;
        for (int r = 64; r < 256; r += 64) {
            for (int g = 64; g < 256; g += 64) {
                for (int b = 64; b < 256; b += 64) {
                    colors[i] = new Color(r, g, b);
                    borders[i] = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4), BorderFactory.createLineBorder(colors[i], 2));
                    i++;
                }
            }
        }
    }

    public static Color nextColor() {
        position++;
        if (position >= colors.length) {
            position = 0;
        }
        return colors[position];
    }

    public static CompoundBorder nextBorder() {
        position++;
        if (position >= borders.length) {
            position = 0;
        }
        return borders[position];
    }
}
