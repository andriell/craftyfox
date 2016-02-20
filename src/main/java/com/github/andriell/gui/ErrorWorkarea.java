package com.github.andriell.gui;

import javax.swing.*;

/**
 * Created by Андрей on 20.02.2016.
 */
public class ErrorWorkArea implements WorkArea {
    private JTextArea errorTextArea;
    private JPanel rootPanel;
    private JTextField sizeTextField;
    private JButton refreshButton;
    private JCheckBox autoRefreshCheckBox;

    public JPanel getRootPanel() {
        return rootPanel;
    }

    @Override
    public String toString() {
        return "Ошибки";
    }
}
