package com.github.andriell.nashorn.console;

import org.springframework.context.ApplicationEvent;

/**
 * Created by Vika on 03.04.2016
 */
public class ConsoleMessage implements ConsoleMessageInterface {
    private String message;
    private int level;

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