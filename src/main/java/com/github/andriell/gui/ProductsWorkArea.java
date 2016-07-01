package com.github.andriell.gui;

import org.springframework.beans.factory.InitializingBean;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Rybalko on 01.07.2016.
 */
public class ProductsWorkArea implements WorkArea, InitializingBean {
    private String name = "Продукты";
    private JPanel rootPanel;
    private JPanel paginationPanel;
    private JPanel dataPanel;
    private JPanel filterPanel;

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

    }

    protected Component newFilter() {
        JPanel jPanel = new JPanel(new BorderLayout());

        jPanel.add(new JLabel("100500100500100500100500"));
        return jPanel;
    }

    private void createUIComponents() {
        filterPanel = new Filter(filterPanel);
    }

    class Filter extends JPanel {
        JPanel rootPanel;
        JPanel parent;
        JPanel northPanel;
        JPanel centerPanel;
        JButton groupButton;
        JButton conditionButton;
        JButton closeButton;
        JComboBox conditionGroupBox;

        public Filter(final JPanel parent) {
            rootPanel = this;
            this.parent = parent;
            setLayout(new BorderLayout());

            northPanel = new JPanel(new FlowLayout());
            add(northPanel, BorderLayout.NORTH);
            groupButton = new JButton("Группа");
            groupButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    centerPanel.add(new Filter(rootPanel));
                    centerPanel.updateUI();
                }
            });
            conditionButton = new JButton("Условие");
            conditionGroupBox = new JComboBox();
            conditionGroupBox.addItem("AND");
            conditionGroupBox.addItem("OR");
            closeButton = new JButton("X");
            closeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    parent.remove(rootPanel);
                    parent.updateUI();
                }
            });

            northPanel.add(groupButton);
            northPanel.add(conditionButton);
            northPanel.add(conditionGroupBox);
            northPanel.add(closeButton);

            centerPanel = new JPanel(new FlowLayout());
            centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
            add(centerPanel, BorderLayout.CENTER);
        }
    }
}
