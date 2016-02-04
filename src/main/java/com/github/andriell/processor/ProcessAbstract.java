package com.github.andriell.processor;

/**
 * Created by Андрей on 04.02.2016.
 */
public abstract class ProcessAbstract<T extends TaskInterface> implements ProcessInterface<T> {
    private ManagerInterface<T, super<T>> manager;

    protected abstract void doJob();

    public void run() {
        doJob();
        getManager().onProcessComplete();
    }

    public T getTask() {
        return manager.pullTask();
    }



    public ManagerInterface getManager() {
        return manager;
    }

    public void setManager(ManagerInterface manager) {
        this.manager = manager;
    }
}
