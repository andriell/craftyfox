package com.github.andriell.processor;

/**
 * Created by Андрей on 04.02.2016.
 */
public interface ManagerInterface<T extends TaskInterface, P extends ProcessInterface<T>> {
    public void addProcess(P process);
    public void addTask(T task);
    public void onProcessComplete();
}
