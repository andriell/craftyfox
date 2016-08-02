package com.github.andriell.processor.http;

import com.github.andriell.processor.ProcessInterface;
import com.github.andriell.processor.ProcessorInterface;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Collection;

/**
 * Created by Rybalko on 12.04.2016.
 */
public class ProcessHttp implements ProcessInterface {
    private static PoolingHttpClientConnectionManager connectionManager;
    private static CloseableHttpClient httpClient;

    static {
        connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(1000);
        connectionManager.setDefaultMaxPerRoute(1000);
        httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .setConnectionManagerShared(true)
                .build();
    }

    private String name;
    private ProcessHttpData data;
    private ProcessHttpContext httpContext;
    private ProcessHttpListenerInterface[] listeners;
    private ProcessorInterface processor;

    // TODO data должна поступать вот сюда
    public void run() {
        HttpClientContext localContext = this.httpContext.getClientContext();
        try {
            CloseableHttpResponse response = httpClient.execute(data, localContext);
            Collection<ProcessHttpDataListenerInterface> dataListeners = data.getDataListeners();

            HttpEntity httpEntity = response.getEntity();
            byte[] body = EntityUtils.toByteArray(httpEntity);
            ContentType contentType = ContentType.getOrDefault(httpEntity);
            EntityUtils.consume(httpEntity);
            if (dataListeners != null) {
                for (ProcessHttpDataListenerInterface dataListener: dataListeners) {
                    dataListener.setResponse(body, contentType, data.getURI().toURL().toString(), response);
                    dataListener.setJsData(data.getJsData());
                    processor.add(dataListener);
                }
            }
            if (listeners != null) {
                for (ProcessHttpListenerInterface listener: listeners) {
                    listener.afterResponse(this);
                }
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
        name = null;
        data = null;
        httpContext = null;
        listeners = null;
        processor = null;
    }

    public void setListeners(ProcessHttpListenerInterface[] listeners) {
        this.listeners = listeners;
    }

    public ProcessHttpData getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = (ProcessHttpData) data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProcessHttpContext getHttpContext() {
        return httpContext;
    }

    public void setHttpContext(ProcessHttpContext httpContext) {
        this.httpContext = httpContext;
    }

    public void setProcessor(ProcessorInterface processor) {
        this.processor = processor;
    }
}
