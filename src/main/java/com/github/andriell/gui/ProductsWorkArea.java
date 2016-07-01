package com.github.andriell.gui;

import com.jgoodies.forms.layout.FormLayout;
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
        JPanel centerPanel;
        JButton groupButton;
        JButton conditionButton;
        JButton closeButton;
        JComboBox conditionGroupBox;

        public Filter(final JPanel parent) {
            rootPanel = this;
            this.parent = parent;
            setLayout(new BorderLayout());
            setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5), BorderFactory.createLineBorder(Color.LIGHT_GRAY)));

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
            conditionButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    centerPanel.add(new Condition());
                }
            });
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

        class Condition extends JPanel {
            JComboBox column;
            JComboBox condition;
            JTextField value;
            JButton close;

            public Condition() {
                setLayout(new FormLayout());
                column = new JComboBox();
                column.addItem("Id");
                column.addItem("Id1");
                column.addItem("Id2");
                add(column);

                condition = new JComboBox();
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
                add(value);

                close = new JButton("X");
                add(close);
            }
        }
    }
}
