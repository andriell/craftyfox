package com.github.andriell.processor;

/**
 * Created by Vika on 06.02.2016
 */
public class ManagerTest {
    public static void main(String[] args) {
        TestProcessFactory factory = new TestProcessFactory();
        Manager manager = new Manager(1000, true);
        manager.setRunnableLimiter(new RunnableLimiter(4));
        manager.setProcessFactory(factory);
        manager.addData(new TestData());
        manager.addData(new TestData());
        manager.addData(new TestData());
        manager.addData(new TestData());
        manager.addData(new TestData());
        manager.addData(new TestData());
        manager.start();
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
    }

    static class TestProcessFactory implements ProcessFactoryInterface {
        public ProcessInterface newProcess(DataInterface data) {
            TestProcess process = new TestProcess();
            process.setData(data);
            return process;
        }
    }
}
