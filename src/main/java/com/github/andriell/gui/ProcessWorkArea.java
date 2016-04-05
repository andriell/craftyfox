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

    private ManagerInterface[] managers;

    public ProcessWorkArea() {
        new Thread(new Runnable() {
            public void run() {
                String s;
                while (true) {
                    for (ManagerInterface manager : managers) {
                        try {
                            s = Integer.toString(manager.getProcessInQueue());
                            if (s.equals(processCountLabel.getText())) {
                                processCountLabel.setText(s);
                            }
                            s = Integer.toString(manager.getRunningProcesses());
                            if (s.equals(processRunningLabel.getText())) {
                                processRunningLabel.setText(s);
                            }
                            s = Integer.toString(manager.getLimitProcess());
                            if (!s.equals(processLimitLabel.getText())) {
                                processLimitLabel.setText(s);
                            }
                        } catch (Exception e) {
                        }
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
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
