package com.github.andriell.processor;

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

    public static class TestData1 implements DataInterface {
        private static int count = 0;
        private String number;
        public TestData1() {
            number = Integer.toString(count++);
        }

        @Override
        public String toString() {
            return number;
        }

        public int getProcessType() {
            return 0;
        }
    }


    public static class TestProcess1 extends ProcessAbstract {
        private static int count = 0;
        private String name;

        public TestProcess1() {
            name = Integer.toString(count++);
        }

        public void run() {
            ManagerTest.TestData1 data = (ManagerTest.TestData1) getData();
            for (int i = 0; i < 10; i++) {
                System.out.println("process " + this + " task " + data + " " + i);
                RunnableLimiter.sleep(100 + (int) (Math.random() * 200));
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
}
