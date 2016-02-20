package com.github.andriell.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.concurrent.*;

/**
 * Created by Андрей on 04.02.2016
 */
public class Manager implements ManagerInterface, InitializingBean, ApplicationContextAware {
    private BlockingQueue<DataInterface> dataQueue;

    private ApplicationContext applicationContext;
    private RunnableLimiter runnableLimiter;
    private RunnableListenerInterface runnableListener;
    private int capacity;
    private boolean fair;

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
            ProcessInterface process = applicationContext.getBean(data.getProcessBeanId(), ProcessInterface.class);
            process.setData(data);
            RunnableAdapter runnableAdapter = RunnableAdapter.envelop(process);
            runnableAdapter.addListenerEnd(runnableListener); // листенер должен выполняться после листенера RunnableLimiter
            if (!runnableLimiter.start(runnableAdapter)) {
                addData(data);
                break;
            }
        }
    }

    public RunnableLimiter getRunnableLimiter() {
        return runnableLimiter;
    }

    public void setRunnableLimiter(RunnableLimiter runnableLimiter) {
        this.runnableLimiter = runnableLimiter;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setFair(boolean fair) {
        this.fair = fair;
    }

    public void afterPropertiesSet() throws Exception {
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

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public int getRunningProcesses() {
        return runnableLimiter.getRunningProcesses();
    }

    public int getLimitProcess() {
        return runnableLimiter.getLimitProcess();
    }

    public int getProcessInQueue() {
        return runnableLimiter.getLimitProcess();
    }
}
