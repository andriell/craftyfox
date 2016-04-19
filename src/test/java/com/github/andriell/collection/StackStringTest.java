package com.github.andriell.collection;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rybalko on 19.04.2016.
 */
public class StackStringTest {
    @Test
    public void test1() {
        StackString stackString = new StackString(5);
        assertEquals(stackString.toString(), "");
        stackString.put("0");
        assertEquals(stackString.toString(), "0");
        stackString.put("1");
        assertEquals(stackString.toString(), "01");
        stackString.put("2");
        assertEquals(stackString.toString(), "012");
        stackString.put("3");
        assertEquals(stackString.toString(), "0123");
        stackString.put("4");
        assertEquals(stackString.toString(), "01234");
        stackString.put("5");
        assertEquals(stackString.toString(), "12345");
    }
}
