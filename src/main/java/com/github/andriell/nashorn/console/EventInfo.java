package com.github.andriell.nashorn.console;

import org.springframework.context.ApplicationEvent;

/**
 * Created by Vika on 03.04.2016
 */
public class EventInfo extends ApplicationEvent {
    private String message;

    public EventInfo(Object source) {
        super(source);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}