package com.github.andriell.gui;

import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;

/**
 * Created by Rybalko on 07.04.2016.
 */
public class ProcessWorkAreaTableModel extends AbstractTableModel  {
    protected EventListenerList listenerList = new EventListenerList();

    private String[] columnNames = {"a","b","c"};
    private Object[][] data = {{"a","b","c"},{"a","b","c"}};

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col) {
        return col < 2;
    }

    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
}
