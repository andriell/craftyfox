package com.github.andriell.gui.process;

import com.github.andriell.gui.WorkArea;
import org.springframework.beans.factory.InitializingBean;

import javax.swing.*;

/**
 * Created by Rybalko on 12.07.2016.
 */
public class ProcessWorkArea2 implements WorkArea, InitializingBean {
    private JPanel rootPanel;
    private String name = "Процессы 2";

    public ProcessWorkArea2() {
        rootPanel.add(new Process());
        rootPanel.add(new Process());
        rootPanel.add(new Process());
        rootPanel.updateUI();
    }

    public void afterPropertiesSet() throws Exception {

    }

    public String getName() {
        return name;
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
