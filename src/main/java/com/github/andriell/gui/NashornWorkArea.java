package com.github.andriell.gui;

import com.github.andriell.general.Files;
import com.github.andriell.nashorn.Nashorn;
import com.github.andriell.nashorn.console.ConsoleListenerInterface;
import com.github.andriell.nashorn.console.ConsoleMessageInterface;
import com.github.andriell.processor.http.ProcessHttpData;
import com.github.andriell.processor.http.ProcessHttpDataListenerInterface;
import com.github.andriell.processor.js.ProcessJsDataHtml;
import com.github.andriell.processor.js.ProcessJsDataInterface;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
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
import java.nio.charset.Charset;

public class NashornWorkArea implements WorkArea, ConsoleListenerInterface {
    private JTabbedPane tabbedPane1;
    private JPanel rootPanel;
    private JTextArea htmlTextArea;
    private JTextArea jsTextArea;
    private JTextArea outTextArea;
    private JButton buttonGo;
    private JComboBox<String> comboBoxPage;
    private JButton buttonSave;
    private JScrollPane htmlScrollPane;
    private JScrollPane jsScrollPane;
    private JComboBox<String> comboBoxProject;
    private JTextArea jsonTextArea;
    private JTextArea textTextArea;
    private JScrollPane jsonScrollPane;
    private JScrollPane textScrollPane;
    private JPanel htmlJPane;
    private JPanel jsonJPane;
    private JPanel textJPane;

    private Nashorn nashorn;
    private File fileJs;
    private File fileHtml;
    private File fileJson;
    private File fileText;

    private DataEditorWorkArea[] dataEditors;

    public Nashorn getNashorn() {
        return nashorn;
    }

    public void setNashorn(Nashorn nashorn) {
        this.nashorn = nashorn;
    }

    public NashornWorkArea() throws FileNotFoundException {
        updateSelect();
        loadFiles();

        comboBoxPage.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                loadFiles();
            }
        });

        buttonSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveFiles();
            }
        });


        buttonGo.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                String projectName = comboBoxProject.getSelectedItem().toString();
                String pageName = comboBoxPage.getSelectedItem().toString();
                outTextArea.setText("");
                ProcessJsDataInterface processData = null;
                property.setResponse(htmlTextArea.getText().getBytes(), ContentType.TEXT_HTML, null, null);
                if (fileHtml != null) {
                    property = new ProcessJsDataHtml();
                }

                try {
                    nashorn.reload();
                    nashorn.loadProject(projectName, pageName, jsTextArea.getText());
                    Object result = nashorn.runProcess(projectName + "." + pageName, property);
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
        boolean b = folder.isDirectory();
        File[] files = folder.listFiles();
        if (files == null) {
            return;
        }
        for (File fileEntry : files) {
            if (fileEntry.isDirectory()) {
                comboBoxProject.addItem(fileEntry.getName());
            }
        }

        comboBoxPage.removeAll();
        folder = new File(Files.PROJECTS_DIR + File.separator + comboBoxProject.getSelectedItem());
        files = folder.listFiles();
        if (files == null) {
            return;
        }
        for (File fileEntry : files) {
            if (fileEntry.isDirectory()) {
                comboBoxPage.addItem(fileEntry.getName());
            }
        }
    }

    public void loadFiles() {
        String projectPath = Files.PROJECTS_DIR + File.separator
                + comboBoxProject.getSelectedItem() + File.separator
                + comboBoxPage.getSelectedItem();

        fileJs = new File(projectPath + File.separator + "process.js");
        jsTextArea.setText(Files.readFile(fileJs));

        if (dataEditors == null) {
            return;
        }
        for (DataEditorWorkArea dataEditor: dataEditors) {
            File file = new File(projectPath + File.separator + dataEditor.getFileName());
            if (file.isFile()) {
                htmlTextArea.setText(Files.readFile(fileHtml));
                tabbedPane1.setEnabledAt(0, true);
            } else {
                fileHtml = null;
                tabbedPane1.setEnabledAt(0, false);
            }
        }

        fileHtml = new File(projectPath + File.separator + "page.html");
        if (fileHtml.isFile()) {
            htmlTextArea.setText(Files.readFile(fileHtml));
            tabbedPane1.setEnabledAt(0, true);
        } else {
            fileHtml = null;
            tabbedPane1.setEnabledAt(0, false);
        }
        fileJson = new File(projectPath + File.separator + "page.json");
        if (fileJson.isFile()) {
            jsonTextArea.setText(Files.readFile(fileJson));
            tabbedPane1.setEnabledAt(1, true);
        } else {
            fileJson = null;
            tabbedPane1.setEnabledAt(1, false);
        }
        fileText = new File(projectPath + File.separator + "page.txt");
        if (fileText.isFile()) {
            textTextArea.setText(Files.readFile(fileText));
            tabbedPane1.setEnabledAt(2, true);
        } else {
            fileText = null;
            tabbedPane1.setEnabledAt(2, false);
        }
    }

    public void saveFiles() {
        Files.writeToFile(fileJs, jsTextArea.getText());
        if (fileHtml != null) {
            Files.writeToFile(fileHtml, htmlTextArea.getText());
        }
        if (fileJson != null) {
            Files.writeToFile(fileJson, htmlTextArea.getText());
        }
        if (fileText != null) {
            Files.writeToFile(fileText, htmlTextArea.getText());
        }
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

        if (dataEditors == null) {
            return;
        }
        for (DataEditorWorkArea dataEditor: dataEditors) {
            tabbedPane1.add(dataEditor.getName(), dataEditor.getRootPanel());
        }
    }

    public void onConsoleMessage(ConsoleMessageInterface consoleMessage) {
        outTextArea.append(consoleMessage.getMessage());
        outTextArea.append("\n");
        outTextArea.setCaretPosition(outTextArea.getDocument().getLength());
    }
}
