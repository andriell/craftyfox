package com.github.andriell.gui.process;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Rybalko on 11.07.2016.
 */
public class Process2 {
    private static final Dimension size = new Dimension(410, 200);
    private static final Font fontTitle = new Font("Arial", Font.PLAIN, 16);
    private static final Border border = BorderFactory.createLineBorder(Color.black);

    private JPanel rootPanel;
    private JLabel title;


    public Process2() {

        FormLayout layout = new FormLayout(
                "right:pref, 3dlu, pref, 7dlu, right:pref, 3dlu, pref", // columns
                "p, 3dlu, p, 3dlu, p, 9dlu, p, 3dlu, p, 3dlu, p");

        layout.setColumnGroups(new int[][]{{1, 5}, {3, 7}});

        PanelBuilder builder = new PanelBuilder(layout);
        builder.setDefaultDialogBorder();

        CellConstraints cc = new CellConstraints();

        title = new JLabel("Title", JLabel.CENTER);
        title.setFont(fontTitle);

        builder.add(title, cc.xyw(2, 2, 5));
        /*builder.addLabel("Contact",       cc.xy (1,  5));
        builder.add(contactField,         cc.xyw(3,  5, 5));

        builder.addSeparator("Propeller", cc.xyw(1,  7, 7));
        builder.addLabel("PTI [kW]",      cc.xy (1,  9));
        builder.add(ptiField,             cc.xy (3,  9));
        builder.addLabel("Power [kW]",    cc.xy (5,  9));
        builder.add(powerField,           cc.xy (7,  9));
        builder.addLabel("R [mm]",        cc.xy (1, 11));
        builder.add(radiusField,          cc.xy (3, 11));
        builder.addLabel("D [mm]",        cc.xy (5, 11));
        builder.add(diameterField,        cc.xy (7, 11));*/

// The builder holds the layout container that we now return.
        rootPanel = builder.getPanel();

        rootPanel.setPreferredSize(size);
        rootPanel.setBorder(border);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
