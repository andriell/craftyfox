package com.github.andriell.gui.logger;

import javax.swing.*;

public class LoggerPanel extends JScrollPane {
    private JPanel body;

    public LoggerPanel() {
        super();
        body = new JPanel();
        body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
        setViewportView(body);

    }
}
