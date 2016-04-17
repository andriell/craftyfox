package com.github.andriell.processor.js;

/**
 * Created by Rybalko on 14.04.2016.
 */
public class ProcessJsDataAbstract implements ProcessJsDataInterface {
    private String pageName;

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }
}
