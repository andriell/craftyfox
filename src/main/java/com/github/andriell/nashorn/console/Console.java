package com.github.andriell.nashorn.console;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * Created by Andrey on 03.04.2016
 */
public class Console implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;

    private void publishConsoleMessage(int level, String message) {
        ConsoleMessage info = new ConsoleMessage(this);
        info.setLevel(level);
        info.setMessage(message);
        publisher.publishEvent(info);
    }

    public void info(String message) {
        publishConsoleMessage(ConsoleMessage.LEVEL_INFO, message);
    }

    public void log(String message) {
        publishConsoleMessage(ConsoleMessage.LEVEL_INFO, message);
    }

    public void warn(String message) {
        publishConsoleMessage(ConsoleMessage.LEVEL_WARN, message);
    }

    public void error(String message) {
        publishConsoleMessage(ConsoleMessage.LEVEL_ERROR, message);
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        publisher = applicationEventPublisher;
    }
}
