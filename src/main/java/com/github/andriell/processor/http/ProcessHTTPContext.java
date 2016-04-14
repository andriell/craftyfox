package com.github.andriell.processor.http;

import org.apache.http.client.CookieStore;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.springframework.beans.factory.InitializingBean;

import java.io.*;

public class ProcessHttpContext implements InitializingBean {
    private HttpClientContext clientContext;
    private CookieStore cookieStore;
    private String name;

    public void afterPropertiesSet() throws Exception {

        if (clientContext == null) {
            clientContext = HttpClientContext.create();
        }
        if (cookieStore == null) {
            cookieStore = new BasicCookieStore();
        }
        clientContext.setAttribute("http.cookie-store", cookieStore);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void saveCookie() throws IOException {
        if (cookieStore instanceof FileCookieStoreInterface) {
            FileCookieStoreInterface fileCookieStore = (FileCookieStoreInterface) cookieStore;
            fileCookieStore.saveCookie();
        }
    }
}
