package com.github.andriell.processor;

/**
 * Created by Андрей on 04.02.2016.
 */
public interface ManagerInterface {
    public void addTask(TaskInterface task);
    public TaskInterface pullTask();
    public void onProcessComplete();
}
