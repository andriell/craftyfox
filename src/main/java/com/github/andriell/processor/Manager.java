package com.github.andriell.processor;

import java.util.concurrent.*;

/**
 * Created by Андрей on 04.02.2016
 */
public class Manager implements ManagerInterface {
    private BlockingQueue<TaskInterface> taskQueue;
    private Starter starter;
    private boolean start = true;

    private ProcessFactoryInterface processFactory;
    private RunnableLimiter runnableLimiter;

    public Manager(int capacity, boolean fair) {
        starter = new Starter();
        taskQueue = new ArrayBlockingQueue<TaskInterface>(capacity, fair);
        taskQueue.remainingCapacity();
    }

    public void start() {
        start = true;
        runnableLimiter.start(starter);
    }

    public void stop() {
        start = false;
    }

    public void addTask(TaskInterface task) {
        taskQueue.add(task);
    }

    public TaskInterface pullTask() {
        return taskQueue.poll();
    }

    private class Starter implements Runnable {
        public void run() {
            while (start) {
                boolean isRunen = true;
                do {
                    try {
                        isRunen = runNew();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } while (isRunen);
                RunnableLimiter.sleep(1000);
            }
        }
    }

    public void onProcessComplete() {
        runNew();
    }

    protected boolean runNew() {
        return runnableLimiter.start(processFactory.newProcess(this));
    }

    public ProcessFactoryInterface getProcessFactory() {
        return processFactory;
    }

    public void setProcessFactory(ProcessFactoryInterface processFactory) {
        this.processFactory = processFactory;
    }

    public RunnableLimiter getRunnableLimiter() {
        return runnableLimiter;
    }

    public void setRunnableLimiter(RunnableLimiter runnableLimiter) {
        if (runnableLimiter.getLimitProcess() <= 1) {
            runnableLimiter.setLimitProcess(2);
        }
        this.runnableLimiter = runnableLimiter;
    }
}
