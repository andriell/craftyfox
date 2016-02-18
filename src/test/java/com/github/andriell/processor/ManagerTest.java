package com.github.andriell.processor;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * Created by Vika on 06.02.2016
 */
public class ManagerTest {
    private static int count = 0;
    private StringBuffer builder;

    public static void main(String[] args) {
        new ManagerTest().test1();
    }


    @Test
    public void test1() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        // Без этого событие destroy для бинов не будет вызвано
        applicationContext.registerShutdownHook();
        Manager manager = applicationContext.getBean("manager", Manager.class);
        builder = applicationContext.getBean("builder", StringBuffer.class);
        for (int p = 0; p <= 7; p++) {
            manager.addData(new TestData1(p));
        }

        RunnableLimiter limiter = new RunnableLimiter();
        limiter.start(manager);
        RunnableLimiter.sleep(2500);
        String s = builder.toString();
        String s1;
        for (int p = 0; p<=7; p++) {
            for (int i = 0; i < 10; i++) {
                s1 = "process " + p + " task " + p + " " + i + "\n";
                assertEquals(s1, true, s.contains(s1));
                s = s.replaceAll(s1, "");
            }
        }
        assertEquals("Пустая строка", "", s);
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
        private StringBuffer builder;

        TestProcess1() {
            name = Integer.toString(count++);
        }

        public void run() {
            ManagerTest.TestData1 data = (ManagerTest.TestData1) getData();
            for (int i = 0; i < 10; i++) {
                String s = "process " + name + " task " + data + " " + i + "\n";
                System.out.print(s);
                builder.append(s);
                RunnableLimiter.sleep((int) (Math.random() * 100));
            }
        }

        public void setBuilder(StringBuffer builder) {
            this.builder = builder;
        }

        public int getProcessType() {
            return 0;
        }
    }
}
