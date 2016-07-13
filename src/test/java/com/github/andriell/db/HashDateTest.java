package com.github.andriell.db;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rybalko on 13.07.2016.
 */
public class HashDateTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        // Без этого событие destroy для бинов не будет вызвано
        applicationContext.registerShutdownHook();
        HashDateDaoImpl dateDao = applicationContext.getBean("hashDateDaoImpl", HashDateDaoImpl.class);

        assertEquals(true, dateDao.checkSec("test", 2));
        assertEquals(false, dateDao.checkSec("test", 2));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {}
        assertEquals(true, dateDao.checkSec("test", 2));
    }
}
