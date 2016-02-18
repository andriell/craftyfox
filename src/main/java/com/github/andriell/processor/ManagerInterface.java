package com.github.andriell.processor;

/**
 * Created by Андрей on 04.02.2016
 */
public interface ManagerInterface extends Runnable {
    void addData(DataInterface task);
    DataInterface pullTask();
}
