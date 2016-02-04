package com.github.andriell.processor;

/**
 * Created by Андрей on 04.02.2016.
 */
public abstract class ProcessAbstract implements ProcessInterface {
    private TaskInterface taskInterface;
    private ManagerInterface processor;

    abstract void doJob();

    public void run() {
        doJob();
    }

    public TaskInterface getTask() {
        return taskInterface;
    }

    public void setTask(TaskInterface taskInterface) {
        this.taskInterface = taskInterface;
    }

    public ManagerInterface getManager() {
        return processor;
    }

    public void setManager(ManagerInterface processor) {
        this.processor = processor;
    }
}
