package com.github.andriell.gui;

import org.springframework.beans.factory.InitializingBean;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Rybalko on 01.07.2016.
 */
public class ProductsWorkArea implements WorkArea, InitializingBean {
    private String name = "Продукты";
    private JPanel rootPanel;
    private JPanel paginationPanel;
    private JPanel dataPanel;
    private JButton addButton;
    private JPanel filterPane;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void afterPropertiesSet() throws Exception {
        addButton.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                filterPane.add(newFilter());
            }
        });
    }

    protected Component newFilter() {
        JPanel jPanel = new JPanel(new FlowLayout());
        jPanel.add(new JLabel("100500"));
        return jPanel;
    }
}
