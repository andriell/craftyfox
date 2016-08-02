package com.github.andriell.processor.http;

import com.github.andriell.processor.DataInterface;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Rybalko on 12.04.2016.
 */
public class ProcessHttpData extends HttpEntityEnclosingRequestBase implements DataInterface {
    public static final String METHOD_GET = "GET";
    public static final String METHOD_HEAD = "HEAD";
    public static final String METHOD_OPTIONS = "OPTIONS";

    public static final String METHOD_PATCH = "PATCH";
    public static final String METHOD_POST = "POST";
    public static final String METHOD_PUT = "PUT";

    private static RequestConfig requestConfig = RequestConfig.custom().setCircularRedirectsAllowed(true).build();
    private String processBeanId;
    private String method = METHOD_GET;
    private Collection<NameValuePair> data = new ArrayList<NameValuePair>();
    private Collection<ProcessHttpDataListenerInterface> dataListeners = new ArrayList<ProcessHttpDataListenerInterface>(2);
    private Object jsData; // Данные передаваемые из js, для js

    public ProcessHttpData() {
        init();
    }

    public ProcessHttpData(URI uri) {
        this.setURI(uri);
        init();
    }

    public ProcessHttpData(String method, URI uri) {
        this.setURI(uri);
        this.method = method;
        init();
    }

    public ProcessHttpData(String uri) {
        this.setURI(URI.create(uri));
        init();
    }

    public ProcessHttpData(String uri, String method) {
        this.setURI(URI.create(uri));
        this.method = method;
        init();
    }

    public void destroy() {
        processBeanId = null;
        method = null;
        data.clear();
        data = null;
        dataListeners.clear();
        dataListeners = null;
        jsData = null;
    }

    private void init() {
        setConfig(requestConfig);
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setUrl(String uri) {
        this.setURI(URI.create(uri));
    }

    public Collection<NameValuePair> getData() {
        return data;
    }

    public void setData(Collection<NameValuePair> data) {
        this.data = data;
        if (METHOD_GET.equals(method) || METHOD_HEAD.equals(method) || METHOD_OPTIONS.equals(method)) {
            URIBuilder builder = new URIBuilder(getURI());
            for (NameValuePair pair:data) {
                builder.setParameter(pair.getName(), pair.getValue());
            }
        } else if (METHOD_POST.equals(method) || METHOD_PATCH.equals(method) || METHOD_PUT.equals(method)) {
            this.setEntity(new UrlEncodedFormEntity(data, Consts.UTF_8));
        }
    }

    public boolean addDataListener(ProcessHttpDataListenerInterface dataListener) {
        return dataListeners.add(dataListener);
    }

    public Collection<ProcessHttpDataListenerInterface> getDataListeners() {
        return dataListeners;
    }

    public String getProcessBeanId() {
        return processBeanId;
    }

    public void setProcessBeanId(String processBeanId) {
        this.processBeanId = processBeanId;
    }

    public void setUserAgent(String userAgent) {
        setHeader("User-Agent", userAgent);
    }

    /**
     * Данные передаваемые из js, для js
     * @return
     */
    public Object getJsData() {
        return jsData;
    }

    /**
     *  Данные передаваемые из js, для js
     * @param jsData
     */
    public void setJsData(Object jsData) {
        this.jsData = jsData;
    }
}