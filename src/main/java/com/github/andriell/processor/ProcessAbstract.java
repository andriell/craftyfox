package com.github.andriell.processor;

/**
 * Created by Андрей on 04.02.2016
 */
public abstract class ProcessAbstract implements ProcessInterface {
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
