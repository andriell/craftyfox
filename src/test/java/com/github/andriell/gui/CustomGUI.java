package com.github.andriell.gui;

import javax.swing.*;
import java.util.Enumeration;

/**
 * Created by Rybalko on 01.08.2016.
 */
public class CustomGUI {
    public static void main(String[] args) {
        Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get (key);
            System.out.print(key);
            System.out.print(":\t");
            System.out.println(value);
        }

    }
}
