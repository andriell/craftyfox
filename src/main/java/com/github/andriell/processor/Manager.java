package com.github.andriell.processor;

import java.util.concurrent.*;

/**
 * Created by Андрей on 04.02.2016.
 */
public class Manager implements ManagerInterface {
    BlockingQueue task;
    private RunnableLimiter runnableLimiter;
    Starter starter;

    ProcessFactoryInterface processFactory;

    public Manager(int capacity, boolean fair) {
        starter = new Starter();

        task = new ArrayBlockingQueue(capacity, fair);
    }

    public void addTask(TaskInterface task) {
        this.task.add(task);
    }

    public TaskInterface pullTask() {
        return null;
    }

    private class Starter implements Runnable {
        public void run() {
            while (true) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onProcessComplete() {
        runNew();
    }

    protected boolean runNew() {
        return runnableLimiter.start(processFactory.newProcess(this));
    }
}
