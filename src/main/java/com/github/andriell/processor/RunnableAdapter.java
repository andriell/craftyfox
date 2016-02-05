package com.github.andriell.processor;

import java.util.HashSet;

/**
 * Created by Vika on 05.02.2016
 */
public class RunnableAdapter implements Runnable {
    private HashSet<RunnableListenerInterface> listeners = new HashSet<RunnableListenerInterface>();
    private Runnable runnable;
    public RunnableAdapter(Runnable runnable) {
        this.runnable = runnable;
    }

    public void run() {
        for (RunnableListenerInterface listener: listeners) {
            try {
                listener.onStart();
            } catch (Exception e) {
                listener.onException(e);
            }
        }
        try {
            runnable.run();
        } catch (Exception e) {
            for (RunnableListenerInterface listener: listeners) {
                listener.onException(e);
            }
        }
        for (RunnableListenerInterface listener: listeners) {
            try {
                listener.onComplete();
            } catch (Exception e) {
                listener.onException(e);
            }
        }
    }
}
