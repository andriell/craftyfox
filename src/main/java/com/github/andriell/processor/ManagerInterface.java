package com.github.andriell.processor;

/**
 * Created by Андрей on 04.02.2016
 */
public interface ManagerInterface extends Runnable {
    boolean addData(Object task);
    String getProcessBeanId();
    String getDataBeanId();
    int getRunningProcesses();
    int getProcessInQueue();
    int getLimitProcess();
    void setLimitProcess(int limit);
    void stop();
    boolean isRun();
}
