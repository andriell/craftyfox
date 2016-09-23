package com.github.andriell.nashorn.http;

import com.github.andriell.processor.ProcessorInterface;
import com.github.andriell.processor.http.ProcessHttpContext;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.InitializingBean;

import java.io.IOException;

/**
 * Created by Rybalko on 23.09.2016.
 */
public class HttpClient implements InitializingBean {
    private PoolingHttpClientConnectionManager connectionManager;
    private CloseableHttpClient httpClient;

    private String name;
    private HttpData data;
    private ProcessHttpContext httpContext;

    private ProcessorInterface processor;

    // TODO data должна поступать вот сюда
    public void run() {
        HttpClientContext localContext = this.httpContext.getClientContext();
        try {
            CloseableHttpResponse response = httpClient.execute(data, localContext);


            HttpEntity httpEntity = response.getEntity();
            byte[] body = EntityUtils.toByteArray(httpEntity);
            ContentType contentType = ContentType.getOrDefault(httpEntity);
            EntityUtils.consume(httpEntity);


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
        processor = null;
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

    public void afterPropertiesSet() throws Exception {
        connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(1000);
        connectionManager.setDefaultMaxPerRoute(1000);
        httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .setConnectionManagerShared(true)
                .build();
    }
}
