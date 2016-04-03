package com.github.andriell.gui;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class ErrorWorkArea implements WorkArea {
    private JTextArea errorTextArea;
    private JPanel rootPanel;
    private JTextField sizeTextField;
    private JButton refreshButton;
    private JCheckBox autoRefreshCheckBox;

    public ErrorWorkArea() {
        System.setErr(new PrintStream(new CustomOutputStream()));
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
            errorTextArea.append(String.valueOf((char)b));
            errorTextArea.setCaretPosition(errorTextArea.getDocument().getLength());
        }
    }
}
