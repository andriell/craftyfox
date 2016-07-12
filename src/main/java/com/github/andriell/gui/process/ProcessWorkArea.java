package com.github.andriell.gui.process;

import com.github.andriell.gui.WorkArea;
import com.github.andriell.processor.ManagerInterface;
import com.github.andriell.processor.ProcessorInterface;
import org.springframework.beans.factory.InitializingBean;

import javax.swing.*;
import java.util.Collection;

/**
 * Created by Rybalko on 12.07.2016.
 */
public class ProcessWorkArea implements WorkArea, InitializingBean, Runnable {
    private JPanel rootPanel;
    private String name = "Процессы";
    private ProcessorInterface processor;
    private Collection<ManagerInterface> managers;
    private Process[] process;

    public void afterPropertiesSet() throws Exception {
        managers = processor.getManagers();
        process = new Process[managers.size()];
        int i = 0;
        for (ManagerInterface manager: managers) {
            process[i] = new Process(manager);
            rootPanel.add(process[i]);
            i++;
        }
        new Thread(this).start();
    }

    public String getName() {
        return name;
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public ProcessorInterface getProcessor() {
        return processor;
    }

    public void setProcessor(ProcessorInterface processor) {
        this.processor = processor;
    }

    public void run() {
        while (true) {
            for (Process p: process) {
                p.update();
            }
            rootPanel.updateUI();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {}
        }
    }
}
