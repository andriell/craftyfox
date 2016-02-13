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
        if (three == null) {
            return "null";
        }
        StringBuilder builder = new StringBuilder();
        toString(this, builder, "");
        return builder.toString();
    }

    public void toString(HashThree position, StringBuilder builder, String tab) {
        builder.append("\n");
        if (position.three == null) {
            builder.append(tab);
            builder.append("Value: ");
            builder.append(position.value);
            return;
        }
        for(int i = 0; i < 8; i++) {
            if (position.three[i] != null) {
                builder.append(tab);
                builder.append(i);
                builder.append(": ");
                toString(position.three[i], builder, tab + "    ");

            }
        }

    }
}
