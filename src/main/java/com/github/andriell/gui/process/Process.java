package com.github.andriell.gui.process;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Rybalko on 11.07.2016.
 */
public class Process extends JPanel {
    private static final Dimension size = new Dimension(410, 200);
    private static final Font fontTitle = new Font("Arial", Font.PLAIN, 16);
    private static final Border border = BorderFactory.createLineBorder(Color.black);

    JLabel title;


    public Process() {
        setLayout(null);
        setPreferredSize(size);
        setBorder(border);

        title = new JLabel("Title", JLabel.CENTER);
        title.setSize(200, 20);
        title.setLocation(5, 5);
        title.setFont(fontTitle);
        add(title);

        JLabel jLabel = new JLabel("Process in queue: ");
        jLabel.setSize(100, 20);
        jLabel.setLocation(5, 30);
        add(jLabel);
    }
}
