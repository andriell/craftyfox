package com.github.andriell.nashorn.http;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.nio.charset.Charset;

/**
 * Created by Rybalko on 23.09.2016.
 */
public class HttpResponse {
    private byte[] body;
    private ContentType contentType;
    private HttpUriRequest uri;
    private CloseableHttpResponse response;

    public HttpResponse(byte[] body, ContentType contentType, HttpUriRequest uri, CloseableHttpResponse response) {
        this.body = body;
        this.contentType = contentType;
        this.uri = uri;
        this.response = response;
    }

    public Charset charset() {
        if (contentType != null) {
            return contentType.getCharset();
        }
        return null;
    }

    public Document html() {
        return Jsoup.parse(text());
    }

    public Document html(String charsets) throws UnsupportedEncodingException {
        return Jsoup.parse(text(charsets));
    }

    public Document html(Charset charsets) {
        return Jsoup.parse(text(charsets));
    }

    public Object xml() {
        return Jsoup.parse(text(), uri.toString(),  Parser.xmlParser());
    }

    public Object xml(String charsets) throws UnsupportedEncodingException {
        return Jsoup.parse(text(charsets), uri.toString(),  Parser.xmlParser());
    }

    public Object xml(Charset charsets) {
        return Jsoup.parse(text(charsets), uri.toString(),  Parser.xmlParser());
    }

    public JSONObject json() {
        return new JSONObject(text());
    }

    public JSONObject json(String charsets) throws UnsupportedEncodingException {
        return new JSONObject(text(charsets));
    }

    public JSONObject json(Charset charsets) {
        return new JSONObject(text(charsets));
    }

    public String text() {
        return text(charset());
    }

    public String text(String charset) throws UnsupportedEncodingException {
        if (charset == null) {
            return new String(body);
        }
        return new String(body, charset);
    }

    public String text(Charset charset) {
        if (charset == null) {
            return new String(body);
        }
        return new String(body, charset);
    }

    public String url() throws MalformedURLException {
        return uri.getURI().toURL().toString();
    }

    public byte[] bytes() {
        return body;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public HttpUriRequest getUri() {
        return uri;
    }

    public CloseableHttpResponse getResponse() {
        return response;
    }
}
