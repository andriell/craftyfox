package com.github.andriell.collection;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rybalko on 19.04.2016.
 */
public class StackByteTest {
    @Test
    public void test1() {
        StackByte stackString = new StackByte(5);
        assertEquals(stackString.toString(), "");
        stackString.put((byte) '0');
        assertEquals(stackString.toString(), "0");
        stackString.put((byte) '1');
        assertEquals(stackString.toString(), "01");
        stackString.put((byte) '2');
        assertEquals(stackString.toString(), "012");
        stackString.put((byte) '3');
        assertEquals(stackString.toString(), "0123");
        stackString.put((byte) '4');
        assertEquals(stackString.toString(), "01234");
        stackString.put((byte) '5');
        assertEquals(stackString.toString(), "12345");
    }
}
