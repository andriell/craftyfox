package com.github.andriell.gui;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by Андрей on 20.02.2016.
 */
public class NashornWorkArea implements WorkArea {
    private JTabbedPane tabbedPane1;
    private JPanel rootPanel;
    private JTextArea htmlTextArea;
    private JTextArea jsTextArea;
    private JTextArea outTextArea;
    private JButton goButton;

    private ScriptEngineManager factory;

    public NashornWorkArea() {
        System.setOut(new PrintStream(new CustomOutputStream()));

        factory = new ScriptEngineManager();

        goButton.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                outTextArea.setText("");
                ScriptEngine engine = factory.getEngineByName("nashorn");
                try {
                    engine.eval(jsTextArea.getText());
                } catch (final ScriptException se) {
                    outTextArea.setText(se.toString());
                }
                tabbedPane1.setSelectedIndex(2);
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    @Override
    public String toString() {
        return "Nashorn консоль";
    }

    class CustomOutputStream extends OutputStream {
        @Override
        public void write(int b) throws IOException {
            outTextArea.append(String.valueOf((char)b));
            outTextArea.setCaretPosition(outTextArea.getDocument().getLength());
        }
    }
}
