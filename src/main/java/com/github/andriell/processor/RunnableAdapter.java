package com.github.andriell.processor;

import java.util.HashSet;

/**
 * Created by Vika on 05.02.2016
 */
public class RunnableAdapter implements Runnable {
    private HashSet<RunnableListenerInterface> listeners;
    private Runnable runnable;

    public RunnableAdapter(Runnable runnable) {
        this.runnable = runnable;
        listeners = new HashSet<RunnableListenerInterface>();
    }

    public void addListener(RunnableListenerInterface listener) {
        listeners.add(listener);
    }

    public void removeListener(RunnableListenerInterface listener) {
        listeners.remove(listener);
    }

    public int sizeListener() {
        return listeners.size();
    }

    public void run() {
        for (RunnableListenerInterface listener: listeners) {
            try {
                listener.onStart(runnable);
            } catch (Exception e) {
                listener.onException(runnable, e);
            }
        }
        try {
            runnable.run();
        } catch (Exception e) {
            for (RunnableListenerInterface listener: listeners) {
                listener.onException(runnable, e);
            }
        }
        for (RunnableListenerInterface listener: listeners) {
            try {
                listener.onComplete(runnable);
            } catch (Exception e) {
                listener.onException(runnable, e);
            }
        }
    }
}
