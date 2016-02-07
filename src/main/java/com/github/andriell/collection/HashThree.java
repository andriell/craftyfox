package com.github.andriell.collection;

/**
 * Created by Vika on 07.02.2016
 */
public class HashThree<T> {
    private HashThree[] three = new HashThree[8];
    private T value;

    public void add(T t) {
        int hash = t.hashCode();
        HashThree<T>[] position = three;
        while (hash > 0) {
            int i = hash % 8;
            if (position[i] == null) {
                position[i].three = new HashThree[8];
            }
            hash -= i;
        }
    }

}
