package com.github.andriell.processor;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by Rybalko on 17.06.2016.
 */
public class ProcessList implements ProcessListInterface  {
    CopyOnWriteArraySet<Runnable> set = new CopyOnWriteArraySet<Runnable>();
    public void onStart(Runnable r) {
        set.add(r);
    }

    public void onException(Runnable r, Exception e) {
        set.remove(r);
    }

    public void onComplete(Runnable r) {
        set.remove(r);
    }


    public Collection<Runnable> getProcess() {
        return set;
    }

    public boolean stop(Runnable r) {
        return false;
    }
}
