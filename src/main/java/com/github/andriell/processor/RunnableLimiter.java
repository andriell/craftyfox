package com.github.andriell.processor;

/**
 * Created by Андрей on 04.02.2016
 */
public class RunnableLimiter {
    private int runningProcesses = 0;
    private int limitProcess = 10;
    private final RunnableListener runnableListener;

    public RunnableLimiter() {
        this(10);
    }

    public RunnableLimiter(int limitProcess) {
        this.limitProcess = limitProcess;
        runnableListener = new RunnableListener();
    }

    public boolean start(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        if (runningProcesses > limitProcess) {
            return false;
        }
        RunnableAdapter adapter = RunnableAdapter.envelop(runnable);
        adapter.addListener(runnableListener);
        Thread thread = new Thread(adapter);
        thread.run();
        return true;
    }

    public int getRunningProcesses() {
        return runningProcesses;
    }

    public int getLimitProcess() {
        return limitProcess;
    }

    public void setLimitProcess(int limitProcess) {
        this.limitProcess = limitProcess;
    }

    private class RunnableListener implements RunnableListenerInterface {
        public void onStart(Runnable r) {
            runningProcesses++;
        }
        public void onException(Runnable r, Exception e) {
            e.printStackTrace();
        }
        public void onComplete(Runnable r) {
            runningProcesses--;
        }
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {}
    }
}
