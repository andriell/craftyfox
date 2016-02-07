package com.github.andriell;

/**
 * Created by Vika on 07.02.2016
 */
public class Test {
    public static void main(String[] args) {
        Object o = new Object();
        int hash = o.hashCode();
        System.out.println(o.hashCode());
        System.out.println(Integer.toBinaryString(hash));
        System.out.println(Integer.toOctalString(hash));

        int i = hash >> 2;
        System.out.println(Integer.toBinaryString(hash));
        System.out.println(Integer.toBinaryString(i));

    }
}
