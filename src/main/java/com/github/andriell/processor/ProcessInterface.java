package com.github.andriell.processor;

/**
 * Created by Андрей on 04.02.2016.
 */
public interface ProcessInterface extends Runnable {
    public void setManager(ManagerInterface processor);
    public ManagerInterface getManager();
    public void setTask(TaskInterface taskInterface);
    public TaskInterface getTask();
    public String getTaskType();
}
