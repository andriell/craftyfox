package com.github.andriell.test;

import com.github.andriell.processor.ProcessAbstract;
import com.github.andriell.processor.RunnableLimiter;

/**
 * Created by Андрей on 04.02.2016
 */
public class TestProcess extends ProcessAbstract {
    private static int count = 0;
    private String name;

    public TestProcess() {
        this(null);
    }

    public TestProcess(TestData data) {
        setData(data);
        name = Integer.toString(count++);
    }

    public void run() {
        TestData data = (TestData) getData();
        for (int i = 0; i < 10; i++) {
            System.out.println("process " + this + " task " + data + " " + i);
            RunnableLimiter.sleep(100);
        }
    }

    public String getTaskType() {
        return TestData.class.toString();
    }

    @Override
    public String toString() {
        return name;
    }
}
