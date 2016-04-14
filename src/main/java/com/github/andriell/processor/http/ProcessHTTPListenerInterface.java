package com.github.andriell.processor.http;

import org.apache.http.client.protocol.HttpClientContext;

/**
 * Created by Rybalko on 14.04.2016.
 */
public interface ProcessHTTPListenerInterface {
    public void afterResponse(ProcessHTTP processHTTP);
}
