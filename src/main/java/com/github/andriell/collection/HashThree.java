package com.github.andriell.collection;

import java.util.Arrays;

/**
 * Created by Vika on 07.02.2016
 */
public class HashThree<T> {
    private HashThree[] three;
    private T value;

    public boolean add(T t) {
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
