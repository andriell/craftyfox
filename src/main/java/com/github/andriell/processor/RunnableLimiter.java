package com.github.andriell.processor;

/**
 * Created by Андрей on 04.02.2016.
 */
public class RunnableLimiter {
    private int runningProcesses = 0;
    private int limitProcess = 0;

    public boolean start(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        if (runningProcesses > limitProcess) {
            return false;
        }
        SelfRunnable selfRunnable;
        if (runnable instanceof SelfRunnable) {
            selfRunnable = (SelfRunnable) runnable;
        } else {
            selfRunnable = new SelfRunnable(runnable);
        }
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
            runningProcesses++;
            try {
                runnable.run();
            } finally {
                runningProcesses--;
            }
        }
    }
}
