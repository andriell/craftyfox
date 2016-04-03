package com.github.andriell.nashorn.console;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * Created by Andrey on 03.04.2016
 */
public class Console implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;

    public void info(String message) {
        EventInfo info = new EventInfo(this);
        info.setMessage(message);
        publisher.publishEvent(info);
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        publisher = applicationEventPublisher;
    }
}
