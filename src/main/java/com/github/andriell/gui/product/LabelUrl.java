package com.github.andriell.gui.product;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.net.URL;

/**
 * Created by Rybalko on 11.07.2016.
 */
public class LabelUrl extends JLabel {
    private static final Log LOG = LogFactory.getLog(ProductsWorkArea.class);
    private URI uri;

    public LabelUrl(String text) {
        super(text);
        try {
            uri = new URL(text).toURI();
        } catch (Exception e) {
            LOG.error(this, e);
        }
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        addMouseListener(new ClickListener());
        setForeground(Color.BLUE);
    }

    public class ClickListener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            try {
                Desktop.getDesktop().browse(uri);
            } catch (Exception e1) {
                LOG.error(this, e1);
            }
        }
    }
}