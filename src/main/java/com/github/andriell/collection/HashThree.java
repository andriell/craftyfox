package com.github.andriell.collection;

/**
 * Created by Vika on 07.02.2016
 */
public class HashThree<T> {
    private HashThree[] three;
    private T value;

    public void add(T t, HashThree[] position, int hash) {
        if (hash > 0) {
            three = new HashThree[8];
            int i = hash % 8;
            if (position[i] == null) {
                position[i].three = new HashThree[8];
            }
        }
    }

}
