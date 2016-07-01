package com.github.andriell.gui;

import com.github.andriell.loging.AdapterStack;
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
    private JButton stopButton;
    private boolean run = true;

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
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                run = !run;
                if (run) {
                    stopButton.setText("Stop");
                } else {
                    stopButton.setText("Run");
                }
            }
        });

        new Thread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        if (run) {
                            errorTextArea.setText(adapterStack.getStack().toString());
                        }
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
