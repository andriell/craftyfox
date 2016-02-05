package com.github.andriell;

import com.github.andriell.processor.Manager;
import com.github.andriell.processor.RunnableLimiter;
import com.github.andriell.processor.DataInterface;
import com.github.andriell.test.TestProcessFactory;
import com.github.andriell.test.TestData;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
        /*ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        // Без этого событие destroy для бинов не будет вызвано
        applicationContext.registerShutdownHook();
        Manager processor = applicationContext.getBean("processor", Manager.class);*/
        test();
    }

    public static void test3() {
        //ThreadPoolExecutor executor = new ThreadPoolExecutor();
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
        manager.setRunnableLimiter(new RunnableLimiter(4));
        manager.setProcessFactory(factory);
        manager.addTask(new TestData());
        manager.addTask(new TestData());
        manager.addTask(new TestData());
        manager.addTask(new TestData());
        manager.start();
    }
}
