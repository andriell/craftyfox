package com.github.andriell.processor.js;

import com.github.andriell.processor.http.ProcessHttpDataListenerInterface;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ProcessJsDataHtml extends ProcessJsDataAbstract implements ProcessHttpDataListenerInterface {
    private Document dataHtml;

    public Document getDataHtml() {
        return dataHtml;
    }

    public void setDataHtml(Document dataHtml) {
        this.dataHtml = dataHtml;
    }

    public void setResponse(byte[] body, ContentType contentType, HttpRequest request, HttpResponse response) {
        setHttpParam(request, response, contentType);
        setDataHtml(Jsoup.parse(new String(body, contentType.getCharset())));
    }
}
