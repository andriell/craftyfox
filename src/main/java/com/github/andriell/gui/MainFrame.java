package com.github.andriell.gui;

import com.jgoodies.looks.windows.WindowsTreeUI;
import org.springframework.beans.factory.InitializingBean;

import javax.swing.*;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
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
        DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) navTree.getCellRenderer();
        renderer.setLeafIcon(null); // Файлы
        renderer.setClosedIcon(new WindowsTreeUI.CollapsedIcon()); // Папки закрытые
        renderer.setOpenIcon(new WindowsTreeUI.ExpandedIcon()); // Папки открытые

        DefaultTreeModel model = new DefaultTreeModel(navTreeMenu);
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
            if (!(o instanceof WorkArea)) {
                return;
            }
            WorkArea workArea = (WorkArea) o;
            workPanel.removeAll();
            workPanel.add(workArea.getRootPanel());
            workPanel.validate();
            workPanel.repaint();
        }
    }

    public void setNavTreeMenu(NavTreeItem navTreeMenu) {
        this.navTreeMenu = navTreeMenu;
    }
}
