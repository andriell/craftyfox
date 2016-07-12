package com.github.andriell.processor;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Андрей on 04.02.2016
 */
public class Manager implements ManagerInterface, ApplicationContextAware {
    private ApplicationContext applicationContext;

    private ThreadPoolExecutor pool =  new ThreadPoolExecutor(2, 100, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

    private String processBeanId;

    public boolean addData(Object data) {
        ProcessInterface process = applicationContext.getBean(getProcessBeanId(), ProcessInterface.class);
        process.setData(data);
        pool.execute(process);
        return true;
    }

    public String getProcessBeanId() {
        return processBeanId;
    }

    public void setProcessBeanId(String processBeanId) {
        this.processBeanId = processBeanId;
    }

    public void stop() {
        pool.shutdown();
    }

    public boolean isRun() {
        return pool.getActiveCount() > 0;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public int getRunningProcesses() {
        return pool.getActiveCount();
    }

    public int getLimitProcess() {
        return pool.getCorePoolSize();
    }

    public void setLimitProcess(int limit) {
        pool.setCorePoolSize(limit);
    }

    public int getTotalProcess() {
        return (int) pool.getTaskCount();
    }

    public int getCompletedProcess() {
        return (int) pool.getCompletedTaskCount();
    }

    public int getProcessInQueue() {
        return (int) (pool.getTaskCount() - pool.getCompletedTaskCount());
    }
}
