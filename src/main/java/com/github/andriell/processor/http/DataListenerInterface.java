package com.github.andriell.processor.http;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

/**
 * Created by Rybalko on 14.04.2016.
 */
public interface DataListenerInterface {
    void setResponse(byte[] body, HttpRequest request, HttpResponse response);
}
