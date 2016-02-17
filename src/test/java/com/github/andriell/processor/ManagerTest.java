package com.github.andriell.processor;

import com.github.andriell.test.TestData1;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Vika on 06.02.2016
 */
public class ManagerTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        // Без этого событие destroy для бинов не будет вызвано
        applicationContext.registerShutdownHook();
        Manager manager = applicationContext.getBean("manager", Manager.class);
        manager.addData(new TestData1());
        manager.addData(new TestData1());
        manager.addData(new TestData1());
        manager.addData(new TestData1());
        manager.addData(new TestData1());
        manager.addData(new TestData1());
        new Thread(manager).start();
    }

}
