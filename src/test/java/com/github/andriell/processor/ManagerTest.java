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

    @Test
    public void test1() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        // Без этого событие destroy для бинов не будет вызвано
        applicationContext.registerShutdownHook();
        Manager manager = applicationContext.getBean("manager", Manager.class);
        builder = applicationContext.getBean("builder", StringBuffer.class);
        for (int p = 0; p <= 3; p++) {
            manager.addData(new TestData1(p));
            manager.addData(new TestData2(p));
        }

        RunnableLimiter limiter = new RunnableLimiter();
        limiter.start(manager);
        RunnableLimiter.sleep(3000);
        String s = builder.toString();
        String s1;
        for (int p = 0; p <= 3; p++) {
            for (int i = 0; i < 10; i++) {
                s1 = "Process1, ProcessName:" + p + ", Data:Data1{" + p + "}, Iteration:" + i + "\n";
                assertEquals(s1, true, s.contains(s1));
                s = s.replaceAll(s1, "");
            }
        }
        assertEquals("Пустая строка", "", s);
    }

    public static class TestData1 implements DataInterface {
        private final String PROCESS_BEAN_ID = "test_process_1";
        private String number;
        public TestData1(int i) {
            number = Integer.toString(i);
        }
        @Override
        public String toString() {
            return "Data1, DataName:" + number;
        }
        public String getProcessBeanId() {
            return PROCESS_BEAN_ID;
        }
    }

    public static class TestData2 implements DataInterface {
        private final String PROCESS_BEAN_ID = "test_process_2";
        private String number;
        public TestData2(int i) {
            number = Integer.toString(i);
        }
        @Override
        public String toString() {
            return "Data2, DataName:" + number;
        }
        public String getProcessBeanId() {
            return PROCESS_BEAN_ID;
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
