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
        name = Integer.toString(count++);
    }

    @Override
    protected void doJob() {
        TestData task = (TestData) pullTask();
        for (int i = 0; i < 10; i++) {
            System.out.println("process " + this + " task " + task + " " + i);
            RunnableLimiter.sleep(100);
        }
    }

    public String getTaskType() {
        return TestData.class.toString();
    }

    @Override
    public String toString() {
        return "TestProcess{" +
                "name='" + name + '\'' +
                '}';
    }
}
