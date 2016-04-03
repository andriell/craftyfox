package com.github.andriell.collection;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by Andrey on 06.02.2016
 */
public class LinkedListTest {
    @Test
    public void test1() {
        LinkedSet<Integer> integers = new LinkedSet<Integer>();

        assertEquals(0, integers.size());

        integers.addEnd(1);
        integers.addEnd(2);
        integers.addEnd(11);
        integers.addEnd(3);
        integers.addEnd(4);
        integers.addEnd(5);
        integers.addEnd(5);
        integers.addEnd(5);
        integers.addEnd(12);
        integers.addFirst(0);
        integers.addFirst(0);
        integers.addFirst(0);
        integers.addFirst(10);
        integers.remove(10);
        integers.remove(11);
        integers.remove(12);

        assertEquals(integers.toString(), "[0, 1, 2, 3, 4, 5]", integers.toString());
        assertEquals(6, integers.size());
    }
}
