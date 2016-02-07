package com.github.andriell.processor;

import com.github.andriell.collection.LinkedSet;

/**
 * Created by Vika on 05.02.2016
 */
public class RunnableAdapter implements Runnable {
    private LinkedSet<RunnableListenerInterface> listeners;
    private Runnable runnable;

    public RunnableAdapter(Runnable runnable) {
        this.runnable = runnable;
        listeners = new LinkedSet<RunnableListenerInterface>();
    }

    public RunnableAdapter addListenerEnd(RunnableListenerInterface listener) {
        listeners.addEnd(listener);
        return this;
    }

    public RunnableAdapter addListenerFirst(RunnableListenerInterface listener) {
        listeners.addFirst(listener);
        return this;
    }

    public RunnableAdapter removeListener(RunnableListenerInterface listener) {
        listeners.remove(listener);
        return this;
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

    public static RunnableAdapter envelop(Runnable runnable) {
        if (runnable instanceof RunnableAdapter) {
            return (RunnableAdapter) runnable;
        } else {
            return new RunnableAdapter(runnable);
        }
    }
}
