package com.github.andriell.test;

import com.github.andriell.processor.DataInterface;

/**
 * Created by Андрей on 04.02.2016
 */
public class TestData implements DataInterface {
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
