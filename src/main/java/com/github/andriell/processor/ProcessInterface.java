package com.github.andriell.processor;

/**
 * Created by Андрей on 04.02.2016.
 */
public interface ProcessInterface<T extends TaskInterface> extends Runnable {
    public void setManager(ManagerInterface processor);
    public ManagerInterface getManager();
    public void setTask(T taskInterface);
    public T getTask();
    public String getTaskType();
}
