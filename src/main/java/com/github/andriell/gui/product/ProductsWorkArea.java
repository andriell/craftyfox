package com.github.andriell.gui.product;

import com.github.andriell.db.Product;
import com.github.andriell.db.ProductDao;
import com.github.andriell.db.ProductProperty;
import com.github.andriell.gui.WorkArea;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.InitializingBean;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * Created by Rybalko on 01.07.2016.
 */
public class ProductsWorkArea implements WorkArea, InitializingBean {
    private static final Log LOG = LogFactory.getLog(ProductsWorkArea.class);

    private static final DateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    Font font = new Font("Segoe UI", Font.PLAIN, 10);
    Insets insets = new Insets(2, 2, 2, 2);
    ProductDao productDao;
    WindowPrice windowPrice = new WindowPrice(null);
    GridBagConstraints gridBagConstraints;

    private String name = "Продукты";
    private JPanel rootPanel;
    private JPanel paginationPanel;
    private JPanel dataPanel;
    private JPanel filterPanel;
    private JTextField pageTextField;
    private JTextField inPageTextField;
    private JLabel totalLabel;
    private JButton nextButton;
    private JButton prevButton;
    private JButton queryButton;
    private Filter filter;

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
        filter = new Filter(null);
        filterPanel.add(filter, BorderLayout.CENTER);
        dataPanel.setLayout(new GridBagLayout());

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.gridx = 0;

        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int v = Integer.parseInt(pageTextField.getText());
                pageTextField.setText(Integer.toString(v + 1));
                queryButton.doClick();
            }
        });

        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int v = Integer.parseInt(pageTextField.getText());
                if (v <= 0) {
                    return;
                }
                pageTextField.setText(Integer.toString(v - 1));
                queryButton.doClick();
            }
        });
    }

    private void createUIComponents() {

    }

    public void setProductDao(ProductDao productDao) {
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
            setBorder(Colors.nextBorder());

            northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            //northPanel.setBorder(border);
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
                queryButton = closeButton = new JButton("Query");
                closeButton.setFont(font);
                closeButton.setMargin(insets);
                closeButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Junction junction = filter.render();
                        Criteria criteriaCount = productDao.countCriteria().add(junction);
                        Long count = (Long) criteriaCount.uniqueResult();
                        totalLabel.setText("Total: " + count);

                        Criteria productsList = productDao.searchCriteria().add(junction);
                        int page = Integer.parseInt(pageTextField.getText());
                        int inPage = Integer.parseInt(inPageTextField.getText());
                        productsList.setFirstResult(page * inPage);
                        productsList.setMaxResults(inPage);

                        LOG.debug(junction.toString());

                        List<Integer> productsId = productsList.list();
                        dataPanel.removeAll();
                        if (productsId != null) {
                            for (Integer id: productsId) {
                                Product product = productDao.getById(id);
                                dataPanel.add(new Item(product), gridBagConstraints);
                            }
                        }
                        dataPanel.updateUI();
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
            centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

            conditionPanel = new JPanel();
            conditionPanel.setLayout(new BoxLayout(conditionPanel, BoxLayout.Y_AXIS));
            //conditionPanel.setBorder(border);
            centerPanel.add(conditionPanel);

            filtersPanel = new JPanel();
            filtersPanel.setLayout(new BoxLayout(filtersPanel, BoxLayout.Y_AXIS));
            //filtersPanel.setBorder(border);
            centerPanel.add(filtersPanel);

            //centerPanel.add(new JPanel(new BorderLayout()));

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
                for (Component component : components) {
                    if (component instanceof Filter) {
                        Filter filter = (Filter) component;
                        junction.add(filter.render());
                    }
                }
            }
            components = conditionPanel.getComponents();
            if (components != null) {
                for (Component component : components) {
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

            setLayout(null);
            //setBorder(border);
            Dimension dimension = new Dimension(220, 46);
            setPreferredSize(dimension);
            setMaximumSize(dimension);
            setMinimumSize(dimension);
            setSize(dimension);

            column = new JComboBox();
            column.setFont(font);
            String[] fields = productDao.searchFields();
            for (String f : fields) {
                column.addItem(f);
            }
            column.setLocation(2, 2);
            column.setSize(96, 20);
            add(column);

            condition = new JComboBox();
            condition.setFont(font);
            condition.addItem("==");
            condition.addItem("!=");
            condition.addItem(">");
            condition.addItem(">=");
            condition.addItem("<");
            condition.addItem("<=");
            condition.addItem("LIKE");
            condition.addItem("NOT LIKE");
            //condition.addItem("IN");
            //condition.addItem("NOT IN");
            //condition.addItem("RANGE");
            condition.addItem("NULL");
            condition.addItem("NOT NULL");
            condition.setLocation(100, 2);
            condition.setSize(78, 20);
            add(condition);

            value = new JTextField();
            value.setColumns(20);
            value.setFont(font);
            value.setMargin(insets);
            value.setLocation(2, 24);
            value.setSize(200, 20);
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
            close.setLocation(180, 2);
            close.setSize(20, 20);
            add(close);

        }

        public void render(Junction junction) {
            String[] s;
            int type = productDao.searchFieldsType(column.getSelectedIndex());
            Object val = value.getText();
            try {
                if (type == ProductDao.TYPE_INT) {
                    val = Integer.parseInt(value.getText());
                } else if (type == ProductDao.TYPE_FLOAT) {
                    val = Float.parseFloat(value.getText());
                } else if (type == ProductDao.TYPE_DATE) {
                    val = FORMAT.parse(value.getText());
                }
            } catch (Exception e) {
                LOG.error(this, e);
            }

            String cond = condition.getSelectedItem().toString();
            String col = column.getSelectedItem().toString();
            if ("==".equals(cond)) {
                junction.add(Restrictions.eq(col, val));
            } else if ("!=".equals(cond)) {
                junction.add(Restrictions.ne(col, val));
            } else if (">".equals(cond)) {
                junction.add(Restrictions.gt(col, val));
            } else if (">=".equals(cond)) {
                junction.add(Restrictions.ge(col, val));
            } else if ("<".equals(cond)) {
                junction.add(Restrictions.lt(col, val));
            } else if ("<=".equals(cond)) {
                junction.add(Restrictions.le(col, val));
            } else if ("LIKE".equals(cond)) {
                junction.add(Restrictions.like(col, val));
            } else if ("NOT LIKE".equals(cond)) {
                junction.add(Restrictions.not(Restrictions.like(col, val)));
            }/*else if ("IN".equals(cond)) {
                s = val.split(";");
                junction.add(Restrictions.in(col, s));
            } else if ("NOT IN".equals(cond)) {
                s = val.split(";");
                junction.add(Restrictions.not(Restrictions.in(col, s)));
            } else if ("RANGE".equals(cond) && val != null) {
                s = val.split(";", 2);
                if (s.length == 2) {
                    junction.add(Restrictions.between(col, s[0].trim(), s[1].trim()));
                }
            }*/ else if ("NULL".equals(cond)) {
                junction.add(Restrictions.isNull(col));
            } else if ("NOT NULL".equals(cond)) {
                junction.add(Restrictions.isNotNull(col));
            }
        }
    }

    class Item extends JPanel {
        private Item rootPanel;
        private Product product;
        public Item(Product p) {
            rootPanel = this;
            product = p;

            setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));
            setBorder(Colors.nextBorder());

            add(new JLabel(p.getCode() + ": " + p.getName()));
            add(new LabelUrl(p.getUrl()));
            JButton price = new JButton(p.getPrice() + " " + p.getCurrency() + " " + p.getDate() + " (" + p.getPriceDelta() + ")");
            price.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    windowPrice.show(product);
                }
            });
            add(price);

            Set<ProductProperty> properties = p.getProperty();
            if (properties != null) {
                for (ProductProperty property:properties) {
                    if ("price".equals(property.getName())) {
                        continue;
                    }
                    add(new JLabel(property.getName() + ": " + property.getValue()));
                }
            }
        }
    }
}
