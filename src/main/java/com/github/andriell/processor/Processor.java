package com.github.andriell.processor;

import com.github.andriell.collection.LinkedSet;

/**
 * Created by Андрей on 04.02.2016
 */
public class Processor {
    ManagerInterface[] managers;
    RunnableLimiter[] limiter;

    public Processor(int size) {
        managers = new Manager[size];
    }


}
