package com.github.andriell.processor;

/**
 * Created by Андрей on 04.02.2016.
 */
public abstract class ProcessAbstract implements Process {
    private Task task;
    private ManagerInterface processor;

    abstract void doJob();

    public void run() {
        doJob();
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public ManagerInterface getProcessor() {
        return processor;
    }

    public void setProcessor(ManagerInterface processor) {
        this.processor = processor;
    }
}
