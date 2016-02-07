package com.github.andriell.collection;

import com.github.andriell.processor.*;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Vika on 06.02.2016
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<Integer>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
