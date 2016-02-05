package com.github.andriell.processor;

import java.util.concurrent.*;

/**
 * Created by Андрей on 04.02.2016
 */
public class Manager implements ManagerInterface {
    private BlockingQueue<DataInterface> taskQueue;
    private Starter starter;

    private ProcessFactoryInterface processFactory;
    private RunnableLimiter runnableLimiter;
    private RunnableListener runnableListener;

    public Manager(int capacity, boolean fair) {

        runnableListener = new RunnableListener();
        taskQueue = new ArrayBlockingQueue<DataInterface>(capacity, fair);
    }

    public void start() {
        if (starter == null) {
            starter = new Starter();
            runnableLimiter.start(starter);
        }
    }

    public void stop() {
        if (starter != null) {
            starter.stop();
            starter = null;
        }
    }

    public void addData(DataInterface task) {
        taskQueue.add(task);
    }

    public DataInterface pullTask() {
        return taskQueue.poll();
    }

    private class Starter implements Runnable {
        private boolean start = true;
        public void run() {
            while (start) {
                boolean isRun = true;
                do {
                    try {
                        isRun = runNew();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } while (isRun && start);
                RunnableLimiter.sleep(1000);
            }
        }
        public void stop() {
            start = false;
        }
    }

    private class RunnableListener implements RunnableListenerInterface {

        public void onStart(Runnable r) {}

        public void onException(Runnable r, Exception e) {}

        public void onComplete(Runnable r) {
            runNew();
        }
    }

    protected boolean runNew() {
        DataInterface data = pullTask();
        if (data == null) {
            return false;
        }
        ProcessInterface process = processFactory.newProcess(data);
        RunnableAdapter runnableAdapter = RunnableAdapter.envelop(process);
        runnableAdapter.addListener(runnableListener);
        if (!runnableLimiter.start(runnableAdapter)) {
            addData(data);
            return false;
        }
        return true;
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
