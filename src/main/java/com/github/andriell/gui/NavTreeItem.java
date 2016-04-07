package com.github.andriell.gui;

import org.springframework.beans.factory.InitializingBean;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Created by Andrey on 03.04.2016
 */
public class NavTreeItem extends DefaultMutableTreeNode {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setChildNodes(NavTreeItem[] childNodes) {
        for (NavTreeItem childNode : childNodes) {
            add(childNode);
        }
    }

    @Override
    public WorkArea getUserObject() {
        return (WorkArea) super.getUserObject();
    }

    public void setUserObject(WorkArea userObject) {
        super.setUserObject(userObject);
    }

    @Override
    public String toString() {
        if (name != null) {
            return name;
        } else if (getUserObject() != null) {
            return getUserObject().getName();
        }
        return "No name";
    }
}
