package com.github.andriell.processor;

import java.util.concurrent.*;

/**
 * Created by Андрей on 04.02.2016
 */
public class Manager implements ManagerInterface {
    private BlockingQueue<DataInterface> dataQueue;

    private ProcessFactoryInterface processFactory;
    private RunnableLimiter runnableLimiter;
    private RunnableListenerInterface runnableListener;

    public Manager(int capacity, boolean fair) {
        runnableListener = new RunnableListenerInterface() {
            public void onStart(Runnable r) {
            }
            public void onException(Runnable r, Exception e) {
                run();
            }
            public void onComplete(Runnable r) {
                run();
            }
        };
        dataQueue = new ArrayBlockingQueue<DataInterface>(capacity, fair);
    }

    public void addData(DataInterface task) {
        dataQueue.add(task);
    }

    public DataInterface pullTask() {
        return dataQueue.poll();
    }

    public void run() {
        while (true) {
            if (!runnableLimiter.canStart()) {
                break;
            }
            DataInterface data = pullTask();
            if (data == null) {
                break;
            }
            ProcessInterface process = processFactory.newProcess(data);
            RunnableAdapter runnableAdapter = RunnableAdapter.envelop(process);
            runnableAdapter.addListenerEnd(runnableListener); // листенер должен выполняться после листенера RunnableLimiter
            if (!runnableLimiter.start(runnableAdapter)) {
                addData(data);
                break;
            }
        }
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
        runnableLimiter.setLimitProcess(runnableLimiter.getLimitProcess() + 1);
        this.runnableLimiter = runnableLimiter;
    }
}
