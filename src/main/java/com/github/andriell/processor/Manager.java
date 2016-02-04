package com.github.andriell.processor;

import java.util.concurrent.*;

/**
 * Created by Андрей on 04.02.2016.
 */
public class Manager<T extends TaskInterface, P extends ProcessInterface<T>> implements ManagerInterface<T, P> {
    BlockingQueue<T> task;

    ProcessFactoryInterface<T, P> processFactory;
    public Manager(int capacity, boolean fair) {
        task = new ArrayBlockingQueue<T>(capacity, fair);
    }

    public void addProcess(P process) {
        process.setManager(this);
    }

    public void addTask(T task) {
        this.task.add(task);
    }

    public void onProcessComplete() {
        processFactory.newProcess(task.poll());
    }
}
