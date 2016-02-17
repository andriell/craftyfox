package com.github.andriell.test;

import com.github.andriell.processor.DataInterface;

/**
 * Created by Андрей on 17.02.2016.
 */
public class TestData1 implements DataInterface {
    private static int count = 0;
    private String number;
    public TestData1() {
        number = Integer.toString(count++);
    }

    @Override
    public String toString() {
        return number;
    }

    public int getProcessType() {
        return 0;
    }
}
