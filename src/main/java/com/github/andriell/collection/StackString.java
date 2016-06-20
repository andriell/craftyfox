package com.github.andriell.collection;

/**
 * Created by Rybalko on 19.04.2016.
 */
public class StackString {
    String[] data;
    int position = -1;
    boolean crowded = false;

    public StackString(int size) {
        data = new String[size];
    }

    public void clear() {
        position = -1;
        crowded = false;
    }

    public void put(String s) {
        synchronized (this) {
            position++;
            if (position >= data.length) {
                position = 0;
                crowded = true;
            }
            data[position] = s;
        }
    }

    public String[] bytes() {
        String[] r = null;
        int index = 0;
        if (crowded) {
            r = new String[data.length];
            for (int i = position + 1; i < data.length; i++) {
                r[index++] = data[i];
            }
        } else if (position >= 0)  {
            r = new String[position + 1];
        } else {
            return r;
        }
        for (int i = 0; i <= position; i++) {
            r[index++] = data[i];
        }
        return r;
    }

    public String toString() {
        StringBuffer r = null;
        if (crowded) {
            r = new StringBuffer(data.length);
            for (int i = position + 1; i < data.length; i++) {
                r.append(data[i]);
            }
        } else if (position >= 0)  {
            r = new StringBuffer(position + 1);
        } else {
            return "";
        }
        for (int i = 0; i <= position; i++) {
            r.append(data[i]);
        }
        return r.toString();
    }
}
