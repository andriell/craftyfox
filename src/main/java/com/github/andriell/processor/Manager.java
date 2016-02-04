package com.github.andriell.processor;

import java.util.concurrent.*;

/**
 * Created by Андрей on 04.02.2016.
 */
public class Manager implements ManagerInterface {
    BlockingQueue<Task> tasks;
    BlockingQueue<Process> process;
    public Manager(int capacity, boolean fair) {
        tasks = new ArrayBlockingQueue<Task>(capacity, fair);
        tasks.add(new TestTask());
    }
}
