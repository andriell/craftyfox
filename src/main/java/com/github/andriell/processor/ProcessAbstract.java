package com.github.andriell.processor;

/**
 * Created by Андрей on 04.02.2016.
 */
public abstract class ProcessAbstract<T extends TaskInterface> implements ProcessInterface<T> {
    private T task;
    private ManagerInterface processor;

    protected abstract void doJob();

    public void run() {
        doJob();
        getManager().onProcessComplete();
    }

    public T getTask() {
        return task;
    }

    public void setTask(T task) {
        this.task = task;
    }

    public ManagerInterface getManager() {
        return processor;
    }

    public void setManager(ManagerInterface processor) {
        this.processor = processor;
    }
}
