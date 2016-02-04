package com.github.andriell.processor;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.*;

/**
 * Created by Андрей on 04.02.2016.
 */
public class Processor {
    BlockingQueue<Task> tasks;
    public Processor(int capacity, boolean fair) {
        tasks = new ArrayBlockingQueue<Task>(capacity, fair);
    }
}
