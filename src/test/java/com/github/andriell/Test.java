package com.github.andriell;

/**
 * Created by Vika on 07.02.2016
 */
public class Test {
    public static void main(String[] args) {
        Object o = new Object();
        int hash = -100500;
        System.out.println("Dec: " + o.hashCode());
        System.out.println("Bin: " + Integer.toBinaryString(hash));
        System.out.println("Oct: " + Integer.toOctalString(hash));
        System.out.println("Oct revers: " + new StringBuilder(Integer.toOctalString(hash)).reverse());

        while(hash != 0) {
            System.out.print(hash & 7);
            hash = hash >>> 3;
        }
    }
}
