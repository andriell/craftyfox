package com.github.andriell.processor.http;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentType;

/**
 * Created by Rybalko on 14.04.2016.
 */
public interface DataListenerInterface {
    void setResponse(byte[] body, ContentType contentType, HttpRequest request, HttpResponse response);
}
