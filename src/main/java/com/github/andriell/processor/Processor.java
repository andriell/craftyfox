package com.github.andriell.processor;

/**
 * Created by Андрей on 04.02.2016
 */
public class Processor {
    ManagerInterface[] managers;

    public Processor(int size) {
        managers = new Manager[size];
    }

    public void addData(DataInterface data) {

    }
}
