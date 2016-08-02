package com.github.andriell.gui.logger;

import org.apache.log4j.spi.LoggingEvent;

import javax.swing.*;

/**
 * Created by Rybalko on 02.08.2016.
 */
public class Message extends JPanel {
    LoggingEvent loggingEvent;
    JTextArea detail;

    public Message(LoggingEvent loggingEvent) {
        super();
        detail = new JTextArea();
        detail.setEditable(false);
        detail.setEnabled(false);
        detail.setText(loggingEvent.toString());

        this.loggingEvent = loggingEvent;
    }
}
