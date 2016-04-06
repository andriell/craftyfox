package com.github.andriell.gui;

import com.github.andriell.processor.ManagerInterface;
import com.github.andriell.processor.Processor;
import com.github.andriell.processor.ProcessorInterface;


import javax.swing.*;
import javax.swing.event.TableModelListener;
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
        tableManagers.setModel(new TableModel() {
            public int getRowCount() {
                return 0;
            }

            public int getColumnCount() {
                return 0;
            }

            public String getColumnName(int columnIndex) {
                return null;
            }

            public Class<?> getColumnClass(int columnIndex) {
                return null;
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }

            public Object getValueAt(int rowIndex, int columnIndex) {
                return null;
            }

            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

            }

            public void addTableModelListener(TableModelListener l) {

            }

            public void removeTableModelListener(TableModelListener l) {

            }
        });
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
