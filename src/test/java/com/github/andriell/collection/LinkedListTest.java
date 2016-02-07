package com.github.andriell.collection;

/**
 * Created by Vika on 06.02.2016
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedSet<Integer> integers = new LinkedSet<Integer>();
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
