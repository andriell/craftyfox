package com.github.andriell.gui;

import com.github.andriell.general.Files;
import com.github.andriell.processor.js.DataConverter;
import com.github.andriell.processor.js.ProcessJsDataInterface;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.swing.*;
import java.io.File;

/**
 * Created by Vika on 17.04.2016
 */
public class DataEditorWorkArea implements WorkArea, InitializingBean, ApplicationContextAware {
    private String name;
    private JPanel rootPanel;
    private JScrollPane scrollPane;
    private JTextArea textArea;

    private DataConverter converter;
    private String syntaxEditingStyle;
    private String dataBinId;
    private String fileName;
    private File file;
    private ApplicationContext applicationContext;

    public DataConverter getConverter() {
        return converter;
    }

    public void setConverter(DataConverter converter) {
        this.converter = converter;
    }

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

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    private void createUIComponents() {
        RSyntaxTextArea rSyntaxTextArea = new RSyntaxTextArea(20, 60);
        rSyntaxTextArea.setCodeFoldingEnabled(true);
        textArea = rSyntaxTextArea;
        scrollPane = new RTextScrollPane(rSyntaxTextArea);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ProcessJsDataInterface getProcessData(String pageName) {
        ProcessJsDataInterface dataBean = (ProcessJsDataInterface) applicationContext.getBean(dataBinId);
        dataBean.setData(converter.convert(textArea.getText()));
        dataBean.setPageName(pageName);
        return dataBean;
    }

    public boolean load(File dirProject) {
        file = new File(dirProject, fileName);
        boolean r = file.exists();
        if (r) {
            textArea.setText(Files.readFile(file));
        }
        return r;
    }

    public void save() {
        Files.writeToFile(file, textArea.getText());
    }

    public void afterPropertiesSet() throws Exception {
        RSyntaxTextArea rSyntaxTextArea = (RSyntaxTextArea) textArea;
        rSyntaxTextArea.setSyntaxEditingStyle(syntaxEditingStyle);
    }
}
