package com.github.andriell.processor.js;

import com.github.andriell.processor.DataInterface;

/**
 * Created by Rybalko on 14.04.2016.
 */
public interface ProcessJsDataInterface extends DataInterface {
    String getPageName();
    void setPageName(String pageName);
    Object getData();
    void setData(Object pageName);
}
