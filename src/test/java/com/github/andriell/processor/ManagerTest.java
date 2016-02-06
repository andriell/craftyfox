package com.github.andriell.processor;

/**
 * Created by Vika on 06.02.2016
 */
public class ManagerTest {
    public static void main(String[] args) {
        TestProcessFactory factory = new TestProcessFactory();
        Manager manager = new Manager(1000, true);
        manager.setRunnableLimiter(new RunnableLimiter(1));
        manager.setProcessFactory(factory);
        manager.addData(new TestData());
        manager.addData(new TestData());
        manager.addData(new TestData());
        manager.addData(new TestData());
        manager.addData(new TestData());
        manager.addData(new TestData());
        manager.start();
    }
}
