package com.github.andriell.processor.http;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Rybalko on 12.04.2016.
 */
public class ProcessHTTPData extends HttpEntityEnclosingRequestBase {
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";

    private String method = METHOD_GET;
    private Collection<NameValuePair> data = new ArrayList<NameValuePair>();

    public ProcessHTTPData() {}

    public ProcessHTTPData(URI uri) {
        this.setURI(uri);
    }

    public ProcessHTTPData(URI uri, String method) {
        this.setURI(uri);
        this.method = method;
    }

    public ProcessHTTPData(String uri) {
        this.setURI(URI.create(uri));
    }

    public ProcessHTTPData(String uri, String method) {
        this.setURI(URI.create(uri));
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setData(Collection<NameValuePair> data) {
        this.data = data;
        if (METHOD_GET.equals(method)) {
            URIBuilder builder = new URIBuilder(getURI());
            for (NameValuePair pair:data) {
                builder.setParameter(pair.getName(), pair.getValue());
            }
        } else if (METHOD_POST.equals(method)) {
            this.setEntity(new UrlEncodedFormEntity(data, Consts.UTF_8));
        }
    }

    public Collection<NameValuePair> getData() {
        return data;
    }
}