package com.github.andriell.processor;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * Created by Andrey on 06.02.2016
 */
public class ManagerTest {
    private StringBuffer builder;

    @Test
    public void test1() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        // Без этого событие destroy для бинов не будет вызвано
        applicationContext.registerShutdownHook();
        Manager manager1 = applicationContext.getBean("manager1", Manager.class);
        Manager manager2 = applicationContext.getBean("manager2", Manager.class);
        builder = applicationContext.getBean("builder", StringBuffer.class);
        for (int p = 0; p <= 3; p++) {
            manager1.addData(new TestData1(p));
        }
        for (int p = 0; p <= 3; p++) {
            manager2.addData(new TestData2(p));
        }

        RunnableLimiter limiter = new RunnableLimiter();
        limiter.start(manager1);
        limiter.start(manager2);
        RunnableLimiter.sleep(3000);
        String s = builder.toString();
        String s1;
        for (int p = 0; p <= 3; p++) {
            for (int i = 0; i < 10; i++) {
                s1 = "Process1, ProcessName:" + p + ", Data:{Data1, DataName:" + p + "}, Iteration:" + i + "\n";
                assertEquals(s1, true, s.contains(s1));
                s = s.replace(s1, "");
                s1 = "Process2, ProcessName:" + p + ", Data:{Data2, DataName:" + p + "}, Iteration:" + i + "\n";
                assertEquals(s1, true, s.contains(s1));
                s = s.replace(s1, "");
            }
        }
        assertEquals("Пустая строка", "", s);
    }

    public static class TestData1 {
        private final String PROCESS_BEAN_ID = "test_process_1";
        private String number;
        public TestData1(int i) {
            number = Integer.toString(i);
        }
        @Override
        public String toString() {
            return "Data1, DataName:" + number;
        }
    }

    public static class TestData2 {
        private final String PROCESS_BEAN_ID = "test_process_2";
        private String number;
        public TestData2(int i) {
            number = Integer.toString(i);
        }
        @Override
        public String toString() {
            return "Data2, DataName:" + number;
        }
    }

    public static class TestProcess1 extends ProcessAbstract {
        private static int count = 0;
        private String name;
        private StringBuffer builder;

        TestProcess1() {
            name = Integer.toString(count++);
        }

        public void run() {
            ManagerTest.TestData1 data = (ManagerTest.TestData1) getData();
            for (int i = 0; i < 10; i++) {
                String s = "Process1, ProcessName:" + name + ", Data:{" + data + "}, Iteration:" + i + "\n";
                System.out.print(s);
                builder.append(s);
                RunnableLimiter.sleep((int) (Math.random() * 100));
            }
        }

        public void setBuilder(StringBuffer builder) {
            this.builder = builder;
        }
    }

    public static class TestProcess2 extends ProcessAbstract {
        private static int count = 0;
        private String name;
        private StringBuffer builder;

        TestProcess2() {
            name = Integer.toString(count++);
        }

        public void run() {
            ManagerTest.TestData2 data = (ManagerTest.TestData2) getData();
            for (int i = 0; i < 10; i++) {
                String s = "Process2, ProcessName:" + name + ", Data:{" + data + "}, Iteration:" + i + "\n";
                System.out.print(s);
                builder.append(s);
                RunnableLimiter.sleep((int) (Math.random() * 100));
            }
        }

        public void setBuilder(StringBuffer builder) {
            this.builder = builder;
        }
    }
}
