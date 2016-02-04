package com.github.andriell.test;

import com.github.andriell.processor.ProcessAbstract;

/**
 * Created by Андрей on 04.02.2016.
 */
public class TestProcess extends ProcessAbstract {
    @Override
    protected void doJob() {

    }

    public String getTaskType() {
        return TestTask.class.toString();
    }
}
