package com.github.andriell.gui;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.util.Enumeration;

/**
 * Created by Rybalko on 01.08.2016.
 */
public class CustomGUI {
    public static void main(String[] args) {
        CustomGUI gui = new CustomGUI();
        gui.go();
        gui.gui();
    }

    public void go() {
        Colors colors = new Colors();
        Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            System.out.print(key);
            System.out.print("\t");
            System.out.print(value);
            if (value instanceof ColorUIResource) {
                Color color = colors.nextColor();
                UIManager.put(key, color);
                System.out.print("\t");
                System.out.print(color);
            }
            System.out.println();
        }
    }

    public void gui() {
        JFrame frame = new JFrame();
        JPanel body = new JPanel();
        JScrollPane scrollPane = new JScrollPane(body);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(50, 30, 300, 50);

        body.add(new JButton("Hello"));

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("tab1", new JPanel());
        tabbedPane.add("tab2", new JPanel());
        body.add(tabbedPane);

        frame.setContentPane(scrollPane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    class Colors {
        public Color[] colors;
        private int position = 0;

        Colors() {
            colors = new Color[2700];
            int i = 0;
            for (int r = 64; r < 256; r += 16) {
                for (int g = 64; g < 256; g += 16) {
                    for (int b = 64; b < 256; b += 16) {
                        colors[i] = new Color(r, g, b);
                        i++;
                    }
                }
            }
        }

        public Color nextColor() {
            position++;
            if (position >= colors.length) {
                position = 0;
            }
            return colors[position];
        }
    }
}
