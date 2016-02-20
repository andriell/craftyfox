package com.github.andriell.gui;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * Created by Андрей on 20.02.2016.
 */
public class MainFrame {
    private JPanel rootPanel;
    private DefaultMutableTreeNode navRootNode;
    private JTree navTree;
    private JPanel workPanel;

    public MainFrame() {
        JFrame frame = new JFrame("Crafty Fox");
        frame.setContentPane(rootPanel);
        //frame.setUndecorated(true); // Убрать заголовок и границы
        frame.pack();
        //frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
        navRootNode.add(new DefaultMutableTreeNode(new ErrorWorkArea()));
        navTree.addTreeSelectionListener(new SelectionListener());
    }

    private void createUIComponents() {
        navRootNode = new DefaultMutableTreeNode("Crafty Fox [Параметры]");
        DefaultTreeModel model = new DefaultTreeModel(navRootNode);
        navTree = new JTree(model);
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
            WorkArea workArea = (WorkArea) o;
            if (selectedNode.isLeaf()) {
                workPanel.removeAll();
                workPanel.add(workArea.getRootPanel());
                workPanel.doLayout();
                System.out.println(workPanel);
            }
        }
    }
}
