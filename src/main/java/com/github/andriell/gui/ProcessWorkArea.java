package com.github.andriell.gui;

import org.springframework.beans.factory.InitializingBean;

import javax.swing.*;

/**
 * Created by Андрей on 20.02.2016.
 */
public class ProcessWorkArea implements WorkArea, InitializingBean {
    private JPanel rootPanel;
    private JTable tableManagers;
    private JComboBox comboBoxProjects;
    private JButton goButton;

    private ProcessWorkAreaTableModel processWorkAreaTableModel;


    public ProcessWorkAreaTableModel getProcessWorkAreaTableModel() {
        return processWorkAreaTableModel;
    }

    public void setProcessWorkAreaTableModel(ProcessWorkAreaTableModel processWorkAreaTableModel) {
        this.processWorkAreaTableModel = processWorkAreaTableModel;
    }

    public String getName() {
        return "Процессы";
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void afterPropertiesSet() throws Exception {
        tableManagers.setModel(processWorkAreaTableModel);
    }
}
