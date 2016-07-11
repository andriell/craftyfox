package com.github.andriell.gui.process;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Rybalko on 11.07.2016.
 */
public class Process extends JPanel {
    GridBagConstraints gridBagConstraints;
    JLabel title = new JLabel("Title");

    public Process() {
        setLayout(new GridBagLayout());

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.gridx = 0;

        add(title, gridBagConstraints);
    }
}
