package com.github.andriell.processor;

/**
 * Created by Андрей on 04.02.2016.
 */
public class TestProcess extends ProcessAbstract {
    @Override
    void doJob() {

    }

    public String getTaskType() {
        return TestTask.class.toString();
    }
}
