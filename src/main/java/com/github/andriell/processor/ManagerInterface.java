package com.github.andriell.processor;

/**
 * Created by Андрей on 04.02.2016
 */
public interface ManagerInterface {
    void addTask(TaskInterface task);
    TaskInterface pullTask();
    void onProcessComplete();
}
