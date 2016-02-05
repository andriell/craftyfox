package com.github.andriell.processor;

/**
 * Created by Андрей on 04.02.2016
 */
public interface ProcessInterface extends Runnable {
    String getTaskType();
    void setData(DataInterface data);
    DataInterface getData();
}
