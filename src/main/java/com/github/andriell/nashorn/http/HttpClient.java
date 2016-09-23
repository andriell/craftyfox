package com.github.andriell.nashorn.http;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.InitializingBean;

import java.io.IOException;

/**
 * Created by Rybalko on 23.09.2016.
 */
public class HttpClient implements InitializingBean {
    private CloseableHttpClient httpClient;
    private HttpClientContext clientContext;
    private CookieStore cookieStore;

    public HttpResponse execute(RequestBuilder data) throws IOException {
        return execute(data.build());
    }

    public HttpResponse execute(HttpUriRequest data) throws IOException {
        HttpResponse r = null;
        CloseableHttpResponse response = httpClient.execute(data, clientContext);
        HttpEntity httpEntity = response.getEntity();
        byte[] body = EntityUtils.toByteArray(httpEntity);
        ContentType contentType = ContentType.getOrDefault(httpEntity);
        EntityUtils.consume(httpEntity);
        r = new HttpResponse(body, contentType, data, response);
        response.close();
        httpClient.close();
        return r;
    }

    public void afterPropertiesSet() throws Exception {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(1000);
        connectionManager.setDefaultMaxPerRoute(1000);

        httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .setConnectionManagerShared(true)
                .build();

        if (clientContext == null) {
            clientContext = HttpClientContext.create();
        }
        if (cookieStore == null) {
            cookieStore = new BasicCookieStore();
        }
        clientContext.setAttribute("http.cookie-store", cookieStore);
    }

    public void saveCookie() throws IOException {
        if (cookieStore instanceof FileCookieStoreInterface) {
            FileCookieStoreInterface fileCookieStore = (FileCookieStoreInterface) cookieStore;
            fileCookieStore.saveCookie();
        }
    }

    public void addCookie(String name, String value, String domain) {
        addCookie(name, value, domain, null);
    }

    public void addCookie(String name, String value, String domain, String path) {
        if (name == null || domain == null) {
            return;
        }
        BasicClientCookie cookie = new BasicClientCookie(name, value);
        cookie.setDomain(domain);
        if (path == null) {
            path = "/";
        }
        cookie.setPath(path);
        cookieStore.addCookie(cookie);
    }

    public HttpClientContext getClientContext() {
        return clientContext;
    }

    public void setClientContext(HttpClientContext clientContext) {
        this.clientContext = clientContext;
    }

    public CookieStore getCookieStore() {
        return cookieStore;
    }

    public void setCookieStore(CookieStore cookieStore) {
        this.cookieStore = cookieStore;
    }

    public String requestHeaders() {
        Header[] headers = clientContext.getRequest().getAllHeaders();
        StringBuilder r = new StringBuilder();
        r.append(clientContext.getRequest().getRequestLine().toString());
        r.append("\n");
        for (Header header : headers) {
            r.append(header.getName());
            r.append(": ");
            r.append(header.getValue());
            r.append("\n");
        }
        return r.toString();
    }
}
