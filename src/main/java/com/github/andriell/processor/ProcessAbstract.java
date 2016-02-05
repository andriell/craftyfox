package com.github.andriell.processor;

/**
 * Created by Андрей on 04.02.2016
 */
public abstract class ProcessAbstract implements ProcessInterface {
   private DataInterface data;

    public DataInterface getData() {
        return data;
    }

    public void setData(DataInterface data) {
        this.data = data;
    }
}
