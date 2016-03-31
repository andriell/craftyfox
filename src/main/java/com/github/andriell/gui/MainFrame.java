package com.github.andriell.gui;

import com.github.andriell.processor.ManagerInterface;
import org.springframework.beans.factory.InitializingBean;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class MainFrame implements InitializingBean {
    private JPanel rootPanel;
    private DefaultMutableTreeNode navRootNode;
    private JTree navTree;
    private JPanel workPanel;

    private ManagerInterface manager;
    private NashornWorkArea nashornWorkArea;

    public void setNashornWorkArea(NashornWorkArea nashornWorkArea) {
        this.nashornWorkArea = nashornWorkArea;
    }

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
        // Error
        navRootNode.add(new DefaultMutableTreeNode(new ErrorWorkArea()));
        // process
        ProcessWorkArea processWorkArea = new ProcessWorkArea();
        processWorkArea.setManager(manager);
        navRootNode.add(new DefaultMutableTreeNode(processWorkArea));
        // Nashorn
        navRootNode.add(new DefaultMutableTreeNode(nashornWorkArea));
        // SelectionListener
        navTree.addTreeSelectionListener(new SelectionListener());
        //</editor-fold>
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
                workPanel.validate();
                workPanel.repaint();
            }
        }
    }

    public void setManager(ManagerInterface manager) {
        this.manager = manager;
    }
}
