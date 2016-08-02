package com.github.andriell.processor.http;

import com.github.andriell.processor.DataInterface;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentType;

/**
 * Created by Rybalko on 14.04.2016.
 */
public interface ProcessHttpDataListenerInterface extends DataInterface {
    void setResponse(byte[] body, ContentType contentType, String request, HttpResponse response);
    void setJsData(Object jsData);
}
