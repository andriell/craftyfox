package com.github.andriell.processor;

/**
 * Created by Андрей on 04.02.2016.
 */
public class RunnableLimiter {
    private final Object sync = new Object();
    private int runningProcesses = 0;
    private int limitProcess = 0;

    public boolean start(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        synchronized (sync) {
            if (runningProcesses > limitProcess) {
                return false;
            }
            runningProcesses++;
        }
        SelfRunnable selfRunnable = new SelfRunnable(runnable);
        Thread thread = new Thread(selfRunnable);
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

    private class SelfRunnable implements Runnable {
        Runnable runnable;

        public SelfRunnable(Runnable runnable) {
            this.runnable = runnable;
        }

        public void run() {
            try {
                runnable.run();
            } finally {
                runningProcesses--;
            }
        }
    }
}
