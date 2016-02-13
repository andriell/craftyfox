package com.github.andriell.collection;

import java.util.Arrays;

/**
 * Created by Vika on 07.02.2016
 */
public class HashThree<T> {
    private HashThree[] three;
    private T value;

    public boolean add(T t) {
        return add(t, this, t.hashCode(), false);
    }

    private boolean add(T t, HashThree position, int hash, boolean replace) {
        if (hash == 0) {
            boolean empty = position.value == null;
            if (replace && !empty) {
                position.value = t;
            }
            return empty;
        } else {
            position.three = new HashThree[8];
            return add(t, position.three[hash & 7] = new HashThree(), hash >>> 7, replace);
        }
    }

    @Override
    public String toString() {
        return Arrays.deepToString(three) + " = " + value;
    }
}
