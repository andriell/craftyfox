package com.github.andriell.processor;

import java.util.concurrent.*;

/**
 * Created by Андрей on 04.02.2016.
 */
public class Manager<T extends TaskInterface, P extends ProcessInterface> implements ManagerInterface<T, P> {
    BlockingQueue<T> task;
    BlockingQueue<P> processRun;
    BlockingQueue<P> processStop;
    public Manager(int capacity, boolean fair) {
        task = new ArrayBlockingQueue<T>(capacity, fair);
        processRun = new ArrayBlockingQueue<P>(1000);
        processStop = new ArrayBlockingQueue<P>(1000);
    }

    public void addProcess(P process) {
        process.setManager(this);
        processStop.add(process);
    }

    public void addTask(T task) {
        this.task.add(task);
    }
}
