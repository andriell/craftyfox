package com.github.andriell.processor.js;

/**
 * Created by Rybalko on 14.04.2016.
 */
public interface ProcessJsDataInterface {
    String getPageName();
    void setPageName(String pageName);
    Object getData();
    void setData(Object pageName);
    void destroy();
}
