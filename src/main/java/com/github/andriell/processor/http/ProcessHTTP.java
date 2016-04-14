package com.github.andriell.processor.http;

import com.github.andriell.processor.ProcessInterface;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;

/**
 * Created by Rybalko on 12.04.2016.
 */
public class ProcessHTTP implements ProcessInterface {
    private ProcessHTTPData data;
    private ProcessHTTPClient httpClient;

    public void setData(Object data) {
        this.data = (ProcessHTTPData) data;
    }

    public ProcessHTTPData getData() {
        return data;
    }

    public void run() {
        CloseableHttpClient httpClient = this.httpClient.getHttpClient();
        HttpClientContext localContext = this.httpClient.getClientContext();
        try {
            CloseableHttpResponse response = null;
            try {
                response = httpClient.execute(data, localContext);
            } catch (IOException e) {
                e.printStackTrace();
            }
            HttpResponse httpResponse = localContext.getResponse();
            HttpRequest httpRequest = localContext.getRequest();

            Header[] headers;

            System.out.println("---Request-------------------------------------");
            headers = httpRequest.getAllHeaders();


            System.out.println("---Response-------------------------------------");
            headers = httpResponse.getAllHeaders();

            response.close();

        } finally {
            httpClient.close();
        }
    }
}
