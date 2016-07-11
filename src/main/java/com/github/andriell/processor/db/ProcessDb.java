package com.github.andriell.processor.db;

import com.github.andriell.processor.ProcessInterface;

/**
 * Created by Rybalko on 11.07.2016.
 */
public class ProcessDb implements ProcessInterface {
    private ProcessDbDataInterface data;

    public void setData(Object data) {
        this.data = (ProcessDbDataInterface) data;
    }

    public Object getData() {
        return data;
    }

    public void setData(ProcessDbDataInterface data) {
        this.data = data;
    }

    public void run() {
        data.save();
        data = null;
    }
}
