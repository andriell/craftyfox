package com.github.andriell.processor;

import java.util.concurrent.*;

/**
 * Created by Андрей on 04.02.2016
 */
public class Manager implements ManagerInterface {
    private BlockingQueue<DataInterface> taskQueue;
    private Starter starter;
    private boolean start = true;

    private ProcessFactoryInterface processFactory;
    private RunnableLimiter runnableLimiter;

    public Manager(int capacity, boolean fair) {
        starter = new Starter();
        taskQueue = new ArrayBlockingQueue<DataInterface>(capacity, fair);
        taskQueue.remainingCapacity();
    }

    public void start() {
        start = true;
        runnableLimiter.start(starter);
    }

    public void stop() {
        start = false;
    }

    public void addTask(DataInterface task) {
        taskQueue.add(task);
    }

    public DataInterface pullTask() {
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
        DataInterface task = pullTask();
        if (task == null) {
            return false;
        }

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
