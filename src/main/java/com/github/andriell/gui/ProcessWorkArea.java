package com.github.andriell.gui;

import com.github.andriell.processor.ManagerInterface;
import com.github.andriell.processor.Processor;
import com.github.andriell.processor.ProcessorInterface;
import org.springframework.beans.factory.InitializingBean;


import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 * Created by Андрей on 20.02.2016.
 */
public class ProcessWorkArea implements WorkArea, InitializingBean {
    private JPanel rootPanel;
    private JTable tableManagers;

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
