package com.github.andriell.processor.js;

import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentType;

/**
 * Created by Rybalko on 14.04.2016.
 */
public abstract class ProcessJsDataAbstract implements ProcessJsDataInterface {
    private DataConverter converter;
    private String processBeanId;
    private Object data;
    private String pageName;
    private String url;
    private HttpResponse response;
    private ContentType contentType;
    private Object jsData; // Данные передаваемые из js, для js

    public void destroy() {
        converter = null;
        processBeanId = null;
        data = null;
        pageName = null;
        url = null;
        response = null;
        contentType = null;
        jsData = null;
    }

    protected void setHttpParam(String url, HttpResponse response, ContentType contentType) {
        this.url = url;
        this.response = response;
        this.contentType = contentType;
    }

    public DataConverter getConverter() {
        return converter;
    }

    public void setConverter(DataConverter converter) {
        this.converter = converter;
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

    public String getUrl() {
        return url;
    }

    public HttpResponse getResponse() {
        return response;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * Данные передаваемые из js, для js
     * @return
     */
    public Object getJsData() {
        return jsData;
    }

    /**
     * Данные передаваемые из js, для js
     * @param jsData
     */
    public void setJsData(Object jsData) {
        this.jsData = jsData;
    }
}
