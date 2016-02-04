package com.github.andriell.processor;

/**
 * Created by Андрей on 04.02.2016.
 */
public interface Process extends Runnable {
    public void setProcessor(ManagerInterface processor);
    public ManagerInterface getProcessor();
    public void setTask(Task task);
    public Task getTask();
    public String getTaskType();
}
