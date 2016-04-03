package com.github.andriell.nashorn.console;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * Created by Andrey on 03.04.2016
 */
public class Console implements ApplicationEventPublisherAware {
    public final static Console console = new Console();

    private Console() {}

    static void info(String message) {
        console.infoPrivate(message);
    }

    private ApplicationEventPublisher publisher;

    public void infoPrivate(String message) {
        EventInfo info = new EventInfo(this);
        info.setMessage(message);
        publisher.publishEvent(info);
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        publisher = applicationEventPublisher;
    }
}
