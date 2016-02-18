package com.github.andriell.processor;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Vika on 06.02.2016
 */
public class ManagerTest {
    private static int count = 0;
    private StringBuilder builder;

    public static void main(String[] args) {
        new ManagerTest().test1();
    }


    @Test
    public void test1() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        // Без этого событие destroy для бинов не будет вызвано
        applicationContext.registerShutdownHook();
        Manager manager = applicationContext.getBean("manager", Manager.class);
        builder = applicationContext.getBean("builder", StringBuilder.class);
        for (int i = 0; i <= 7; i++) {
            manager.addData(new TestData1(i));
        }

        RunnableLimiter limiter = new RunnableLimiter();
        limiter.start(manager);
        RunnableLimiter.sleep(2000);
        System.out.print(builder);
    }

    public static class TestData1 implements DataInterface {
        private String number;
        public TestData1(int i) {
            number = Integer.toString(i);
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
        private String name;
        private StringBuilder builder;

        TestProcess1() {
            name = Integer.toString(count++);
        }

        public void run() {
            ManagerTest.TestData1 data = (ManagerTest.TestData1) getData();
            for (int i = 0; i < 10; i++) {
                builder.append("process ").append(name).append(" task ").append(data).append(" ").append(i).append("\n");
                RunnableLimiter.sleep(100 + (int) (Math.random() * 200));
            }
        }

        public void setBuilder(StringBuilder builder) {
            this.builder = builder;
        }

        public int getProcessType() {
            return 0;
        }
    }
}
