package com.github.andriell.gui;

import com.github.andriell.processor.ManagerInterface;
import com.github.andriell.processor.Processor;
import com.github.andriell.processor.ProcessorInterface;


import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 * Created by Андрей on 20.02.2016.
 */
public class ProcessWorkArea implements WorkArea {
    private JPanel rootPanel;
    private JTable tableManagers;



    private ManagerInterface[] managers;
    private ProcessorInterface processor;

    public ProcessWorkArea() {
        tableManagers.setModel(new ProcessWorkAreaTableModel());
    }

    public void setManagers(ManagerInterface[] manager) {
        this.managers = manager;
    }

    public String getName() {
        return "Процессы";
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
