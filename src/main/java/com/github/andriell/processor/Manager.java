package com.github.andriell.processor;

import java.util.concurrent.*;

/**
 * Created by Андрей on 04.02.2016.
 */
public class Manager<T extends TaskInterface, P extends ProcessInterface<T>> implements ManagerInterface<T, P> {
    BlockingQueue<T> task;
    private int runProcess = 0;
    private int runProcessMax = 10;
    Starter starter;

    ProcessFactoryInterface<T, P> processFactory;
    public Manager(int capacity, boolean fair) {
        starter = new Starter();

        task = new ArrayBlockingQueue<T>(capacity, fair);
    }

    public void addTask(T task) {
        this.task.add(task);

    }

    class Starter implements Runnable {


        public void run() {
            while (true) {
                while(runProcess <= runProcessMax) {
                    if (!runNew()) {
                        break;
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onProcessComplete() {
        runNew();
    }

    protected boolean runNew() {
        runProcess--;
        T task = this.task.poll();
        if (task == null) {
            return false;
        }
        P process = processFactory.newProcess(task);
        if (process == null) {
            return false;
        }
        Thread thread = new Thread(process);
        thread.run();
        runProcess++;
        return true;
    }
}
