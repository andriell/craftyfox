package com.github.andriell.gui;

import com.github.andriell.collection.StackByte;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class LogWorkArea implements WorkArea {
    StackByte buffer = new StackByte(10000);
    private JTextArea errorTextArea;
    private JPanel rootPanel;
    private JTextField sizeTextField;
    private JButton clearButton;

    public LogWorkArea() {
        System.setErr(new PrintStream(new CustomOutputStream()));
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buffer.clear();
            }
        });

        new Thread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        errorTextArea.setText(buffer.toString());
                        //errorTextArea.setCaretPosition(errorTextArea.getDocument().getLength());
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public String getName() {
        return "Ошибки";
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    class CustomOutputStream extends OutputStream {
        @Override
        public void write(int b) throws IOException {
            buffer.put((byte) b);
        }
    }
}