package com.github.andriell.processor.csv;

import com.github.andriell.processor.ProcessInterface;

import java.util.Collection;

/**
 * Created by Rybalko on 17.06.2016.
 */
public class ProcessCsv implements ProcessInterface {
    public Object getData() {
        return null;
    }

    public void setData(Object data) {
        if (data instanceof Collection) {
            Collection collection = (Collection) data;

        }
    }

    public void run() {

    }
}
