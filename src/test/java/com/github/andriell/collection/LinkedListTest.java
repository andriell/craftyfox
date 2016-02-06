package com.github.andriell.collection;

import com.github.andriell.processor.*;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Vika on 06.02.2016
 */
public class LinkedListTest {
    public static void main(String[] args) {

    }

    public static void test3() {
        RunnableLimiter limiter = new RunnableLimiter(1);
        limiter.start(new TestProcess(new TestData()));
        System.out.println(1);
        limiter.start(new TestProcess(new TestData()));
        System.out.println(2);
        limiter.start(new TestProcess(new TestData()));
        System.out.println(3);
    }

    public static void test2() {
        BlockingQueue<DataInterface> taskQueue = new ArrayBlockingQueue<DataInterface>(1000);
        taskQueue.add(new TestData());
        taskQueue.add(new TestData());
        taskQueue.add(new TestData());
        System.out.println(taskQueue.poll());
        System.out.println(taskQueue.poll());
        System.out.println(taskQueue.poll());
        System.out.println(taskQueue.poll());
    }

    public static void test() {
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
