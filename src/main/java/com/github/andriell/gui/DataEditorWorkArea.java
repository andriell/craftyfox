package com.github.andriell.gui;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import javax.swing.*;

/**
 * Created by Vika on 17.04.2016
 */
public class DataEditorWorkArea implements WorkArea {
    private String name;
    private JPanel rootPanel;
    private String syntaxEditingStyle;
    private String dataBinId;
    private String fileName;
    private JScrollPane scrollPane;
    private JTextArea textArea;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSyntaxEditingStyle() {
        return syntaxEditingStyle;
    }

    public void setSyntaxEditingStyle(String syntaxEditingStyle) {
        this.syntaxEditingStyle = syntaxEditingStyle;
    }

    public String getDataBinId() {
        return dataBinId;
    }

    public void setDataBinId(String dataBinId) {
        this.dataBinId = dataBinId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    private void createUIComponents() {
        RSyntaxTextArea rSyntaxTextArea = new RSyntaxTextArea(20, 60);
        rSyntaxTextArea.setSyntaxEditingStyle(syntaxEditingStyle);
        rSyntaxTextArea.setCodeFoldingEnabled(true);
        textArea = rSyntaxTextArea;
        scrollPane = new RTextScrollPane(rSyntaxTextArea);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
