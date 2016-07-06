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

    private void createUIComponents() {
        filterPanel = new Filter(filterPanel);
    }

    class Filter extends JPanel {
        JPanel rootPanel;
        JPanel parent;
        JPanel northPanel;
        JPanel conditionPanel;
        JPanel groupPanel;
        JButton groupButton;
        JButton conditionButton;
        JButton closeButton;
        JComboBox conditionGroupBox;

        Font font = new Font("Segoe UI", Font.PLAIN, 10);
        Insets insets = new Insets(2, 2, 2, 2);

        public Filter(final JPanel parent) {
            rootPanel = this;
            this.parent = parent;
            setLayout(new BorderLayout());
            setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5), BorderFactory.createLineBorder(Color.LIGHT_GRAY)));

            northPanel = new JPanel(new FlowLayout());
            add(northPanel, BorderLayout.NORTH);
            groupButton = new JButton("Группа");
            groupButton.setFont(font);
            groupButton.setMargin(insets);
            groupButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    groupPanel.add(new Filter(groupPanel));
                    groupPanel.updateUI();
                }
            });

            conditionButton = new JButton("Условие");
            conditionButton.setFont(font);
            conditionButton.setMargin(insets);
            conditionButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    conditionPanel.add(new Condition());
                    conditionPanel.updateUI();
                }
            });

            conditionGroupBox = new JComboBox();
            conditionGroupBox.setFont(font);
            conditionGroupBox.addItem("AND");
            conditionGroupBox.addItem("OR");

            closeButton = new JButton("X");
            closeButton.setFont(font);
            closeButton.setMargin(insets);
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

            JPanel centerPanel = new JPanel();
            centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));

            groupPanel = new JPanel();
            groupPanel.setLayout(new BoxLayout(groupPanel, BoxLayout.PAGE_AXIS));
            centerPanel.add(groupPanel);

            conditionPanel = new JPanel();
            conditionPanel.setLayout(new BoxLayout(conditionPanel, BoxLayout.PAGE_AXIS));
            centerPanel.add(conditionPanel);

            add(centerPanel, BorderLayout.CENTER);
        }

        class Condition extends JPanel {
            JComboBox column;
            JComboBox condition;
            JTextField value;
            JButton close;

            public Condition() {
                setLayout(new FlowLayout());
                column = new JComboBox();
                column.setFont(font);
                column.addItem("Id");
                column.addItem("Id1");
                column.addItem("Id2");
                add(column);

                condition = new JComboBox();
                condition.setFont(font);
                condition.addItem("=");
                condition.addItem("!=");
                condition.addItem(">");
                condition.addItem(">=");
                condition.addItem("<");
                condition.addItem("<=");
                condition.addItem("LIKE");
                condition.addItem("IN");
                condition.addItem("RANGE");
                add(condition);

                value = new JTextField();
                value.setColumns(20);
                value.setFont(font);
                value.setMargin(insets);
                add(value);

                close = new JButton("X");
                close.setFont(font);
                close.setMargin(insets);
                add(close);
            }
        }
    }
}
