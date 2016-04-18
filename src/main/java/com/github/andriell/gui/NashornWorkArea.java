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
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.Charset;

public class NashornWorkArea implements WorkArea, ConsoleListenerInterface, InitializingBean {
    private JTabbedPane tabbedPane1;
    private JPanel rootPanel;
    private JTextArea htmlTextArea;
    private JTextArea jsTextArea;
    private JTextArea outTextArea;
    private JButton buttonGo;
    private JComboBox<String> comboBoxPage;
    private JButton buttonSave;
    private JScrollPane jsScrollPane;
    private JComboBox<String> comboBoxProject;

    private Nashorn nashorn;
    private File fileJs;
    private File fileHtml;
    private File fileJson;
    private File fileText;

    private DataEditorWorkArea[] dataEditors;
    private DataEditorWorkArea dataEditorActive;

    public void setNashorn(Nashorn nashorn) {
        this.nashorn = nashorn;
    }

    public void setDataEditors(DataEditorWorkArea[] dataEditors) {
        this.dataEditors = dataEditors;
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
                ProcessJsDataInterface processData = dataEditorActive.getProcessData();

                try {
                    nashorn.reload();
                    nashorn.loadProject(projectName, pageName, jsTextArea.getText());
                    Object result = nashorn.runProcess(processData);
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

    private void updateSelect() {
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
        File projectPathFile = new File(projectPath);

        fileJs = new File(projectPath + File.separator + "process.js");
        jsTextArea.setText(Files.readFile(fileJs));

        if (dataEditors == null) {
            return;
        }
        for (DataEditorWorkArea dataEditor: dataEditors) {
            if (dataEditor.load(projectPathFile)) {
                //htmlTextArea.setText(Files.readFile(fileHtml));
                //tabbedPane1.setEnabledAt(0, true);
            } else {
                //fileHtml = null;
                //tabbedPane1.setEnabledAt(0, false);
            }
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
    }

    public void onConsoleMessage(ConsoleMessageInterface consoleMessage) {
        outTextArea.append(consoleMessage.getMessage());
        outTextArea.append("\n");
        outTextArea.setCaretPosition(outTextArea.getDocument().getLength());
    }

    public void afterPropertiesSet() throws Exception {
        if (dataEditors == null) {
            return;
        }
        for (DataEditorWorkArea dataEditor: dataEditors) {
            tabbedPane1.add(dataEditor.getName(), dataEditor.getRootPanel());
        }
    }
}
