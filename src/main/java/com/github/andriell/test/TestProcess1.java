package com.github.andriell.test;

import com.github.andriell.processor.ProcessAbstract;
import com.github.andriell.processor.RunnableLimiter;

/**
 * Created by Андрей on 17.02.2016.
 */
public class TestProcess1 extends ProcessAbstract {
    private static int count = 0;
    private String name;

    public TestProcess1() {
        name = Integer.toString(count++);
    }

    public void run() {
        TestData1 data = (TestData1) getData();
        for (int i = 0; i < 10; i++) {
            System.out.println("process " + this + " task " + data + " " + i);
            RunnableLimiter.sleep(100);
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public int getProcessType() {
        return 0;
    }
}
