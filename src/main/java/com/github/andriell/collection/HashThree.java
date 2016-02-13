package com.github.andriell.collection;

import java.util.Arrays;

/**
 * Created by Vika on 07.02.2016
 */
public class HashThree<T> {
    private HashThree[] three;
    private T value;

    public boolean add(T t) {
        return add(t, false);
    }

    public boolean replace(T t) {
        return add(t, true);
    }

    private boolean add(T t, boolean replace) {
        int hash = t.hashCode();
        HashThree position = this;
        while(hash != 0) {
            if (position.three == null) {
                position.three = new HashThree[8];
            }
            int index = hash & 7;
            if (position.three[index] == null) {
                position.three[index] = new HashThree();
            }
            position = position.three[index];
            hash = hash >>> 3;
        }
        if (position.value == null) {
            position.value = t;
            return true;
        } else if (replace) {
            position.value = t;
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        if (value == null) {
            return Arrays.deepToString(three);
        } else {
            return "Value: " + value;
        }
    }
}
