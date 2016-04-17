package com.github.andriell.processor.http;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Rybalko on 12.04.2016.
 */
public class ProcessHttpData extends HttpEntityEnclosingRequestBase {
    public static final String METHOD_GET = "GET";
    public static final String METHOD_HEAD = "HEAD";
    public static final String METHOD_OPTIONS = "OPTIONS";

    public static final String METHOD_PATCH = "PATCH";
    public static final String METHOD_POST = "POST";
    public static final String METHOD_PUT = "PUT";

    private String method = METHOD_GET;
    private Collection<NameValuePair> data = new ArrayList<NameValuePair>();
    private Collection<ProcessHttpDataListenerInterface> dataListeners = new ArrayList<ProcessHttpDataListenerInterface>(2);

    public ProcessHttpData() {}

    public ProcessHttpData(URI uri) {
        this.setURI(uri);
    }

    public ProcessHttpData(String method, URI uri) {
        this.setURI(uri);
        this.method = method;
    }

    public ProcessHttpData(String uri) {
        this.setURI(URI.create(uri));
    }

    public ProcessHttpData(String uri, String method) {
        this.setURI(URI.create(uri));
        this.method = method;
    }

    public String getMethod() {
        return method;
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

    public Collection<NameValuePair> getData() {
        return data;
    }

    public boolean addDataListener(ProcessHttpDataListenerInterface dataListener) {
        return dataListeners.add(dataListener);
    }

    public Collection<ProcessHttpDataListenerInterface> getDataListeners() {
        return dataListeners;
    }
}