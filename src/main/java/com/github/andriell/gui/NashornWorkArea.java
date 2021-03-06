package com.github.andriell.gui;

import com.github.andriell.collection.StackString;
import com.github.andriell.general.Files;
import com.github.andriell.nashorn.Nashorn;
import com.github.andriell.nashorn.console.ConsoleListenerInterface;
import com.github.andriell.nashorn.console.ConsoleMessageInterface;
import com.github.andriell.processor.js.ProcessJsDataInterface;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.springframework.beans.factory.InitializingBean;

import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

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
    private JPanel outputJPanel;
    private JPanel jsJPanel;

    private Nashorn nashorn;
    private File fileJs;
    private StackString stack = new StackString(1000);

    private DataEditorWorkArea[] dataEditors;
    private DataEditorWorkArea dataEditorActive;

    public NashornWorkArea() throws FileNotFoundException {
        comboBoxProject.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                updateSelect();
            }
        });

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
                String pageNameFull = projectName + "." + pageName;
                stack.clear();
                ProcessJsDataInterface processData = null;
                if (dataEditorActive != null) {
                    processData = dataEditorActive.getProcessData(pageNameFull);
                }
                try {
                    nashorn.reload();
                    nashorn.loadProject(projectName, pageName, jsTextArea.getText());
                    if (processData == null) {
                        Object result = nashorn.runProcess(pageNameFull);
                    } else {
                        Object result = nashorn.runProcess(processData);
                    }
                } catch (final ScriptException se) {
                    stack.put(se.toString());
                } catch (NoSuchMethodException e1) {
                    stack.put(e1.toString());
                } catch (Exception e1) {
                    stack.put(e1.toString());
                }
                tabbedPane1.setSelectedComponent(outputJPanel);
            }
        });
    }

    public void setNashorn(Nashorn nashorn) {
        this.nashorn = nashorn;
    }

    public void setDataEditors(DataEditorWorkArea[] dataEditors) {
        this.dataEditors = dataEditors;
    }

    private void updateSelect() {
        File folder = new File(Files.PROJECTS_DIR);
        File[] files = folder.listFiles();
        if (files == null) {
            return;
        }
        if (comboBoxProject.getItemCount() <= 0) {
            for (File fileEntry : files) {
                if (fileEntry.isDirectory()) {
                    comboBoxProject.addItem(fileEntry.getName());
                }
            }
        }
        folder = new File(Files.PROJECTS_DIR + File.separator + comboBoxProject.getSelectedItem());
        files = folder.listFiles();
        if (files == null) {
            return;
        }
        comboBoxPage.removeAllItems();
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
        File projectFile = new File(projectPath);

        fileJs = new File(projectFile, "process.js");
        jsTextArea.setText(Files.readFile(fileJs));

        tabbedPane1.removeAll();
        dataEditorActive = null;

        if (dataEditors != null) {
            for (DataEditorWorkArea dataEditor: dataEditors) {
                if (dataEditor.load(projectFile)) {
                    tabbedPane1.add(dataEditor.getName(), dataEditor.getRootPanel());
                    dataEditorActive = dataEditor;
                    break;
                }
            }
        }
        tabbedPane1.add("JS", jsJPanel);
        tabbedPane1.add("Output", outputJPanel);
        outTextArea.setText("");
    }

    public void saveFiles() {
        Files.writeToFile(fileJs, jsTextArea.getText());
        for (DataEditorWorkArea dataEditor: dataEditors) {
            dataEditor.save();
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
        stack.put(consoleMessage.getMessage());
        stack.put("\n");
    }

    public void afterPropertiesSet() throws Exception {
        updateSelect();
        loadFiles();

        new Thread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        outTextArea.setText(stack.toString());
                        //outTextArea.setCaretPosition(outTextArea.getDocument().getLength());
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
