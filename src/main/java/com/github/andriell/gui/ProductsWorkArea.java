package com.github.andriell.gui;

import com.github.andriell.db.ProductDaoImpl;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Restrictions;
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
    ProductDaoImpl productDao;

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

    public void setProductDao(ProductDaoImpl productDao) {
        this.productDao = productDao;
    }

    class Filter extends JPanel {
        Filter rootPanel;
        Filter parent;
        JPanel northPanel;
        JPanel conditionPanel;
        JPanel filtersPanel;
        JButton groupButton;
        JButton conditionButton;
        JButton closeButton;
        JComboBox conditionComboBox;

        public Filter(Filter p) {
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
                    filtersPanel.add(new Filter(rootPanel));
                    filtersPanel.updateUI();
                }
            });

            conditionButton = new JButton("Условие");
            conditionButton.setFont(font);
            conditionButton.setMargin(insets);
            conditionButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    conditionPanel.add(new Condition(rootPanel));
                    conditionPanel.updateUI();
                }
            });

            conditionComboBox = new JComboBox();
            conditionComboBox.setFont(font);
            conditionComboBox.addItem("AND");
            conditionComboBox.addItem("OR");



            if (p == null) {
                closeButton = new JButton("Query");
                closeButton.setFont(font);
                closeButton.setMargin(insets);
                closeButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Filter filter = (Filter) filterPanel;
                        Junction junction = filter.render();
                        System.out.println(junction);
                    }
                });
            } else {
                closeButton = new JButton("X");
                closeButton.setFont(font);
                closeButton.setMargin(insets);
                closeButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        parent.filtersPanel.remove(rootPanel);
                        parent.filtersPanel.updateUI();
                    }
                });
            }

            northPanel.add(groupButton);
            northPanel.add(conditionButton);
            northPanel.add(conditionComboBox);
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

        public Junction render() {
            Junction junction;
            if ("AND".equals(conditionComboBox.getSelectedItem())) {
                junction = Restrictions.and();
            } else {
                junction = Restrictions.or();
            }

            Component[] components = filtersPanel.getComponents();
            if (components != null) {
                for (Component component: components) {
                    if (component instanceof Filter) {
                        Filter filter = (Filter) component;
                        junction.add(filter.render());
                    }
                }
            }
            components = conditionPanel.getComponents();
            if (components != null) {
                for (Component component: components) {
                    if (component instanceof Condition) {
                        Condition condition = (Condition) component;
                        condition.render(junction);
                    }
                }
            }
            return junction;
        }
    }

    class Condition extends JPanel {
        JPanel rootPanel;
        JComboBox column;
        JComboBox condition;
        JTextField value;
        JButton close;
        Filter parent;

        public Condition(Filter p) {
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
                    parent.conditionPanel.remove(rootPanel);
                    parent.conditionPanel.updateUI();
                }
            });
            add(close);
        }

        public void render(Junction junction) {
            junction.add(Restrictions.eq(column.getSelectedItem().toString(), value.getText()));
        }
    }
}
