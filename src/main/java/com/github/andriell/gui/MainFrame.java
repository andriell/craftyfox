package com.github.andriell.gui;

import com.jgoodies.looks.windows.WindowsTreeUI;
import org.springframework.beans.factory.InitializingBean;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame implements InitializingBean, Runnable {
    private String logo = "Crafty Fox     ";
    private String space = "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             ";
    private JFrame frame;
    private JPanel rootPanel;
    private NavTreeItem navTreeMenu;
    private JTree navTree;
    private JPanel workPanel;
    private JLabel footerJLabel;
    private JLabel titleJLabel;
    private JLabel _JLabel;
    private JLabel pJLabel;
    private JLabel xJLabel;
    private JPanel titleJPanel;
    private JLabel logoJLabel;
    private JLabel resizeLabel;

    public void afterPropertiesSet() throws Exception {
        //rootPanel.setBackground(new Color(0,0,0));
        //rootPanel.setBounds(1,1,1,1);


        //xJLabel.setOpaque(true);
        //xJLabel.setBackground(Color.RED);
        //xJLabel.setForeground(Color.WHITE);
        //xJLabel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        frame = new JFrame(logo);
        //<editor-fold desc="Управление окном">
        xJLabel.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                System.exit(0);
            }
        });
        _JLabel.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                frame.setState(JFrame.ICONIFIED);
            }
        });
        pJLabel.addMouseListener(new MouseAdapter() {
            private boolean max = false;
            public void mouseReleased(MouseEvent e) {
                if (max) {
                    frame.setExtendedState(JFrame.NORMAL);
                } else {
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                }
                max = !max;
            }
        });
        MouseAdapter drugAndDropMouseAdapter = new MouseAdapter() {
            private int pX, pY;
            public void mousePressed(MouseEvent me) {
                pX = me.getX();
                pY = me.getY();
            }
            public void mouseDragged(MouseEvent me) {
                frame.setLocation(frame.getLocation().x + me.getX() - pX,
                        frame.getLocation().y + me.getY() - pY);
            }
        };
        logoJLabel.addMouseListener(drugAndDropMouseAdapter);
        logoJLabel.addMouseMotionListener(drugAndDropMouseAdapter);
        titleJPanel.addMouseListener(drugAndDropMouseAdapter);
        titleJPanel.addMouseMotionListener(drugAndDropMouseAdapter);

        MouseAdapter resizeAdapter = new MouseAdapter() {
            private int pX, pY, width, height;
            public void mousePressed(MouseEvent me) {
                pX = me.getX();
                pY = me.getY();
            }
            public void mouseDragged(MouseEvent me) {
                frame.setSize(frame.getSize().width + me.getX() - pX, frame.getSize().height + me.getY() - pY);
            }
        };
        resizeLabel.addMouseListener(resizeAdapter);
        resizeLabel.addMouseMotionListener(resizeAdapter);
        //resizeLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        //</editor-fold>
        frame.setContentPane(rootPanel);
        frame.setUndecorated(true); // Убрать заголовок и границы
        frame.pack();
        //frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 600);


        //<editor-fold desc="navTree">
        // SelectionListener
        DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) navTree.getCellRenderer();
        renderer.setLeafIcon(null); // Файлы
        renderer.setClosedIcon(new WindowsTreeUI.CollapsedIcon()); // Папки закрытые
        renderer.setOpenIcon(new WindowsTreeUI.ExpandedIcon()); // Папки открытые

        DefaultTreeModel model = new DefaultTreeModel(navTreeMenu);
        navTree.setModel(model);
        navTree.addTreeSelectionListener(new SelectionListener());
        //</editor-fold>

        footerJLabel.setFont(new Font("Monospaced", Font.PLAIN, 12));

        frame.setVisible(true);

        new Thread(this).start();
    }

    public void run() {
        while (true) {
            int usedBytes = Math.round((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1204);
            footerJLabel.setText("Program running | " + usedBytes + " Mb | ");
            try {
                Thread.sleep(10000);
            } catch (Exception e) {}
        }
    }

    public void setNavTreeMenu(NavTreeItem navTreeMenu) {
        this.navTreeMenu = navTreeMenu;
    }

    public class SelectionListener implements TreeSelectionListener {

        public void valueChanged(TreeSelectionEvent se) {
            JTree tree = (JTree) se.getSource();
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree
                    .getLastSelectedPathComponent();
            Object o = selectedNode.getUserObject();
            if (!(o instanceof WorkArea)) {
                return;
            }
            logoJLabel.setText(logo + selectedNode.toString());
            WorkArea workArea = (WorkArea) o;
            workPanel.removeAll();
            workPanel.add(workArea.getRootPanel());
            workPanel.validate();
            workPanel.repaint();
        }
    }
}
