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

    public String[] strings() {
        String[] r = null;
        if (crowded) {
            r = new String[data.length];
            for (int i = position + 1; i < data.length; i++) {
                r[i] = data[i];
            }
        } else if (position >= 0)  {
            r = new String[position + 1];
        } else {
            return r;
        }
        for (int i = 0; i <= position; i++) {
            r[i] = data[i];
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
