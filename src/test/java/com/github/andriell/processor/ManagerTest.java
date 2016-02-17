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


        manager.setRunnableLimiter(new RunnableLimiter(4));
        manager.addData(new TestData());
        manager.addData(new TestData());
        manager.addData(new TestData());
        manager.addData(new TestData());
        manager.addData(new TestData());
        manager.addData(new TestData());
        new Thread(manager).start();
    }

    static class TestData implements DataInterface {
        private static int count = 0;
        private String number;
        public TestData() {
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

    public static class TestProcess extends ProcessAbstract {
        private static int count = 0;
        private String name;

        public TestProcess() {
            name = Integer.toString(count++);
        }

        public void run() {
            TestData data = (TestData) getData();
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
}
