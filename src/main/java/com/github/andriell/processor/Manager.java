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
    private BlockingQueue<Object> dataQueue;

    private ApplicationContext applicationContext;
    private RunnableLimiter runnableLimiter;
    private RunnableListenerInterface runnableListener;
    private String processBeanId;
    private int capacity;
    private boolean fair;

    public void addData(Object task) {
        dataQueue.add(task);
    }

    public void setProcessBeanId(String processBeanId) {
        this.processBeanId = processBeanId;
    }

    public String getProcessBeanId() {
        return processBeanId;
    }

    public Object pullTask() {
        return dataQueue.poll();
    }

    public void run() {
        while (true) {
            if (!runnableLimiter.canStart()) {
                break;
            }
            Object data = pullTask();
            if (data == null) {
                break;
            }
            ProcessInterface process = applicationContext.getBean(getProcessBeanId(), ProcessInterface.class);
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
        dataQueue = new ArrayBlockingQueue<Object>(capacity, fair);
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
        return dataQueue.size();
    }
}
