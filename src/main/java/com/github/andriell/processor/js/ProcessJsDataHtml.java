package com.github.andriell.processor.js;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ProcessJsDataHtml extends ProcessJsDataAbstract {
    private Document document;

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public void setResponse(byte[] body, ContentType contentType, HttpRequest request, HttpResponse response) {
        setDocument(Jsoup.parse(new String(body, contentType.getCharset())));
    }
}
