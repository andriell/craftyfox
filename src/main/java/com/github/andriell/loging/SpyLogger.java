package com.github.andriell.loging;

import com.p6spy.engine.logging.Category;
import com.p6spy.engine.spy.appender.FormattedLogger;

import java.io.PrintStream;

/**
 * Created by Rybalko on 01.07.2016.
 */
public class SpyLogger extends FormattedLogger {
    public SpyLogger() {
        int i = 10;
    }

    protected PrintStream getStream() {
        return System.out;
    }

    public void logException(Exception e) {
        e.printStackTrace(this.getStream());
    }

    public void logText(String text) {
        System.out.println(text);
    }

    public boolean isCategoryEnabled(Category category) {
        return true;
    }
}
