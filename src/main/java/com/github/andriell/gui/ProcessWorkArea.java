package com.github.andriell.gui;

import com.github.andriell.processor.Manager;
import com.github.andriell.processor.ManagerInterface;

import javax.swing.*;

/**
 * Created by Андрей on 20.02.2016.
 */
public class ProcessWorkArea implements WorkArea {
    private JPanel rootPanel;
    private JLabel processCountLabel;
    private JLabel processRunningLabel;
    private JTextField processLimitLabel;

    private ManagerInterface manager;

    public ProcessWorkArea() {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    processCountLabel.setText(Integer.toString(manager.getProcessInQueue()));
                    processRunningLabel.setText(Integer.toString(manager.getRunningProcesses()));
                    processLimitLabel.setText(Integer.toString(manager.getLimitProcess()));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {}
                }
            }
        }).start();
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    @Override
    public String toString() {
        return "Процессы";
    }
}
