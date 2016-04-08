package com.github.andriell.gui;

import com.github.andriell.processor.ManagerInterface;
import com.github.andriell.processor.ProcessorInterface;

import javax.swing.table.AbstractTableModel;
import java.util.Collection;

/**
 * Created by Rybalko on 07.04.2016.
 */
public class ProcessWorkAreaTableModel extends AbstractTableModel  {
    private String[] columnNames = {"ProcessBeanId", "RunningProcesses", "ProcessInQueue", "LimitProcess"};
    private ManagerInterface[] managers;

    public String[] getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }

    public ManagerInterface[] getManagers() {
        return managers;
    }

    public void setProcessor(ProcessorInterface processor) {
        Collection<ManagerInterface> collection = processor.getManagers();
        if (collection == null) {
            return;
        }
        int size = collection.size();
        managers = new ManagerInterface[size];
        int i = 0;
        for (ManagerInterface manager:collection) {
            managers[i++] = manager;
        }
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return managers.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        ManagerInterface manager = managers[row];
        if (col == 0) {
            return manager.getProcessBeanId();
        } else if (col == 1) {
            return manager.getRunningProcesses();
        } else if (col == 2) {
            return manager.getProcessInQueue();
        } else if (col == 3) {
            return manager.getLimitProcess();
        }
        return "";
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col) {
        return col == 3;
    }

    public void setValueAt(Object value, int row, int col) {
        if (col != 3) {
            return;
        }
        managers[row].setLimitProcess((Integer) value);
        fireTableCellUpdated(row, col);
    }
}
