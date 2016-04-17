package com.github.andriell.processor.js;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentType;

/**
 * Created by Rybalko on 14.04.2016.
 */
public abstract class ProcessJsDataAbstract implements ProcessJsDataInterface {
    private String pageName;
    private HttpRequest request;
    private HttpResponse response;
    private ContentType contentType;

    protected void setHttpParam(HttpRequest request, HttpResponse response, ContentType contentType) {
        this.request = request;
        this.response = response;
        this.contentType = contentType;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public HttpRequest getRequest() {
        return request;
    }

    public HttpResponse getResponse() {
        return response;
    }

    public ContentType getContentType() {
        return contentType;
    }
}
