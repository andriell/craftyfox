package com.github.andriell.nashorn.http;

import org.apache.http.*;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.Charset;

/**
 * Created by Rybalko on 23.09.2016.
 */
public class HttpResponse {
    private HttpUriRequest request;
    private org.apache.http.HttpResponse response;

    public HttpResponse(HttpUriRequest request, org.apache.http.HttpResponse response) {
        this.request = request;
        this.response = response;
    }

    public Charset charset() {
        ContentType contentType = getContentType();
        if (contentType != null) {
            return contentType.getCharset();
        }
        return null;
    }

    public Document html() throws IOException {
        return Jsoup.parse(text());
    }

    public Document html(String charsets) throws IOException {
        return Jsoup.parse(text(charsets));
    }

    public Document html(Charset charsets) throws IOException {
        return Jsoup.parse(text(charsets));
    }

    public Object xml() throws IOException {
        return Jsoup.parse(text(), url(),  Parser.xmlParser());
    }

    public Object xml(String charsets) throws IOException {
        return Jsoup.parse(text(charsets), url(),  Parser.xmlParser());
    }

    public Object xml(Charset charsets) throws IOException {
        return Jsoup.parse(text(charsets), url(),  Parser.xmlParser());
    }

    public JSONObject json() throws IOException {
        return new JSONObject(text());
    }

    public JSONObject json(String charsets) throws IOException {
        return new JSONObject(text(charsets));
    }

    public JSONObject json(Charset charsets) throws IOException {
        return new JSONObject(text(charsets));
    }

    public String text() throws IOException {
        return text(charset());
    }

    public String text(String charset) throws IOException {
        if (charset == null) {
            return new String(bytes());
        }
        return new String(bytes(), charset);
    }

    public String text(Charset charset) throws IOException {
        if (charset == null) {
            return new String(bytes());
        }
        return new String(bytes(), charset);
    }

    public String url() throws MalformedURLException {
        return request.getURI().toURL().toString();
    }

    private static void header2string(Header[] headers, StringBuilder r) {
        for (Header header : headers) {
            r.append(header.getName());
            r.append(": ");
            r.append(header.getValue());
            r.append("\n");
        }
    }

    public String responseHeaders() {
        Header[] headers = response.getAllHeaders();
        StringBuilder r = new StringBuilder();
        r.append(response.getStatusLine().toString());
        r.append("\n");
        header2string(headers, r);
        return r.toString();
    }

    public String requestHeaders() {
        Header[] headers = request.getAllHeaders();
        StringBuilder r = new StringBuilder();
        r.append(request.getRequestLine().toString());
        r.append("\n");
        header2string(headers, r);
        return r.toString();
    }

    public byte[] bytes() throws IOException {
        HttpEntity httpEntity = response.getEntity();
        if (httpEntity == null) {
            return null;
        }
        return EntityUtils.toByteArray(httpEntity);
    }

    public ContentType getContentType() {
        HttpEntity httpEntity = response.getEntity();
        if (httpEntity == null) {
            return null;
        }
        return ContentType.getOrDefault(httpEntity);
    }

    public HttpUriRequest getRequest() {
        return request;
    }

    public org.apache.http.HttpResponse getResponse() {
        return response;
    }

    public HttpEntity httpEntity() {
        return response.getEntity();
    }
}
