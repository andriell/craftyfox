package com.github.andriell.processor;

/**
 * Created by Andrey on 06.02.2016
 */
public class RunnableLimiterTest1 {
    public static void main(String[] args) {
        RunnableLimiter limiter = new RunnableLimiter(1);
        limiter.start(new TestProcess(new TestData()));
        System.out.println(1);
        limiter.start(new TestProcess(new TestData()));
        System.out.println(2);
        limiter.start(new TestProcess(new TestData()));
        System.out.println(3);
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

        public String getProcessBeanId() {
            return null;
        }
    }

    static class TestProcess extends ProcessAbstract {
        private static int count = 0;
        private String name;

        public TestProcess() {
            this(null);
        }

        public TestProcess(TestData data) {
            setData(data);
            name = Integer.toString(count++);
        }

        public void run() {
            TestData data = (TestData) getData();
            for (int i = 0; i < 10; i++) {
                System.out.println("process " + this + " task " + data + " " + i);
                RunnableLimiter.sleep(100);
            }
        }

        public String getTaskType() {
            return TestData.class.toString();
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
