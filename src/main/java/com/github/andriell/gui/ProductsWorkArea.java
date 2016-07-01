package com.github.andriell.gui;

import javax.swing.*;

/**
 * Created by Rybalko on 01.07.2016.
 */
public class ProductsWorkArea implements WorkArea {
    private String name = "Продукты";
    private JPanel rootPanel;
    private JPanel paginationPanel;
    private JPanel dataPanel;
    private JButton addButton;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
