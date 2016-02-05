package com.github.andriell.test;

import com.github.andriell.processor.ProcessFactoryInterface;
import com.github.andriell.processor.ProcessInterface;
import com.github.andriell.processor.DataInterface;

/**
 * Created by Андрей on 04.02.2016.
 */
public class TestProcessFactory implements ProcessFactoryInterface {
    public ProcessInterface newProcess(DataInterface manager) {
        TestProcess process = new TestProcess();
        process.setManager(manager);
        return process;
    }
}
