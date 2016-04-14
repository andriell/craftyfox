package com.github.andriell.processor.http;

import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;
import org.springframework.beans.factory.InitializingBean;

import java.io.*;

public class ProcessHTTPClient implements InitializingBean {
    private HttpClient httpClient;
    private HttpContext clientContext;
    private CookieStore cookieStore;

    public void afterPropertiesSet() throws Exception {
        if (httpClient == null) {
            httpClient = HttpClients.createDefault();
        }
        if (clientContext == null) {
            clientContext = HttpClientContext.create();
        }
        if (cookieStore == null) {
            cookieStore = new BasicCookieStore();
        }
        clientContext.setAttribute("http.cookie-store", cookieStore);
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public HttpContext getClientContext() {
        return clientContext;
    }

    public void setClientContext(HttpContext clientContext) {
        this.clientContext = clientContext;
    }

    public CookieStore getCookieStore() {
        return cookieStore;
    }

    public void setCookieStore(CookieStore cookieStore) {
        this.cookieStore = cookieStore;
    }

    public void saveCookie() throws IOException {
        if (cookieStore instanceof FileCookieStoreInterface) {
            FileCookieStoreInterface fileCookieStore = (FileCookieStoreInterface) cookieStore;
            fileCookieStore.saveCookie();
        }
    }
}
