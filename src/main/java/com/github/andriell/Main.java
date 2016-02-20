package com.github.andriell;

import com.github.andriell.gui.MainFrame;
import com.github.andriell.processor.Manager;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        // Без этого событие destroy для бинов не будет вызвано
        applicationContext.registerShutdownHook();
        Manager manager = applicationContext.getBean("manager", Manager.class);
        MainFrame frame = new MainFrame();
        frame.setManager(manager);
        frame.afterPropertiesSet();
    }
}
