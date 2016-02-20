package com.github.andriell.gui;

import com.github.andriell.general.Files;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class NashornWorkArea implements WorkArea {
    private JTabbedPane tabbedPane1;
    private JPanel rootPanel;
    private JTextArea htmlTextArea;
    private JTextArea jsTextArea;
    private JTextArea outTextArea;
    private JButton goButton;
    private JComboBox<String> parserComboBox;
    private JButton saveButton;
    private JScrollPane htmlScrollPane;
    private JScrollPane jsScrollPane;

    private ScriptEngineManager factory;
    private File fileJs;
    private File fileHtml;

    public NashornWorkArea() throws FileNotFoundException {
        System.setOut(new PrintStream(new CustomOutputStream()));

        updateSelect();
        loadFiles("example");
        parserComboBox.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                String s = parserComboBox.getSelectedItem().toString();
                loadFiles(s);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveFiles();
            }
        });

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

    public void updateSelect() {
        parserComboBox.removeAll();
        File folder = new File(Files.CRAFT_DIR);
        File[] files = folder.listFiles();
        if (files == null) {
            return;
        }
        for (File fileEntry : files) {
            if (fileEntry.isDirectory()) {
                parserComboBox.addItem(fileEntry.getName());
            }
        }
    }

    public void loadFiles(String parserName) {
        fileJs = new File(Files.CRAFT_DIR + File.separator + parserName + File.separator + "parser.js");
        fileHtml = new File(Files.CRAFT_DIR + File.separator + parserName + File.separator + "page.html");
        jsTextArea.setText(Files.readFile(fileJs));
        htmlTextArea.setText(Files.readFile(fileHtml));
    }

    public void saveFiles() {
        Files.writeToFile(fileJs, jsTextArea.getText());
        Files.writeToFile(fileHtml, htmlTextArea.getText());
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    @Override
    public String toString() {
        return "Nashorn консоль";
    }

    private void createUIComponents() {
        RSyntaxTextArea rSyntaxTextArea = new RSyntaxTextArea(20, 60);
        rSyntaxTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVASCRIPT);
        rSyntaxTextArea.setCodeFoldingEnabled(true);
        jsTextArea = rSyntaxTextArea;
        jsScrollPane = new RTextScrollPane(rSyntaxTextArea);

        rSyntaxTextArea = new RSyntaxTextArea(20, 60);
        rSyntaxTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_HTML);
        rSyntaxTextArea.setCodeFoldingEnabled(true);
        htmlTextArea = rSyntaxTextArea;
        htmlScrollPane = new RTextScrollPane(rSyntaxTextArea);
    }

    class CustomOutputStream extends OutputStream {
        @Override
        public void write(int b) throws IOException {
            outTextArea.append(String.valueOf((char)b));
            outTextArea.setCaretPosition(outTextArea.getDocument().getLength());
        }
    }
}
