package com.github.andriell;

import com.github.andriell.collection.HashThree;

/**
 * Created by Vika on 07.02.2016
 */
public class Test {
    private static final char[] alphabet = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };

    public static void main(String[] args) {
        Object o = new Object();
        int hash = o.hashCode();
        System.out.println("Dec: " + o.hashCode());
        System.out.println("Hex: " + Integer.toHexString(hash));
        System.out.println("Hex revers: " + new StringBuilder(Integer.toHexString(hash)).reverse());
        System.out.println();

        for(byte b = 0; b < 8; b++) {
            int index = hash & 0xF;
            System.out.print(alphabet[index]);
            hash = hash >>> 4;
        }
        System.out.println();
        System.out.println();

        HashThree<Object> three = new HashThree<Object>();
        three.add(o);
        System.out.println(three);
    }

}
