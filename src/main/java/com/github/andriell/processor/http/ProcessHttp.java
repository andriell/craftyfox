package com.github.andriell.processor.http;

import com.github.andriell.processor.ProcessInterface;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Collection;

/**
 * Created by Rybalko on 12.04.2016.
 */
public class ProcessHttp implements ProcessInterface {
    private String name;
    private ProcessHttpData data;
    private ProcessHttpContext httpClient;
    private ProcessHttpListenerInterface[] listeners;

    public void run() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpClientContext localContext = this.httpClient.getClientContext();
        try {
            CloseableHttpResponse response = httpClient.execute(data, localContext);
            Collection<DataListenerInterface> dataListeners = data.getDataListeners();

            HttpResponse httpResponse = localContext.getResponse();
            HttpRequest httpRequest = localContext.getRequest();

            HttpEntity httpEntity = httpResponse.getEntity();
            byte[] body = EntityUtils.toByteArray(httpEntity);
            ContentType contentType = ContentType.getOrDefault(httpEntity);
            EntityUtils.consume(httpEntity);
            for (DataListenerInterface dataListener: dataListeners) {
                dataListener.setResponse(body, contentType, httpRequest, httpResponse);
            }

            for (ProcessHttpListenerInterface listener: listeners) {
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

    public void setListeners(ProcessHttpListenerInterface[] listeners) {
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
