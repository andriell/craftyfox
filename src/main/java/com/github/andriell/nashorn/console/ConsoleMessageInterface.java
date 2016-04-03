package com.github.andriell.nashorn.console;

/**
 * Created by Vika on 03.04.2016
 */
public interface ConsoleMessageInterface {
    public final static int LEVEL_LOG = 0;
    public final static int LEVEL_INFO = 1;
    public final static int LEVEL_WARN = 2;
    public final static int LEVEL_ERROR = 3;

    public String getMessage();
    public int getLevel();
}
