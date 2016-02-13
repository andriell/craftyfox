package com.github.andriell.collection;

import java.util.Arrays;

/**
 * Created by Vika on 07.02.2016
 */
public class HashThree<T> {
    private HashThree[] three;
    private T value;
    private final int OST = 8;
    private final int OST1 = 7;

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
                position.three = new HashThree[OST];
            }
            int index = hash & 7;
            hash = hash >>> 3;
            if (position.three[index] == null) {
                position.three[index] = new HashThree();
            }
            position = position.three[index];
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
        StringBuilder builder = new StringBuilder();
        toString(this, builder);
        return builder.toString();
    }

    public void toString(HashThree position, StringBuilder builder) {
        if (position.three == null) {
            builder.append(":");
            builder.append(position.value);
            builder.append("\n");
            return;
        }
        for(int i = 0; i < OST; i++) {
            if (position.three[i] != null) {
                builder.append(i);
                toString(position.three[i], builder);
            }
        }
    }
}
