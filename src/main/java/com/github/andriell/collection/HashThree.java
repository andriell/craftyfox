package com.github.andriell.collection;

import java.util.Arrays;

/**
 * Created by Vika on 07.02.2016
 */
public class HashThree<T> {
    private Entity root = new Entity();
    /** размер этого узла и всех вложенных в него */
    private int size = 0;
    private static final char[] alphabet = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };

    public boolean add(T t) {
        return add(t, false);
    }

    public boolean replace(T t) {
        return add(t, true);
    }

    public boolean exist(T t) {
        int hash = t.hashCode();
        Entity position = root;
        for(byte b = 0; b < 8; b++) {
            if (position.three == null) {
                return false;
            }
            int index = hash & 15;
            hash = hash >>> 4;
            if (position.three[index] == null) {
                return false;
            }
            position = position.three[index];
        }
        return true;
    }

    public boolean remove(T t) {
        byte[] count = new byte[8];
        Entity[] path = new Entity[8];
        int hash = t.hashCode();
        Entity position = root;
        for(byte i = 0; i < 8; i++) {
            if (position.three == null) {
                return false;
            }
            int index = hash & 15;
            hash = hash >>> 4;
            if (position.three[index] == null) {
                return false;
            }
            count[i] = 0;
            path[i] = position;
            for (byte j = 0; j < 8; j++) {
                if (position.three[j] != null) {
                    count[i]++;
                }
            }
            position = position.three[index];
        }
        for(byte i = 7; i <= 0; i--) {
            if (count[i] == 0) {
                continue;
            }
            if (count[i] > 1) {
                break;
            }
            path[i].three = null;
        }
        return true;
    }

    public int getSize() {
        return size;
    }

    private boolean add(T t, boolean replace) {
        int hash = t.hashCode();
        Entity position = root;
        for(byte b = 0; b < 8; b++) {
            if (position.three == null) {
                position.three = new Entity[16];
            }
            int index = hash & 15;
            hash = hash >>> 4;
            if (position.three[index] == null) {
                position.three[index] = new Entity();
            }
            position = position.three[index];
        }
        if (position.value == null) {
            position.value = t;
            size++;
            return true;
        } else if (replace) {
            position.value = t;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        toString(root, builder);
        return builder.toString();
    }

    public void toString(Entity position, StringBuilder builder) {
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

    public class Entity<T> {
        public Entity[] three;
        private T value;
    }
}
