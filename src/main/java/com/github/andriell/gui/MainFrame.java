package com.github.andriell.gui;

import org.springframework.beans.factory.InitializingBean;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class MainFrame implements InitializingBean {
    private JPanel rootPanel;
    private NavTreeItem navTreeMenu;
    private JTree navTree;
    private JPanel workPanel;

    public void afterPropertiesSet() throws Exception {
        JFrame frame = new JFrame("Crafty Fox");
        frame.setContentPane(rootPanel);
        //frame.setUndecorated(true); // Убрать заголовок и границы
        frame.pack();
        //frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);

        //<editor-fold desc="navTree">
        // SelectionListener
        DefaultTreeModel model = new DefaultTreeModel(navTreeMenu.getNode());
        navTree.setModel(model);
        navTree.addTreeSelectionListener(new SelectionListener());
        //</editor-fold>
    }

    public class SelectionListener implements TreeSelectionListener {

        public void valueChanged(TreeSelectionEvent se) {
            JTree tree = (JTree) se.getSource();
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree
                    .getLastSelectedPathComponent();
            Object o = selectedNode.getUserObject();
            if (!(o instanceof NavTreeItem)) {
                return;
            }
            NavTreeItem navTreeItem = (NavTreeItem) o;
            WorkArea workArea = navTreeItem.getWorkArea();
            if (workArea != null) {
                workPanel.removeAll();
                workPanel.add(workArea.getRootPanel());
                workPanel.validate();
                workPanel.repaint();
            }
        }
    }

    public void setNavTreeMenu(NavTreeItem navTreeMenu) {
        this.navTreeMenu = navTreeMenu;
    }
}
