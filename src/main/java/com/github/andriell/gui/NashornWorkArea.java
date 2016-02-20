package com.github.andriell.gui;

import com.github.andriell.general.Files;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

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

    public NashornWorkArea() throws FileNotFoundException {
        System.setOut(new PrintStream(new CustomOutputStream()));

        jsTextArea.setText(Files.CRAFT_DIR  + File.separator + "example" + File.separator + "parser.js");

        factory = new ScriptEngineManager();

        goButton.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                outTextArea.setText("");
                Document document = Jsoup.parse(htmlTextArea.getText());
                ScriptEngine engine = factory.getEngineByName("nashorn");
                Invocable invocable = (Invocable) engine;
                try {
                    engine.eval(jsTextArea.getText());
                    Object result = invocable.invokeFunction("parse", document);
                } catch (final ScriptException se) {
                    outTextArea.setText(se.toString());
                } catch (NoSuchMethodException e1) {
                    outTextArea.setText(e1.toString());
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
