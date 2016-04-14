package com.github.andriell.processor.js;

/**
 * Created by Rybalko on 14.04.2016.
 */
public class ProcessJsDataAbstract implements ProcessJsDataInterface {
    private String craftName;

    public String getCraftName() {
        return craftName;
    }

    public void setCraftName(String craftName) {
        this.craftName = craftName;
    }
}
