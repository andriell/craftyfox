package com.github.andriell.processor.js;

import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentType;

/**
 * Created by Rybalko on 14.04.2016.
 */
public class ProcessJsData implements ProcessJsDataInterface {
    private Object data;
    private String pageName;
    private String processBeanId;

    public void destroy() {
        data = null;
        pageName = null;
    }

    public String getProcessBeanId() {
        return processBeanId;
    }

    public void setProcessBeanId(String processBeanId) {
        this.processBeanId = processBeanId;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
