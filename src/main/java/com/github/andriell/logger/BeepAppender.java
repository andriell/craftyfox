package com.github.andriell.logger;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

import java.awt.*;

/**
 * Этот аппендер пикает PC-спикером и выводит на консоль сообщение.
 */
public class BeepAppender extends AppenderSkeleton {
    /**
     * Пикаем и выводим сообщение.
     * @param event отсюда берётся сообщение.
     */
    @Override
    protected void append(LoggingEvent event) {
        Toolkit.getDefaultToolkit().beep();
        System.out.println(event.getMessage());
    }

    /**
     * ресурсы не выделялись - закрывать ничего не надо.
     */
    public void close() {

    }
    /**
     * Layout не используется.
     */
    public boolean requiresLayout() {
        return false;
    }
}