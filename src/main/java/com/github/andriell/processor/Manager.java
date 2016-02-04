package com.github.andriell.processor;

import java.util.concurrent.*;

/**
 * Created by Андрей on 04.02.2016.
 */
public class Manager<T extends TaskInterface, P extends ProcessInterface<T>> implements ManagerInterface<T, P> {
    BlockingQueue<T> task;
    private RunnableLimiter runnableLimiter;
    Starter starter;

    ProcessFactoryInterface<T, P> processFactory;
    public Manager(int capacity, boolean fair) {
        starter = new Starter();

        task = new ArrayBlockingQueue<T>(capacity, fair);
    }

    public void addTask(T task) {
        this.task.add(task);

    }

    public T pullTask() {
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
        T task = this.task.poll();
        if (task == null) {
            return false;
        }
        boolean isStart = runnableLimiter.start(processFactory.newProcess(task));
        if (!isStart) {
            this.task.add(task);
        }
        return isStart;
    }
}
