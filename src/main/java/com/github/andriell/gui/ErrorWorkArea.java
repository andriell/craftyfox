package com.github.andriell.gui;

import com.github.andriell.collection.StackByte;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.ByteBuffer;

public class ErrorWorkArea implements WorkArea {
    private JTextArea errorTextArea;
    private JPanel rootPanel;
    private JTextField sizeTextField;
    private JButton clearButton;

    StackByte buffer = new StackByte(10000);

    public ErrorWorkArea() {
        System.setErr(new PrintStream(new CustomOutputStream()));
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                errorTextArea.setText("");
            }
        });

        new Thread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        errorTextArea.setText(buffer.toString());
                        errorTextArea.setCaretPosition(errorTextArea.getDocument().getLength());
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
