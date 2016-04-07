package com.github.andriell.gui;

import org.springframework.beans.factory.InitializingBean;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Created by Andrey on 03.04.2016
 */
public class NavTreeItem implements InitializingBean {
    private DefaultMutableTreeNode node;

    private String name;
    private NavTreeItem[] childNodes;
    private WorkArea workArea;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setChildNodes(NavTreeItem[] childNodes) {
        this.childNodes = childNodes;
    }

    public void setWorkArea(WorkArea workArea) {
        this.workArea = workArea;
    }

    public DefaultMutableTreeNode getNode() {
        return node;
    }

    public WorkArea getWorkArea() {
        return workArea;
    }

    public void afterPropertiesSet() throws Exception {
        node = new DefaultMutableTreeNode(this);
        if (childNodes != null) {
            for (NavTreeItem childNode : childNodes) {
                node.add(childNode.getNode());
            }
        }
    }

    @Override
    public String toString() {
        if (name != null) {
            return name;
        } else if (workArea != null) {
            return workArea.getName();
        }
        return "No name";
    }
}
