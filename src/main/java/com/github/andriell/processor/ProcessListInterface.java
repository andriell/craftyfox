package com.github.andriell.processor;

import java.util.Collection;

/**
 * Created by Rybalko on 17.06.2016.
 */
public interface ProcessListInterface extends RunnableListenerInterface {
    Collection<Runnable> getProcess();
    public boolean stop(Runnable r);
}
