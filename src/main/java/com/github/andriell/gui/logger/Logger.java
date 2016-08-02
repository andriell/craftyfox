package com.github.andriell.gui.logger;

import org.apache.log4j.*;

import java.util.Enumeration;

/**
 * Created by Rybalko on 02.08.2016.
 */
public class Logger {
    public Logger() {
        ConsoleAppender console = new ConsoleAppender(); //create appender
        //configure the appender
        String PATTERN = "100500 - %d [%p|%c|%C{1}] %m%n";
        console.setLayout(new PatternLayout(PATTERN));
        console.setThreshold(Level.DEBUG);
        console.activateOptions();
        //add appender to any Logger (here is root)
        org.apache.log4j.Logger.getRootLogger().addAppender(console);

        System.out.println(100500);
        for (Enumeration loggers = LogManager.getCurrentLoggers(); loggers.hasMoreElements(); ) {
            org.apache.log4j.Logger logger = (org.apache.log4j.Logger) loggers.nextElement();
            logger.addAppender(console);
            logger.setLevel(Level.DEBUG);
            System.out.println(logger.getName());
            for (Enumeration appenders = logger.getAllAppenders(); appenders.hasMoreElements(); ) {
                Appender appender = (Appender) appenders.nextElement();
            }
        }
    }
}
