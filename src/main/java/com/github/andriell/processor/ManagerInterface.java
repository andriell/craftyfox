package com.github.andriell.processor;

/**
 * Created by Андрей on 04.02.2016
 */
public interface ManagerInterface {
    boolean addData(Object data);
    String getProcessBeanId();
    int getRunningProcesses();
    int getProcessInQueue();
    int getLimitProcess();
    void setLimitProcess(int limit);
    void stop();
    boolean isRun();
}
