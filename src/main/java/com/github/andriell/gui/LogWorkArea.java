package com.github.andriell.gui;

import org.springframework.beans.factory.InitializingBean;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogWorkArea implements WorkArea, InitializingBean {
    private AdapterStack adapterStack;
    private JTextArea errorTextArea;
    private JPanel rootPanel;
    private JTextField sizeTextField;
    private JButton clearButton;

    public String getName() {
        return "Ошибки";
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void setAdapterId(int adapterId) {
        adapterStack = AdapterStack.getAdapter(adapterId);
    }

    public void afterPropertiesSet() throws Exception {
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adapterStack.getStack().clear();
            }
        });

        new Thread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        errorTextArea.setText(adapterStack.getStack().toString());
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
