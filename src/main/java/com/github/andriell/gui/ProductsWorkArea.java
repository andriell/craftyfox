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
    Font font = new Font("Segoe UI", Font.PLAIN, 10);
    Insets insets = new Insets(2, 2, 2, 2);
    StringBuilder query = new StringBuilder();

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

    public void afterPropertiesSet() throws Exception { }

    private void createUIComponents() {
        filterPanel = new Filter(null);
    }

    class Filter extends JPanel {
        JPanel rootPanel;
        JPanel parent;
        JPanel northPanel;
        JPanel conditionPanel;
        JPanel filtersPanel;
        JButton groupButton;
        JButton conditionButton;
        JButton closeButton;
        JComboBox conditionGroupBox;

        public Filter(JPanel p) {
            rootPanel = this;
            this.parent = p;
            setLayout(new BorderLayout());
            setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5), BorderFactory.createLineBorder(Color.LIGHT_GRAY)));

            northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            add(northPanel, BorderLayout.NORTH);
            groupButton = new JButton("Группа");
            groupButton.setFont(font);
            groupButton.setMargin(insets);
            groupButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    filtersPanel.add(new Filter(filtersPanel));
                    filtersPanel.updateUI();
                }
            });

            conditionButton = new JButton("Условие");
            conditionButton.setFont(font);
            conditionButton.setMargin(insets);
            conditionButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    conditionPanel.add(new Condition(conditionPanel));
                    conditionPanel.updateUI();
                }
            });

            conditionGroupBox = new JComboBox();
            conditionGroupBox.setFont(font);
            conditionGroupBox.addItem("AND");
            conditionGroupBox.addItem("OR");



            if (p == null) {
                closeButton = new JButton("Query");
                closeButton.setFont(font);
                closeButton.setMargin(insets);
                closeButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        query.setLength(0);
                        query.append("1 = 1 ");
                        Filter filter = (Filter) filterPanel;
                        filter.render();
                        System.out.println(query.toString());
                    }
                });
            } else {
                closeButton = new JButton("X");
                closeButton.setFont(font);
                closeButton.setMargin(insets);
                closeButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        parent.remove(rootPanel);
                        parent.updateUI();
                    }
                });
            }

            northPanel.add(groupButton);
            northPanel.add(conditionButton);
            northPanel.add(conditionGroupBox);
            northPanel.add(closeButton);

            JPanel centerPanel = new JPanel();
            centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));

            filtersPanel = new JPanel();
            filtersPanel.setLayout(new BoxLayout(filtersPanel, BoxLayout.PAGE_AXIS));
            centerPanel.add(filtersPanel);

            conditionPanel = new JPanel();
            conditionPanel.setLayout(new BoxLayout(conditionPanel, BoxLayout.PAGE_AXIS));
            centerPanel.add(conditionPanel);

            add(centerPanel, BorderLayout.CENTER);
        }

        public void render() {
            Component[] components = filtersPanel.getComponents();
            if (components != null) {
                for (Component component: components) {
                    if (component instanceof Filter) {
                        Filter filter = (Filter) component;
                        query.append(conditionGroupBox.getSelectedItem().toString());
                        query.append(" (");
                        filter.render();
                        query.append(") ");
                    }
                }
            }
            components = conditionPanel.getComponents();
            if (components != null) {
                for (Component component: components) {
                    if (component instanceof Condition) {
                        Condition condition = (Condition) component;
                        query.append(conditionGroupBox.getSelectedItem().toString());
                        query.append(" (");
                        condition.render();
                        query.append(") ");
                    }
                }
            }
        }
    }

    class Condition extends JPanel {
        JPanel rootPanel;
        JComboBox column;
        JComboBox condition;
        JTextField value;
        JButton close;
        JPanel parent;

        public Condition(JPanel p) {
            rootPanel = this;
            this.parent = p;

            setLayout(new FlowLayout(FlowLayout.LEFT));
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
            close.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    parent.remove(rootPanel);
                    parent.updateUI();
                }
            });
            add(close);
        }

        public void render() {
            query.append(column.getSelectedItem().toString());
            query.append(" ");
            query.append(condition.getSelectedItem().toString());
            query.append(" ");
            query.append(value.getText());
        }
    }
}
