package com.github.andriell.nashorn.informer;

import java.awt.*;

/**
 * Created by Rybalko on 22.09.2016.
 */
public class InformerBeep implements InformerInterface {
    public boolean sendMessage() {
        Toolkit.getDefaultToolkit().beep();
        return true;
    }

    public boolean sendMessage(MessageInterface message) {
        Toolkit.getDefaultToolkit().beep();
        return true;
    }
}
