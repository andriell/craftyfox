package com.github.andriell.nashorn.console;

import org.springframework.context.ApplicationEvent;

/**
 * Created by Vika on 03.04.2016
 */
public class ConsoleMessage extends ApplicationEvent {
    public final static int LEVEL_INFO = 1;
    public final static int LEVEL_WARN = 2;
    public final static int LEVEL_ERROR = 4;

    private String message;
    private int level;

    public ConsoleMessage(Object source) {
        super(source);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}