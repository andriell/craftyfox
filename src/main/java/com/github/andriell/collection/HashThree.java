package com.github.andriell.collection;

import java.util.Arrays;

/**
 * Created by Vika on 07.02.2016
 */
public class HashThree<T> {
    private HashThree[] three;
    private T value;
    /** размер этого узла и всех вложенных в него */
    private int size = 0;
    private static final char[] alphabet = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };

    public boolean add(T t) {
        return add(t, false);
    }

    public boolean replace(T t) {
        return add(t, true);
    }

    public boolean remove(T t) {
        return true;
    }

    public int getSize() {
        return size;
    }

    private boolean add(T t, boolean replace) {
        int hash = t.hashCode();
        HashThree position = this;
        while(hash != 0) {
            position.size++;
            if (position.three == null) {
                position.three = new HashThree[16];
            }
            int index = hash & 15;
            hash = hash >>> 4;
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
        for(int i = 0; i < 16; i++) {
            if (position.three[i] != null) {
                builder.append(alphabet[i]);
                toString(position.three[i], builder);
            }
        }
    }
}
