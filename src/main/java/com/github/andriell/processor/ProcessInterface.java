package com.github.andriell.processor;

/**
 * Created by Андрей on 04.02.2016.
 */
public interface ProcessInterface<T extends TaskInterface> extends Runnable {
    public void setManager(ManagerInterface<T, ProcessInterface<T>> manager);
    public ManagerInterface<T, ProcessInterface<T>> getManager();
    public T getTask();
    public String getTaskType();
}
