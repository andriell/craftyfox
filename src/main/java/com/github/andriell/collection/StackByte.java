package com.github.andriell.collection;

/**
 * Created by Rybalko on 19.04.2016.
 */
public class StackByte {
    byte[] data;
    int position = -1;
    boolean crowded = false;

    public StackByte(int size) {
        data = new byte[size];
    }

    public void put(byte b) {
        synchronized (this) {
            position++;
            if (position >= data.length) {
                position = 0;
                crowded = true;
            }
            data[position] = b;
        }
    }

    public byte[] bytes() {
        byte[] r = null;
        int index = 0;
        if (crowded) {
            r = new byte[data.length];
            for (int i = position + 1; i < data.length; i++) {
                r[index++] = data[i];
            }
        } else if (position >= 0)  {
            r = new byte[position + 1];
        } else {
            return r;
        }
        for (int i = 0; i <= position; i++) {
            r[index++] = data[i];
        }
        return r;
    }

    public String toString() {
        byte[] bytes = bytes();
        if (bytes == null) {
            return "";
        }
        return new String(bytes());
    }
}
