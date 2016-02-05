package com.github.andriell;

import com.github.andriell.processor.Manager;
import com.github.andriell.processor.RunnableLimiter;
import com.github.andriell.test.TestProcess;
import com.github.andriell.test.TestProcessFactory;
import com.github.andriell.test.TestTask;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        // Без этого событие destroy для бинов не будет вызвано
        applicationContext.registerShutdownHook();
        Manager processor = applicationContext.getBean("processor", Manager.class);
        test();
    }

    public static void test() {
        TestProcessFactory factory = new TestProcessFactory();
        Manager manager = new Manager(1000, true);
        manager.setRunnableLimiter(new RunnableLimiter());
        manager.setProcessFactory(factory);
        manager.addTask(new TestTask());
        manager.addTask(new TestTask());
        manager.addTask(new TestTask());
        manager.addTask(new TestTask());
        manager.addTask(new TestTask());
        manager.addTask(new TestTask());
        manager.addTask(new TestTask());
        manager.addTask(new TestTask());
        manager.addTask(new TestTask());
        manager.addTask(new TestTask());
        manager.addTask(new TestTask());
        manager.addTask(new TestTask());
        manager.addTask(new TestTask());
        manager.addTask(new TestTask());
    }
}
