package com.github.andriell.gui;

import javax.swing.*;

/**
 * Created by Андрей on 20.02.2016.
 */
public class MainFrame {
    private JPanel rootPanel;
    private JTree navTree;
    private JPanel workPanel;

    public MainFrame() {
        JFrame frame = new JFrame("Crafty Fox");
        frame.setContentPane(rootPanel);
        //frame.setUndecorated(true); // Убрать заголовок и границы
        frame.pack();
        //frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
