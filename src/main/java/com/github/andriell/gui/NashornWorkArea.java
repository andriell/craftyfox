package com.github.andriell.gui;

import com.github.andriell.general.Files;
import com.github.andriell.nashorn.Nashorn;
import com.github.andriell.nashorn.console.ConsoleListenerInterface;
import com.github.andriell.nashorn.console.ConsoleMessageInterface;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class NashornWorkArea implements WorkArea, ConsoleListenerInterface {
    private JTabbedPane tabbedPane1;
    private JPanel rootPanel;
    private JTextArea htmlTextArea;
    private JTextArea jsTextArea;
    private JTextArea outTextArea;
    private JButton buttonGo;
    private JComboBox<String> comboBoxParser;
    private JButton buttonSave;
    private JScrollPane htmlScrollPane;
    private JScrollPane jsScrollPane;
    private JComboBox<String> comboBoxProject;

    private Nashorn nashorn;
    private File fileJs;
    private File fileHtml;

    public Nashorn getNashorn() {
        return nashorn;
    }

    public void setNashorn(Nashorn nashorn) {
        this.nashorn = nashorn;
    }

    public NashornWorkArea() throws FileNotFoundException {
        updateSelect();
        loadFiles("example");

        comboBoxParser.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                String craftName = comboBoxParser.getSelectedItem().toString();
                loadFiles(craftName);
            }
        });

        buttonSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveFiles();
            }
        });


        buttonGo.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                String craftName = comboBoxParser.getSelectedItem().toString();
                outTextArea.setText("");
                Document document = Jsoup.parse(htmlTextArea.getText());
                try {
                    nashorn.reload(craftName, jsTextArea.getText());
                    Object result = nashorn.runProcess(craftName, document);
                } catch (final ScriptException se) {
                    outTextArea.setText(se.toString());
                } catch (NoSuchMethodException e1) {
                    outTextArea.setText(e1.toString());
                } catch (Exception e1) {
                    outTextArea.setText(e1.toString());
                }
                tabbedPane1.setSelectedIndex(2);
            }
        });
    }

    public void updateSelect() {
        comboBoxProject.removeAll();
        File folder = new File(Files.PROJECTS_DIR);
        File[] files = folder.listFiles();
        if (files == null) {
            return;
        }
        for (File fileEntry : files) {
            if (fileEntry.isDirectory()) {
                comboBoxProject.addItem(fileEntry.getName());
            }
        }

        comboBoxParser.removeAll();
        folder = new File(Files.PROJECTS_DIR + File.separator + comboBoxProject.getSelectedItem());
        files = folder.listFiles();
        if (files == null) {
            return;
        }
        for (File fileEntry : files) {
            if (fileEntry.isDirectory()) {
                comboBoxParser.addItem(fileEntry.getName());
            }
        }
    }

    public void loadFiles(String craftName) {
        fileJs = new File(Files.PROJECTS_DIR + File.separator + craftName + File.separator + "100-init.js");
        fileHtml = new File(Files.PROJECTS_DIR + File.separator + craftName + File.separator + "page.html");
        jsTextArea.setText(Files.readFile(fileJs));
        htmlTextArea.setText(Files.readFile(fileHtml));
    }

    public void saveFiles() {
        Files.writeToFile(fileJs, jsTextArea.getText());
        Files.writeToFile(fileHtml, htmlTextArea.getText());
    }

    public String getName() {
        return "Nashorn консоль";
    }

    public JPanel getRootPanel() {
        return rootPanel;
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

    public void onConsoleMessage(ConsoleMessageInterface consoleMessage) {
        outTextArea.append(consoleMessage.getMessage());
        outTextArea.append("\n");
        outTextArea.setCaretPosition(outTextArea.getDocument().getLength());
    }
}
