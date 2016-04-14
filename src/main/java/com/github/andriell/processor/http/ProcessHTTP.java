package com.github.andriell.processor.http;

import com.github.andriell.processor.ProcessInterface;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * Created by Rybalko on 12.04.2016.
 */
public class ProcessHttp implements ProcessInterface {
    private String name;
    private ProcessHttpData data;
    private HttpClientContext localContext;
    private ProcessHttpContext httpClient;
    private ProcessHTTPListenerInterface[] listeners;

    public void run() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        localContext = this.httpClient.getClientContext();
        try {
            CloseableHttpResponse response = httpClient.execute(data, localContext);
            for (ProcessHTTPListenerInterface listener: listeners) {
                listener.afterResponse(this);
            }
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HttpClientContext getLocalContext() {
        return localContext;
    }

    public void setListeners(ProcessHTTPListenerInterface[] listeners) {
        this.listeners = listeners;
    }

    public void setData(Object data) {
        this.data = (ProcessHttpData) data;
    }

    public ProcessHttpData getData() {
        return data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProcessHttpContext getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(ProcessHttpContext httpClient) {
        this.httpClient = httpClient;
    }
}
