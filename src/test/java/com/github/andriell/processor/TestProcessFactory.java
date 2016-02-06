package com.github.andriell.processor;

/**
 * Created by Андрей on 04.02.2016.
 */
public class TestProcessFactory implements ProcessFactoryInterface {
    public ProcessInterface newProcess(DataInterface data) {
        TestProcess process = new TestProcess();
        process.setData(data);
        return process;
    }
}
