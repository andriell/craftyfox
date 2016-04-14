package com.github.andriell.processor.http;

import com.github.andriell.processor.ProcessInterface;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;

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



        try {
            // Create a local instance of cookie store
            cookieStore = new BasicCookieStore();
            cookieStore.clear();

            // Create local HTTP context
            localContext = HttpClientContext.create();
            // Bind custom cookie store to the local context
            localContext.setCookieStore(cookieStore);

            CloseableHttpResponse response = null;
            for (int i = 0; i < 2; i++) {
                HttpGet httpGet = new HttpGet("http://ya.ru");
                System.out.println("Executing request " + httpGet.getRequestLine());

                // Pass local context as a parameter
                response = httpClient.execute(httpGet, localContext);
                HttpResponse httpResponse = localContext.getResponse();
                HttpRequest httpRequest = localContext.getRequest();

                Header[] headers;

                System.out.println("---Request-------------------------------------");
                headers = httpRequest.getAllHeaders();
                for (Header header:headers) {
                    System.out.println(header);
                }

                System.out.println("---Response-------------------------------------");
                headers = httpResponse.getAllHeaders();
                for (Header header:headers) {
                    System.out.println(header);
                }
            }

            response.close();

        } finally {
            httpClient.close();
        }
    }
}
