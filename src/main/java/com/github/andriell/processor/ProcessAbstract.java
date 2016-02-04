package com.github.andriell.processor;

/**
 * Created by Андрей on 04.02.2016.
 */
public abstract class ProcessAbstract implements Process {
    private Task task;
    private ProcessorInterface processor;

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

    public ProcessorInterface getProcessor() {
        return processor;
    }

    public void setProcessor(ProcessorInterface processor) {
        this.processor = processor;
    }
}
