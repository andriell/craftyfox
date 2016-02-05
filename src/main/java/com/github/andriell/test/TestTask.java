package com.github.andriell.test;

import com.github.andriell.processor.TaskInterface;

/**
 * Created by Андрей on 04.02.2016
 */
public class TestTask implements TaskInterface {
    private static int count = 0;
    public TestTask() {
        count++;
    }

    @Override
    public String toString() {
        return "" + count;
    }
}
