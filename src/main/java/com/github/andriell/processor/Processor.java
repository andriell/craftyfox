package com.github.andriell.processor;

import com.github.andriell.collection.LinkedSet;

/**
 * Created by Андрей on 04.02.2016
 */
public class Processor {
    LinkedSet[] data;
    RunnableLimiter[] limiter;

    public Processor(int size) {
        data = new LinkedSet[size];
        limiter = new RunnableLimiter[size];
    }
}
