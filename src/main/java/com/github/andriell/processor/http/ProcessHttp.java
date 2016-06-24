package com.github.andriell.processor.http;

import com.github.andriell.processor.ProcessInterface;
import com.github.andriell.processor.ProcessorInterface;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.IOException;
import java.util.Collection;

/**
 * Created by Rybalko on 12.04.2016.
 */
public class ProcessHttp implements ProcessInterface {
    private String name;
    private ProcessHttpData data;
    private ProcessHttpContext httpContext;
    private ProcessHttpListenerInterface[] listeners;
    private ProcessorInterface processor;

    // TODO data должна поступать вот сюда
    public void run() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpClientContext localContext = this.httpContext.getClientContext();
        try {
            CloseableHttpResponse response = httpClient.execute(data, localContext);
            System.out.println("run " + data);
            Collection<ProcessHttpDataListenerInterface> dataListeners = data.getDataListeners();

            HttpResponse httpResponse = localContext.getResponse();
            HttpRequest httpRequest = localContext.getRequest();

            HttpEntity httpEntity = httpResponse.getEntity();
            byte[] body = EntityUtils.toByteArray(httpEntity);
            ContentType contentType = ContentType.getOrDefault(httpEntity);
            EntityUtils.consume(httpEntity);
            if (dataListeners != null) {
                for (ProcessHttpDataListenerInterface dataListener: dataListeners) {
                    dataListener.setResponse(body, contentType, httpRequest, httpResponse);
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
    }

    public void setListeners(ProcessHttpListenerInterface[] listeners) {
        this.listeners = listeners;
    }

    public void setData(Object data) {
        System.out.println("set " + data);
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
