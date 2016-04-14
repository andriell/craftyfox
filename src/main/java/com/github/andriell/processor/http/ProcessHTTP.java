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
public class ProcessHTTP implements ProcessInterface {
    private ProcessHTTPData data;
    private HttpClientContext localContext;
    private ProcessHTTPContext httpClient;
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

    public ProcessHTTPListenerInterface[] getListeners() {
        return listeners;
    }

    public void setListeners(ProcessHTTPListenerInterface[] listeners) {
        this.listeners = listeners;
    }

    public void setData(Object data) {
        this.data = (ProcessHTTPData) data;
    }

    public ProcessHTTPData getData() {
        return data;
    }

    public ProcessHTTPContext getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(ProcessHTTPContext httpClient) {
        this.httpClient = httpClient;
    }
}
