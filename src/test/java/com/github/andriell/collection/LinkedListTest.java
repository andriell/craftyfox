package com.github.andriell.collection;

/**
 * Created by Vika on 06.02.2016
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedSet<Integer> integers = new LinkedSet<>();
        integers.addEnd(1);
        integers.addEnd(1);
        integers.addEnd(2);
        integers.addEnd(2);
        integers.addEnd(3);
        integers.addEnd(3);
        integers.addEnd(4);
        integers.addEnd(4);
        integers.addEnd(5);
        integers.addEnd(5);
        integers.addEnd(5);
        integers.addFirst(0);
        integers.addFirst(0);
        integers.addFirst(0);
        System.out.println(integers);
        if ("[0, 1, 2, 3, 4, 5]".equals(integers.toString())) {
            System.out.println("Ok");
        } else {
            System.out.println("Error");
        }
    }
}
