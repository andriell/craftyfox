package org.springframework.context.support;

import com.github.andriell.processor.Manager;
import org.junit.Test;
import org.springframework.beans.BeansException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Vika on 24.06.2016
 */
public class ContextTest {
    protected ClassPathXmlApplicationContext applicationContext;
    @Test
    public void test1() {
        applicationContext = new ClassPathXmlApplicationContext("classpath:test-container.xml");
        // Без этого событие destroy для бинов не будет вызвано
        applicationContext.registerShutdownHook();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 100; i++) {
            new Thread(new Process()).start();
        }

    }

    class Process implements Runnable {

        public void run() {

            Object objectPrototype1, objectPrototype2, objectSingleton1, objectSingleton2;

            objectPrototype1 = applicationContext.getBean("objectPrototype", Object.class);

            for (int i = 0; i<100; i++) {
                objectPrototype2 = applicationContext.getBean("objectPrototype", Object.class);
                assertEquals("objectPrototype" + i, true, objectPrototype1 != objectPrototype2);
                objectPrototype1 = objectPrototype2;
            }

            objectSingleton1 = applicationContext.getBean("objectSingleton", Object.class);

            for (int i = 0; i<100; i++) {
                objectSingleton2 = applicationContext.getBean("objectSingleton", Object.class);
                assertEquals("objectSingleton" + i, true, objectSingleton1 == objectSingleton2);
                objectSingleton1 = objectSingleton2;
            }
        }
    }
}
