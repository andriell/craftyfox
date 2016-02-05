package com.github.andriell.processor;

/**
 * Created by Андрей on 04.02.2016
 */
public abstract class ProcessAbstract implements ProcessInterface {
    private ManagerInterface manager;

    protected abstract void doJob();

    public void run() {
        doJob();
        getManager().onProcessComplete();
    }

    public TaskInterface pullTask() {
        return manager.pullTask();
    }

    public ManagerInterface getManager() {
        return manager;
    }

    public void setManager(ManagerInterface manager) {
        this.manager = manager;
    }
}
