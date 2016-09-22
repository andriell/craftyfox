package com.github.andriell.nashorn.console;

/**
 * Created by Andrey on 03.04.2016
 */
public class Console {
    private ConsoleListenerInterface[] consoleListeners;

    private void publishConsoleMessage(int level, String message) {
        ConsoleMessage consoleMessage = new ConsoleMessage();
        consoleMessage.setLevel(level);
        consoleMessage.setMessage(message);
        for (ConsoleListenerInterface listener: consoleListeners) {
            listener.onConsoleMessage(consoleMessage);
        }
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

    public void setConsoleListeners(ConsoleListenerInterface[] consoleListeners) {
        this.consoleListeners = consoleListeners;
    }

    public void sleep(int s) {
        try {
            Thread.sleep(s * 1000);
        } catch (Exception ignored) {}
    }

    public void sleep(long s) {
        try {
            Thread.sleep(s * 1000);
        } catch (Exception ignored) {}
    }
}
