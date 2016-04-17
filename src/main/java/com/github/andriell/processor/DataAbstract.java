package com.github.andriell.processor;

/**
 * Created by Vika on 17.04.2016
 */
public class DataAbstract implements DataInterface {
    private String processBeanId;

    public String getProcessBeanId() {
        return processBeanId;
    }

    public void setProcessBeanId(String processBeanId) {
        this.processBeanId = processBeanId;
    }
}
